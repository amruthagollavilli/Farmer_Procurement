package org.example.farmer_procurement.dto_response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FarmerRegistrationResponse {
    private String message;
    private String name;
    private Long mobileNumber;
    private Long farmerId;
    private String preferredLanguage;


    public FarmerRegistrationResponse(String message,
                                      Long farmerId,
                                      String name,
                                      Long mobileNumber,
                                      String preferredLanguage) {
        this.message = message;
        this.farmerId = farmerId;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.preferredLanguage = preferredLanguage;
    }
}
