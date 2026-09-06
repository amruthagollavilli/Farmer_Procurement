package org.example.farmer_procurement.dto_request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    
    @NotBlank(message = "Mobile number or Farmer ID is required")
    private String loginValue;

    @NotBlank(message = "password is required")
    private String password;

}
