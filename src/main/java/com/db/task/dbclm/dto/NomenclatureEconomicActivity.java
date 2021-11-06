package com.db.task.dbclm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class NomenclatureEconomicActivity implements Serializable {
    private Long order;
    private Integer level;
    private String code;
    private String parent;
    private String description;
    private String itemIncludes;
    private String itemAlsoIncludes;
    private String ruling;
    private String itemExcludes;
    private String referenceToIsic;
}
