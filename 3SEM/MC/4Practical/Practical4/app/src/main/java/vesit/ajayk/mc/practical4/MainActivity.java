package vesit.ajayk.mc.practical4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vesit.ajayk.mc.practical4.data.AppDatabase;
import vesit.ajayk.mc.practical4.data.Student;
import vesit.ajayk.mc.practical4.data.StudentDao;

public class MainActivity extends AppCompatActivity {
    private StudentDao studentDao;
    TableLayout studentsTbl;
    private void refreshTable(){
        List<Student> students=studentDao.getAll();
        TableRow row = null;
        if(students.isEmpty()){
            Toast.makeText(this, "Table is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        for(Student student : students){
            final TextView idTxt=new TextView(getApplicationContext());
            final TextView nameTxt=new TextView(getApplicationContext());
            final TextView scoreTxt=new TextView(getApplicationContext());
            idTxt.setText(student.id);
            nameTxt.setText(student.name);
            scoreTxt.setText(student.score);
            row = new TableRow(getApplicationContext());
            row.addView(idTxt);
            row.addView(nameTxt);
            row.addView(scoreTxt);
        }
        studentsTbl.addView(row);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentDao = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,
                        "student").allowMainThreadQueries().build().studentDao();
        studentsTbl=findViewById(R.id.studentsTbl);
        findViewById(R.id.refreshBtn).setOnClickListener(view -> refreshTable());
    }
}