package vesit.ajayk57.mc.practical3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.goToWebSiteBtn).setOnClickListener(view -> goToWebsite());
        findViewById(R.id.openMapBtn).setOnClickListener(view -> openMap());
        findViewById(R.id.shareTextBtn).setOnClickListener(view -> shareText());
    }
    private void goToWebsite(){
        final EditText websiteTxt =findViewById(R.id.websiteTxt);
        String url=websiteTxt.getText().toString();
        if (!url.startsWith("http://") && !url.startsWith("https://"))
        {
            url = "http://" + url;
        }
        final Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
    private void openMap(){
        final EditText locationTxt=findViewById(R.id.locationTxt);
        final String location = "http://maps.google.co.in/maps?q=" + locationTxt.getText().toString();
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
        startActivity(intent);
    }
    private void shareText(){
        final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        final EditText messageTxt=findViewById(R.id.messageTxt);
        final String message = messageTxt.getText().toString();
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, getString(R.string.share_using)));
    }
}