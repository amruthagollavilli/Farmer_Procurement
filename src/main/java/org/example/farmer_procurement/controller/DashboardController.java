package org.example.farmer_procurement.controller;

import org.example.farmer_procurement.dto_response.DashboardResponse;
import org.example.farmer_procurement.service.DashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/{farmerId}")
    public DashboardResponse getDashboard(
            @PathVariable Long farmerId) {

        return dashboardService.getDashboard(farmerId);
    }
}