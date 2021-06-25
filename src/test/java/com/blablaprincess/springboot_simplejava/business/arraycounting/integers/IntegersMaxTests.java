package com.blablaprincess.springboot_simplejava.business.arraycounting.integers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegersMaxTests {

    @Test
    void countWithPositiveSet() {
        // Arrange
        Integer[] set = {1, 2, 3, 4, 5, 5};

        // Act
        double result = new IntegersMax().count(set);

        // Assert
        assertEquals(5, result);
    }

    @Test
    void countWithMixedSet() {
        // Arrange
        Integer[] set = {20, -10};

        // Act
        double result = new IntegersMax().count(set);

        // Assert
        assertEquals(20, result);
    }

    @Test
    void countWithEmptySetThrowsIllegalArgumentException() {
        // Arrange
        Integer[] set = {};

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> new IntegersMax().count(set));
    }

}