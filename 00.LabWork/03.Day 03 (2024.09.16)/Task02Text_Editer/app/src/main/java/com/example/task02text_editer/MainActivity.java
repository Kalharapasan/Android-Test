package com.example.task02text_editer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =findViewById(R.id.button);
        editText =findViewById(R.id.editTextText1);
        textView =findViewById(R.id.outPutText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name =editText.getText().toString();
                textView.setVisibility(View.VISIBLE);
                textView.setText("You Name is "+name);


            }
        });




    }
}