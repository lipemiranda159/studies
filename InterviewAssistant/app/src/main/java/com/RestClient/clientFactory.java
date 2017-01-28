package com.RestClient;

/**
 * Created by Rafael on 27/01/2017.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class clientFactory {

    public static interviewClient Build(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:55987/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(interviewClient.class);

    }
}