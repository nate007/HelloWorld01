package com.example.www.helloworld01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by renshuang on 20/08/15.
 */
public class ContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.content, null);


        TextView content = (TextView) view.findViewById(R.id.content);
        if (getArguments() != null && getArguments().getString("key") != null) {
            content.setText(getArguments().getString("key"));
        }

        return view;
    }
}
