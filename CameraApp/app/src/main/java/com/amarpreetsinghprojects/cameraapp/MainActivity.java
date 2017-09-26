package com.amarpreetsinghprojects.cameraapp;

import android.hardware.Camera;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static android.R.attr.data;
import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;

public class MainActivity extends AppCompatActivity {

    Camera c;
    String TAG = "Size : ";
    ConstraintLayout constraint;
    CameraPreview cameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    @Override
    protected void onResume() {
        super.onResume();
        c = Camera.open();


        int currentOrientation =  getWindowManager().getDefaultDisplay().getRotation();
        switch (currentOrientation){
            case Surface.ROTATION_0 : c.setDisplayOrientation(90);
                break;
            case Surface.ROTATION_90: c.setDisplayOrientation(0);
                break;
            case Surface.ROTATION_180: c.setDisplayOrientation(270);
                break;
            case Surface.ROTATION_270: c.setDisplayOrientation(180);
                break;
        }

        getCameraParams();

        constraint = (ConstraintLayout)findViewById(R.id.parentConstraintLayout);

        cameraView = new CameraPreview(this,c);

        constraint.addView(cameraView);

    }

    @Override
    protected void onStop() {
        super.onStop();
        c.release();
        constraint.removeView(cameraView);

    }

    @Override
    protected void onPause() {
        super.onPause();
        c.release();
        constraint.removeView(cameraView);

    }

    public void getCameraParams(){
         List<Camera.Size> pictureSizes = c.getParameters().getSupportedPictureSizes();
        for (Camera.Size s : pictureSizes){
            Log.d(TAG, "onCreate: picture size" + s.width +" X " +s.height + '\n');
        }
        List<Camera.Size> videoSizes= c.getParameters().getSupportedVideoSizes();
        for (Camera.Size s : videoSizes){
            Log.d(TAG, "onCreate: Video size" + s.width + " X "+ s.height+ '\n');
        }
        List<Camera.Size> previewSizes =  c.getParameters().getSupportedPreviewSizes();
        for (Camera.Size s : previewSizes){
            Log.d(TAG, "onCreate: preview size" + s.width +" X "+ s.height + '\n');
        }
    }

    public void takePic(View view) {

        c.takePicture(null, new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] rawdata, Camera camera) {
                // raw format in byte array
            }
        }, new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                // jpeg format in byte array

               // File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),"IMGFILE");

                File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);

                if (pictureFile == null){
                    Log.d(TAG, "Error creating media file, check storage permissions: ");
                    return;
                }

                try {
                    FileOutputStream fos = new FileOutputStream(pictureFile);
                    fos.write(data);
                    fos.close();
                } catch (FileNotFoundException e) {
                    Log.d(TAG, "File not found: " + e.getMessage());
                } catch (IOException e) {
                    Log.d(TAG, "Error accessing file: " + e.getMessage());
                }
            }
        });
    }

    private static File getOutputMediaFile(int type){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), "MyCameraApp");

        Log.e("path", "getOutputMediaFile: "+ Environment.getExternalStorageDirectory().getAbsolutePath() );
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } /*else if(type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");
        }*/
        else {
            return null;
        }

        return mediaFile;
    }
}
