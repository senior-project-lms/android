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
import umtkas.com.lms.adapters.views.CourseView;
import umtkas.com.lms.adapters.views.ResourceView;
import umtkas.com.lms.models.Course;
import umtkas.com.lms.models.Resource;

public class ResourceListAdapter extends ArrayAdapter<Resource> {

    public ResourceListAdapter(@NonNull Context context, List<Resource> resources) {
        super(context, 0, resources);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_resource, parent, false);
        }


        ResourceView resourceView = new ResourceView(getItem(position), convertView, position);

        convertView.setTag(resourceView);

        return convertView;
    }
}
