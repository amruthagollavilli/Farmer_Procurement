package org.example.farmer_procurement.serviceImpl;

import org.example.farmer_procurement.dto_request.FarmerRegistrationRequest;
import org.example.farmer_procurement.dto_request.LoginRequest;
import org.example.farmer_procurement.dto_response.FarmerRegistrationResponse;
import org.example.farmer_procurement.dto_response.LoginResponse;
import org.example.farmer_procurement.entity.Farmer;
import org.example.farmer_procurement.repository.FarmerRepository;
import org.example.farmer_procurement.service.FarmerService;
import org.springframework.stereotype.Service;

@Service
public class FarmerServiceImpl implements FarmerService {

    private final FarmerRepository farmerRepository;

    public FarmerServiceImpl(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    @Override
    public FarmerRegistrationResponse registerFarmer(
            FarmerRegistrationRequest request) {

        if (farmerRepository.existsByFarmerId(request.getFarmerId())) {
            throw new RuntimeException("Farmer Id already exists");
        }

        if (farmerRepository.existsByMobileNumber(request.getMobileNumber())) {
            throw new RuntimeException("Mobile number already exists");
        }

        Farmer farmer = new Farmer();

        farmer.setName(request.getName());
        farmer.setMobileNumber(request.getMobileNumber());
        farmer.setFarmerId(request.getFarmerId());
        farmer.setPassword(request.getPassword());
        farmer.setPreferredLanguage(request.getPreferredLanguage());

        Farmer savedFarmer = farmerRepository.save(farmer);

        return new FarmerRegistrationResponse(
                "Farmer registered successfully",
                savedFarmer.getFarmerId(),
                savedFarmer.getName(),
                savedFarmer.getMobileNumber(),
                savedFarmer.getPreferredLanguage()
        );
    }

    @Override
    public LoginResponse loginFarmer(LoginRequest request) {

        String loginValue = request.getLoginValue();

        Farmer farmer;

        if (loginValue.length() == 10) {

            Long mobileNumber = Long.parseLong(loginValue);

            farmer = farmerRepository.findByMobileNumber(mobileNumber)
                    .orElseThrow(() ->
                            new RuntimeException("Farmer not found"));

        } else if (loginValue.length() == 12) {

            Long farmerId = Long.parseLong(loginValue);

            farmer = farmerRepository.findByFarmerId(farmerId)
                    .orElseThrow(() ->
                            new RuntimeException("Farmer not found"));

        } else {

            throw new RuntimeException(
                    "Enter a valid 10 digit mobile number or 12 digit Farmer ID"
            );
        }

        if (!farmer.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return new LoginResponse(
                "Login successful",
                farmer.getFarmerId(),
                farmer.getName(),
                farmer.getMobileNumber(),
                farmer.getPreferredLanguage()
        );
    }

    @Override
    public FarmerRegistrationResponse getFarmerById(Long farmerId) {

        Farmer farmer = farmerRepository.findByFarmerId(farmerId)
                .orElseThrow(() ->
                        new RuntimeException("Farmer not found"));

        return new FarmerRegistrationResponse(
                "Farmer found",
                farmer.getFarmerId(),
                farmer.getName(),
                farmer.getMobileNumber(),
                farmer.getPreferredLanguage()
        );
    }
}