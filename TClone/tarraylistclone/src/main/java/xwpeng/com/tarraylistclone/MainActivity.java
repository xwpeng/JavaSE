package xwpeng.com.tarraylistclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        System.out.println("main: students " + students.hashCode());
        students.add(new Student("22", 22));
        students.add(new Student("11", 11));
        System.out.println("main: students after" + students.hashCode());
        ArrayList<Student> students1 = new ArrayList<>();
        System.out.println("main: students1 " + students1.hashCode());
        students1.addAll(students);
        students1.add(new Student("33", 33));
        System.out.println("main: students1 after " + students1.hashCode());
        students1.remove(2);
        System.out.println("main: students1 after2 " + students1.hashCode());
        ArrayList<Student> students2 = (ArrayList<Student>) students.clone();
        System.out.println("main: students2  " + students2.hashCode());

    }
}
