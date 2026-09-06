package org.example.farmer_procurement.config;

import org.example.farmer_procurement.entity.Procurement;
import org.example.farmer_procurement.repository.ProcurementCentreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializerProcurement {

    @Bean
    CommandLineRunner loadProcurementCentres(
            ProcurementCentreRepository procurementCentreRepository) {

        return args -> {

            if (procurementCentreRepository.count() == 0) {

                procurementCentreRepository.save(
                        new Procurement(null, "Guntur Procurement Centre")
                );

                procurementCentreRepository.save(
                        new Procurement(null, "Vijayawada Procurement Centre")
                );

                procurementCentreRepository.save(
                        new Procurement(null, "Warangal Procurement Centre")
                );

                procurementCentreRepository.save(
                        new Procurement(null, "Visakhapatnam Procurement Centre")
                );
            }
        };
    }
}