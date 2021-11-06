package com.db.task.dbclm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class NomenclatureEconomicActivityDto implements Serializable {
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
