package umtkas.com.lms.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import umtkas.com.lms.R;
import umtkas.com.lms.adapters.AnnouncementListAdapter;
import umtkas.com.lms.adapters.GradeListAdapter;
import umtkas.com.lms.models.Announcement;
import umtkas.com.lms.models.Grade;
import umtkas.com.lms.models.User;

public class AnnouncementFragment extends Fragment {



    @BindView(R.id.lstAnnouncement)
    ListView announcementListView;

    ArrayList<Announcement> announcements;

    AnnouncementListAdapter announcementListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_announcement, container, false);
        ButterKnife.bind(this, view);
        announcements = new ArrayList<>();
        announcements.add(new Announcement("1", "Final Exam", "Hello all final exam date and time are below", new Date(System.currentTimeMillis()), new User("", "umit.kas", "", "")));
        announcements.add(new Announcement("1", "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", new Date(System.currentTimeMillis()), new User("", "umit.kas", "", "")));
        announcements.add(new Announcement("1", "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", new Date(System.currentTimeMillis()), new User("", "umit.kas", "", "")));
        announcements.add(new Announcement("1", "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", new Date(System.currentTimeMillis()), new User("", "umit.kas", "", "")));

        announcements.add(new Announcement("1", "Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", new Date(System.currentTimeMillis()), new User("", "umit.kas", "", "")));

        announcementListAdapter = new AnnouncementListAdapter(view.getContext(), announcements);
        //gradeListAdapter.notifyDataSetChanged();
        announcementListView.setAdapter(announcementListAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
