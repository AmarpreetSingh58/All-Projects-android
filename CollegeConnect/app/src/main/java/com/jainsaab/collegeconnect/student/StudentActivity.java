package com.jainsaab.collegeconnect.student;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.jainsaab.collegeconnect.R;
import com.jainsaab.collegeconnect.Utility;
import com.jainsaab.collegeconnect.signingin.RegisterAsActivity;

public class StudentActivity extends AppCompatActivity {

    SharedPreferences mGetPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        mGetPrefs = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_student, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.student_sign_out_menu:
                Utility.signedOutCleanUp(this, mGetPrefs);
                startActivity(new Intent(this, RegisterAsActivity.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
