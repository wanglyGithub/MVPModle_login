package com.wangly.mvpmodle.biz;

/**
 * Created by wangly on 2016/8/22.
 */
public interface LoginListener {
    void login(String username, String password, ResultCallBack back);
}
