package com.hakaton.ReportService.entities.dtos.requestPost;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class RequestReport {
    Long reportId;
    Long userId;
    String text;
    Date createdDate;

}
