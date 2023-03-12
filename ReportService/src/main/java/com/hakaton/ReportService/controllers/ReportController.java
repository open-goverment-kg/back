package com.hakaton.ReportService.controllers;

import com.hakaton.ReportService.entities.dtos.requestPost.RequestReport;
import com.hakaton.ReportService.services.ReportService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveReport(@RequestBody RequestReport requestReport) {
        return ResponseEntity.ok(reportService.save(requestReport));
    }

    @GetMapping("/list")
    public  ResponseEntity<?> getListReports(){
        return ResponseEntity.ok(reportService.listReports());
    }

}
