/////////////////////////////////////////////////////////////////////Task 01//////////////////////////////////////////////
single_layout_view.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_margin="10dp">




    <LinearLayout
        android:id="@+id/linearLayout"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/nameText"
            android:textSize="22sp"
            android:textStyle="bold"
            android:text="Name">

        </TextView>
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/emailText"
            android:textSize="18sp"
            android:textStyle="italic"
            android:text="Email"
            android:textColor="#E71010"
            android:layout_marginTop="10dp">

        </TextView>

    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>

MyListData.java

package com.example.a01task01resycleview;

public class MyListData {
    private String name;
    private String email;

    public MyListData(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}


MyAdapter.java

package com.example.a01task01resycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    
    public  MyListData[] listData;

    public MyAdapter(Context context,MyListData [] listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
        View view = LayoutInflater.from(context).inflate(R.layout.single_layout_view,parent,false);
        return new ViewHolder(view);
        
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        
        holder.textView1.setText(listData[position].getName());
        holder.textView2.setText(listData[position].getEmail());
        
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1,textView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1= itemView.findViewById(R.id.nameText);
            textView2 =itemView.findViewById(R.id.emailText);
        }
    }
}


MainActivity.java
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
            new MyListData("ABC","abc@gmail.com"),
            new MyListData("Kalhara","kalharap84@gmauil.com"),
            new MyListData("Tharushi","tharu@gmail.com"),
            new MyListData("Saman","samn@gmail.com")    
        };
        
        MyAdapter adapter =new MyAdapter(getApplicationContext(),listData);
        
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        recyclerView.setAdapter(adapter);

    }
}

activity_main.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.recyclerview.widget.RecyclerView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/recycleview"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">



</androidx.recyclerview.widget.RecyclerView>