package org.example.farmer_procurement.serviceImpl;

import org.example.farmer_procurement.dto_request.BookingRequest;
import org.example.farmer_procurement.dto_response.BookingResponse;
import org.example.farmer_procurement.entity.*;
import org.example.farmer_procurement.repository.BookingRepository;
import org.example.farmer_procurement.repository.CropRepository;
import org.example.farmer_procurement.repository.FarmerRepository;
import org.example.farmer_procurement.repository.ProcurementCentreRepository;
import org.example.farmer_procurement.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final FarmerRepository farmerRepository;
    private final CropRepository cropRepository;
    private final ProcurementCentreRepository procurementCentreRepository;

    public BookingServiceImpl(
            BookingRepository bookingRepository,
            FarmerRepository farmerRepository,
            CropRepository cropRepository,
            ProcurementCentreRepository procurementCentreRepository) {

        this.bookingRepository = bookingRepository;
        this.farmerRepository = farmerRepository;
        this.cropRepository = cropRepository;
        this.procurementCentreRepository = procurementCentreRepository;
    }

    @Override
    public BookingResponse createBooking(BookingRequest request) {

        Farmer farmer = farmerRepository.findByFarmerId(request.getFarmerId())
                .orElseThrow(() ->
                        new RuntimeException("Farmer not found"));

        Crop crop = cropRepository.findById(request.getCropId())
                .orElseThrow(() ->
                        new RuntimeException("Crop not found"));

        Procurement centre = procurementCentreRepository
                .findById(request.getProcurementCentreId())
                .orElseThrow(() ->
                        new RuntimeException("Procurement centre not found"));

        Double pricePerKg = crop.getPricePerKg();

        Double totalAmount =
                request.getQuantityKg() * pricePerKg;

        Booking booking = new Booking();

        booking.setFarmer(farmer);
        booking.setCrop(crop);
        booking.setProcurement(centre);
        booking.setQuantityKg(request.getQuantityKg());
        booking.setPricePerKg(pricePerKg);
        booking.setTotalAmount(totalAmount);
        booking.setBookingDate(LocalDateTime.now());

        Booking savedBooking =
                bookingRepository.save(booking);

        return new BookingResponse(
                savedBooking.getId(),
                farmer.getFarmerId(),
                crop.getName(),
                centre.getCentreName(),
                savedBooking.getQuantityKg(),
                savedBooking.getPricePerKg(),
                savedBooking.getTotalAmount(),
                savedBooking.getBookingDate(),
                "Booking successful"
        );
    }

    @Override
    public List<BookingResponse> getBookingHistory(Long farmerId) {

        Farmer farmer = farmerRepository.findByFarmerId(farmerId)
                .orElseThrow(() ->
                        new RuntimeException("Farmer not found"));

        List<Booking> bookings =
                bookingRepository.findByFarmer(farmer);

        return bookings.stream()
                .map(booking -> new BookingResponse(
                        booking.getId(),
                        farmer.getFarmerId(),
                        booking.getCrop().getName(),
                        booking.getProcurement().getCentreName(),
                        booking.getQuantityKg(),
                        booking.getPricePerKg(),
                        booking.getTotalAmount(),
                        booking.getBookingDate(),
                        "Booking history"
                ))
                .toList();
    }
}