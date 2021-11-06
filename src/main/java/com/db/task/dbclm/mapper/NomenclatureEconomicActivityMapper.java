package com.db.task.dbclm.mapper;

import com.db.task.dbclm.dto.NomenclatureEconomicActivityDto;
import com.db.task.dbclm.model.NomenclatureEconomicActivity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NomenclatureEconomicActivityMapper {

    NomenclatureEconomicActivityDto toDto(NomenclatureEconomicActivity nomenclatureEconomicActivity);

    NomenclatureEconomicActivity toBo(NomenclatureEconomicActivityDto nomenclatureEconomicActivityDto);
}
