package com.db.task.dbclm;

import com.db.task.dbclm.dto.NomenclatureEconomicActivity;

public final class NaceDataHelper {

    public static NomenclatureEconomicActivity NACE_398481;
    public static NomenclatureEconomicActivity NACE_398488;

    static {
        NACE_398481 = NomenclatureEconomicActivity.builder()
                .order(398481L)
                .level(1)
                .code("A")
                .parent("")
                .description("AGRICULTURE, FORESTRY AND FISHING")
                .itemExcludes("This section includes the exploitation of vegetal and animal natural resources, " +
                        "comprising the activities of growing of crops, raising and breeding of animals, harvesting " +
                        "of timber and other plants, animals or animal products from a farm or their natural habitats.")
                .itemAlsoIncludes("")
                .ruling("")
                .itemExcludes("")
                .build();


        NACE_398488 = NomenclatureEconomicActivity.builder()
                .order(398488L)
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
    }


}
