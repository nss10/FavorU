package com.favoru;

import android.support.v7.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nvas on 25/6/17.
 */

public class Feed implements Comparable{

    private String mFeedId;
    private String mA_phno = "9094904875";
    private String mB_phnno;
    private String mE_title="Title_Nvas";
    private String mE_date="12-12-2017";
    private String mE_time="4:15pm";
    private String mE_location="Kamala nagar";
    private String mE_description="I'm looking for someone who can write an english exam for me. Kindly help!";


    public Feed(String feedString) {
        String arr[] = feedString.split("<br>");
        this.mFeedId = arr[0];
        this.mA_phno = arr[1];
        this.mB_phnno = arr[2];
        this.mE_title = arr[3];
        this.mE_date = arr[4];
        this.mE_time = arr[5];
        this.mE_location = arr[6];
        this.mE_description = arr[7];
    }

    public String getmFeedId() {
        return mFeedId;
    }

    public void setmFeedId(String mFeedId) {
        this.mFeedId = mFeedId;
    }

    public String getmA_phno() {
        return mA_phno;
    }

    public void setmA_phno(String mA_phno) {
        this.mA_phno = mA_phno;
    }

    public String getmB_phnno() {
        return mB_phnno;
    }

    public void setmB_phnno(String mB_phnno) {
        this.mB_phnno = mB_phnno;
    }

    public String getmE_title() {
        return mE_title;
    }

    public void setmE_title(String mE_title) {
        this.mE_title = mE_title;
    }

    public String getmE_date() {
        return mE_date;
    }

    public void setmE_date(String mE_date) {
        this.mE_date = mE_date;
    }

    public String getmE_time() {
        return mE_time;
    }

    public void setmE_time(String mE_time) {
        this.mE_time = mE_time;
    }

    public String getmE_location() {
        return mE_location;
    }

    public void setmE_location(String mE_location) {
        this.mE_location = mE_location;
    }

    public String getmE_description() {
        return mE_description;
    }

    public void setmE_description(String mE_description) {
        this.mE_description = mE_description;
    }

    @Override
    public int compareTo(Object o) {
        String dateString1 = this.getmE_date();
        Feed otherFeed = (Feed)o;
        String dateString2 = otherFeed.getmE_date();
        Date thisDate=null,otherDate=null;

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            thisDate = (Date)formatter.parse(dateString1);
            otherDate = (Date)formatter.parse(dateString2);
            //Sorting in descending order of date
            return -(thisDate.compareTo(otherDate));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }


}
