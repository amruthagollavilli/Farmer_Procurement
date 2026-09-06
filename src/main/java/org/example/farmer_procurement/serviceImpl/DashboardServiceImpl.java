package org.example.farmer_procurement.serviceImpl;

import org.example.farmer_procurement.dto_response.DashboardResponse;
import org.example.farmer_procurement.entity.Booking;
import org.example.farmer_procurement.entity.Farmer;
import org.example.farmer_procurement.exception.ResourceNotFoundException;
import org.example.farmer_procurement.repository.BookingRepository;
import org.example.farmer_procurement.repository.FarmerRepository;
import org.example.farmer_procurement.service.DashboardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final FarmerRepository farmerRepository;
    private final BookingRepository bookingRepository;

    public DashboardServiceImpl(
            FarmerRepository farmerRepository,
            BookingRepository bookingRepository) {

        this.farmerRepository = farmerRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public DashboardResponse getDashboard(Long farmerId) {

        Farmer farmer = farmerRepository.findByFarmerId(farmerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Farmer not found"));

        List<Booking> bookings =
                bookingRepository.findByFarmer(farmer);

        long totalBookings = bookings.size();

        double totalQuantityKg = bookings.stream()
                .mapToDouble(Booking::getQuantityKg)
                .sum();

        double totalAmount = bookings.stream()
                .mapToDouble(Booking::getTotalAmount)
                .sum();

        return new DashboardResponse(
                farmer.getFarmerId(),
                farmer.getName(),
                totalBookings,
                totalQuantityKg,
                totalAmount
        );
    }
}