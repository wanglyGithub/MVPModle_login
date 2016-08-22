package com.wangly.mvpmodle.view;

/**
 * Created by wangly on 2016/8/22.
 */
public interface LoginView {
    public String getUserName();

    public String getPassword();

    public void showProgress();

    public void dismissProgress();

    void showToast(String toast);

}
