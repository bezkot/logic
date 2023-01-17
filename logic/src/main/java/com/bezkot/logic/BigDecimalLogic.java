package com.bezkot.logic;

import java.math.BigDecimal;

/**
 * Обёртка над логическими операциями типа BigDecimal.
 */
public class BigDecimalLogic {
    /**
     * Аргумент 'a' равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean equal(BigDecimal a, BigDecimal b) {
        return new CompareLogic<BigDecimal>() {}.equal(a, b);
    }

    /**
     * Аргумент 'a' меньше аргумента 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean less(BigDecimal a, BigDecimal b) {
        return new CompareLogic<BigDecimal>() {}.less(a, b);
    }


    /**
     * Аргумент 'a' больше аргумента 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean more(BigDecimal a, BigDecimal b) {
        return new CompareLogic<BigDecimal>() {}.more(a, b);
    }

    /**
     * Аргумент 'a' не равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean notEqual(BigDecimal a, BigDecimal b) {
        return !equal(a, b);
    }

    /**
     * Аргумент 'a' меньше, или равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean lessOrEqual(BigDecimal a, BigDecimal b) {
        return less(a, b) || equal(a, b);
    }

    /**
     * Аргумент 'a' больше, или равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean moreOrEqual(BigDecimal a, BigDecimal b) {
        return more(a, b) || equal(a, b);
    }

    /**
     * Является нулём.
     * @param a проверяемый аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean isZero(BigDecimal a) {
        return equal(a, BigDecimal.ZERO);
    }

    /**
     * Меньше нуля.
     * @param a проверяемый аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean lessZero(BigDecimal a) {
        return less(a, BigDecimal.ZERO);
    }

    /**
     * Больше нуля.
     * @param a проверяемы аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    public static boolean moreZero(BigDecimal a) {
        return more(a, BigDecimal.ZERO);
    }
}