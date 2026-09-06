package org.example.farmer_procurement.service;

import org.example.farmer_procurement.dto_response.CropResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CropService {
    List<CropResponse> getAllCrops();
}
