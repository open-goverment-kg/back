package com.hakaton.ReportService.repositories;

import com.hakaton.ReportService.entities.dtos.requestPost.RequestReport;

import java.util.List;

public interface RequestReportRepo {
    public List<RequestReport> getList();
}
