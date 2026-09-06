package org.example.farmer_procurement.repository;
import org.example.farmer_procurement.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FarmerRepository extends JpaRepository<Farmer,Long>{
    Optional<Farmer> findByMobileNumber(Long mobileNumber);

    Optional<Farmer> findByFarmerId(Long farmerId);

    boolean existsByFarmerId(Long farmerId);

    boolean existsByMobileNumber(Long mobileNumber);
}
