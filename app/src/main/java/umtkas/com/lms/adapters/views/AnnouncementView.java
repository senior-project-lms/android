package umtkas.com.lms.adapters.views;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import org.ocpsoft.prettytime.PrettyTime;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import su.levenetc.android.badgeview.BadgeView;
import umtkas.com.lms.R;
import umtkas.com.lms.models.Announcement;
import umtkas.com.lms.models.Course;

public class AnnouncementView {
    private Announcement announcement;
    private View view;

    @BindView(R.id.lblTitle)
    TextView lblTitle;


    @BindView(R.id.lblAnnouncement)
    TextView lblAnnouncement;



    @BindView(R.id.lblCreatedAt)
    TextView lblCreatedAt;



    @BindView(R.id.lblCreatedBy)
    TextView lblCreatedBy;



    public AnnouncementView(Announcement announcement, View view, long index) {
        ButterKnife.bind(this, view);
        this.announcement = announcement;
        this.view = view;

        PrettyTime p = new PrettyTime();

        lblTitle.setText(announcement.getTitle());
        lblAnnouncement.setText(announcement.getContent());
        lblCreatedAt.setText(p.format(announcement.getCreatedAt()));
        lblCreatedBy.setText(announcement.getCreatedBy().getUsername());
    }


}
