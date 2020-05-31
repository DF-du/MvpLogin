package com.dlf.mvplogin.api;

import com.dlf.mvplogin.bean.Login_Bean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    String baseLoginUrl = "https://www.wanandroid.com/";

    @POST("user/login")
    @FormUrlEncoded
    Observable<Login_Bean> login(@Field("username") String username, @Field("password") String password);
}
