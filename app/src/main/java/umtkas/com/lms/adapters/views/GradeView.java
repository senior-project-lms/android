package umtkas.com.lms.adapters.views;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import su.levenetc.android.badgeview.BadgeView;
import umtkas.com.lms.R;
import umtkas.com.lms.models.Course;
import umtkas.com.lms.models.Grade;

public class GradeView {
    private Grade grade;
    private View view;

    @BindView(R.id.lblGradeName)
    TextView lblGradeName;


    @BindView(R.id.lblScore)
    TextView lblScore;

    @BindView(R.id.lblAverage)
    TextView lblAverage;


    @BindView(R.id.rowColorView)
    View viewColor;


    public GradeView(Grade grade, View view, long index) {
        ButterKnife.bind(this, view);
        this.grade = grade;
        this.view = view;

        lblGradeName.setText(grade.getName());
        lblScore.setText(String.format("%.1f/%.1f",grade.getScore(), grade.getMaxScore()));
        lblAverage.setText(String.format("%.1f", grade.getAverage()));
        viewColor.setBackgroundColor(getRandomColor());
    }

    private int getRandomColor(){

        Random color = new Random();

        int red = color.nextInt(255);
        int green = color.nextInt(255);
        int blue = color.nextInt(255);
       return  Color.argb(140, red, green, blue);

    }
}
