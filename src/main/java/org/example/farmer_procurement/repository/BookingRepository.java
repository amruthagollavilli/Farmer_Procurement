package org.example.farmer_procurement.repository;

import org.example.farmer_procurement.entity.Booking;
import org.example.farmer_procurement.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByFarmer_Id(Long farmerId);

    List<Booking> findByFarmer(Farmer farmer);
}
