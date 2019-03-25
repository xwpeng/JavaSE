package xwpeng.com.tstate;

import android.content.Context;

public class LoginContext implements UserState {
    private LoginContext(){

    }

    private static class Inner {
        private static LoginContext loginContext = new LoginContext();
    }

    public static LoginContext getInstance() {
        return Inner.loginContext;
    }

    private UserState userState = new LoginOutState();

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    @Override
    public void comment(Context context) {
        userState.comment(context);
    }

    @Override
    public void forward(Context context) {
        userState.forward(context);
    }
}
