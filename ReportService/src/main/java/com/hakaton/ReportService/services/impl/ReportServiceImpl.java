package com.hakaton.ReportService.services.impl;

import com.hakaton.ReportService.entities.Publication;
import com.hakaton.ReportService.entities.Report;
import com.hakaton.ReportService.entities.ReportDate;
import com.hakaton.ReportService.entities.dtos.requestPost.RequestReport;
import com.hakaton.ReportService.repositories.PublicationRepo;
import com.hakaton.ReportService.repositories.ReportDateRepo;
import com.hakaton.ReportService.repositories.ReportRepo;
import com.hakaton.ReportService.repositories.impl.RequestReportRepoimpl;
import com.hakaton.ReportService.services.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    private final PublicationRepo publicationRepo;
    private  final ReportDateRepo reportDateRepo;
    private final ReportRepo reportRepo;
    private final RequestReportRepoimpl requestReportRepo;

    public ReportServiceImpl(PublicationRepo publicationRepo, ReportDateRepo reportDateRepo, ReportRepo reportRepo,
                             RequestReportRepoimpl requestReportRepo) {
        this.publicationRepo = publicationRepo;
        this.reportDateRepo = reportDateRepo;
        this.reportRepo = reportRepo;

        this.requestReportRepo = requestReportRepo;
    }

    @Override
    public ResponseEntity<?> save(RequestReport requestReport) {
        Publication publication = new Publication();
        publication.setText(requestReport.getText());
        publication = publicationRepo.save(publication);

        ReportDate reportDate = new ReportDate();
        reportDate.setCreateDate(requestReport.getCreatedDate());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2100,0,1);
        reportDate.setEndDate(calendar.getTime());
        reportDate = reportDateRepo.save(reportDate);

        Report report = new Report();
        report.setUserId(requestReport.getUserId());
        report.setReportDate(reportDate);
        report.setPublication(publication);
        report = reportRepo.save(report);


        requestReport.setReportId(report.getId());
        requestReport.setCreatedDate(reportDate.getCreateDate());

        return ResponseEntity.ok(requestReport);
    }

    @Override
    public ResponseEntity<?> listReports() {
        List<RequestReport> requestReportList = requestReportRepo.getList();
        return ResponseEntity.ok(requestReportList);
    }
}
