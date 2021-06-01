package com.Spawner;

import com.google.gson.Gson;
import com.models.Grade;
import com.models.Student;
import com.models.Teacher;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MyFile {

    public void createFile(List<Teacher> teachers, List<Grade> grades) throws IOException {

        int nRows = 5;
        BufferedWriter writer2=null;
        String name = LocalDateTime.now().getSecond() +String.valueOf(LocalDateTime.now().getNano()) + Thread.currentThread().getName();
        for (int i = 0; i < nRows; i++) {

            File file = new File("C:\\Users\\kamal\\Desktop\\Creator\\" + name + ".txt");
            if (!file.exists()) {
                writer2 = new BufferedWriter(new FileWriter("C:\\Users\\kamal\\Desktop\\Creator\\"+ name + ".txt"));
            }
            int randomForGrade2 = (int) (Math.random() * grades.size() - 1);
            int randomForTeacherStart2 = (int) (Math.random() * teachers.size() - 1);
            int max2 = teachers.size();
            int min2 = randomForTeacherStart2;
            int range2 = max2 - min2;
            int randomForTeacherCount2 = (int) (Math.random() * range2) + min2;

            Student student = new Student(null, "StudentName" + (i + 1), "Surname", 30, grades.get(randomForGrade2), teachers.stream().filter(teacher -> teacher.getId() >= randomForTeacherStart2 && teacher.getId() <= randomForTeacherCount2).collect(Collectors.toList()));
            writer2.append(new Gson().toJson(student));
            writer2.newLine();

        }
        writer2.close();


    }
    public void filesSpawner(List<Teacher> teachers, List<Grade> grades) throws IOException {
//        InputStream inputStream;
//        Properties prop = new Properties();
//        String propFileName = "config.properties";
//
//        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
//        prop.load(inputStream);
//        String filePath = prop.getProperty("folderPath");
//        String threadCount = prop.getProperty("threadCount");
//        int nThread = Integer.valueOf(threadCount);
//        String rowsInEachFile = prop.getProperty("rowsInEachFile");
//        int nRows = Integer.valueOf(rowsInEachFile);
        int nThread = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(nThread);
        while (true){
            executorService.submit(new Thread(() -> {
                try {

                    createFile(teachers, grades);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
        }
    }
}
