package com.pocs.apisecurityapp.util;

import java.lang.reflect.Field;

public class AppUtil {
    public static boolean areAllFieldsNullOrEmpty(Object obj) {
        if (obj == null) {
            return true;
        }

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(obj);

                if (value != null && !value.toString().isEmpty()) {
                    return false; // At least one field is not null or empty
                }
            } catch (IllegalAccessException e) {
                // Handle the exception as needed
                e.printStackTrace();
                return false;
            }
        }

        return true; // All fields are either null or empty
    }
}
