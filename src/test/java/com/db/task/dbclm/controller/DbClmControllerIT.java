package com.db.task.dbclm.controller;

import com.db.task.dbclm.NaceDataHelper;
import com.db.task.dbclm.dto.NomenclatureEconomicActivityDto;
import com.db.task.dbclm.exception.ApiError;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DbClmControllerIT {

    private final String nace_uri = "http://localhost:8080/v1/nomenclatures/";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(1)
    public void testPutNaceDetails_NACE_Created() {
        var nace = NaceDataHelper.NACE_398488;
        var response = this.restTemplate.postForEntity(nace_uri,
                nace,
                NomenclatureEconomicActivityDto.class);

        var naceResponse = response.getBody();
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(naceResponse);
        assertEquals(nace.getOrder(), naceResponse.getOrder());
        assertEquals(nace.getDescription(), naceResponse.getDescription());
        assertEquals(nace.getCode(), naceResponse.getCode());
        assertEquals(nace.getItemIncludes(), naceResponse.getItemIncludes());
    }

    @Test
    @Order(2)
    public void testPutNaceDetails_InvalidInput() {
        var invalidNace = new NomenclatureEconomicActivityDto();
        var response = this.restTemplate.postForEntity(nace_uri,
                invalidNace,
                ApiError.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testGetNaceDetails_NACE_Found() {
        var order = 398488L;
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
    @Order(3)
    public void testGetNaceDetails_NACE_Found_FromCache() {
        var order = 398488L;
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
    @Order(4)
    public void testGetNaceDetails_NACE_NotFound() {
        var order = 123466L;
        ResponseEntity<ApiError> response = this.restTemplate.getForEntity(nace_uri + order,
                ApiError.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @Order(5)
    public void testGetNaceDetails_InvalidInput() {
        var order = "invalidinput";
        ResponseEntity<ApiError> response = this.restTemplate.getForEntity(nace_uri + order,
                ApiError.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
