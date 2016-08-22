package com.wangly.mvpmodle.biz;

import android.os.Handler;
import android.os.Message;

import com.wangly.mvpmodle.modle.Login;

/**
 * Created by wangly on 2016/8/22.
 */
public class LoginUtils implements LoginListener {
    public final static int SENT_SUCCESS_MESSAGE = 1001;
    public final static int SENT_FAILED_MESSAGE = 1002;
    private ResultCallBack back;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SENT_SUCCESS_MESSAGE:
                    Login login = (Login) msg.obj;
                    back.Success(login);
                    break;

                case SENT_FAILED_MESSAGE:
                    String error = (String) msg.obj;
                    back.Failed(error);
                    break;
                default:
                    break;
            }


        }
    };

    @Override
    public void login(final String username, final String password, final ResultCallBack back) {
        this.back = back;
        if ("".equals(username)) {
            back.Failed("请输入用户名");
            return;
        }
        if ("".equals(password)) {
            back.Failed("请输入密码");
            return;
        }
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    if ("张三".equals(username) && "111111".equals(password)) {
                        Login login = new Login();
                        login.setUserName(username);
                        login.setPassword(password);
                        handler.obtainMessage(SENT_SUCCESS_MESSAGE, login).sendToTarget();

                    } else {
                        handler.obtainMessage(SENT_FAILED_MESSAGE, "用户名或密码错误").sendToTarget();
                    }

                } catch (Exception e) {
                    handler.obtainMessage(SENT_FAILED_MESSAGE, "登录失败！" + e.getMessage()).sendToTarget();
                }
            }
        }).start();
    }
}
