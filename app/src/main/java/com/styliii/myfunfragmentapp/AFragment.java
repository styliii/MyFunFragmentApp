package com.styliii.myfunfragmentapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

public class AFragment extends Fragment {
    //Link the view to the fragment
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // last argument is false....b/c otherwise it would append to container
        // you probably have its own insertion logic, so do not attach it yet
        View v = inflater.inflate(R.layout.fragment_a,container,false);

        ProgressBar pb = (ProgressBar) v.findViewById(R.id.progressBar);

        return v;
   }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
