package com.xwpeng.tsinglevar;

import com.xwpeng.tclone.Student;

/**
 * Created by xwpeng on 2019/2/18.
 */
public class Single {
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    private Single(){

    }

    public static Single getInstance() {
        return Inner.instance;
    }

    public static class Inner{
        private static Single instance = new Single();
    }

}
