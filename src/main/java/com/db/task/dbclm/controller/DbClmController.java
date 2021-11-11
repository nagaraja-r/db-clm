package com.db.task.dbclm.controller;

import com.db.task.dbclm.dto.NomenclatureEconomicActivityDto;
import com.db.task.dbclm.exception.NaceDataNotFoundException;
import com.db.task.dbclm.service.DbClmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1")
@Tag(name = "db-clm", description = "These are APIs to manage the NACE Details")
public class DbClmController {

    private final DbClmService dbClmService;

    @Autowired
    public DbClmController(final DbClmService dbClmService) {
        this.dbClmService = dbClmService;
    }

    @Operation(summary = "Find NACE Details by order", description = "Returns a NACE record for the given order",
            tags = {"db-clm"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = NomenclatureEconomicActivityDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Input"),
            @ApiResponse(responseCode = "404", description = "No NACE data found")})
    @GetMapping(value = "/nomenclatures/{order}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NomenclatureEconomicActivityDto> getNaceDetailsBy(@Parameter(description = "Order Id",
            required = true) final @PathVariable Long order) throws NaceDataNotFoundException {
        return ResponseEntity.ok(dbClmService.getNaceDetailsByOrder(order));
    }

    @Operation(summary = "Creates a NACE record", description = "Creates a new NACE record",
            tags = {"db-clm"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The NACE created",
                    content = @Content(schema = @Schema(implementation = NomenclatureEconomicActivityDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Input")})
    @PostMapping(value = "/nomenclatures", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NomenclatureEconomicActivityDto> putNaceDetails(@Parameter(description = "NACE record",
            required = true) final @RequestBody NomenclatureEconomicActivityDto naceData) {
        final var nace = dbClmService.putNaceDetails(naceData);
        return ResponseEntity.status(HttpStatus.CREATED).body(nace);
    }
}
