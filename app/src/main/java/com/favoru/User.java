package com.favoru;

import static com.favoru.MainActivity.mPort;

/**
 * Created by nvas on 25/6/17.
 */

public class User {

    String mName;
    String mPhno;
    String mType;


    public User(String phone) {

        GetUserInfoBG getUserInfoBG = new GetUserInfoBG();
        getUserInfoBG.execute(mPort,phone);
        getUserInfoBG.onProgressUpdate();
        String UserProfileString = getUserInfoBG.result;
        String arr[] = UserProfileString.split("<br>");
        this.mPhno = arr[0];
        this.mName = arr[1];
        this.mType = arr[2];
    }


    public String getmName() {
        return mName;
    }

    public String getmPhno() {
        return mPhno;
    }

    public String getmType() {
        return mType;
    }


}
