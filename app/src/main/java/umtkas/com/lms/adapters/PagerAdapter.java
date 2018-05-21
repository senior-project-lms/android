package umtkas.com.lms.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import umtkas.com.lms.fragments.AnnouncementFragment;
import umtkas.com.lms.fragments.AssignmentFragment;
import umtkas.com.lms.fragments.GradeFragment;
import umtkas.com.lms.fragments.QAFragment;
import umtkas.com.lms.fragments.QTFragment;
import umtkas.com.lms.fragments.ResourceFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numberOfFragments;

    private AnnouncementFragment announcementFragment = new AnnouncementFragment();
    private AssignmentFragment assignmentFragment = new AssignmentFragment();
    private GradeFragment gradeFragment = new GradeFragment();
    private QAFragment qaFragment = new QAFragment();
    private QTFragment qtFragment = new QTFragment();
    private ResourceFragment resourceFragment = new ResourceFragment();


    public PagerAdapter(FragmentManager fm, int numberOfFragments) {
        super(fm);
        this.numberOfFragments = numberOfFragments;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return announcementFragment;
            case 1:
                return gradeFragment;
//            case 2:
//                return assignmentFragment;
//            case 3:
//                return qtFragment;
            case 2:
                return resourceFragment;
//            case 3:
//                return qaFragment;

            default:
                return announcementFragment;
        }
    }


    @Override
    public int getCount() {
        return numberOfFragments;
    }

}
