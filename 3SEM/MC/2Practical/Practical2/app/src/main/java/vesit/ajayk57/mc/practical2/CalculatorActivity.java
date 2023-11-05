package vesit.ajayk57.mc.practical2;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CalculatorActivity extends AppCompatActivity {
    final List<EditText> numFields=new ArrayList<>();
    TextView answerTxt;
    private boolean areAllNumFieldsFilled(){
        for(EditText numField: numFields){
            if(numField.length()==0){
                return false;
            }
        }
        return true;
    }
    private void calculateOrShowToast(CalcOperation operation,String num1Str,String num2Str){
        if(!areAllNumFieldsFilled()){
            Toast.makeText(this, "Please Fill all the fields", Toast.LENGTH_SHORT).show();
        }
        double num1;
        double num2;
        double result;
        try{
            num1=Double.parseDouble(num1Str);
            num2=Double.parseDouble(num2Str);
        }catch (Exception exc){
            Toast.makeText(this, "Please enter valid number(s)", Toast.LENGTH_SHORT).show();
            return;
        }
        switch (operation){
            case ADD:
                result=num1+num2;
                break;
            case SUBTRACT:
                result=num1-num2;
                break;
            case MULTIPLY:
                result=num1*num2;
                break;
            case DIVIDE:
                if(num2==0){
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result=num1/num2;
                break;
            default:
                Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                return;
        }
        answerTxt.setText(getString(R.string.answer,result));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        EditText num1Edt=findViewById(R.id.num1Edt);
        EditText num2Edt=findViewById(R.id.num2Edt);
        answerTxt=findViewById(R.id.answerTxt);
        numFields.add(num1Edt);
        numFields.add(num2Edt);
        findViewById(R.id.addBtn).setOnClickListener(view -> calculateOrShowToast(CalcOperation.ADD,
                num1Edt.getText().toString(),
                num2Edt.getText().toString()
        ));
        findViewById(R.id.subtractBtn).setOnClickListener(view -> calculateOrShowToast(CalcOperation.SUBTRACT,
                num1Edt.getText().toString(),
                num2Edt.getText().toString()
        ));
        findViewById(R.id.multiplyBtn).setOnClickListener(view -> calculateOrShowToast(CalcOperation.MULTIPLY,
                num1Edt.getText().toString(),
                num2Edt.getText().toString()
        ));
        findViewById(R.id.divideBtn).setOnClickListener(view -> calculateOrShowToast(CalcOperation.DIVIDE,
                num1Edt.getText().toString(),
                num2Edt.getText().toString()
        ));
        findViewById(R.id.calcBackBtn).setOnClickListener(view -> finish());
    }

}