package umtkas.com.lms.adapters.views;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import su.levenetc.android.badgeview.BadgeView;
import umtkas.com.lms.R;
import umtkas.com.lms.models.Course;

public class CourseView {
    private Course course;
    private View view;

    @BindView(R.id.lblCourseName)
    TextView lblCourseName;

    @BindView(R.id.rowColorView)
    View viewColor;

//    @BindView(R.id.badge)
//    BadgeView badgeView;

    public CourseView(Course course, View view, long index) {
        ButterKnife.bind(this, view);
        this.course = course;
        this.view = view;

        this.lblCourseName.setText(course.getName());
        viewColor.setBackgroundColor(getRandomColor());
//        badgeView.setValue(course.getNotifications());
    }

    private int getRandomColor(){

        Random color = new Random();

        int red = color.nextInt(255);
        int green = color.nextInt(255);
        int blue = color.nextInt(255);
       return  Color.argb(140, red, green, blue);

    }
}
