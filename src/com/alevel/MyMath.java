package com.alevel;

public class MyMath {

    @Pow
    private String string = "hello";

    @Pow
    private Double aDouble = 3.0;

    private Integer integer = 2;


    @Override
    public String toString() {
        return "MyMath{" +
                "string='" + string + '\'' +
                ", aDouble=" + aDouble +
                ", integer=" + integer +
                '}';
    }
}

