package com.bezkot.logic;

/**
 * Базовые логически операции.
 * @since 1.0.2.0
 */
public class BaseLogic {
    /**
     * Аргумент 'a' равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     * @param <T> тип проверяемых аргументов, реализующих {@link Comparable}
     * @since 1.0.2.0
     */
    public static <T extends Comparable<T>> boolean equal(T a, T b) {
        if (a == null || b == null) {
            return false;
        }
        return a.compareTo(b) == 0;
    }

    /**
     * Аргумент 'a' меньше аргумента 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     * @param <T> тип проверяемых аргументов, реализующих {@link Comparable}
     * @since 1.0.2.0
     */
    public static <T extends Comparable<T>> boolean lessThan(T a, T b) {
        if (a == null && b != null) {
            return true;
        }
        if (b == null) {
            return false;
        }

        return a.compareTo(b) < 0;
    }

    /**
     * Аргумент 'a' больше аргумента 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     * @param <T> тип проверяемых аргументов, реализующих {@link Comparable}
     * @since 1.0.2.0
     */
    public static <T extends Comparable<T>> boolean greaterThan(T a, T b) {
        if (a != null && b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }

        return a.compareTo(b) > 0;
    }

    /**
     * Аргумент 'a' не равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     * @param <T> тип проверяемых аргументов, реализующих {@link Comparable}
     * @since 1.0.2.0
     */
    public static <T extends Comparable<T>> boolean notEqual(T a, T b) {
        return !equal(a, b);
    }

    /**
     * Аргумент 'a' меньше, или равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     * @param <T> тип проверяемых аргументов, реализующих {@link Comparable}
     * @since 1.0.2.0
     */
    public static <T extends Comparable<T>> boolean lessThanOrEqual(T a, T b) {
        return lessThan(a, b) || equal(a, b);
    }

    /**
     * Аргумент 'a' больше, или равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     * @param <T> тип проверяемых аргументов, реализующих {@link Comparable}
     * @since 1.0.2.0
     */
    public static <T extends Comparable<T>> boolean greaterThanOrEqual(T a, T b) {
        return greaterThan(a, b) || equal(a, b);
    }

    /**
     * Проверяемый параметр входит в диапазон, ВКЛЮЧАЯ границы диапазона.
     * Начало проверяемого диапазона должно быть меньше или равно концу проверяемого диапазона,
     * в противном случае - последующая логика не отрабатывает, а в качестве результата выводится FALSE.
     * @param check проверяемый параметр
     * @param start начало диапазона
     * @param end конец диапазона
     * @return true - условие выполняется, false - условие не выполняется
     * @param <T> тип проверяемых аргументов, реализующих {@link Comparable}
     * @since 1.0.2.0
     */
    public static <T extends Comparable<T>> boolean inRangeIncludeBounds(T check, T start, T end) {
        return lessThanOrEqual(start, end) && greaterThanOrEqual(check, start) && lessThanOrEqual(check, end);
    }

    /**
     * Проверяемый параметр входит в диапазон, ИСКЛЮЧАЯ границы диапазона.
     * Начало проверяемого диапазона должно быть меньше конца проверяемого диапазона,
     * в противном случае - последующая логика не отрабатывает, а в качестве результата выводится FALSE.
     * @param check проверяемый параметр
     * @param start начало диапазона
     * @param end конец диапазона
     * @return true - условие выполняется, false - условие не выполняется
     * @param <T> тип проверяемых аргументов, реализующих {@link Comparable}
     * @since 1.0.2.0
     */
    public static <T extends Comparable<T>> boolean inRangeExcludeBounds(T check, T start, T end) {
        return lessThan(start, end) && greaterThan(check, start) && lessThan(check, end);
    }
}

