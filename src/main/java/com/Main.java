package com;

import com.Spawner.MyFile;
import com.google.gson.reflect.TypeToken;
import com.models.Grade;
import com.models.Student;
import com.models.Subject;
import com.models.Teacher;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Proxy;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Main {


    public static void main(String[] args) throws IOException {
        List<Teacher> teachers = IntStream.range(1, 21).parallel().mapToObj(i -> new Teacher(i, "Name" + i, "Surname" + i, 15, new Subject(i, "SubjectName" + i))).collect(Collectors.toList());
        List<Grade> grades = Arrays.asList(new Grade(1, "A"), new Grade(2, "B"), new Grade(3, "C"), new Grade(4, "D"), new Grade(5, "E"), new Grade(6, "F"));

        MyFile myFile = new MyFile();
        myFile.filesSpawner(teachers,grades);
    }
}
