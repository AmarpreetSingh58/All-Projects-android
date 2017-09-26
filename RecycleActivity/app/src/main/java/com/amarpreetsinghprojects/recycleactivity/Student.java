package com.amarpreetsinghprojects.recycleactivity;

/**
 * Created by kulvi on 06/16/17.
 */

public class Student {
    String name,age,course;

    public Student(String name, String age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }
}
