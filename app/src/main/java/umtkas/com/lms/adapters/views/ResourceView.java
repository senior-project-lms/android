package umtkas.com.lms.adapters.views;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import umtkas.com.lms.R;
import umtkas.com.lms.models.Resource;
import umtkas.com.lms.service.Server;

public class ResourceView {
    private Resource resource;
    private View view;

    @BindView(R.id.lblFileName)
    TextView lblFileName;


    @BindView(R.id.btnDownload)
    Button btnDownload;


    private SharedPreferences sharedPreferences;

    public ResourceView(final Resource resource, final View view, long index) {
        ButterKnife.bind(this, view);
        this.resource = resource;
        this.view = view;
        lblFileName.setText(resource.getOriginalFileName());
        sharedPreferences = view.getContext().getSharedPreferences("lms-auth", Context.MODE_PRIVATE);
        final String accessToken = sharedPreferences.getString("access_token", "");

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager dm = (DownloadManager) view.getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                String url = String.format("%s/%s?access_token=%s", Server.BASE_URL, resource.getUrl(), accessToken);
                Uri uri = Uri.parse(url);
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                long reference = dm.enqueue(request);
            }
        });

    }
}
