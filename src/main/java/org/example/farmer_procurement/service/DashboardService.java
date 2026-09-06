package org.example.farmer_procurement.service;

import org.example.farmer_procurement.dto_response.DashboardResponse;

public interface DashboardService {

    DashboardResponse getDashboard(Long farmerId);
}