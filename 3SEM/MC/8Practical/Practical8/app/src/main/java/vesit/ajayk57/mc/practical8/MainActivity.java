package vesit.ajayk57.mc.practical8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.runA).setOnClickListener(view -> startActivity(
                new Intent(this, ProblemAActivity.class)
        ));
        findViewById(R.id.runB).setOnClickListener(view -> startActivity(
                new Intent(this, ProblemBActivity.class)
        ));
        findViewById(R.id.runC).setOnClickListener(view -> startActivity(
                new Intent(this, ProblemCActivity.class)
        ));
    }

}