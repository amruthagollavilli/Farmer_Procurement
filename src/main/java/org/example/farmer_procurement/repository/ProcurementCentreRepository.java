package org.example.farmer_procurement.repository;

import org.example.farmer_procurement.entity.Procurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcurementCentreRepository extends JpaRepository<Procurement,Long> {
}
