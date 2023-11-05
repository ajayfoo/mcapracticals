package vesit.ajayk57.mc.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Bundle extras=getIntent().getExtras();
        TextView summaryTxt=findViewById(R.id.summaryTxt);
        assert extras != null;
        summaryTxt.setText(getString(R.string.a_summary,
                extras.getString("username"),
                extras.getString("email"))
        );
        Button backBtn=findViewById(R.id.backBtn);
        backBtn.setOnClickListener(view -> finish());
    }
}