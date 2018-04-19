package com.android.xwpeng.tobservermode;

import java.util.Observable;

/**
 * Created by xwpeng on 2018/4/17.
 */

public interface Observer {
   void update(Object message);
}
