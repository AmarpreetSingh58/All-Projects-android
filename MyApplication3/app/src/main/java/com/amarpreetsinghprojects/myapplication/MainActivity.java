package com.amarpreetsinghprojects.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    private static final String INPUT = "input";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.inputText);
        textView = (TextView)findViewById(R.id.outputtex);
        button = (Button)findViewById(R.id.clickButton);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        String gotvalue = sharedPreferences.getString(INPUT,"0");
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        textView.setText(gotvalue);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editText.getText().toString();

                editor.putString(INPUT,value);

                editor.apply();

                textView.setText(value);
            }
        });

    }
}
