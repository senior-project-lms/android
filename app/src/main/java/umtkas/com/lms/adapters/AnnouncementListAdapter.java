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
import umtkas.com.lms.adapters.views.AnnouncementView;
import umtkas.com.lms.adapters.views.CourseView;
import umtkas.com.lms.models.Announcement;
import umtkas.com.lms.models.Course;

public class AnnouncementListAdapter extends ArrayAdapter<Announcement> {

    public AnnouncementListAdapter(@NonNull Context context, List<Announcement> announcements) {
        super(context, 0, announcements);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_announcement, parent, false);
        }


        AnnouncementView announcementView = new AnnouncementView(getItem(position), convertView, position);

        convertView.setTag(announcementView);

        return convertView;
    }
}
