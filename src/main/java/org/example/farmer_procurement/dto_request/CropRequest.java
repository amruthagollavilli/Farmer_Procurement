package org.example.farmer_procurement.dto_request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CropRequest {
    private Long id;
    private String name;
    private String season;
}
