package vesit.ajayk57.mc.practical2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UnitConvertorActivity extends AppCompatActivity {
    private EditText distance1Txt;
    private TextView resultTxt;
    private Spinner unitSp1;
    private Spinner unitSp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_convertor);
        assignViewReferences();
        populateUnitTypesSpinner();
        Button convertBtn=findViewById(R.id.convertBtn);
        convertBtn.setOnClickListener(view -> updateResultTxt());
    }
    private void assignViewReferences(){
        distance1Txt=findViewById(R.id.distance1Txt);
        resultTxt=findViewById(R.id.resultTxt);
        unitSp1=findViewById(R.id.distance1UnitSp);
        unitSp2=findViewById(R.id.distance2UnitSp);
    }
    private void populateUnitTypesSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.distance_units,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSp1.setAdapter(adapter);
        unitSp2.setAdapter(adapter);
    }
    private void updateResultTxt()  {
        double d1Value=0;
        try{
            d1Value = Double.parseDouble(distance1Txt.getText().toString());
        }catch(NumberFormatException exc){
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
            return;
        }
        final Distance.UnitType d1UnitType=Distance.UnitType.create(
                unitSp1.getSelectedItemPosition()
        );
        final Distance distance1=new Distance(d1Value,d1UnitType);
        final Distance.UnitType d2UnitType=Distance.UnitType.create(
                unitSp2.getSelectedItemPosition()
        );
        final Distance convertedDistance=distance1.to(d2UnitType);
        resultTxt.setText(getString(R.string.result,convertedDistance.getValue()));
    }
}