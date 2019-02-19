package com.xwpeng.tenum;

/**
 * Created by xwpeng on 2019/2/18.
 */
public enum ColorEnum {
    RED("red", "红"), GREEN("green", "绿"), BLUE("blue", "蓝");

    public final String us;
    public final String cn;

    ColorEnum(String us, String cn) {
        this.us = us;
        this.cn = cn;
    }

    //根据us获取cn
    public static ColorEnum getEnumByUs(String us){
        if(null == us){
            return null;
        }
        for(ColorEnum temp:ColorEnum.values()){
            if(temp.us.equals(us)){
                return temp;
            }
        }
        return null;
    }
}
