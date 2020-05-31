package com.dlf.mvplogin.presenter;

import android.text.TextUtils;
import android.widget.Toast;

import com.dlf.mvplogin.bean.Login_Bean;
import com.dlf.mvplogin.callback.Login_CallBack;
import com.dlf.mvplogin.model.Login_Model_J;
import com.dlf.mvplogin.view.Login_View_I;

public class Login_Presenter_J implements Login_Presenter_I {

    private Login_Model_J login_model_j;
    private Login_View_I login_view_i;

    public Login_Presenter_J(Login_View_I login_view_i) {
        this.login_view_i = login_view_i;
        login_model_j = new Login_Model_J();
    }

    @Override
    public void login(String name, String pwd) {
        if (TextUtils.isEmpty(name)) {
            login_view_i.onFlied("name不能为空");
            return;
        }

        if (TextUtils.isEmpty(pwd)) {
            login_view_i.onFlied("pwd不能为空");
            return;
        }
        login_model_j.login(name, pwd, new Login_CallBack() {
            @Override
            public void onSuccess(Login_Bean login_bean) {
                login_view_i.onSuccess(login_bean);
            }

            @Override
            public void onFlied(String msg) {
                login_view_i.onFlied(msg);
            }
        });
    }
}
