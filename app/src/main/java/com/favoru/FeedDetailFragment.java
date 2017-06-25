package com.favoru;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.favoru.dummy.DummyContent;

/**
 * A fragment representing a single Feed detail screen.
 * This fragment is either contained in a {@link FeedListActivity}
 * in two-pane mode (on tablets) or a {@link FeedDetailActivity}
 * on handsets.
 */
public class FeedDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Feed mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FeedDetailFragment() {
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.

            if(getArguments().getString(ARG_ITEM_ID)!=null)
                mItem = FeedContent.FEED_MAP.get(Integer.parseInt(getArguments().getString(ARG_ITEM_ID)));
            else
                return;



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.feed_detail, container, false);

        Activity activity = this.getActivity();
        CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setTitle(mItem.getmE_title());
        }
        // Show the dummy content as text in a TextView.
        if (mItem != null) {

            //((TextView) rootView.findViewById(R.id.feed_detail)).setText(mItem.details);
//            View mainView = rootView.findViewById(R.id.feed_detail);
            //To be continued.....

            TextView name = (TextView)rootView.findViewById(R.id.name_description);
            name.setText(name.getText().toString() + new User(mItem.getmA_phno()).getmName());
            TextView phno = (TextView)rootView.findViewById(R.id.mno_description);
            phno.setText(phno.getText().toString() + mItem.getmA_phno() );
            TextView date = (TextView)rootView.findViewById(R.id.date_description);
            date.setText(date.getText().toString() + mItem.getmE_date() );
            TextView time = (TextView)rootView.findViewById(R.id.time_description);
            time.setText(time.getText().toString() +  mItem.getmE_time() );
            TextView location = (TextView)rootView.findViewById(R.id.location_description);
            location.setText(location.getText().toString()  + mItem.getmE_location() );
            TextView desc = (TextView)rootView.findViewById(R.id.desc_description);
            desc.setText(desc.getText().toString() +  mItem.getmE_description() );

        }

        return rootView;
    }
}
