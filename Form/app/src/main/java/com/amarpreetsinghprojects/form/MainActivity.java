package com.amarpreetsinghprojects.form;

import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String NAME = "name";
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editText = (EditText)findViewById(R.id.nameTV);


        FloatingActionButton clickButton = (FloatingActionButton)findViewById(R.id.clickButton);
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        editText.setText(sharedPreferences.getString(NAME,null));
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(NAME,editText.getText().toString());
                editor.apply();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();

        switch(item.getItemId()){
            case R.id.main_settings :
                //do something
                break;
            case R.id.mainAdd://do something
                break;
            case R.id.mainDelete://do something
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
