package com.models;

import lombok.Data;

@Data
public class Teacher {
    private int id;
    private String name;
    private String surname;
    private int age;
    private Subject subject;

    public Teacher(int id, String name, String surname, int age, Subject subject) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.subject = subject;
    }
}
