package com.bezkot.logic;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static com.bezkot.logic.TimeLogic.*;
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
    void less_True() {
        assertTrue(less(lt_12_30_22, lt_18_15_04));
    }
    @Test
    void less_False() {
        assertFalse(less(lt_18_15_04, lt_12_30_22));
    }

    @Test
    void more_True() {
        assertTrue(more(lt_21_22_56, lt_12_30_22));
    }
    @Test
    void more_False() {
        assertFalse(more(lt_12_30_22, lt_21_22_56));
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
    void lessOrEqual_True() {
        assertTrue(lessOrEqual(lt_12_30_22, lt_18_15_04));
    }
    @Test
    void lessOrEqual_False() {
        assertFalse(lessOrEqual(lt_21_22_56, lt_12_30_22));
    }

    @Test
    void moreOrEqual_True() {
        assertTrue(moreOrEqual(lt_21_22_56, lt_12_30_22));
    }
    @Test
    void moreOrEqual_False() {
        assertFalse(moreOrEqual(lt_12_30_22, lt_18_15_04));
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
