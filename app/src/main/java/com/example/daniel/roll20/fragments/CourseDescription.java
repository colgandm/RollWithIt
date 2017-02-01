package com.example.daniel.roll20.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniel.roll20.R;

public class CourseDescription extends Fragment {

    private static final String _courseIndexStateKey = "courseIndex";
    private static final int _courseIndexDefaultValue = 0;

    TextView _descriptionView;
    String[] _courseDescription;
    int _courseIndex;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragmentView = inflater.inflate(R.layout.fragment_course_description, container, false);

        _descriptionView = (TextView)fragmentView.findViewById(R.id.courseDescription);
        _courseDescription = getResources().getStringArray(R.array.course_descriptions);

        _courseIndex = _courseIndexDefaultValue;

        setDisplayedDescription(_courseIndex);

        return fragmentView;
    }

    public void setDisplayedDescription(int courseIndex) {
        _courseIndex = courseIndex;
        _descriptionView.setText(_courseDescription[_courseIndex]);
    }

}
