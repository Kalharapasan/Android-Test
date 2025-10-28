package com.example.a23sqlite;

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

public class MainActivity extends AppCompatActivity {
    DBHelp dbHelp;
    Button insert,update,delete;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =findViewById(R.id.listViewData);
        insert =findViewById(R.id.addDataButton);
        update =findViewById(R.id.updateDataButton);
        delete =findViewById(R.id.deleteDataButton);

        dbHelp =new DBHelp(this);

        ArrayList<String> dataList = new ArrayList<>();
        Cursor res = dbHelp.getAllData();

        if (res.getCount() == 0){
            dataList.add("No Data In User Databases");
        }else {
            while(res.moveToNext()){
                String recode = "ID: " +res.getInt(0) +
                        "\nFirst Name: " +res.getString(1)+
                        "\nLast Name: "+res.getString(2)+
                        "\nGender: "+res.getString(3)+
                        "\nMail: "+res.getString(4);

                dataList.add(recode);
            }

        }

        ArrayAdapter<String> adapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Add_Data.class);
                startActivity(intent);
            }
        });
    }
}