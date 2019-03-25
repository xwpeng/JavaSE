package xwpeng.com.tstate.tvcontroller;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import xwpeng.com.tstate.LoginActivity;
import xwpeng.com.tstate.UserState;

public class LoginedState implements UserState {
    @Override
    public void comment(Context context) {
        Toast.makeText(context, "评论成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void forward(Context context)
    {
        Toast.makeText(context, "转发成功", Toast.LENGTH_SHORT).show();

    }
}
