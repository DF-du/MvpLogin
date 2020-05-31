package com.dlf.mvplogin.view;

import com.dlf.mvplogin.bean.Login_Bean;

public interface Login_View_I {
    void onSuccess(Login_Bean login_bean);
    void onFlied(String msg);
}
