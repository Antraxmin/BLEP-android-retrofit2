package com.example.BLEP_android_server;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final String BASEURL = "http://jsonplaceholder.typicode.com/";
    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.text_view_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        createPost();
    }

    private void createPost() {
        Map<String, Post> map = new HashMap<String, Post>();
        map.put("1", new Post("1", "20211111", "108", "68", "2022-11-08"));

        Call<Post> call = jsonPlaceHolderApi.createPost(map);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("code: " + response.code());
                    return;
                }

                Post postResponse = response.body();

                String content = "";
                content += "id : " + postResponse.getId() + "\n";
                content += "Code: " + postResponse.getCode() + "\n";
                content += "혈압: " + postResponse.getHeart() + "\n";
                content += "심박수: " + postResponse.getBp() + "\n";
                content += "측정일: " + postResponse.getDate() + "\n";

                textViewResult.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
