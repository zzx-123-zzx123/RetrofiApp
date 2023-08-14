package com.example.retrofiapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Appservice {
    @GET("get_data.json")// "get_data.json"为请求地址相对路径，非根路径
    Call<List<App>> GetAppData();
}
