package com.amarpreetsinghprojects.asyntask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    ArrayList<User> userArrayList = new ArrayList<>();
    String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

       // final MyAsynTask myAsynTask = new MyAsynTask();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //myAsynTask.execute(10);
                (new MyAsynTask()).execute("https://jsonplaceholder.typicode.com/posts");
            }
        });


    }

    class MyAsynTask extends AsyncTask<String,Integer,ArrayList<User>>{
        @Override
        protected ArrayList<User> doInBackground(String... params) {
            String result = null,urlpassed = params[0];
            try {
                URL url = new URL(urlpassed);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // creates a connection object
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(3000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect(); // gets connection in connection object

                // checks if the connection is succeful or not
                if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    throw new IOException("HTTP error code" + httpURLConnection.getResponseCode());
                }
                InputStream inputStream = httpURLConnection.getInputStream(); // reads data from server

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder stringBuilder = new StringBuilder();

                String line;


                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line); // creates data into string format
                }

                result = stringBuilder.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject currentObject = jsonArray.getJSONObject(i);
                    //String userId = currentObject.getString("userid");
                    userArrayList.add(new User(currentObject.getString("id"),
                            currentObject.getString("userId"),
                            currentObject.getString("title"),
                            currentObject.getString("body")));


                }

            } catch (JSONException e) {
                e.printStackTrace();
                Log.e(TAG, "onCreate: JOSN is invalid" );
            }
            return userArrayList;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<User> users) {
            super.onPostExecute(users);
            textView.setText(""+users.size());
        }
        /*ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Please Wait");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Integer... params) {
           /* for (int i=0;i<params[0];i++){
                long currTime = System.currentTimeMillis();
                while (System.currentTimeMillis()-currTime<1000){
                }
                publishProgress(i);

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            textView.setText("10 Seconds Passed");
            progressDialog.hide();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Integer recievedProgress = values[0];
            progressDialog.setMessage(recievedProgress + " seconds have passed");
        }*/
    }
}
