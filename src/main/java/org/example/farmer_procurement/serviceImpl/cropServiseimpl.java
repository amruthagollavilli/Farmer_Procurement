package org.example.farmer_procurement.serviceImpl;

import org.example.farmer_procurement.dto_response.CropResponse;
import org.example.farmer_procurement.entity.Crop;
import org.example.farmer_procurement.repository.CropRepository;
import org.example.farmer_procurement.service.CropService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cropServiseimpl implements CropService {
    private final CropRepository cropRepository;

    public cropServiseimpl(CropRepository cropRepository) {
        this.cropRepository = cropRepository;
    }

    @Override
    public List<CropResponse> getAllCrops() {

        List<Crop> crops = cropRepository.findAll();

        return crops.stream()
                .map(crop -> new CropResponse(
                        crop.getId(),
                        crop.getName(),
                        crop.getSeason(),
                        crop.getPricePerKg()
                ))
                .toList();
    }
}