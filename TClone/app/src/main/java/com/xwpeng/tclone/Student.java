package com.xwpeng.tclone;

/**
 * Created by xwpeng on 2019/2/14.
 */
public class Student  implements Cloneable{
    public int age;
    public String name;

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        Object object = super.clone();
        return object;
    }
}
