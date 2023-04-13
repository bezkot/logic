package com.bezkot.logic;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.bezkot.logic.BaseLogic.*;
import static org.junit.jupiter.api.Assertions.*;

public class DateLogicTest {
    private final LocalDate ld_2022_11_02 = LocalDate.of(2022, 11, 2);
    private final LocalDate ld_2022_12_31 = LocalDate.of(2022, 12, 31);
    private final LocalDate ld_2023_01_17 = LocalDate.of(2023, 1, 17);

    @Test
    void equal_True() {
        assertTrue(equal(ld_2022_11_02, LocalDate.of(2022, 11, 2)));
    }
    @Test
    void equal_False() {
        assertFalse(equal(ld_2022_11_02, ld_2022_12_31));
    }

    @Test
    void lessThan_True() {
        assertTrue(lessThan(ld_2022_11_02, ld_2022_12_31));
    }
    @Test
    void lessThan_False() {
        assertFalse(lessThan(ld_2022_12_31, ld_2022_11_02));
    }

    @Test
    void greaterThan_True() {
        assertTrue(greaterThan(ld_2023_01_17, ld_2022_11_02));
    }
    @Test
    void greaterThan_False() {
        assertFalse(greaterThan(ld_2022_11_02, ld_2023_01_17));
    }

    @Test
    void notEqual_True() {
        assertTrue(notEqual(ld_2022_11_02, ld_2022_12_31));
    }
    @Test
    void notEqual_False() {
        assertFalse(notEqual(ld_2022_11_02, LocalDate.of(2022, 11, 2)));
    }

    @Test
    void lessThanOrEqual_True() {
        assertTrue(lessThanOrEqual(ld_2022_11_02, ld_2022_12_31));
    }
    @Test
    void lessThanOrEqual_False() {
        assertFalse(lessThanOrEqual(ld_2023_01_17, ld_2022_11_02));
    }

    @Test
    void greaterThanOrEqual_True() {
        assertTrue(greaterThanOrEqual(ld_2023_01_17, ld_2022_11_02));
    }
    @Test
    void greaterThanOrEqual_False() {
        assertFalse(greaterThanOrEqual(ld_2022_11_02, ld_2022_12_31));
    }

    @Test
    void inRangeIncludeBounds_True() {
        assertTrue(inRangeIncludeBounds(LocalDate.of(2022, 11, 2), ld_2022_11_02, ld_2022_12_31));
    }
    @Test
    void inRangeIncludeBounds_False() {
        assertFalse(inRangeIncludeBounds(ld_2023_01_17, ld_2022_11_02, ld_2022_12_31));
    }

    @Test
    void inRangeExcludeBounds_True() {
        assertTrue(inRangeExcludeBounds(ld_2022_12_31, ld_2022_11_02, ld_2023_01_17));
    }
    @Test
    void inRangeExcludeBounds_False() {
        assertFalse(inRangeExcludeBounds(LocalDate.of(2022, 11, 2), ld_2022_11_02, ld_2022_12_31));
    }
}
