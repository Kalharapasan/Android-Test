//###########################################################Task01########################################################

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    tools:context=".MainActivity">


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:weightSum="1">


        <EditText

            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="0.5"
            android:textSize="20sp"
            android:hint="Left" />


        <EditText

            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="0.5"
            android:textSize="20sp"
            android:hint="Right" />
    </LinearLayout>


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="horizontal">

        <EditText

            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="20sp"
            android:hint="Full width input" />
    </LinearLayout>


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="horizontal">

        <EditText

            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="20sp"
            android:hint="Full width input" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:weightSum="3"
        android:layout_marginTop="16dp">

        <EditText

            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:textSize="20sp"
            android:hint="Input 1" />

        <EditText

            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:textSize="20sp"
            android:hint="Input 2" />

        <EditText

            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:textSize="20sp"
            android:hint="Input 3" />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:weightSum="1">


        <EditText

            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="0.75"
            android:textSize="20sp"
            android:hint="Left" />


        <EditText

            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="0.25"
            android:textSize="20sp"
            android:hint="Right" />
    </LinearLayout>





</LinearLayout>

//###############################################################Task02########################################################
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal" >
        
        <EditText
            android:id="@+id/firstName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" 
            android:layout_weight="1"
            android:hint="First Name"/>
        <EditText
            android:id="@+id/lastname"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="@string/last_name"/>
        
    </LinearLayout>
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        
        <EditText
            android:id="@+id/address"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:textAlignment="center"
            android:hint="@string/address"/>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <EditText
            android:id="@+id/email"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:textAlignment="center"
            android:hint="@string/email"/>
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        
        <EditText
            android:id="@+id/age"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:hint="@string/age"
            />
        <EditText
            android:id="@+id/grade"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:hint="@string/grade" />
        
        <EditText
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:hint="Class"
            />
        
    </LinearLayout>
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        
        <EditText
            android:id="@+id/phoneNumber"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="0.75" 
            android:hint="@string/enter_you_phione_number"/>
        <EditText
            android:id="@+id/date"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1" 
            android:hint="@string/date"/>
        
    </LinearLayout>
      


    </LinearLayout>


//##################################################################################Task03#####################################################
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    tools:context=".MainActivity"
    android:background="">
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:text="Sing Up"
            android:textAlignment="center"
            android:textSize="45sp" />


    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal" >

        <EditText
            android:id="@+id/firstName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="First Name"/>
        <EditText
            android:id="@+id/lastname"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="@string/last_name"/>

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <EditText
            android:id="@+id/address"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:textAlignment="center"
            android:hint="@string/address"/>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <EditText
            android:id="@+id/email"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:textAlignment="center"
            android:hint="@string/email"/>
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <EditText
            android:id="@+id/age"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:hint="@string/age"
            />
        <EditText
            android:id="@+id/grade"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:hint="@string/grade" />

        <EditText
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:hint="Class"
            />

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <EditText
            android:id="@+id/phoneNumber"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="0.75"
            android:hint="@string/enter_you_phione_number"/>
        <EditText
            android:id="@+id/date"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:hint="@string/date"/>

    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        
        <Button
            android:id="@+id/singup"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Sing Up"
            android:textAlignment="center"/>
    </LinearLayout>



    </LinearLayout>

    <?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity2">
    
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/button1"
        android:text="@string/login" />
    
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/button2"
        android:layout_toEndOf="@+id/button1"
        android:text="@string/register"/>

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/button1"
        android:layout_marginStart="-175dp"
        android:layout_marginTop="630dp"
        android:layout_toEndOf="@+id/button2"
        android:text="Button" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/button1"
        android:id="@+id/button4"
        android:text="@string/login"
        android:layout_centerHorizontal="true"/>


</RelativeLayout>

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="24dp"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/label1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:text="Registration"
        android:textAlignment="center"
        android:textColor="#F44336"
        android:textSize="32sp"
        android:textStyle="bold" />

    <EditText
        android:id="@+id/firstName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/label1"
        android:layout_marginTop="24dp"
        android:hint="First Name"
        android:inputType="textPersonName"
        android:textSize="16sp" />

    <EditText
        android:id="@+id/lastName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/firstName"
        android:layout_marginTop="12dp"
        android:hint="Last Name"
        android:inputType="textPersonName"
        android:textSize="16sp" />

    <EditText
        android:id="@+id/email"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/lastName"
        android:layout_marginTop="12dp"
        android:hint="Email"
        android:inputType="textEmailAddress"
        android:textSize="16sp" />

    <EditText
        android:id="@+id/phone"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/email"
        android:layout_marginTop="12dp"
        android:hint="Phone Number"
        android:inputType="phone"
        android:textSize="16sp" />

    <EditText
        android:id="@+id/password"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/phone"
        android:layout_marginTop="12dp"
        android:hint="Password"
        android:inputType="textPassword"
        android:textSize="16sp" />

    <EditText
        android:id="@+id/confirmPassword"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/password"
        android:layout_marginTop="12dp"
        android:hint="Confirm Password"
        android:inputType="textPassword"
        android:textSize="16sp" />

    <Button
        android:id="@+id/registerButton"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/confirmPassword"
        android:layout_marginTop="24dp"
        android:text="Register"
        android:textAllCaps="false"
        android:backgroundTint="#F44336"
        android:textColor="#FFFFFF"
        android:textSize="18sp" />

</RelativeLayout>

