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
import umtkas.com.lms.models.Course;

public class CourseListAdapter extends ArrayAdapter<Course> {

    public CourseListAdapter(@NonNull Context context, List<Course> courses) {
        super(context, 0, courses);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_course, parent, false);
        }


        CourseView courseView = new CourseView(getItem(position), convertView, position);

        convertView.setTag(courseView);

        return convertView;
    }
}
