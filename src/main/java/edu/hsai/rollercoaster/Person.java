package edu.hsai.rollercoaster;

public class Person {
    private final String id;

    Person(String num) {
        id = num;
    }

    @Override
    public String toString() {
        return id;
    }
}
