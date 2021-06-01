package com.models;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private Integer id;
    private String name;
    private String surname;
    private int age;
    private Grade grade;
    private List<Teacher> teachers;

    public Student(Integer id, String name, String surname, int age, Grade grade, List<Teacher> teachers) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.grade = grade;
        this.teachers = teachers;
    }
}
