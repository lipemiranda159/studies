package com.example.rafael.interviewassistant.Views;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

import com.RestClient.clientFactory;
import com.RestClient.interviewClient;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rafael on 28/01/2017.
 */

public class SendInterviewsInformation extends Service {

    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    // Handler that receives messages from the thread
    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {
            // Normally we would do some work here, like download a file.
            // For our sample, we just sleep for 5 seconds.
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // Restore interrupt status.
                Thread.currentThread().interrupt();
            }
            // Stop the service using the startId, so that we don't stop
            // the service in the middle of handling another job
            stopSelf(msg.arg1);
        }
    }

    @Override
    public void onCreate() {
        // Start up the thread running the service.  Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block.  We also make it
        // background priority so CPU-intensive work will not disrupt our UI.
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job
        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);

        if (isOnline())
        {
            Toast.makeText(this, "Enviando dados de entrevista", Toast.LENGTH_SHORT).show();
            final InterviewEntity interview = InterviewEntity.getInstance(this);
            List<Interview> interviews = interview.GetAll();

            if (interviews != null) {

                for (int x = 0; x < interviews.size(); x++) {
                    final Interview newInterview = interviews.get(x);
                    interviewClient client = clientFactory.Build();
                    Call<Interview> request = client.createInterview(newInterview);
                    request.enqueue(new Callback<Interview>() {
                        @Override
                        public void onResponse(Call<Interview> call, Response<Interview> response) {
                            Log.i("Sucesso", "funciona muito - id: " + response.body().getId());
                            newInterview.setInterviewSent(true);
                            interview.update(newInterview);
                        }

                        @Override
                        public void onFailure(Call<Interview> call, Throwable t) {

                            Log.i("erro", t.getMessage());
                            newInterview.setInterviewSent(false);
                            interview.update(newInterview);
                        }
                    });

                }
                Toast.makeText(this, "Dados enviados", Toast.LENGTH_SHORT).show();

            } else Toast.makeText(this, "Sem entrevistas para serem enviadas", Toast.LENGTH_SHORT).show();



        }

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
    }

    public boolean isOnline() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);

        return manager.getActiveNetworkInfo() != null &&
                manager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}