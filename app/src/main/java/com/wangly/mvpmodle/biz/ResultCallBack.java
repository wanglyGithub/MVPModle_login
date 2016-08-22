package com.wangly.mvpmodle.biz;

import com.wangly.mvpmodle.modle.Login;

/**
 * Created by wangly on 2016/8/22.
 */
public interface ResultCallBack {
    void Success(Login login);
    void Failed(String error);
}
