package com.db.task.dbclm.util;

import com.db.task.dbclm.dto.NomenclatureEconomicActivityDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NaceDataValidatorTest {
    NaceDataValidator validator = new NaceDataValidator();

    @Test
    public void testNaceValidate_NACE_VALID() {
        //prepare
        NomenclatureEconomicActivityDto nace = NomenclatureEconomicActivityDto.builder()
                .order(38984L)
                .code("1.15")
                .level(4)
                .parent("1.1")
                .description("Growing of tobaccco")
                .itemExcludes("growing of unmanufactured tobacco")
                .itemAlsoIncludes("")
                .ruling("")
                .itemExcludes("manufacture of tobacco products, see 12.00")
                .referenceToIsic("115")
                .build();
        //act
        Optional<ValidationRules> rule = validator.validate(nace);
        //assert
        assertTrue(rule.isEmpty());
    }

    @Test
    @DisplayName("")
    public void testNaceValidate_NACE_NULL() {
        //prepare
        NomenclatureEconomicActivityDto nace = null;
        //act
        Optional<ValidationRules> rule = validator.validate(nace);
        //assert
        assertEquals(ValidationRules.NACE_NULL, rule.get());
    }

    @Test
    @DisplayName("")
    public void testNaceValidate_NACE_ORDER_EMPTY() {
        //prepare
        NomenclatureEconomicActivityDto nace = NomenclatureEconomicActivityDto.builder()
                .level(4)
                .code("1.15")
                .parent("1.1")
                .description("Growing of tobaccco")
                .itemExcludes("growing of unmanufactured tobacco")
                .itemAlsoIncludes("")
                .ruling("")
                .itemExcludes("manufacture of tobacco products, see 12.00")
                .referenceToIsic("115")
                .build();
        //act
        Optional<ValidationRules> rule = validator.validate(nace);
        //assert
        assertEquals(ValidationRules.NACE_ORDER_EMPTY, rule.get());

    }

    @Test
    @DisplayName("")
    public void testNaceValidate_LEVEL_EMPTY() {
        //prepare
        NomenclatureEconomicActivityDto nace = NomenclatureEconomicActivityDto.builder()
                .order(38984L)
                .code("1.15")
                .parent("1.1")
                .description("Growing of tobaccco")
                .itemExcludes("growing of unmanufactured tobacco")
                .itemAlsoIncludes("")
                .ruling("")
                .itemExcludes("manufacture of tobacco products, see 12.00")
                .referenceToIsic("115")
                .build();
        //act
        Optional<ValidationRules> rule = validator.validate(nace);
        //assert
        assertEquals(ValidationRules.NACE_LEVEL_EMPTY, rule.get());
    }
}
