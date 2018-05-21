package umtkas.com.lms.adapters.views;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import umtkas.com.lms.R;
import umtkas.com.lms.models.Grade;
import umtkas.com.lms.models.Resource;

public class ResourceView {
    private Resource resource;
    private View view;

    @BindView(R.id.lblFileName)
    TextView lblFileName;


    @BindView(R.id.btnDownload)
    Button btnDownload;



    public ResourceView(Resource resource, View view, long index) {
        ButterKnife.bind(this, view);
        this.resource = resource;
        this.view = view;

        lblFileName.setText(resource.getOriginalFileName());

    }
}
