package com.bezkot.logic;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.bezkot.logic.DateTimeLogic.*;
import static org.junit.jupiter.api.Assertions.*;

public class DateTimeLogicTest {
    private final LocalDateTime ldt_2022_11_02__12_30_22 = LocalDateTime.of(2022, 11, 2, 12, 30, 22);
    private final LocalDateTime ldt_2022_12_31__18_15_04 = LocalDateTime.of(2022, 12, 31, 18, 15, 4);
    private final LocalDateTime ldt_2023_01_17__21_22_56 = LocalDateTime.of(2023, 1, 17, 21, 22,56);

    @Test
    void equal_True() {
        assertTrue(equal(ldt_2022_11_02__12_30_22, LocalDateTime.of(2022, 11, 2, 12, 30, 22)));
    }
    @Test
    void equal_False() {
        assertFalse(equal(ldt_2022_11_02__12_30_22, ldt_2022_12_31__18_15_04));
    }

    @Test
    void less_True() {
        assertTrue(less(ldt_2022_11_02__12_30_22, ldt_2022_12_31__18_15_04));
    }
    @Test
    void less_False() {
        assertFalse(less(ldt_2022_12_31__18_15_04, ldt_2022_11_02__12_30_22));
    }

    @Test
    void more_True() {
        assertTrue(more(ldt_2023_01_17__21_22_56, ldt_2022_11_02__12_30_22));
    }
    @Test
    void more_False() {
        assertFalse(more(ldt_2022_11_02__12_30_22, ldt_2023_01_17__21_22_56));
    }

    @Test
    void notEqual_True() {
        assertTrue(notEqual(ldt_2022_11_02__12_30_22, ldt_2022_12_31__18_15_04));
    }
    @Test
    void notEqual_False() {
        assertFalse(notEqual(ldt_2022_11_02__12_30_22, LocalDateTime.of(2022, 11, 2, 12, 30, 22)));
    }

    @Test
    void lessOrEqual_True() {
        assertTrue(lessOrEqual(ldt_2022_11_02__12_30_22, ldt_2022_12_31__18_15_04));
    }
    @Test
    void lessOrEqual_False() {
        assertFalse(lessOrEqual(ldt_2023_01_17__21_22_56, ldt_2022_11_02__12_30_22));
    }

    @Test
    void moreOrEqual_True() {
        assertTrue(moreOrEqual(ldt_2023_01_17__21_22_56, ldt_2022_11_02__12_30_22));
    }
    @Test
    void moreOrEqual_False() {
        assertFalse(moreOrEqual(ldt_2022_11_02__12_30_22, ldt_2022_12_31__18_15_04));
    }

    @Test
    void inRangeIncludeBounds_True() {
        assertTrue(inRangeIncludeBounds(LocalDateTime.of(2022, 11, 2, 12, 30, 22), ldt_2022_11_02__12_30_22, ldt_2022_12_31__18_15_04));
    }
    @Test
    void inRangeIncludeBounds_False() {
        assertFalse(inRangeIncludeBounds(ldt_2023_01_17__21_22_56, ldt_2022_11_02__12_30_22, ldt_2022_12_31__18_15_04));
    }

    @Test
    void inRangeExcludeBounds_True() {
        assertTrue(inRangeExcludeBounds(ldt_2022_12_31__18_15_04, ldt_2022_11_02__12_30_22, ldt_2023_01_17__21_22_56));
    }
    @Test
    void inRangeExcludeBounds_False() {
        assertFalse(inRangeExcludeBounds(LocalDateTime.of(2022, 11, 2, 12, 30, 22), ldt_2022_11_02__12_30_22, ldt_2022_12_31__18_15_04));
    }
}
