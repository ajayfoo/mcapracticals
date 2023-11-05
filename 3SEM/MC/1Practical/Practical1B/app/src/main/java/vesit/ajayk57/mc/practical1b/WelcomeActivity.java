package vesit.ajayk57.mc.practical1b;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Bundle extras=getIntent().getExtras();
        TextView welcomeTxt=findViewById(R.id.welcomeTxt);
        Button backBtn=findViewById(R.id.backBtn);
        if (extras != null) {
            String welcomeStr = getString(R.string.welcome_msg,extras.getString("username"));
            welcomeTxt.setText(welcomeStr);
        }
        backBtn.setOnClickListener(view -> finish());
    }
}