package com.hakaton.ReportService.repositories;

import com.hakaton.ReportService.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepo extends JpaRepository<Publication,Long> {
}
