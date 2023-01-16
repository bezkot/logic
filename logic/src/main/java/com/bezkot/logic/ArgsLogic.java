package com.bezkot.logic;

import java.util.Collection;
import java.util.Map;

/**
 * Различные проверки списка аргументов и отдельных значений.
 */
public class ArgsLogic {
    /**
     * Возвращает первый попавшийся аргумент, отличный от NULL.
     * Если же все аргументы равны NULL, результатом тоже будет NULL.
     * @param args
     * @return
     * @param <T>
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
     * Все переданные объекты не равны NULL.
     * @param args
     * @return
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
     * Любой из переданных объектов не равен NULL.
     * @param args
     * @return
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
     * Все переданные объекты равны NULL.
     * @param args
     * @return
     */
    @SafeVarargs
    public static <T> boolean allNull(T... args) {
        return !anyNotNull(args);
    }

    /**
     * Любой из переданных объектов равен NULL.
     * @param args
     * @return
     */
    @SafeVarargs
    public static <T> boolean anyNull(T... args) {
        return !allNotNull(args);
    }

    /**
     * Проверяет, существует ли значение у объекта.
     * Пустые строки, коллекции и карты считаются не прошедшими проверку.
     * @param value
     * @return
     * @param <T>
     */
    public static <T> boolean valueExist(T value) {
        return value != null
                && (!(value instanceof String) || !((String) value).isEmpty())
                && (!(value instanceof Collection) || !((Collection<?>) value).isEmpty())
                && (!(value instanceof Map) || !((Map<?, ?>) value).isEmpty());
    }
}
