package com.bezkot.logic;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

/**
 * Обёртка над логическими операциями для LocalDateTime, LocalDate и LocalTime.
 */
public class DateTimeLogic {
    /**
     * Аргумент 'a' равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean equal(LocalDateTime a, LocalDateTime b) {
        return new CompareLogic<ChronoLocalDateTime<?>>() {}.equal(a, b);
    }

    /**
     * Аргумент 'a' меньше аргумента 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean less(LocalDateTime a, LocalDateTime b) {
        return new CompareLogic<ChronoLocalDateTime<?>>() {}.less(a, b);
    }

    /**
     * Аргумент 'a' больше аргумента 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean more(LocalDateTime a, LocalDateTime b) {
        return new CompareLogic<ChronoLocalDateTime<?>>() {}.more(a, b);
    }

    /**
     * Аргумент 'a' не равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean notEqual(LocalDateTime a, LocalDateTime b) {
        return !equal(a, b);
    }

    /**
     * Аргумент 'a' меньше, или равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean lessOrEqual(LocalDateTime a, LocalDateTime b) {
        return less(a, b) || equal(a, b);
    }

    /**
     * Аргумент 'a' больше, или равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean moreOrEqual(LocalDateTime a, LocalDateTime b) {
        return more(a, b) || equal(a, b);
    }

    /**
     * Проверяемый параметр входит в диапазон, ВКЛЮЧАЯ границы диапазона.
     * @param check проверяемый параметр
     * @param start начало диапазона
     * @param end конец диапазона
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean inRangeIncludeBounds(LocalDateTime check, LocalDateTime start, LocalDateTime end) {
        return moreOrEqual(check, start) && lessOrEqual(check, end);
    }

    /**
     * Проверяемый параметр входит в диапазон, ИСКЛЮЧАЯ границы диапазона.
     * @param check проверяемый параметр
     * @param start начало диапазона
     * @param end конец диапазона
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean inRangeExcludeBounds(LocalDateTime check, LocalDateTime start, LocalDateTime end) {
        return more(check, start) && less(check, end);
    }
}
