/////////////////////////////////////////////////////////////////////Task01/////////////////////////////////////////////////////////////////////

chatgpt.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <RelativeLayout
        android:id="@+id/relativeLayout"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#EEE"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:padding="16dp">

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:src="@drawable/ic_launcher_foreground"
            android:contentDescription="Image" />

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="TextView"
            android:textSize="18sp"
            android:textStyle="bold"
            android:layout_toRightOf="@id/imageView"
            android:layout_marginStart="16dp"
            android:layout_alignTop="@id/imageView" />

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Button"
            android:layout_below="@id/textView"
            android:layout_alignStart="@id/textView"
            android:layout_marginTop="16dp" />

    </RelativeLayout>

</androidx.constraintlayout.widget.ConstraintLayout>

single_layout.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
             android:layout_height="match_parent">

    <RelativeLayout
        android:layout_width="0dp"
        android:id="@+id/reativelayout"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintEnd_toEndOf="parent">


        <ImageView
            android:id="@+id/imageView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            tools:layout_editor_absoluteX="91dp"
            tools:layout_editor_absoluteY="113dp"
            tools:srcCompat="@tools:sample/avatars" />

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Kalhara"
            android:textSize="30sp"
            android:textStyle="bold"
            android:textColor="#E01010"
            android:layout_toRightOf="@id/imageView"
            
             />

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="View"
            android:layout_toRightOf="@id/imageView"
            android:layout_below="@id/textView"
            android:backgroundTint="#0AEB13"
            />
    </RelativeLayout>

</androidx.constraintlayout.widget.ConstraintLayout>

activity_main.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/main"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="16dp"/>
</androidx.constraintlayout.widget.ConstraintLayout>


DataClass.java

package com.example.a01task01;

public class DataClass {
    private String name;
    
    private int imgID;
    
    private  int buttonID;

    public DataClass(String name, int imgID, int buttonID) {
        this.name = name;
        this.imgID = imgID;
        this.buttonID = buttonID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public int getButtonID() {
        return buttonID;
    }

    public void setButtonID(int buttonID) {
        this.buttonID = buttonID;
    }
}

MyAdapter.java

package com.example.a01task01;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;

    public DataClass [] data;

    public MyAdapter(Context context,DataClass [] data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        holder.textView.setText(data[position].getName());
        holder.imageView.setImageResource(data[position].getImgID());

        final  int currectPoistion  =position;
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataClass dataClass =data[currectPoistion];
                Toast.makeText(context,"You clicked "+dataClass.getName(),Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView =itemView.findViewById(R.id.imageView);
            button =itemView.findViewById(R.id.button);

        }
    }
}

MainActivity.java
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





/////////////////////////////////////////////////////////////////////Task01/////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////Task01/////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////Task01/////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////Task01/////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////Task01/////////////////////////////////////////////////////////////////////