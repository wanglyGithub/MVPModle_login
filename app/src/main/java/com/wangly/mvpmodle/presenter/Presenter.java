package com.wangly.mvpmodle.presenter;

import com.wangly.mvpmodle.biz.LoginUtils;
import com.wangly.mvpmodle.biz.ResultCallBack;
import com.wangly.mvpmodle.modle.Login;
import com.wangly.mvpmodle.view.LoginView;

/**
 * Created by wangly on 2016/8/22.
 */
public class Presenter {
    private LoginUtils loginBiz;
    public void login(final LoginView loginView) {
        loginBiz = new LoginUtils();
        loginView.showProgress();
        loginBiz.login(loginView.getUserName(), loginView.getPassword(), new ResultCallBack() {
            @Override
            public void Success(Login login) {
                loginView.showToast("登录成功");
                loginView.dismissProgress();

            }

            @Override
            public void Failed(final String error) {
                loginView.showToast(error);
                loginView.dismissProgress();

            }
        });
    }
}
