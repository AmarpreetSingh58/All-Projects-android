package com.amarpreetsinghprojects.cameraapp;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by kulvi on 07/21/17.
 */

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {


    Camera c;


    public CameraPreview(Context context, Camera camera) {
        super(context);
        c = camera;
        SurfaceHolder h = getHolder();

       h.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        try {
            c.setPreviewDisplay(holder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        c.startPreview();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        c.stopPreview();

        try {
            c.setPreviewDisplay(holder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        c.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //c.release();
    }
    /*// Required for directly using the custom view in xml files.
    public CameraPreview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraPreview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }*/



}
