package com.bezkot.logic;

import java.util.Collection;
import java.util.Map;

/**
 * Различные проверки списка аргументов и отдельных значений.
 * @since 1.0.2.0
 */
public class ArgsLogic {

    /**
     * Возвращает первый попавшийся аргумент, отличный от NULL.
     * Если же все аргументы равны NULL, результатом тоже будет NULL.
     * @param args проверяемые аргументы
     * @return первый попавшийся не NULL объект, иначе NULL
     * @param <T> тип проверяемых аргументов
     * @since 1.0.2.0
     */
    @SafeVarargs
    public static <T> T coalesce(T... args) {
        if (args == null) {
            return null;
        }
        for (T arg : args) {
            if (arg != null) {
                return arg;
            }
        }
        return null;
    }

    /**
     * Все переданные аргументы не равны NULL.
     * @param args проверяемые аргументы
     * @return true - все переданные аргументы не равны NULL, false - присутствует NULL аргумент
     * @param <T> тип проверяемых аргументов
     * @since 1.0.2.0
     */
    @SafeVarargs
    public static <T> boolean allNotNull(T... args) {
        if (args == null) {
            return false;
        }
        for (T arg : args) {
            if (arg == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Любой из переданных аргументы не равен NULL.
     * @param args проверяемые аргументы
     * @return true - найден элемент со значением не NULL среди проверяемых аргументов, false - все аргументы равны NULL
     * @param <T> тип проверяемых аргументов
     * @since 1.0.2.0
     */
    @SafeVarargs
    public static <T> boolean anyNotNull(T... args) {
        if (args == null) {
            return false;
        }
        for (T arg : args) {
            if (arg != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Все переданные аргументы равны NULL.
     * @param args проверяемые аргументы
     * @return true - все переданные аргументы равны NULL, false - присутствует не NULL аргумент
     * @param <T> тип проверяемых аргументов
     * @since 1.0.2.0
     */
    @SafeVarargs
    public static <T> boolean allNull(T... args) {
        return !anyNotNull(args);
    }

    /**
     * Любой из переданных аргументы равен NULL.
     * @param args проверяемые аргументы
     * @return true - найден элемент со значением NULL среди проверяемых аргументов, false - все аргументы не NULL
     * @param <T> тип проверяемых аргументов
     * @since 1.0.2.0
     */
    @SafeVarargs
    public static <T> boolean anyNull(T... args) {
        return !allNotNull(args);
    }

    /**
     * Проверяет, существует ли значение у объекта.
     * Пустые строки, коллекции и карты считаются не прошедшими проверку.
     * @param arg проверяемая сущность
     * @return true - значение присутствует, иначе - false
     * @param <T> тип проверяемого аргумента
     * @since 1.0.2.0
     */
    public static <T> boolean valueExist(T arg) {
        return arg != null
                && (!(arg instanceof String) || !((String) arg).isEmpty())
                && (!(arg instanceof Collection) || !((Collection<?>) arg).isEmpty())
                && (!(arg instanceof Map) || !((Map<?, ?>) arg).isEmpty());
    }
}
