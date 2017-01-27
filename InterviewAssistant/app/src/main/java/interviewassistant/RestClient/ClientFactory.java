package interviewassistant.RestClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rafael on 27/01/2017.
 */

public class ClientFactory {

    public static InterviewClient Build(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(InterviewClient.class);

    }
}
