package vesit.ajayk57.mc.practical8;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class ProblemBActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problemb);
        VideoView videoView=findViewById(R.id.videoView);
        final String packageName="vesit.ajayk57.mc.practical8";
        final String videoLocation="android.resource://"+packageName+"/raw/"+R.raw.video;
        videoView.setVideoURI(Uri.parse(videoLocation));
        videoView.setMediaController(new MediaController(this));
        videoView.start();
        findViewById(R.id.bBackBtn).setOnClickListener(view -> finish());
    }
}