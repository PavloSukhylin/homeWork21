package com.alevel;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        MyMath myMath = new MyMath();
        try {
            Field[] fields = myMath.getClass().getDeclaredFields();  //создаем объект поля fields для доступа k private полям
            System.out.println(myMath);                              //класса MyPath
            Stream.of(fields)
                    .filter(f -> f.isAnnotationPresent(Pow.class))   //фильтр по аннотации Pow
                    .filter(f -> {                                   //псевдофильтр. На самом деле просто разрешаем доступ  к полям
                        f.setAccessible(true);                       // и возвращаем true
                        return true;
                    })
                    .forEach(field -> {
                        try {
                            Object value = field.get(myMath);
                            if (value instanceof Number) {                 //содержит ли поле цифры
                                if (value instanceof Byte) {               //прогон по всем типам и запись квадрата числа в поле
                                    Byte byte1 = (Byte) value;             //здесь может быть решение попроще
                                    field.set(myMath, (byte) (byte1 * byte1));
                                }
                                if (value instanceof Short) {
                                    Short short1 = (Short) value;
                                    field.set(myMath, (short) (short1 * short1));
                                }
                                if (value instanceof Integer) {
                                    Integer int1 = (Integer) value;
                                    field.set(myMath, int1 * int1);
                                }
                                if (value instanceof Long) {
                                    Long long1 = (Long) value;
                                    field.set(myMath, long1 * long1);
                                }
                                if (value instanceof Float) {
                                    Float float1 = (Float) value;
                                    field.set(myMath, float1 * float1);
                                }
                                if (value instanceof Double) {
                                    Double double1 = (Double) value;
                                    field.set(myMath, double1 * double1);
                                }
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    });
            System.out.println(myMath);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
