package org.example.farmer_procurement.config;

import org.example.farmer_procurement.entity.Crop;
import org.example.farmer_procurement.repository.CropRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner loadCropData(CropRepository cropRepository){
       return args -> {
           cropRepository.save(new Crop(null, "Rice", "Kharif", 23.0));
           cropRepository.save(new Crop(null, "Wheat", "Rabi", 25.0));
           cropRepository.save(new Crop(null, "Maize", "Kharif", 22.0));
           cropRepository.save(new Crop(null, "Cotton", "Kharif", 70.0));
           cropRepository.save(new Crop(null, "Pulses", "Kharif / Rabi", 60.0));
           cropRepository.save(new Crop(null, "Groundnut", "Kharif", 55.0));
       };
       }
    }
