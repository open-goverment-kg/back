package com.hakaton.ReportService.services;

import com.hakaton.ReportService.entities.dtos.requestPost.RequestReport;
import org.springframework.http.ResponseEntity;

public interface ReportService {

     ResponseEntity<?> save(RequestReport requestReport);

    ResponseEntity<?> listReports();
}
