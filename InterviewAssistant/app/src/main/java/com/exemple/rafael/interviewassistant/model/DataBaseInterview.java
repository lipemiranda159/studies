package com.exemple.rafael.interviewassistant.model;

/**
 * Created by Rafael on 20/01/2017.
 */
public class DataBaseInterview {
    public InterviewedPersonEntity  interviewdPerson = null;
    public InterviewEntity interview = null;

    public DataBaseInterview(InterviewedPersonEntity id, InterviewEntity i){
        this.interviewdPerson = id;
        this.interview = i;

    }
}
