package com.bezkot.logic;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.bezkot.logic.BigDecimalLogic.*;
import static org.junit.jupiter.api.Assertions.*;

public class BigDecimalLogicTest {
    @Test
    void equal_True() {
        assertTrue(equal(new BigDecimal("2.3"), new BigDecimal("2.30")));
    }
    @Test
    void equal_False() {
        assertFalse(equal(new BigDecimal("2.3"), new BigDecimal("2.31")));
    }

    @Test
    void lessThan_True() {
        assertTrue(lessThan(new BigDecimal("2.3"), new BigDecimal("2.35")));
    }
    @Test
    void lessThan_False() {
        assertFalse(lessThan(new BigDecimal("2.35"), new BigDecimal("2.30")));
    }

    @Test
    void greaterThan_True() {
        assertTrue(greaterThan(new BigDecimal("2.38"), new BigDecimal("2.35")));
    }
    @Test
    void greaterThan_False() {
        assertFalse(greaterThan(new BigDecimal("2.35"), new BigDecimal("2.39")));
    }

    @Test
    void notEqual_True() {
        assertTrue(notEqual(new BigDecimal("2.3"), new BigDecimal("2.31")));
    }
    @Test
    void notEqual_False() {
        assertFalse(notEqual(new BigDecimal("2.3"), new BigDecimal("2.30")));
    }

    @Test
    void lessThanOrEqual_True() {
        assertTrue(lessThanOrEqual(new BigDecimal("2.3"), new BigDecimal("2.44")));
    }
    @Test
    void lessThanOrEqual_False() {
        assertFalse(lessThanOrEqual(new BigDecimal("2.44"), new BigDecimal("2.30")));
    }

    @Test
    void greaterThanOrEqual_True() {
        assertTrue(greaterThanOrEqual(new BigDecimal("2.3"), new BigDecimal("2.12")));
    }
    @Test
    void greaterThanOrEqual_False() {
        assertFalse(greaterThanOrEqual(new BigDecimal("2.12"), new BigDecimal("2.30")));
    }

    @Test
    void isZero_True1() {
        assertTrue(isZero(BigDecimal.ZERO));
    }
    @Test
    void isZero_True2() {
        assertTrue(isZero(new BigDecimal("0.0")));
    }
    @Test
    void isZero_True3() {
        assertTrue(isZero(new BigDecimal("0.0")));
    }
    @Test
    void isZero_False() {
        assertFalse(isZero(new BigDecimal("12.435")));
    }

    @Test
    void lessThanZero_True() {
        assertTrue(lessThanZero(new BigDecimal("-2.3")));
    }
    @Test
    void lessThanZero_False() {
        assertFalse(lessThanZero(new BigDecimal("4.345")));
    }

    @Test
    void greaterThanZero_True() {
        assertTrue(greaterThanZero(new BigDecimal("2.3")));
    }
    @Test
    void greaterThanZero_False() {
        assertFalse(greaterThanZero(new BigDecimal("-4.345")));
    }
}
