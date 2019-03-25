package com.xwpeng.tclone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwpeng on 2019/2/14.
 */
public class Student implements Cloneable {
    public int age;
    public String name;
    public List<String> books = new ArrayList<>();

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        Student student = (Student) object;
        student.books = (List<String>) ((ArrayList<String>) books).clone();
        return object;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
