package com.ensa.jobscrapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlModifierTest {

    @Test
    void testGetModifiedUrls_WithAllParameters() {
        // Arrange
        String location = "remote";
        String offerName = "java developer";
        String expLevel = "mid";

        // Act
        String[] urls = UrlModifier.getModifiedUrls(location, offerName, expLevel);

        // Assert
        assertEquals(2, urls.length);
        assertTrue(urls[0].startsWith("https://nofluffjobs.com/remote"));
        assertTrue(urls[0].contains("seniority%3Dmid"));

        assertTrue(urls[1].startsWith("https://justjoin.it/remote"));
        assertTrue(urls[1].contains("experience-level_mid"));
        assertTrue(urls[1].contains("keyword=java+developer"));
    }

    @Test
    void testGetModifiedUrls_WithEmptyParameters() {
        // Arrange
        String location = "";
        String offerName = "";
        String expLevel = "";

        // Act
        String[] urls = UrlModifier.getModifiedUrls(location, offerName, expLevel);

        // Assert
        assertEquals(2, urls.length);
        assertEquals("https://nofluffjobs.com/?page=1&criteria=", urls[0]);
        assertEquals("https://justjoin.it/with-salary_yes?", urls[1]);
    }

    @Test
    void testGetModifiedUrls_OnlyLocation() {
        // Arrange
        String location = "warsaw";
        String offerName = "";
        String expLevel = "";

        // Act
        String[] urls = UrlModifier.getModifiedUrls(location, offerName, expLevel);

        // Assert
        assertEquals(2, urls.length);
        assertEquals("https://nofluffjobs.com/warsaw?page=1&criteria=", urls[0]);
        assertEquals("https://justjoin.it/warsaw/with-salary_yes?", urls[1]);
    }

    @Test
    void testGetModifiedUrls_OnlyOfferName() {
        // Arrange
        String location = "";
        String offerName = "python developer";
        String expLevel = "";

        // Act
        String[] urls = UrlModifier.getModifiedUrls(location, offerName, expLevel);

        // Assert
        assertEquals(2, urls.length);
        assertTrue(urls[1].contains("keyword=python+developer"));
    }
}