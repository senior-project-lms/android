package umtkas.com.lms.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import umtkas.com.lms.R;
import umtkas.com.lms.adapters.ResourceListAdapter;
import umtkas.com.lms.models.Announcement;
import umtkas.com.lms.models.Resource;
import umtkas.com.lms.models.User;

public class ResourceFragment extends Fragment {


    @BindView(R.id.lstResources)
    ListView resourceListView;

    ArrayList<Resource> resources;

    ResourceListAdapter resourceListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resource, container, false);
        ButterKnife.bind(this, view);
        resources = new ArrayList<>();
        resources.add(new Resource("", "", "lecture6.pdf"));
        resources.add(new Resource("", "", "lecture5.pdf"));
        resources.add(new Resource("", "", "lecture4.pdf"));
        resources.add(new Resource("", "", "lecture3.pdf"));
        resources.add(new Resource("", "", "lecture2.pdf"));
        resources.add(new Resource("", "", "lecture1.pdf"));

        resourceListAdapter = new ResourceListAdapter(view.getContext(), resources);
        //gradeListAdapter.notifyDataSetChanged();
        resourceListView.setAdapter(resourceListAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
