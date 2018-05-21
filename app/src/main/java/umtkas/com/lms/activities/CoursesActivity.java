package umtkas.com.lms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import umtkas.com.lms.R;
import umtkas.com.lms.adapters.CourseListAdapter;
import umtkas.com.lms.models.Course;

public class CoursesActivity extends AppCompatActivity {


    @BindView(R.id.lstCourses)
    ListView courseListView;

    private ArrayList<Course> courses = new ArrayList<>();
    private CourseListAdapter courseListAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        ButterKnife.bind(this);

        courses.add(new Course("", "CS444-Data Mining"));
        courses.add(new Course("", "CS445-Machine Learning"));
        courses.add(new Course("", "CS492-Senior Project"));
        this.courseListAdapter = new CourseListAdapter(this.getApplicationContext(), this.courses);
        this.courseListView.setAdapter(this.courseListAdapter);
        courseListAdapter.notifyDataSetChanged();


        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
    }



}
