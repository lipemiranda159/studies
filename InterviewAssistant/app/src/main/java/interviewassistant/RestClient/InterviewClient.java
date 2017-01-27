package interviewassistant.RestClient;

import interviewassistant.models.Interview;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Rafael on 27/01/2017.
 */

public interface InterviewClient {

    @POST("users/new")
    Call<Interview> createInterview(@Body Interview interview);
}
