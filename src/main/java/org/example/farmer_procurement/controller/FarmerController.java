package org.example.farmer_procurement.controller;

import jakarta.validation.Valid;
import org.example.farmer_procurement.dto_request.FarmerRegistrationRequest;
import org.example.farmer_procurement.dto_request.LoginRequest;
import org.example.farmer_procurement.dto_response.FarmerRegistrationResponse;
import org.example.farmer_procurement.dto_response.LoginResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.farmer_procurement.service.FarmerService;

@RestController
@RequestMapping("/farmer")
public class FarmerController {
  private final FarmerService farmerService;
    public  FarmerController(FarmerService farmerService){
        this.farmerService = farmerService;
    }
    @PostMapping("/register")
    public FarmerRegistrationResponse registerFarmer(
            @Valid @RequestBody FarmerRegistrationRequest farmerRegistrationRequest
            ){
        return farmerService.registerFarmer(farmerRegistrationRequest);
    }
    @PostMapping("/login")
    public LoginResponse loginFarmer(
            @Valid @RequestBody LoginRequest farmerLoginRequest
    ) {
        return farmerService.loginFarmer(farmerLoginRequest);
    }

}
