package com.exemple.rafael.interviewassistant.model;

import android.content.Context;

/**
 * Created by Rafael on 20/01/2017.
 */

public class DataBaseUtil {
    private InterviewedPersonEntity interviewedPersonEntity;
    private InterviewEntity interviewEntity;

    public void DataBaseUtil(Context context){
        interviewedPersonEntity = InterviewedPersonEntity.getInstance(context);
        interviewEntity = InterviewEntity.getInstance(context);
    }

    public InterviewedPersonEntity getInterviewedPersonEntity() {
        return interviewedPersonEntity;
    }

    public InterviewEntity getInterviewEntity() {
        return interviewEntity;
    }
}
