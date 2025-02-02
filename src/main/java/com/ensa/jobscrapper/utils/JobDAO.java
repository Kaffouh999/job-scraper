package com.ensa.jobscrapper.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {
    private static final Logger logger = LogManager.getLogger(JobDAO.class);

    public void createJobsTable() {
        String sql = """
                    CREATE TABLE IF NOT EXISTS jobs (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(255),
                        company VARCHAR(255),
                        salary VARCHAR(255),
                        expLevel VARCHAR(255),
                        url VARCHAR(255),
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                    )
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            logger.error("Error creating jobs table", e);
        }
    }

    public void saveJob(Job job) {
        String sql = """
                    INSERT INTO jobs (name, company, salary, expLevel, url)
                    VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, job.getName());
            pstmt.setString(2, job.getCompany());
            pstmt.setString(3, job.getSalary());
            pstmt.setString(4, job.getExpLevel());
            pstmt.setString(5, job.getLink());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error saving job", e);
        }
    }

    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT * FROM jobs ORDER BY created_at DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Job job = new Job();
                job.setId(rs.getLong("id"));
                job.setName(rs.getString("name"));
                job.setCompany(rs.getString("company"));
                job.setSalary(rs.getString("salary"));
                job.setExpLevel(rs.getString("expLevel"));
                job.setLink(rs.getString("url"));
                jobs.add(job);
            }
        } catch (SQLException e) {
            logger.error("Error retrieving jobs", e);
        }
        return jobs;
    }
}
