package com.example.a01task01;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.main);

        DataClass[] data = new DataClass[] {
                new DataClass("Kalhara", android.R.drawable.btn_star_big_on, 1),
                new DataClass("Tharushi", android.R.drawable.btn_star, 2)
        };

        MyAdapter adapter = new MyAdapter(this, data);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
