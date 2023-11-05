package vesit.ajayk57.mc.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button runABtn=findViewById(R.id.runABtn);
        Button runBBtn=findViewById(R.id.runBBtn);
        Button runCBtn=findViewById(R.id.runCBtn);
        runABtn.setOnClickListener(view -> startActivity(new Intent(this,RegistrationActivity.class)));
        runBBtn.setOnClickListener(view -> startActivity(new Intent(this,CalculatorActivity.class)));
        runCBtn.setOnClickListener(view -> startActivity(new Intent(this, UnitConvertorActivity.class)));

    }
}