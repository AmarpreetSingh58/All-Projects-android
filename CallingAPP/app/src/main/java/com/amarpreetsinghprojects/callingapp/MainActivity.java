package com.amarpreetsinghprojects.callingapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    EditText number;
    Button call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number= (EditText)findViewById(R.id.numberInput);
        call = (Button)findViewById(R.id.callButton);

        int permissionResult = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permissionResult == PackageManager.PERMISSION_GRANTED){
         //checks permission if granted
            Intent intent =new Intent();
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:8447950098"));
            startActivity(intent);

        }
        else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},123);

        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){

        }
        if (requestCode == 123){
            if (permissions[0].equals(Manifest.permission.CALL_PHONE)&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Intent intent =new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:8447950098"));
                startActivity(intent);
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void callPhone(){
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+ number.getText().toString()));
                startActivity(intent);
            }
        });
    }

}
