package vesit.ajayk57.mc.practical1b;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    static final Map<String,String> users= new HashMap<String, String>() {{
        put("ajay","ajayk57");
        put("manoj","m2");
        put("george","g1");
    }};
    static int numOfFailedAttempts=0;
    final int MAX_NUM_OF_FAILED_ATTEMPTS=3;
    private static boolean isValidUser(String username,String password){
        if(username==null || password==null) return false;
        return Objects.equals(users.get(username), password);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.wrong_password);
        AlertDialog dialog = builder.create();
        TextView usernameTxt=findViewById(R.id.usernameTxt);
        TextView passwordTxt=findViewById(R.id.passwordTxt);
        Button loginBtn=findViewById(R.id.loginBtn);
        Intent intent=new Intent(this,WelcomeActivity.class);
        loginBtn.setOnClickListener(view -> {
            if(isValidUser(usernameTxt.getText().toString(),passwordTxt.getText().toString())){
                intent.putExtra("username",usernameTxt.getText().toString());
                startActivity(intent);
            }
            else if(numOfFailedAttempts<MAX_NUM_OF_FAILED_ATTEMPTS){
                ++numOfFailedAttempts;
                dialog.setMessage(getString(R.string.failed_attempt_msg,
                        MAX_NUM_OF_FAILED_ATTEMPTS-numOfFailedAttempts));
                dialog.show();
            }else{
                view.setEnabled(false);
            }
        });
    }
}