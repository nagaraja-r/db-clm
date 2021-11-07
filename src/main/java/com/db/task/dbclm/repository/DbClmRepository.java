package com.db.task.dbclm.repository;

import com.db.task.dbclm.model.NomenclatureEconomicActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DbClmRepository extends JpaRepository<NomenclatureEconomicActivity, Long> {

    Optional<NomenclatureEconomicActivity> findByOrder(Long order);
}
