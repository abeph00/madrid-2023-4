package com.inditex.zboost.controller;

import com.inditex.zboost.entity.Product;
import com.inditex.zboost.entity.ReportSummary;
import com.inditex.zboost.service.ProductService;
import com.inditex.zboost.service.ReportSummaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController

public class ReportSummaryController {

    private ReportSummaryService reportSummaryService;

    public ReportSummaryController(ReportSummaryService reportSummaryService) {
        this.reportSummaryService = reportSummaryService;
    }

    @GetMapping("/report-summary")
    public ReportSummary reportSummary() {
        return reportSummaryService.reportSummary();
    }

}
