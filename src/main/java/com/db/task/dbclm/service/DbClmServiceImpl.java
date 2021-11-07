package com.db.task.dbclm.service;

import com.db.task.dbclm.dto.NomenclatureEconomicActivityDto;
import com.db.task.dbclm.exception.InvalidNaceDataException;
import com.db.task.dbclm.exception.NaceDataNotFoundException;
import com.db.task.dbclm.mapper.NomenclatureEconomicActivityMapper;
import com.db.task.dbclm.repository.DbClmRepository;
import com.db.task.dbclm.util.NaceDataValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DbClmServiceImpl implements DbClmService {
    private final DbClmRepository dbClmRepository;
    private final NomenclatureEconomicActivityMapper mapper;

    public DbClmServiceImpl(final DbClmRepository dbClmRepository, final NomenclatureEconomicActivityMapper mapper) {
        this.dbClmRepository = dbClmRepository;
        this.mapper = mapper;
    }

    @Override
    public NomenclatureEconomicActivityDto getNaceDetailsByOrder(final Long theOrder) throws NaceDataNotFoundException {
        if (theOrder == null) {
            throw new IllegalArgumentException("The order must not be null");
        }
        log.info("Finding the NACE for the given order: {}", theOrder);

        var theNace = dbClmRepository.findByOrder(theOrder);

        if (theNace.isPresent()) {
            log.info("Found the NACE for a  given order: {}", theOrder);
            return mapper.toDto(theNace.get());
        }

        throw new NaceDataNotFoundException("No NACE found for the given order:" + theOrder);
    }

    @Override
    public NomenclatureEconomicActivityDto putNaceDetails(final NomenclatureEconomicActivityDto newNaceDto) {
        validateNaceData(newNaceDto);
        log.info("the new NACE is valid");
        final var naceBo = mapper.toBo(newNaceDto);
        log.info("persisiting the NACE with order : {}", naceBo.getOrder());
        return mapper.toDto(dbClmRepository.save(naceBo));
    }

    /**
     * This method validates the NACE record
     * Validations can be extended as per the business needs
     *
     * @param theNace
     */
    private void validateNaceData(final NomenclatureEconomicActivityDto theNace) {
        var naceDataValidator = new NaceDataValidator();
        var rule = naceDataValidator.validate(theNace);

        InvalidNaceDataException.throwIf(rule.isPresent(), rule);
    }
}
