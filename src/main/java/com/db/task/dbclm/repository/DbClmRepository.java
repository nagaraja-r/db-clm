package com.db.task.dbclm.repository;

import com.db.task.dbclm.model.NomenclatureEconomicActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbClmRepository extends JpaRepository<NomenclatureEconomicActivity, Long> {
}
