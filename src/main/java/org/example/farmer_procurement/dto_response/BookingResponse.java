package org.example.farmer_procurement.dto_response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {

    private Long bookingId;
    private Long farmerId;
    private String cropName;
    private String centreName;
    private Double quantityKg;
    private Double pricePerKg;
    private Double totalAmount;
    private LocalDateTime bookingDate;
    private LocalDate scheduledDate;
    private LocalTime scheduledTime;
    private String message;
}