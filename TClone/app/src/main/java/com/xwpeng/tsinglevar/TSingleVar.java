package com.xwpeng.tsinglevar;

import com.xwpeng.tclone.Student;

/**
 * Created by xwpeng on 2019/2/18.
 */
public class TSingleVar {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "初始";
        Single.getInstance().setStudent(student);
        aa();
        bb();
    }

    private static void aa() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < 500; i++) {
                            System.out.println("打印的： " + Single.getInstance().getStudent().name);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
    }

    private static void bb() {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < 500; i++) {
                            Student student = new Student();
                            student.name = "在变: " + System.currentTimeMillis();
                            Single.getInstance().setStudent(student);
//                        Single.getInstance().getStudent().name = "在变: " + System.currentTimeMillis();
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
    }
}
