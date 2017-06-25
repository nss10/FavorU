package com.favoru;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import static com.favoru.MainActivity.mPort;

/**
 * Created by nvas on 25/6/17.
 */

public class A_Home extends AppCompatActivity {

    String mPhone;
    String mE_title;
    String mE_location;
    String mE_description;
    String mE_date;
    String mE_time;
    String mUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.a_home);

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("credentials", Context.MODE_PRIVATE);
        mPhone=sharedPreferences.getString("username","unknown");
        Log.d("Rajni",mPhone);
        final User mUser = new User(mPhone);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Rajni","Clicked fab");
                View ra_1 = (View)findViewById(R.id.type_a);
                ra_1.setVisibility(View.VISIBLE);
            }
        });

        final EditText et = (EditText)findViewById(R.id.event_title_desc);
        final EditText eloc = (EditText)findViewById(R.id.loc_desc);
        final EditText edesc = (EditText)findViewById(R.id.desc_desc);

        Button next = (Button)findViewById(R.id.next1_desc);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Rajni","Clicked next");
                mE_title = et.getText().toString().trim();
                mE_location = eloc.getText().toString().trim();
                mE_description = edesc.getText().toString().trim();
                View ra_1 = (View)(findViewById(R.id.type_a));
                ra_1.setVisibility(View.INVISIBLE);
                View ra_2 = (View)(findViewById(R.id.type_a1));
                ra_2.setVisibility(View.VISIBLE);

            }
        });
        final EditText eTime = (EditText)findViewById(R.id.time_desc);
        final Button publish = (Button)findViewById(R.id.publish);
        final Button set_date = (Button)findViewById(R.id.set_date);
        final Button set_time = (Button)findViewById(R.id.set_time);
        final EditText eDate = (EditText)findViewById(R.id.date_desc);
        final DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);

        eDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Rajni","Clicked eDate");
                eDate.setVisibility(View.INVISIBLE);
                eTime.setVisibility(View.INVISIBLE);
                eDate.setVisibility(View.INVISIBLE);
                publish.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.VISIBLE);
                set_date.setVisibility(View.VISIBLE);

            }
        });

        set_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Rajni","Clicked setDate");
                mE_date= datePicker.getDayOfMonth()+"-"+datePicker.getMonth()+"-"+ datePicker.getYear();
                eDate.setVisibility(View.VISIBLE);
                eTime.setVisibility(View.VISIBLE);
                eDate.setVisibility(View.VISIBLE);
                publish.setVisibility(View.VISIBLE);
                eDate.setText(mE_date);
                datePicker.setVisibility(View.INVISIBLE);
                set_date.setVisibility(View.INVISIBLE);
            }
        });


        eTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Rajni","Clicked eTime");
                eDate.setVisibility(View.INVISIBLE);
                eTime.setVisibility(View.INVISIBLE);
                eDate.setVisibility(View.INVISIBLE);
                publish.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
                set_time.setVisibility(View.VISIBLE);

            }
        });

        set_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Rajni","Clicked setTime");
                mE_time= timePicker.getHour()+":"+timePicker.getMinute();
                eDate.setVisibility(View.VISIBLE);
                eTime.setVisibility(View.VISIBLE);
                eDate.setVisibility(View.VISIBLE);
                publish.setVisibility(View.VISIBLE);
                eTime.setText(mE_time);
                timePicker.setVisibility(View.INVISIBLE);
                set_time.setVisibility(View.INVISIBLE);
            }
        });

        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Rajni","Clicked publish");
                setFeedBG sfBG = new setFeedBG();
                sfBG.execute(mPort,mPhone,mE_title,mE_date,mE_time,mE_location,mE_description);
                sfBG.onProgressUpdate();

            }
        });









    }
}
