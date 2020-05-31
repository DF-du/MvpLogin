package com.dlf.mvplogin.model;

import com.dlf.mvplogin.bean.Login_Bean;
import com.dlf.mvplogin.callback.Login_CallBack;
import com.dlf.mvplogin.api.ApiService;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login_Model_J implements Login_Model_I {
    @Override
    public void login(String name, String pwd, Login_CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.baseLoginUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<Login_Bean> login = retrofit.create(ApiService.class).login(name, pwd);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Login_Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Login_Bean login_bean) {
                        int errorCode = login_bean.getErrorCode();
                        if (errorCode == 0) {
                            callBack.onSuccess(login_bean);
                        } else {
                            callBack.onFlied(login_bean.getErrorMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFlied(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
