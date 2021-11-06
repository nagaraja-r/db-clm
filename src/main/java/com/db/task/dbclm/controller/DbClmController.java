package com.db.task.dbclm.controller;

import com.db.task.dbclm.dto.NomenclatureEconomicActivity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1")
@Tag(name = "db-clm", description = "These are APIs to manage the NACE Details")
public class DbClmController {

    @Operation(summary = "Find NACE details by order", description = "Returns the set of NACE for a given order",
            tags = {"db-clm"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = NomenclatureEconomicActivity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Input"),
            @ApiResponse(responseCode = "404", description = "No records found")})
    @GetMapping(value = "/nomenclatures/{order}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NomenclatureEconomicActivity> getNaceDetailsBy(@Parameter(description = "Order Id",
            required = true) final @PathVariable Long order) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @Operation(summary = "Creates a NACE record", description = "Creates a new NACE record",
            tags = {"db-clm"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The NACE created",
                    content = @Content(schema = @Schema(implementation = NomenclatureEconomicActivity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Input")})
    @PutMapping(value = "/nomenclatures", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NomenclatureEconomicActivity> putNaceDetails(@Parameter(description = "NACE record",
            required = true) final @RequestBody NomenclatureEconomicActivity naceData) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
