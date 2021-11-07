package com.db.task.dbclm.service;

import com.db.task.dbclm.dto.NomenclatureEconomicActivityDto;
import com.db.task.dbclm.exception.NaceDataNotFoundException;

public interface DbClmService {

    NomenclatureEconomicActivityDto getNaceDetailsByOrder(Long theOrder) throws NaceDataNotFoundException;

    NomenclatureEconomicActivityDto putNaceDetails(NomenclatureEconomicActivityDto newNace);
}
