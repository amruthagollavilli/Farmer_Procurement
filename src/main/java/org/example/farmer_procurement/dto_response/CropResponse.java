package org.example.farmer_procurement.dto_response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CropResponse {

    private Long id;
    private String cropName;
    private String season;
    private Double pricePerKg;
}