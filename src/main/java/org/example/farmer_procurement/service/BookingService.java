package org.example.farmer_procurement.service;

import org.example.farmer_procurement.dto_request.BookingRequest;
import org.example.farmer_procurement.dto_response.BookingResponse;

import java.util.List;

public interface BookingService {

    BookingResponse createBooking(BookingRequest bookingRequest);
    List<BookingResponse> getBookingHistory(Long farmerId);
}