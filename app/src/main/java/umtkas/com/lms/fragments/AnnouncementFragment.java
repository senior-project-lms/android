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
import android.widget.AbsListView;
import android.widget.ListView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import umtkas.com.lms.R;
import umtkas.com.lms.adapters.AnnouncementListAdapter;
import umtkas.com.lms.adapters.AnnouncementListAdapter;
import umtkas.com.lms.models.Announcement;
import umtkas.com.lms.models.Announcement;
import umtkas.com.lms.models.User;
import umtkas.com.lms.service.ApiClient;
import umtkas.com.lms.service.ApiService;
import umtkas.com.lms.service.Server;

public class AnnouncementFragment extends Fragment {



    @BindView(R.id.lstAnnouncement)
    ListView announcementListView;

    @BindView(R.id.announcementLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    
    ArrayList<Announcement> announcements;

    AnnouncementListAdapter announcementListAdapter;
    private ApiClient apiService;
    private SharedPreferences sharedPreferences;
    private String accessToken;
    private String coursePublicKey;
    private int page = 1;
    private boolean isLoadMore = false;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_announcement, container, false);
        ButterKnife.bind(this, view);
        apiService = ApiService.getClient();

        sharedPreferences = getContext().getSharedPreferences("lms-auth", Context.MODE_PRIVATE);
        accessToken = sharedPreferences.getString("access_token", "");
        coursePublicKey = sharedPreferences.getString("course_public_key", "");

        announcements = new ArrayList<>();
        announcementListAdapter = new AnnouncementListAdapter(view.getContext(), announcements);
        //gradeListAdapter.notifyDataSetChanged();
        announcementListView.setAdapter(announcementListAdapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                announcements.clear();
                page = 1;
                fetchAnnouncements();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        announcementListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                fetchAnnouncements();
                int lastInScreen = firstVisibleItem + visibleItemCount;


                if ((lastInScreen == totalItemCount) && !isLoadMore && totalItemCount !=0) {
                    page++;
                    isLoadMore = true;
                    fetchAnnouncements();
                }
            }
        });

        this.fetchAnnouncements();
        return view;
    }

    @Override
    public void onResume() {
        page = 1;
        super.onResume();

    }

    private void fetchAnnouncements(){
        Call<List<Announcement>> call = apiService.getAnnouncements(Server.getCredentials(), coursePublicKey, page, accessToken);

        call.enqueue(new Callback<List<Announcement>>() {
            @Override
            public void onResponse(Call<List<Announcement>> call, Response<List<Announcement>> response) {
                if (response.code() == 200){
                    List<Announcement> respAnnouncements = response.body();
                    announcements.addAll(respAnnouncements);
                    announcementListAdapter.notifyDataSetChanged();
                    if (respAnnouncements.size() == 5){
                        isLoadMore = false;
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Announcement>> call, Throwable t) {


            }
        });
    }
}
