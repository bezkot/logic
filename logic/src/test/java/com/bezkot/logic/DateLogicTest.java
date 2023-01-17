package com.bezkot.logic;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;


import static com.bezkot.logic.DateLogic.*;

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
    void less_True() {
        assertTrue(less(ld_2022_11_02, ld_2022_12_31));
    }
    @Test
    void less_False() {
        assertFalse(less(ld_2022_12_31, ld_2022_11_02));
    }

    @Test
    void more_True() {
        assertTrue(more(ld_2023_01_17, ld_2022_11_02));
    }
    @Test
    void more_False() {
        assertFalse(more(ld_2022_11_02, ld_2023_01_17));
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
    void lessOrEqual_True() {
        assertTrue(lessOrEqual(ld_2022_11_02, ld_2022_12_31));
    }
    @Test
    void lessOrEqual_False() {
        assertFalse(lessOrEqual(ld_2023_01_17, ld_2022_11_02));
    }

    @Test
    void moreOrEqual_True() {
        assertTrue(moreOrEqual(ld_2023_01_17, ld_2022_11_02));
    }
    @Test
    void moreOrEqual_False() {
        assertFalse(moreOrEqual(ld_2022_11_02, ld_2022_12_31));
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
