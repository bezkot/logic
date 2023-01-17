package com.bezkot.logic;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import static com.bezkot.logic.ArgsLogic.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArgsLogicTest {

    @Test
    void coalesce_Nulls() {
        Integer elem1 = null;
        String elem2 = null;
        Object elem3 = null;
        assertNull(coalesce(elem1, elem2, elem3));
    }
    @Test
    void coalesce_NotNulls() {
        Integer elem1 = null;
        String elem2 = "value2";
        Object elem3 = null;
        assertNotNull(coalesce(elem1, elem2, elem3));
    }

    @Test
    void allNotNull_Nulls() {
        assertFalse(allNotNull("value1", new Object(), null));
    }
    @Test
    void allNotNull_NotNulls() {
        assertTrue(allNotNull("value1", new Object(), BigDecimal.ONE));
    }

    @Test
    void anyNotNull_Nulls() {
        assertFalse(anyNotNull(null, null, null));
    }
    @Test
    void anyNotNull_NotNulls() {
        assertTrue(anyNotNull(null, null, "value3"));
    }

    @Test
    void allNull_Nulls() {
        assertTrue(allNull(null, null, null));
    }
    @Test
    void allNull_NotNulls() {
        assertFalse(allNull(null, BigInteger.TWO, null));
    }

    @Test
    void anyNull_Nulls() {
        assertTrue(anyNull("value1", "value2", null, "value3"));
    }
    @Test
    void anyNull_NotNulls() {
        assertFalse(anyNull("value1", BigDecimal.ZERO, new Object()));
    }

    @Test
    void valueExist_FalseObj() {
        BigDecimal bigDecimal = null;
        assertFalse(valueExist(bigDecimal));
    }
    @Test
    void valueExist_FalseString() {
        String str = "";
        assertFalse(valueExist(str));
    }
    @Test
    void valueExist_FalseList() {
        List<String> list =  new ArrayList<>();
        assertFalse(valueExist(list));
    }
    @Test
    void valueExist_FalseMap() {
        Map<String, BigDecimal> map = new HashMap<>();

        assertFalse(valueExist(map));
    }
    @Test
    void valueExist_TrueObj() {
        assertTrue(valueExist(BigDecimal.valueOf(44)));
    }
    @Test
    void valueExist_TrueString() {
        assertTrue(valueExist("value1"));
    }
    @Test
    void valueExist_TrueList() {
        assertTrue(valueExist(Arrays.asList("value1", "value2")));
    }
    @Test
    void valueExist_TrueMap() {
        Map<String, BigDecimal> map = new HashMap<>();
        map.put("key1", BigDecimal.ONE);

        assertTrue(valueExist(map));
    }
}
