package org.example.farmer_procurement.service;

import org.example.farmer_procurement.dto_request.FarmerRegistrationRequest;
import org.example.farmer_procurement.dto_request.LoginRequest;
import org.example.farmer_procurement.dto_response.FarmerRegistrationResponse;
import org.example.farmer_procurement.dto_response.LoginResponse;

public interface FarmerService {

    FarmerRegistrationResponse registerFarmer(
            FarmerRegistrationRequest request
    );

    LoginResponse loginFarmer(
            LoginRequest request
    );

    FarmerRegistrationResponse getFarmerById(
            Long farmerId
    );
}