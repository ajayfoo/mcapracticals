package vesit.ajayk57.mc.practicala;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Bundle extras=getIntent().getExtras();
        TextView movieNameTxt=findViewById(R.id.movieNameTxt);
        TextView movieReviewTxt=findViewById(R.id.movieReviewTxt);
        RatingBar ratingBar=findViewById(R.id.ratingBar2);
        TextView adjectiveTxt=findViewById(R.id.adjectiveTxt);
        TextView rewatchableTxt=findViewById(R.id.rewatchableTxt);
        if (extras != null) {
            movieNameTxt.setText(extras.getString("name"));
            movieReviewTxt.setText(extras.getString("review"));
            ratingBar.setRating(extras.getFloat("rating"));
            boolean isEntertaining=extras.getBoolean("entertaining");
            boolean isInformative=extras.getBoolean("informative");
            boolean isRewatchable=extras.getBoolean("rewatchable");
            String adjectiveStr=(isInformative?getString(R.string.informative)+" ":"")+
                    (isEntertaining?getString(R.string.entertaining):"");
            adjectiveTxt.setText(adjectiveStr);
            String rewatchableStr=getString(R.string.isRewatchable,isRewatchable?"":"not ");
            rewatchableTxt.setText(rewatchableStr);
        }
        Button backButton=findViewById(R.id.backBtn);
        backButton.setOnClickListener(view -> finish());
    }
}