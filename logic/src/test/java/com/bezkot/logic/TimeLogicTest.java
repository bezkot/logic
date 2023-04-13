package com.bezkot.logic;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static com.bezkot.logic.BaseLogic.*;
import static org.junit.jupiter.api.Assertions.*;

public class TimeLogicTest {
    private final LocalTime lt_12_30_22 = LocalTime.of(12, 30, 22);
    private final LocalTime lt_18_15_04 = LocalTime.of(18, 15, 4);
    private final LocalTime lt_21_22_56 = LocalTime.of(21, 22, 56);

    @Test
    void equal_True() {
        assertTrue(equal(lt_12_30_22, LocalTime.of(12, 30, 22)));
    }
    @Test
    void equal_False() {
        assertFalse(equal(lt_12_30_22, lt_18_15_04));
    }

    @Test
    void lessThan_True() {
        assertTrue(lessThan(lt_12_30_22, lt_18_15_04));
    }
    @Test
    void lessThan_False() {
        assertFalse(lessThan(lt_18_15_04, lt_12_30_22));
    }

    @Test
    void greaterThan_True() {
        assertTrue(greaterThan(lt_21_22_56, lt_12_30_22));
    }
    @Test
    void greaterThan_False() {
        assertFalse(greaterThan(lt_12_30_22, lt_21_22_56));
    }

    @Test
    void notEqual_True() {
        assertTrue(notEqual(lt_12_30_22, lt_18_15_04));
    }
    @Test
    void notEqual_False() {
        assertFalse(notEqual(lt_12_30_22, LocalTime.of(12, 30, 22)));
    }

    @Test
    void lessThanOrEqual_True() {
        assertTrue(lessThanOrEqual(lt_12_30_22, lt_18_15_04));
    }
    @Test
    void lessThanOrEqual_False() {
        assertFalse(lessThanOrEqual(lt_21_22_56, lt_12_30_22));
    }

    @Test
    void greaterThanOrEqual_True() {
        assertTrue(greaterThanOrEqual(lt_21_22_56, lt_12_30_22));
    }
    @Test
    void greaterThanOrEqual_False() {
        assertFalse(greaterThanOrEqual(lt_12_30_22, lt_18_15_04));
    }

    @Test
    void inRangeIncludeBounds_True() {
        assertTrue(inRangeIncludeBounds(LocalTime.of(12, 30, 22), lt_12_30_22, lt_18_15_04));
    }
    @Test
    void inRangeIncludeBounds_False() {
        assertFalse(inRangeIncludeBounds(lt_21_22_56, lt_12_30_22, lt_18_15_04));
    }

    @Test
    void inRangeExcludeBounds_True() {
        assertTrue(inRangeExcludeBounds(lt_18_15_04, lt_12_30_22, lt_21_22_56));
    }
    @Test
    void inRangeExcludeBounds_False() {
        assertFalse(inRangeExcludeBounds(LocalTime.of(12, 30, 22), lt_12_30_22, lt_18_15_04));
    }
}
