package org.example.farmer_procurement.serviceImpl;

import org.example.farmer_procurement.dto_response.ProcurementResponse;
import org.example.farmer_procurement.entity.Procurement;
import org.example.farmer_procurement.repository.ProcurementCentreRepository;
import org.example.farmer_procurement.service.ProcurementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcurementServiceImpl implements ProcurementService {

    private final ProcurementCentreRepository procurementCentreRepository;

    public ProcurementServiceImpl(ProcurementCentreRepository procurementCentreRepository) {
        this.procurementCentreRepository = procurementCentreRepository;
    }

    @Override
    public List<ProcurementResponse> getAllCentres() {

        List<Procurement> centres = procurementCentreRepository.findAll();

        return centres.stream()
                .map(centre -> new ProcurementResponse(
                        centre.getId(),
                        centre.getCentreName()
                ))
                .toList();
    }
}