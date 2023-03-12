package com.hakaton.ReportService.repositories.impl;

import com.hakaton.ReportService.entities.dtos.requestPost.RequestReport;
import com.hakaton.ReportService.repositories.RequestReportRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RequestReportRepoimpl implements RequestReportRepo {
    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    public List<RequestReport> getList(){



    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select rp.id,rp.user_id,pb.text,dt.create_date from\n" +
                    "    reports rp\n" +
                    "        join publications pb on rp.publication_id = pb.id\n" +
                    "        join reports_date dt on rp.report_date_id = dt.id where dt.end_date > now()\n"
                    ); {

                List<RequestReport> requestReportList = new ArrayList<>();

                while (rs.next()) {
                    RequestReport requestReport = new RequestReport();
                    requestReport.setReportId(rs.getLong(1));
                    requestReport.setUserId(rs.getLong(2));
                    requestReport.setText(rs.getString(3));
                    requestReport.setCreatedDate(rs.getDate(4));
                    requestReportList.add(requestReport);
                }

                return requestReportList;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
}
