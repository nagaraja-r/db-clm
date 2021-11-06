package com.db.task.dbclm.util;

import com.db.task.dbclm.dto.NomenclatureEconomicActivityDto;

import java.util.Optional;

public class NaceDataValidator implements Validation<NomenclatureEconomicActivityDto> {

    @Override
    public Optional<ValidationRules> validate(final NomenclatureEconomicActivityDto nace) {
        if (nace == null) {
            return Optional.of(ValidationRules.NACE_NULL);
        } else if (nace.getOrder() == null) {
            return Optional.of(ValidationRules.NACE_ORDER_EMPTY);
        } else if (nace.getLevel() == null) {
            return Optional.of(ValidationRules.NACE_LEVEL_EMPTY);
        } else if (nace.getCode() == null) {
            return Optional.of(ValidationRules.NACE_CODE_EMPTY);
        }
        return Optional.empty();
    }
}
