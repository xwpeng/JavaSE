package com.xwpeng.tclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
       tClone();
//        tClone2();
    }

    /**
     * 浅克隆
     */
    private static void tClone() throws CloneNotSupportedException {
        Student student = new Student();
        student.age = 24;
        student.name = "neisong";
        student.books = new ArrayList<>();
        student.books.add("111");
        Student student2 = (Student)student.clone();
        System.out.println(student.toString());
        System.out.println(student2.toString());
        student2.age = 23;
        student2.books.add("222");
        //克隆后得到的是一个新的对象，所以重新写的是student2这个对象的值
        System.out.println(student.toString());
        System.out.println(student2.toString());
        Intent intent = new Intent();
    }

    /**
     * 深克隆
     * 包含了类中对象的克隆
     */
    private static void tClone2() throws CloneNotSupportedException {
        Teacher teacher = new Teacher();
        teacher.setAge(40);
        teacher.setName("teacher zhang");

        AStudent aStudent = new AStudent();
        aStudent.setAge(14);
        aStudent.setName("lisi");
        aStudent.setTeacher(teacher);

        AStudent aStudent1 = (AStudent)aStudent.clone();
        //深复制，aStudent1中的teacher是aStudent.teacher的一个复制
        //所以下面teacher.setName只是对他原来的这个对象更改，但是复制的那个并没有更改
        System.out.println(aStudent1.getAge());
        System.out.println(aStudent1.getName());
        System.out.println(aStudent1.getTeacher().getAge());
        teacher.setName("teacher niesong");//不会又任何影响
        System.out.println(aStudent.getTeacher().getName());
        System.out.println(aStudent1.getTeacher().getName());
    }




}
