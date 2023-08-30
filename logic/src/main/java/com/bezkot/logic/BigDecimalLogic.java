package com.bezkot.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Обёртка над логическими операциями типа BigDecimal.
 * @since 1.0.2.0
 */
public class BigDecimalLogic extends BaseLogic {
    /**
     * Является нулём.
     * @param a проверяемый аргумент
     * @return true - условие выполняется, false - условие не выполняется
     * @since 1.0.2.0
     */
    public static boolean isZero(BigDecimal a) {
        return equal(a, a == null ? BigDecimal.ZERO : BigDecimal.ZERO.setScale(a.scale(), RoundingMode.HALF_EVEN));
    }

    /**
     * Меньше нуля.
     * @param a проверяемый аргумент
     * @return true - условие выполняется, false - условие не выполняется
     * @since 1.0.2.0
     */
    public static boolean lessThanZero(BigDecimal a) {
        return lessThan(a, a == null ? BigDecimal.ZERO : BigDecimal.ZERO.setScale(a.scale(), RoundingMode.HALF_EVEN));
    }

    /**
     * Больше нуля.
     * @param a проверяемы аргумент
     * @return true - условие выполняется, false - условие не выполняется
     * @since 1.0.2.0
     */
    public static boolean greaterThanZero(BigDecimal a) {
        return greaterThan(a, a == null ? BigDecimal.ZERO : BigDecimal.ZERO.setScale(a.scale(), RoundingMode.HALF_EVEN));
    }
}