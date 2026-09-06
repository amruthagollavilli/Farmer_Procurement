package org.example.farmer_procurement.dto_response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private Long farmerId;
    private String farmerName;

    private Long totalBookings;
    private Double totalQuantityKg;
    private Double totalAmount;
}