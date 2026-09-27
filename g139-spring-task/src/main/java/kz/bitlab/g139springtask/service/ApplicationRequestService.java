package kz.bitlab.g139springtask.service;

import kz.bitlab.g139springtask.model.ApplicationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationRequestService {

    private final Connection connection;

    public List<ApplicationRequest> applicationRequests() {
        List<ApplicationRequest> applicationRequests = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from application_requests"
            );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ApplicationRequest applicationRequest = new ApplicationRequest();
                applicationRequest.setId(resultSet.getLong("id"));
                applicationRequest.setUserName(resultSet.getString("username"));
                applicationRequest.setCourseName(resultSet.getString("courseName"));
                applicationRequest.setCommentary(resultSet.getString("commentary"));
                applicationRequest.setPhone(resultSet.getString("phone"));
                applicationRequest.setHandled(resultSet.getBoolean("handled"));
                applicationRequests.add(applicationRequest);
            }
            preparedStatement.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return applicationRequests;
    }
}
