package com.udacity.gradle;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
//        return "foo";
        return name;
    }
}