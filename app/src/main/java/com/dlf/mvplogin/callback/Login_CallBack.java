package com.dlf.mvplogin.callback;

import com.dlf.mvplogin.bean.Login_Bean;

public interface Login_CallBack {
    void onSuccess(Login_Bean login_bean);
    void onFlied(String msg);
}
