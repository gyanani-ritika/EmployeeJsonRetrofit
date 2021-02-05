package com.example.myjsonexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @GET("todos/1")
    Call<Todo> getEmp();//getEmp is a method name it can be anything like - login,register, addEvent,
    // addOrganiser
    @POST("json")
    Call<Todo> getTodo();
}
