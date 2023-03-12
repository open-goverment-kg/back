package com.hakaton.ReportService.repositories;

import com.hakaton.ReportService.entities.ReportDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportDateRepo extends JpaRepository<ReportDate,Long> {
}
