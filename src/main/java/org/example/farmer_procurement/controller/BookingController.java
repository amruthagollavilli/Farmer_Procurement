package org.example.farmer_procurement.controller;

import org.example.farmer_procurement.dto_request.BookingRequest;
import org.example.farmer_procurement.dto_response.BookingResponse;
import org.example.farmer_procurement.service.BookingService;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponse createBooking(
            @Valid @RequestBody BookingRequest bookingRequest) {

        return bookingService.createBooking(bookingRequest);
    }

    @GetMapping("/history/{farmerId}")
    public List<BookingResponse> getBookingHistory(
            @PathVariable Long farmerId) {

        return bookingService.getBookingHistory(farmerId);
    }
}