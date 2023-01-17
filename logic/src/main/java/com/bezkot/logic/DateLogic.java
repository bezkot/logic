package com.bezkot.logic;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

/**
 * Обёртка над логическими операциями для LocalDate.
 */
public class DateLogic {
    /**
     * Аргумент 'a' равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean equal(LocalDate a, LocalDate b){
        return new CompareLogic<ChronoLocalDate>() {}.equal(a, b);
    }

    /**
     * Аргумент 'a' меньше аргумента 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean less(LocalDate a, LocalDate b) {
        return new CompareLogic<ChronoLocalDate>() {}.less(a, b);
    }

    /**
     * Аргумент 'a' больше аргумента 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean more(LocalDate a, LocalDate b) {
        return new CompareLogic<ChronoLocalDate>() {}.more(a, b);
    }

    /**
     * Аргумент 'a' не равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean notEqual(LocalDate a, LocalDate b) {
        return !equal(a, b);
    }

    /**
     * Аргумент 'a' меньше, или равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean lessOrEqual(LocalDate a, LocalDate b) {
        return less(a, b) || equal(a, b);
    }

    /**
     * Аргумент 'a' больше, или равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean moreOrEqual(LocalDate a, LocalDate b) {
        return more(a, b) || equal(a, b);
    }

    /**
     * Проверяемый параметр входит в диапазон, ВКЛЮЧАЯ границы диапазона.
     * Начало проверяемого диапазона должно быть меньше или равно концу проверяемого диапазона,
     * в противном случае - последующая логика не отрабатывает, а в качестве результата выводится FALSE.
     * @param check проверяемый параметр
     * @param start начало диапазона
     * @param end конец диапазона
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean inRangeIncludeBounds(LocalDate check, LocalDate start, LocalDate end) {
        return lessOrEqual(start, end) && moreOrEqual(check, start) && lessOrEqual(check, end);
    }

    /**
     * Проверяемый параметр входит в диапазон, ИСКЛЮЧАЯ границы диапазона.
     * Начало проверяемого диапазона должно быть меньше конца проверяемого диапазона,
     * в противном случае - последующая логика не отрабатывает, а в качестве результата выводится FALSE.
     * @param check проверяемый параметр
     * @param start начало диапазона
     * @param end конец диапазона
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean inRangeExcludeBounds(LocalDate check, LocalDate start, LocalDate end) {
        return less(start, end) && more(check, start) && less(check, end);
    }
}
