package com.db.task.dbclm.service;

import com.db.task.dbclm.dto.NomenclatureEconomicActivityDto;
import com.db.task.dbclm.exception.InvalidNaceDataException;
import com.db.task.dbclm.mapper.NomenclatureEconomicActivityMapper;
import com.db.task.dbclm.model.NomenclatureEconomicActivity;
import com.db.task.dbclm.repository.DbClmRepository;
import com.db.task.dbclm.util.NaceDataValidator;
import com.db.task.dbclm.util.ValidationRules;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public NomenclatureEconomicActivityDto putNaceDetails(final NomenclatureEconomicActivityDto newNaceDto) {
        validateNaceData(newNaceDto);
        log.info("the new NACE is valid");
        final NomenclatureEconomicActivity naceBo = mapper.toBo(newNaceDto);
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
        NaceDataValidator naceDataValidator = new NaceDataValidator();
        Optional<ValidationRules> rule = naceDataValidator.validate(theNace);

        InvalidNaceDataException.throwIf(rule.isPresent(), rule);
    }
}
