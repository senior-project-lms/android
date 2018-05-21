package umtkas.com.lms.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import umtkas.com.lms.R;
import umtkas.com.lms.adapters.views.CourseView;
import umtkas.com.lms.adapters.views.GradeView;
import umtkas.com.lms.models.Course;
import umtkas.com.lms.models.Grade;

public class GradeListAdapter extends ArrayAdapter<Grade> {

    public GradeListAdapter(@NonNull Context context, List<Grade> grades) {
        super(context, 0, grades);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_grade, parent, false);
        }


        GradeView gradeView = new GradeView(getItem(position), convertView, position);

        convertView.setTag(gradeView);

        return convertView;
    }
}
