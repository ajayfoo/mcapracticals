package vesit.ajayk57.mc.practical2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class RegistrationActivity extends AppCompatActivity {
    final List<EditText> formFields= new ArrayList<>();
    private boolean areAllFieldsFilled(){
        for(EditText field: formFields){
            if(field.length()==0){
                return false;
            }
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        formFields.add(findViewById(R.id.usernameTxt));
        formFields.add(findViewById(R.id.emailTxt));
        formFields.add(findViewById(R.id.passwordTxt));
        Button goHomeBtn=findViewById(R.id.goHomeBtn);
        goHomeBtn.setOnClickListener(view -> finish());
        EditText usernameTxt=findViewById(R.id.usernameTxt);
        EditText emailTxt=findViewById(R.id.emailTxt);
        Intent intent=new Intent(this, SummaryActivity.class);
        Button registerBtn=findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(view -> {
            if(areAllFieldsFilled()){
                intent.putExtra("username",usernameTxt.getText().toString());
                intent.putExtra("email",emailTxt.getText().toString());
                startActivity(intent);
            }else{
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}