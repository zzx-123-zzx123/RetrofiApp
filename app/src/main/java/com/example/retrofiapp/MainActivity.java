package com.example.retrofiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Appservice appService = (Appservice) retrofit.create(App.class);
        appService.GetAppData().enqueue(new Callback<List<App>>() {
            @Override
            public void onResponse(Call<List<App>> call, Response<List<App>> response) {
                List<App> list = response.body();
                if(!list.isEmpty()){
                    for ( App a:list) {
                        String id = a.id;
                        String name = a.name;
                        String version = a.version;
                    }
                }
            }

            @Override
            public void onFailure(Call<List<App>> call, Throwable t) {

            }
        });

    }

    private void getDate(){
      Retrofit retrofit = new Retrofit.Builder()
              .baseUrl("")
              .addConverterFactory(GsonConverterFactory.create())
              .build();
      Appservice appservice = (Appservice) retrofit.create(App.class);
      appservice.GetAppData().enqueue(new Callback<List<App>>() {
          @Override
          public void onResponse(Call<List<App>> call, Response<List<App>> response) {
              List<App> appList = response.body();
          }

          @Override
          public void onFailure(Call<List<App>> call, Throwable t) {

          }
      });

    }

    //
}
