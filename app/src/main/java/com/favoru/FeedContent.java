package com.favoru;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by nvas on 25/6/17.
 */

public class FeedContent {


    public static final HashMap<Integer,Feed> FEED_MAP = new HashMap<>();
    public static final ArrayList<Feed> FEED_ARRAY = new ArrayList<>();
    private static Feed[] feedArr;


    static
    {
        GetFeedBG getFeedBG = new GetFeedBG();
        getFeedBG.execute(MainActivity.mPort);
        getFeedBG.onProgressUpdate();
        String arr[] = getFeedBG.result.split("SPLITTER");
        feedArr = new Feed[arr.length];
        for(int i=0;i<arr.length;i++)
            feedArr[i] = new Feed(arr[i]);
        addFeed(feedArr);
    }
    public static void addFeed(Feed[] feedArr)
    {
        for(Feed feed : feedArr)
        {
            FEED_ARRAY.add(feed);
        }

        Collections.sort(FEED_ARRAY);
        for(int i=0;i<FEED_ARRAY.size();i++)
            FEED_MAP.put(i,FEED_ARRAY.get(i));
    }










}
