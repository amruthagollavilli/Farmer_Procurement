package org.example.farmer_procurement.controller;

import org.example.farmer_procurement.dto_response.CropResponse;
import org.example.farmer_procurement.service.CropService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crop")

public class CropController {
    private final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    @GetMapping
    public List<CropResponse> getAllCrops() {
        return cropService.getAllCrops();
    }
}
