package com.RestClient;

import com.exemple.rafael.interviewassistant.model.Interview;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Rafael on 27/01/2017.
 */

public interface interviewClient {

    @POST("api/Interviews")
    Call<Interview> createInterview(@Body Interview interview);
}