package com.dlf.mvplogin;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dlf.mvplogin.bean.Login_Bean;
import com.dlf.mvplogin.presenter.Login_Presenter_J;
import com.dlf.mvplogin.view.Login_View_I;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Login_View_I {

    private EditText ed_name;
    private EditText ed_pwd;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ed_name = (EditText) findViewById(R.id.ed_name);
        ed_pwd = (EditText) findViewById(R.id.ed_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String name = ed_name.getText().toString().trim();
        String pwd = ed_pwd.getText().toString().trim();
        Login_Presenter_J login_presenter_j = new Login_Presenter_J(this);
        login_presenter_j.login(name, pwd);
    }

    @Override
    public void onSuccess(Login_Bean login_bean) {
        //登陆成功
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFlied(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
