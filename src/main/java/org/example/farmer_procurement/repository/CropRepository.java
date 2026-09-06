package org.example.farmer_procurement.repository;

import org.example.farmer_procurement.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop,Long>{
}
