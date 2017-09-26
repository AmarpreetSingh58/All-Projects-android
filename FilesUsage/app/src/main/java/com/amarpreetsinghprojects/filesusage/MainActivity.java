package com.amarpreetsinghprojects.filesusage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String TAG = "msg:";
    EditText etfilename,etfileContent;
    TextView outputTV;
    File f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etfilename = (EditText)findViewById(R.id.etFilename);
        etfileContent = (EditText)findViewById(R.id.etFilcontent);
        outputTV = (TextView)findViewById(R.id.outputTV);

        File filesDir = getFilesDir();// this is deleted only when app is uninstalled
        File cacheDir = getCacheDir();// this can be deleted by phone at any time as per memory available

        File externalFilesDir = getExternalFilesDir(null);

        File externalMusicDir = getExternalFilesDir(Environment.DIRECTORY_MUSIC);

        File externalCacheDir = getExternalCacheDir();

        File externalStorageDir = Environment.getExternalStorageDirectory();

        Log.d(TAG, "onCreate: "+filesDir.getAbsolutePath() +
                '\n' + cacheDir.getAbsolutePath() +
                '\n'+externalFilesDir.getAbsolutePath()+
                '\n'+externalMusicDir.getAbsolutePath()+
                '\n'+externalCacheDir.getAbsolutePath()+
                '\n'+externalStorageDir);

        try {
            Log.d(TAG, "onCreate: "+filesDir.getCanonicalPath() +
                    '\n' + cacheDir.getCanonicalPath() +
                    '\n'+externalFilesDir.getCanonicalPath()+
                    '\n'+externalMusicDir.getCanonicalPath()+
                    '\n'+externalCacheDir.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToInternalStorage(View view) {
        String fileContent = etfileContent.getText().toString();
        String filename = etfilename.getText().toString();
        /*try {

            FileOutputStream fos = openFileOutput(filename,MODE_APPEND);
            fos.write(fileContent.getBytes());
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        f = new File(Environment.getExternalStorageDirectory(),filename);
        int permissionResult = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionResult == PackageManager.PERMISSION_GRANTED) {
            try {
                FileOutputStream fos = new FileOutputStream(f, true);// true or false sets that whether content will be appended or not.
                fos.write(fileContent.getBytes());
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},123);

        }
    }

    public void readFromInternalStorage(View view) {
        String filename = etfilename.getText().toString();
        String result = null;
        /*try {
            FileInputStream fis = openFileInput(filename);
            StringBuilder stringBuilder = new StringBuilder();
            int b=0;
           
            while ((b = fis.read())>=0){

                stringBuilder.append((((char) b)));
            }
            result = stringBuilder.toString();
            Log.e(TAG, "readFromInternalStorage: "+result );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        int permissionResult = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permissionResult == PackageManager.PERMISSION_GRANTED) {
            try {
                FileInputStream fis = new FileInputStream(f);
                StringBuilder stringBuilder = new StringBuilder();
                int b = 0;

                while ((b = fis.read()) >= 0) {

                    stringBuilder.append((((char) b)));
                }
                result = stringBuilder.toString();
                fis.close();
                Log.e(TAG, "readFromInternalStorage: " + result);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            outputTV.setText(result);
        }

        else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},123);

        }

    }
}
