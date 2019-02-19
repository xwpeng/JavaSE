package com.xwpeng.tclone;

/**
 * Created by xwpeng on 2019/2/14.
 */
public class Teacher implements Cloneable {
    private int age;
    private String name;
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
