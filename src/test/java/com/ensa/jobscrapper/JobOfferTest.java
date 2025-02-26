package com.ensa.jobscrapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobOfferTest {

    @Test
    void testConstructor() {
        // Arrange & Act
        JobOffer offer = new JobOffer("Java Developer", "Tech Corp", "10000-15000 PLN", "Mid", "https://example.com/job/123");

        // Assert
        assertEquals("Java Developer", offer.name);
        assertEquals("Tech Corp", offer.company);
        assertEquals("10000-15000 PLN", offer.salary);
        assertEquals("Mid", offer.expLevel);
        assertEquals("https://example.com/job/123", offer.link);
    }

    @Test
    void testGetMeanSalary_WithRange() {
        // Arrange
        JobOffer offer = new JobOffer("Java Developer", "Tech Corp", "10000-15000 PLN", "Mid", "https://example.com/job/123");

        // Act
        double meanSalary = offer.getMeanSalary();

        // Assert
        assertEquals(12500.0, meanSalary);
    }

    @Test
    void testGetMeanSalary_WithSingleValue() {
        // Arrange
        JobOffer offer = new JobOffer("Java Developer", "Tech Corp", "10000 PLN", "Mid", "https://example.com/job/123");

        // Act
        double meanSalary = offer.getMeanSalary();

        // Assert
        assertEquals(10000.0, meanSalary);
    }

    @Test
    void testGetMeanSalary_WithDash() {
        // Arrange
        JobOffer offer = new JobOffer("Java Developer", "Tech Corp", "10000–15000 PLN", "Mid", "https://example.com/job/123");

        // Act
        double meanSalary = offer.getMeanSalary();

        // Assert
        assertEquals(12500.0, meanSalary);
    }

    @Test
    void testGetMeanSalary_InvalidFormat() {
        // Arrange
        JobOffer offer = new JobOffer("Java Developer", "Tech Corp", "Not specified", "Mid", "https://example.com/job/123");

        // Act
        double meanSalary = offer.getMeanSalary();

        // Assert - should return 1 for invalid format as per implementation
        assertEquals(1.0, meanSalary);
    }

    @Test
    void testGetters() {
        // Arrange
        JobOffer offer = new JobOffer("Java Developer", "Tech Corp", "10000-15000 PLN", "Mid", "https://example.com/job/123");

        // Act & Assert
        assertEquals("Tech Corp", offer.getCompany());
        assertEquals("Java Developer", offer.getOfferName());
    }
}