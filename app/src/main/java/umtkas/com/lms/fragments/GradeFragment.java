package umtkas.com.lms.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import umtkas.com.lms.R;
import umtkas.com.lms.adapters.GradeListAdapter;
import umtkas.com.lms.models.Course;
import umtkas.com.lms.models.Grade;
import umtkas.com.lms.service.ApiClient;
import umtkas.com.lms.service.ApiService;
import umtkas.com.lms.service.Server;

public class GradeFragment extends Fragment {



    @BindView(R.id.lstGrades)
    ListView gradeListView;

    @BindView(R.id.gradeLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    ArrayList<Grade> grades;

    GradeListAdapter gradeListAdapter;

    private ApiClient apiService;
    private SharedPreferences sharedPreferences;
    private String accessToken;
    private String coursePublicKey;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade, container, false);
        ButterKnife.bind(this, view);
        apiService = ApiService.getClient();

        sharedPreferences = getContext().getSharedPreferences("lms-auth", Context.MODE_PRIVATE);
        accessToken = sharedPreferences.getString("access_token", "");
        coursePublicKey = sharedPreferences.getString("course_public_key", "");


        grades = new ArrayList<>();
//        grades.add(new Grade("Final Exam", 78, 100, 54, 35));
//        grades.add(new Grade("Assignment 4", 10, 10, 8, 10));
//        grades.add(new Grade("Assignment 3", 10, 10, 8, 10));
//        grades.add(new Grade("Midterm Exam", 58, 100, 55, 25));
//        grades.add(new Grade("Assignment 2", 10, 10, 7, 10));
//        grades.add(new Grade("Assignment 1", 10, 10, 9, 10));

        gradeListAdapter = new GradeListAdapter(view.getContext(), grades);
        //gradeListAdapter.notifyDataSetChanged();
        gradeListView.setAdapter(gradeListAdapter);
        this.fetchGrades();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchGrades();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void fetchGrades(){
        Call<List<Grade>> call = apiService.getGrades(Server.getCredentials(), coursePublicKey, accessToken);

        call.enqueue(new Callback<List<Grade>>() {
            @Override
            public void onResponse(Call<List<Grade>> call, Response<List<Grade>> response) {
                if (response.code() == 200){
                    List<Grade> respGrades = response.body();
                    grades.clear();
                    grades.addAll(respGrades);
                    gradeListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Grade>> call, Throwable t) {

            }
        });
    }
}
