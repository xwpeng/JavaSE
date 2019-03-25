package xwpeng.com.tstate;

import android.content.Context;
import android.content.Intent;

public class LoginOutState implements UserState {
    @Override
    public void comment(Context context) {
         gotoLoginActivity(context);
    }

    @Override
    public void forward(Context context) {
        gotoLoginActivity(context);
    }

    public void gotoLoginActivity(Context context){
        context.startActivity(new Intent(context, LoginActivity.class));
    }
}
