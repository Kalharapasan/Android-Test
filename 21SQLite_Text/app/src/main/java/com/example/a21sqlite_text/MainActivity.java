package com.example.a21sqlite_text;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper data;
    EditText name,surname,marks;
    Button add,view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data =new DatabaseHelper(this);
        name =findViewById(R.id.name);
        surname =findViewById(R.id.surname);
        marks =findViewById(R.id.mark);
        add =findViewById(R.id.add);
        view = findViewById(R.id.view);
        addData();
        viewAll();



    }
    public void addData(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInsert= data.insertData(name.getText().toString(),
                        surname.getText().toString(),
                        marks.getText().toString());
                if (isInsert == true){
                    Toast.makeText(MainActivity.this,"Data Insert ",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Error ",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void viewAll(){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = data.getAllData();
                if (res.getCount() == 0){
                    showMessage("Error","Nothing Found");
                    return;
                }
                StringBuffer stringBuffer =new StringBuffer();
                while (res.moveToNext()){
                    stringBuffer.append("ID : "+res.getString(0)+"\n");
                    stringBuffer.append("Name : "+res.getString(1)+"\n");
                    stringBuffer.append("Sur Name : "+res.getString(2)+"\n");
                    stringBuffer.append("Marks : "+res.getString(3)+"\n\n");
                }
                showMessage("Data",stringBuffer.toString());
            }
        });
    }

    public  void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}