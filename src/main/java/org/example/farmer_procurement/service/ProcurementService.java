package org.example.farmer_procurement.service;

import org.example.farmer_procurement.dto_response.ProcurementResponse;

import java.util.List;

public interface ProcurementService {

    List<ProcurementResponse> getAllCentres();
}