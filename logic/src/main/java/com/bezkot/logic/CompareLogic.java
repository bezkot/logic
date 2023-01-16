package com.bezkot.logic;

public interface CompareLogic<T extends Comparable<T>> {
    /**
     * Аргумент 'a' равен аргументу 'b'.
     * @param a первый аргумент
     * @param b второй аргумент
     * @return true - условие выполняется, false - условие не выполняется
     */
    default boolean equal(T a, T b) {
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
     */
    default boolean less(T a, T b) {
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
     */
    default boolean more(T a, T b) {
        if (a != null && b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }

        return a.compareTo(b) > 0;
    }
}
