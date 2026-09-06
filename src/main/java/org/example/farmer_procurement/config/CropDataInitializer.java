package org.example.farmer_procurement.config;

import org.example.farmer_procurement.entity.Crop;
import org.example.farmer_procurement.repository.CropRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CropDataInitializer implements CommandLineRunner {

    private final CropRepository cropRepository;

    public CropDataInitializer(CropRepository cropRepository) {
        this.cropRepository = cropRepository;
    }

    @Override
    public void run(String... args) {

        if (cropRepository.count() == 0) {

            List<Crop> crops = List.of(
                    new Crop(null, "Rice", "Kharif", 23.0),
                    new Crop(null, "Wheat", "Rabi", 25.0),
                    new Crop(null, "Maize", "Kharif", 22.0),
                    new Crop(null, "Cotton", "Kharif", 70.0),
                    new Crop(null, "Pulses", "Kharif / Rabi", 60.0),
                    new Crop(null, "Groundnut", "Kharif", 55.0)
            );

            cropRepository.saveAll(crops);

            System.out.println("Crop data inserted successfully.");

        } else {

            System.out.println("Crop data already exists. Skipping initialization.");
        }
    }
}