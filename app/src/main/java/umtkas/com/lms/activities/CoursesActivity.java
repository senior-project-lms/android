package umtkas.com.lms.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import umtkas.com.lms.R;
import umtkas.com.lms.adapters.CourseListAdapter;
import umtkas.com.lms.models.Course;
import umtkas.com.lms.service.ApiClient;
import umtkas.com.lms.service.ApiService;
import umtkas.com.lms.service.Server;

public class CoursesActivity extends AppCompatActivity {


    @BindView(R.id.lstCourses)
    ListView courseListView;

    @BindView(R.id.courseLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private ArrayList<Course> courses = new ArrayList<>();
    private CourseListAdapter courseListAdapter;

    private ApiClient apiService;
    private SharedPreferences sharedPreferences;
    private String accessToken;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        ButterKnife.bind(this);
        apiService = ApiService.getClient();

        sharedPreferences = getSharedPreferences("lms-auth", Context.MODE_PRIVATE);
        editor = this.sharedPreferences.edit();


        accessToken = sharedPreferences.getString("access_token", "");

        this.courseListAdapter = new CourseListAdapter(this.getApplicationContext(), this.courses);
        this.courseListView.setAdapter(this.courseListAdapter);


        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course = courses.get(position);

                editor.putString("course_public_key", course.getPublicKey());
                editor.commit();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);


            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchCourses();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        this.fetchCourses();
    }

    private void fetchCourses(){
        Call<List<Course>> call = apiService.getCourses(Server.getCredentials(), accessToken);

        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                if (response.code() == 200){
                    List<Course> respCourses = response.body();
                    courses.clear();
                    courses.addAll(respCourses);
                    courseListAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {

            }
        });
    }



}
