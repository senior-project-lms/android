package umtkas.com.lms.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import umtkas.com.lms.R;
import umtkas.com.lms.adapters.GradeListAdapter;
import umtkas.com.lms.models.Grade;

public class GradeFragment extends Fragment {



    @BindView(R.id.lstGrades)
    ListView gradeListView;

    ArrayList<Grade> grades;

    GradeListAdapter gradeListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade, container, false);
        ButterKnife.bind(this, view);
        grades = new ArrayList<>();
        grades.add(new Grade("Final Exam", 78, 100, 54, 35));
        grades.add(new Grade("Assignment 4", 10, 10, 8, 10));
        grades.add(new Grade("Assignment 3", 10, 10, 8, 10));
        grades.add(new Grade("Midterm Exam", 58, 100, 55, 25));
        grades.add(new Grade("Assignment 2", 10, 10, 7, 10));
        grades.add(new Grade("Assignment 1", 10, 10, 9, 10));

        gradeListAdapter = new GradeListAdapter(view.getContext(), grades);
        //gradeListAdapter.notifyDataSetChanged();
        gradeListView.setAdapter(gradeListAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
