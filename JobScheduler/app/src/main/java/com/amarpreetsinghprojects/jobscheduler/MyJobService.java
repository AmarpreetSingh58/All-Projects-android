package com.amarpreetsinghprojects.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

/**
 * Created by kulvi on 07/26/17.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService {

    private JobParameters param;

    @Override
    public boolean onStartJob(JobParameters params) {
        //Toast.makeText(getBaseContext(), "Service Started", Toast.LENGTH_SHORT).show();
        this.param = params;
        new MyTask().execute();
        return true; // shows if all the work of svheduler is finished or not. should be true if using async.
        //if set as true false then no more task is executed.
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    class MyTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            jobFinished(param,false);
            return null;
        }
    }
}
