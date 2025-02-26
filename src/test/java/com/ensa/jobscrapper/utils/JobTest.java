package com.ensa.jobscrapper.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        Long id = 1L;
        String name = "Java Developer";
        String company = "Tech Corp";
        String salary = "10000-15000 PLN";
        String expLevel = "Mid";
        String link = "https://example.com/job/123";

        // Act
        Job job = new Job(id, name, company, salary, expLevel, link);

        // Assert
        assertEquals(id, job.getId());
        assertEquals(name, job.getName());
        assertEquals(company, job.getCompany());
        assertEquals(salary, job.getSalary());
        assertEquals(expLevel, job.getExpLevel());
        assertEquals(link, job.getLink());
    }

    @Test
    void testSetters() {
        // Arrange
        Job job = new Job();
        Long id = 2L;
        String name = "Python Developer";
        String company = "Data Corp";
        String salary = "12000-18000 PLN";
        String expLevel = "Senior";
        String link = "https://example.com/job/456";

        // Act
        job.setId(id);
        job.setName(name);
        job.setCompany(company);
        job.setSalary(salary);
        job.setExpLevel(expLevel);
        job.setLink(link);

        // Assert
        assertEquals(id, job.getId());
        assertEquals(name, job.getName());
        assertEquals(company, job.getCompany());
        assertEquals(salary, job.getSalary());
        assertEquals(expLevel, job.getExpLevel());
        assertEquals(link, job.getLink());
    }
}