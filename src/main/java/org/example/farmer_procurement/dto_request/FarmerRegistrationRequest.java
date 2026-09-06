package org.example.farmer_procurement.dto_request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FarmerRegistrationRequest {

   @NotBlank(message = "Name is required")
   private String name;

   @NotNull(message = "Mobile number is required")
   @Digits(integer = 10, fraction = 0, message = "Mobile number must contain exactly 10 digits")
   private Long mobileNumber;

   @NotNull(message = "Farmer ID is required")
   @Digits(integer = 12, fraction = 0, message = "Farmer ID must contain exactly 12 digits")
   private Long farmerId;

   @NotBlank(message = "Password is required")
   @Size(min = 8, message = "Password must contain at least 8 characters")
   private String password;

   @Pattern(
           regexp = "^(English|Hindi|Telugu)$",
           message = "Preferred language must be English, Hindi, or Telugu"
   )
   private String preferredLanguage;
}
