package com.db.task.dbclm.service;

import com.db.task.dbclm.util.NaceTestData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DbClmRunner implements CommandLineRunner {

    @Autowired
    private DbClmService dbClmService;

    @Override
    public void run(String... args) throws Exception {
        for (var nace : NaceTestData.getNaceData()) {
            log.info("Loading the NACE with order : {}", nace.getOrder());
            dbClmService.putNaceDetails(nace);
        }
        log.info("Loading of NACE data is completed");
    }
}
