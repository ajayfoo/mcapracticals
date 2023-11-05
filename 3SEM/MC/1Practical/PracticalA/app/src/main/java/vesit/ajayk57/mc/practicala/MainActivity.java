package vesit.ajayk57.mc.practicala;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(this, SummaryActivity.class);
        final EditText movieNameEdt=findViewById(R.id.movieNameEdt);
        final EditText moveReviewEdt=findViewById(R.id.movieReviewEdt);
        final RatingBar ratingBar=findViewById(R.id.ratingBar);
        final CheckBox informativeChk=findViewById(R.id.informativeChk);
        final CheckBox entertainingChk=findViewById(R.id.entertainmentChk);
        final RadioButton rewatchableRb=findViewById(R.id.rewatchableRb);
        final Button createBtn=findViewById(R.id.createBtn);
        createBtn.setOnClickListener(view -> {
            intent.putExtra("name",movieNameEdt.getText().toString());
            intent.putExtra("review",moveReviewEdt.getText().toString());
            intent.putExtra("rating",ratingBar.getRating());
            intent.putExtra("entertaining",entertainingChk.isChecked());
            intent.putExtra("informative",informativeChk.isChecked());
            intent.putExtra("rewatchable",rewatchableRb.isChecked());
            startActivity(intent);
        });
    }
}