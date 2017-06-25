package com.favoru;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by nvas on 24/6/17.
 */

public class setFeedBG extends AsyncTask<String,Void,String>{

    String result;
    String TAG="setFeedBG";


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        while(result==null || result==""){}


    }

    @Override
    protected String doInBackground(String... params) {

        String mPort = params[0];
        String ph_no= params[1];
        String e_title = params[2];
        String e_date= params[3];
        String e_time = params[4];
        String e_location = params[5];
        String e_description= params[6];





        result="";
        String login_url = mPort + "/viewFeed.php";
        try
        {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(login_url).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("ph_no", "UTF-8") + "=" + URLEncoder.encode(ph_no, "UTF-8") + "&" +
                               URLEncoder.encode("e_title", "UTF-8") + "=" + URLEncoder.encode(e_title, "UTF-8")+ "&" +
                               URLEncoder.encode("e_date", "UTF-8") + "=" + URLEncoder.encode(e_date, "UTF-8")+ "&" +
                               URLEncoder.encode("e_time", "UTF-8") + "=" + URLEncoder.encode(e_time, "UTF-8")+ "&" +
                               URLEncoder.encode("e_location", "UTF-8") + "=" + URLEncoder.encode(e_location, "UTF-8")+ "&" +
                               URLEncoder.encode("e_description", "UTF-8") + "=" + URLEncoder.encode(e_description, "UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

            String str = "";
            while (true) {
                str = bufferedReader.readLine();
                if (str != null) {
                    result += str;
                } else {
                    //Log.d(this.TAG, this.result + " test");
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    Log.d(this.TAG, "finally0: " + this.result);
                    return result;
                }
            }
        } catch (MalformedURLException e) {
//        /*Log.d(this.TAG, "into catch1" + e);
            Log.d(TAG, "finally1: " + e);
            return result;
        } catch (IOException e2) {
        /*Log.d(this.TAG, "into catch2:" + e2);
        this.result = "NO NET";
        Log.d(this.TAG, "finally2: " + this.result);*/
            Log.d(TAG, "finally1: " + e2);
            return result;
        } catch (Throwable th) {
        /*Log.d(this.TAG, "finally3: " + this.result + th);*/
            Log.d(TAG, "finally1: " + th);
            return result;
        }



    }
}

