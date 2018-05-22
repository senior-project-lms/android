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
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import umtkas.com.lms.R;
import umtkas.com.lms.adapters.ResourceListAdapter;
import umtkas.com.lms.models.Announcement;
import umtkas.com.lms.models.Resource;
import umtkas.com.lms.models.User;
import umtkas.com.lms.service.ApiClient;
import umtkas.com.lms.service.ApiService;
import umtkas.com.lms.service.Server;

public class ResourceFragment extends Fragment {


    @BindView(R.id.lstResources)
    ListView resourceListView;

    @BindView(R.id.resourceLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    ArrayList<Resource> resources;

    ResourceListAdapter resourceListAdapter;
    private ApiClient apiService;
    private SharedPreferences sharedPreferences;
    private String accessToken;
    private String coursePublicKey;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resource, container, false);
        ButterKnife.bind(this, view);
        resources = new ArrayList<>();
        resourceListAdapter = new ResourceListAdapter(view.getContext(), resources);
        //gradeListAdapter.notifyDataSetChanged();
        apiService = ApiService.getClient();


        sharedPreferences = getContext().getSharedPreferences("lms-auth", Context.MODE_PRIVATE);
        accessToken = sharedPreferences.getString("access_token", "");
        coursePublicKey = sharedPreferences.getString("course_public_key", "");

        resourceListView.setAdapter(resourceListAdapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchResources();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        this.fetchResources();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void fetchResources() {
        Call<List<Resource>> call = apiService.getResource(Server.getCredentials(), coursePublicKey, accessToken);

        call.enqueue(new Callback<List<Resource>>() {
            @Override
            public void onResponse(Call<List<Resource>> call, Response<List<Resource>> response) {
                if (response.code() == 200) {
                    List<Resource> respResource = response.body();
                    resources.addAll(respResource);
                    resourceListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Resource>> call, Throwable t) {


            }
        });
    }
}
