package com.bezkot.logic;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.bezkot.logic.BigDecimalLogic.*;
import static org.junit.jupiter.api.Assertions.*;

public class BigDecimalLogicTest {

    @Test
    void equal_True() {
        assertTrue(equal(BigDecimal.valueOf(2.3), BigDecimal.valueOf(2.30)));
    }
    @Test
    void equal_False() {
        assertFalse(equal(BigDecimal.valueOf(2.3), BigDecimal.valueOf(2.31)));
    }

    @Test
    void less_True() {
        assertTrue(less(BigDecimal.valueOf(2.3), BigDecimal.valueOf(2.35)));
    }
    @Test
    void less_False() {
        assertFalse(less(BigDecimal.valueOf(2.35), BigDecimal.valueOf(2.30)));
    }

    @Test
    void more_True() {
        assertTrue(more(BigDecimal.valueOf(2.38), BigDecimal.valueOf(2.35)));
    }
    @Test
    void more_False() {
        assertFalse(more(BigDecimal.valueOf(2.35), BigDecimal.valueOf(2.39)));
    }

    @Test
    void notEqual_True() {
        assertTrue(notEqual(BigDecimal.valueOf(2.3), BigDecimal.valueOf(2.31)));
    }
    @Test
    void notEqual_False() {
        assertFalse(notEqual(BigDecimal.valueOf(2.3), BigDecimal.valueOf(2.30)));
    }

    @Test
    void lessOrEqual_True() {
        assertTrue(lessOrEqual(BigDecimal.valueOf(2.3), BigDecimal.valueOf(2.44)));
    }
    @Test
    void lessOrEqual_False() {
        assertFalse(lessOrEqual(BigDecimal.valueOf(2.44), BigDecimal.valueOf(2.30)));
    }

    @Test
    void moreOrEqual_True() {
        assertTrue(moreOrEqual(BigDecimal.valueOf(2.3), BigDecimal.valueOf(2.12)));
    }
    @Test
    void moreOrEqual_False() {
        assertFalse(moreOrEqual(BigDecimal.valueOf(2.12), BigDecimal.valueOf(2.30)));
    }

    @Test
    void isZero_True1() {
        assertTrue(isZero(BigDecimal.ZERO));
    }
    @Test
    void isZero_True2() {
        assertTrue(isZero(BigDecimal.valueOf(0.0)));
    }
    @Test
    void isZero_True3() {
        assertTrue(isZero(new BigDecimal("0.0")));
    }
    @Test
    void isZero_False() {
        assertFalse(isZero(BigDecimal.valueOf(12.435)));
    }

    @Test
    void lessZero_True() {
        assertTrue(lessZero(BigDecimal.valueOf(-2.3)));
    }
    @Test
    void lessZero_False() {
        assertFalse(lessZero(new BigDecimal("4.345")));
    }

    @Test
    void moreZero_True() {
        assertTrue(moreZero(BigDecimal.valueOf(2.3)));
    }
    @Test
    void moreZero_False() {
        assertFalse(moreZero(new BigDecimal("-4.345")));
    }
}
