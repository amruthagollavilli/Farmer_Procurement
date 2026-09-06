package org.example.farmer_procurement.controller;

import org.example.farmer_procurement.dto_response.ProcurementResponse;
import org.example.farmer_procurement.service.ProcurementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/procurement")
public class ProcurementController {

    private final ProcurementService procurementService;

    public ProcurementController(ProcurementService procurementService) {
        this.procurementService = procurementService;
    }

    @GetMapping
    public List<ProcurementResponse> getAllCentres() {
        return procurementService.getAllCentres();
    }
}