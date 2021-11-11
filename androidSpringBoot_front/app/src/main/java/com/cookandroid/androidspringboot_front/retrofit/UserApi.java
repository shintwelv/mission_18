package com.cookandroid.androidspringboot_front.retrofit;

import com.cookandroid.androidspringboot_front.MainActivity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {
    @POST("signin")
    Call<Boolean> postUser(@Body User user);

    @POST("signup")
    Call<Boolean> createUser(@Body User user);
}
