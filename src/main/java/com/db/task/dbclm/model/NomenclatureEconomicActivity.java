package com.db.task.dbclm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "nomenclature_economic_activities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NomenclatureEconomicActivity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "order_id", nullable = false)
    private Long order;
    @Column(name = "level", nullable = false)
    private Integer level;
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "parent", nullable = false)
    private String parent;
    @Column(name = "description")
    private String description;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "item_includes")
    private String itemIncludes;
    @Column(name = "item_also_includes")
    private String itemAlsoIncludes;
    @Column(name = "ruling")
    private String ruling;
    @Column(name = "item_excludes")
    private String itemExcludes;
    @Column(name = "reference_to_isic")
    private String referenceToIsic;
}
