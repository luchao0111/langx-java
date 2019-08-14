package com.jn.langx.util;

import com.jn.langx.util.collection.Arrs;

import java.util.Collection;
import java.util.Map;

public class Emptys {

    private static boolean isZero(Number number) {
        if (number == null) {
            return true;
        }
        if (number instanceof Byte) {
            return number.equals(Byte.valueOf("0"));
        }
        if (number instanceof Short) {
            return number.equals(Short.valueOf("0"));
        }
        if (number instanceof Integer) {
            return number.intValue() == 0;
        }
        if (number instanceof Long) {
            return number.longValue() == 0L;
        }
        if (number instanceof Float) {
            return number.floatValue() == 0F;
        }
        if (number instanceof Double) {
            return number.doubleValue() == 0D;
        }
        return false;
    }

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof String) {
            return Strings.isEmpty((String) object);
        }

        if (object instanceof Number) {
            return isZero((Number) object);
        }

        if (object instanceof Collection) {
            return ((Collection) object).isEmpty();
        }

        if (object instanceof Map) {
            return ((Map) object).isEmpty();
        }
        if (object.getClass().isArray()) {
            return Arrs.getLengthIfIsArray(object) <= 0;
        }

        if (object.getClass().isEnum()) {
            return false;
        }

        return false;
    }

    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    public static boolean isNull(Object o) {
        return o == null;
    }

    public static boolean isNotNull(Object o) {
        return o != null;
    }

}
