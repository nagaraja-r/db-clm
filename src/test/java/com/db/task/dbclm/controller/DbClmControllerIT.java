package com.db.task.dbclm.controller;

import com.db.task.dbclm.NaceDataHelper;
import com.db.task.dbclm.dto.NomenclatureEconomicActivityDto;
import com.db.task.dbclm.exception.ApiError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class DbClmControllerIT {

    private final String nace_uri = "http://localhost:8080/v1/nomenclatures/";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testPutNaceDetails_NACE_Created() {
        NomenclatureEconomicActivityDto nace = NaceDataHelper.NACE_398488;
        ResponseEntity<NomenclatureEconomicActivityDto> response = this.restTemplate.postForEntity(nace_uri,
                nace,
                NomenclatureEconomicActivityDto.class);

        NomenclatureEconomicActivityDto naceResponse = response.getBody();
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(naceResponse);
        assertEquals(nace.getOrder(), naceResponse.getOrder());
        assertEquals(nace.getDescription(), naceResponse.getDescription());
        assertEquals(nace.getCode(), naceResponse.getCode());
        assertEquals(nace.getItemIncludes(), naceResponse.getItemIncludes());
    }

    @Test
    public void testPutNaceDetails_InvalidInput() {
        NomenclatureEconomicActivityDto invalidNace = new NomenclatureEconomicActivityDto();
        ResponseEntity<ApiError> response = this.restTemplate.postForEntity(nace_uri,
                invalidNace,
                ApiError.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testGetNaceDetails_NACE_Found() {
        Long order = 398488L;
        ResponseEntity<NomenclatureEconomicActivityDto> response = this.restTemplate.getForEntity(nace_uri + order,
                NomenclatureEconomicActivityDto.class);

        NomenclatureEconomicActivityDto nace = NaceDataHelper.NACE_398488;
        assertEquals(HttpStatus.OK, response.getStatusCode());
        NomenclatureEconomicActivityDto naceResponse = response.getBody();
        assertNotNull(naceResponse);
        assertEquals(nace.getOrder(), naceResponse.getOrder());
        assertEquals(nace.getDescription(), naceResponse.getDescription());
        assertEquals(nace.getCode(), naceResponse.getCode());
        assertEquals(nace.getItemIncludes(), naceResponse.getItemIncludes());
    }

    @Test
    public void testGetNaceDetails_NACE_NotFound() {
        Long order = 123466L;
        ResponseEntity<NomenclatureEconomicActivityDto> response = this.restTemplate.getForEntity(nace_uri + order,
                NomenclatureEconomicActivityDto.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        NomenclatureEconomicActivityDto naceResponse = response.getBody();
        assertNull(naceResponse);
    }
}
