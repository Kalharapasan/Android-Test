package com.example.task01;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class View_Data extends AppCompatActivity {

    Button back;
    DBHelper dbHelper;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        back =findViewById(R.id.button3);
        listView =findViewById(R.id.listViewData);
        dbHelper =new DBHelper(this);

        ArrayList<String> dataList = new ArrayList<>();
        Cursor res =dbHelper.getAllData();

        if (res.getCount() == 0){
            dataList.add("No Data");
        }else {
            while(res.moveToNext()){
                String record = "ID: "+res.getInt(0) +
                        "\nName : "+res.getString(1) +
                        "\nemail : " +res.getString(2)+
                        "\nAge: "+ res.getInt(3)+"" +
                        "\nAddres: " +res.getString(4);

                dataList.add(record);
            }
        }

        ArrayAdapter<String> adapter =new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,dataList
        );

        listView.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(View_Data.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}