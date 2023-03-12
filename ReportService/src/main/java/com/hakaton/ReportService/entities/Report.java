package com.hakaton.ReportService.entities;

import com.hakaton.ReportService.enums.ReportStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    Publication publication;
    @OneToOne
    ReportDate reportDate;
    @Enumerated(value = EnumType.STRING)
    ReportStatus reportStatus = ReportStatus.UNCHECKED;
    Long userId;


}
