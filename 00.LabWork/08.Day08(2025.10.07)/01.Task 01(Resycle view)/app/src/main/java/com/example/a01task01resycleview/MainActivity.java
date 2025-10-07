package com.example.a01task01resycleview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a01task01resycleview.R;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycleview);

        MyListData [] listData =new MyListData[]{
                new MyListData("Yapa","abc@gmail.com"),
                new MyListData("Kalhara","kalharap84@gmauil.com"),
                new MyListData("Tharushi","tharu@gmail.com"),
                new MyListData("Saman","samn@gmail.com"),
                new MyListData("Kumara","abc@gmail.com"),
                new MyListData("Pasan","kalharap84@gmauil.com"),
                new MyListData("Randhula","tharu@gmail.com"),
                new MyListData("Saman","samn@gmail.com"),
                new MyListData("Saranga","saranga@gmail.com"),
                new MyListData("Chathyuranga","chathu@gmail.com"),
                new MyListData("Yapa","abc@gmail.com"),
                new MyListData("Kalhara","kalharap84@gmauil.com"),
                new MyListData("Tharushi","tharu@gmail.com"),
                new MyListData("Saman","samn@gmail.com"),
                new MyListData("Kumara","abc@gmail.com"),
                new MyListData("Pasan","kalharap84@gmauil.com"),
                new MyListData("Randhula","tharu@gmail.com"),
                new MyListData("Saman","samn@gmail.com"),
                new MyListData("Saranga","saranga@gmail.com"),
                new MyListData("Chathyuranga","chathu@gmail.com"),
                new MyListData("Yapa","abc@gmail.com"),
                new MyListData("Kalhara","kalharap84@gmauil.com"),
                new MyListData("Tharushi","tharu@gmail.com"),
                new MyListData("Saman","samn@gmail.com"),
                new MyListData("Kumara","abc@gmail.com"),
                new MyListData("Pasan","kalharap84@gmauil.com"),
                new MyListData("Randhula","tharu@gmail.com"),
                new MyListData("Saman","samn@gmail.com"),
                new MyListData("Saranga","saranga@gmail.com"),
                new MyListData("Chathyuranga","chathu@gmail.com"),
                new MyListData("Yapa","abc@gmail.com"),
                new MyListData("Kalhara","kalharap84@gmauil.com"),
                new MyListData("Tharushi","tharu@gmail.com"),
                new MyListData("Saman","samn@gmail.com"),
                new MyListData("Kumara","abc@gmail.com"),
                new MyListData("Pasan","kalharap84@gmauil.com"),
                new MyListData("Randhula","tharu@gmail.com"),
                new MyListData("Saman","samn@gmail.com"),
                new MyListData("Saranga","saranga@gmail.com"),
                new MyListData("Chathyuranga","chathu@gmail.com")

        };

        MyAdapter adapter =new MyAdapter(getApplicationContext(),listData);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        recyclerView.setAdapter(adapter);

    }
}