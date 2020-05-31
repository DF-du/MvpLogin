package com.dlf.mvplogin.model;

import com.dlf.mvplogin.callback.Login_CallBack;

public interface Login_Model_I {
    void login(String name, String pwd, Login_CallBack callBack);
}
