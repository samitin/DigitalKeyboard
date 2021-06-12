package ru.samitin.digitalkeyboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String keyCounters = "Colculete";
    ColculeteData colculeteData;
    EditText editText;
    TextView info;
    String numberStr="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializeButton();
        editText=findViewById(R.id.editTextNumber);
    }
    private void inicializeButton(){
        colculeteData=new ColculeteData();

        info=findViewById(R.id.infoTextView);
        Button button_0=findViewById(R.id.button_0);
        button_0.setOnClickListener(this);
        Button button_1=findViewById(R.id.button_1);
        button_1.setOnClickListener(this);
        Button button_2=findViewById(R.id.button_2);
        button_2.setOnClickListener(this);
        Button button_3=findViewById(R.id.button_3);
        button_3.setOnClickListener(this);
        Button button_4=findViewById(R.id.button_4);
        button_4.setOnClickListener(this);
        Button button_5=findViewById(R.id.button_5);
        button_5.setOnClickListener(this);
        Button button_6=findViewById(R.id.button_6);
        button_6.setOnClickListener(this);
        Button button_7=findViewById(R.id.button_7);
        button_7.setOnClickListener(this);
        Button button_8=findViewById(R.id.button_8);
        button_8.setOnClickListener(this);
        Button button_9=findViewById(R.id.button_9);
        button_9.setOnClickListener(this);
        Button button_clear=findViewById(R.id.button_clear);
        button_clear.setOnClickListener(this);
        Button button_delite=findViewById(R.id.button_delite);
        button_delite.setOnClickListener(this);
        Button button_divider=findViewById(R.id.button_divider);
        button_divider.setOnClickListener(this);
        Button button_equals=findViewById(R.id.button_equals);
        button_equals.setOnClickListener(this);
        Button button_minus=findViewById(R.id.button_minus);
        button_minus.setOnClickListener(this);
        Button button_myltiply=findViewById(R.id.button_myltiply);
        button_myltiply.setOnClickListener(this);
        Button button_percent=findViewById(R.id.button_percent);
        button_percent.setOnClickListener(this);
        Button button_plus=findViewById(R.id.button_plus);
        button_plus.setOnClickListener(this);
        Button button_point=findViewById(R.id.button_point);
        button_point.setOnClickListener(this);
        Button button_plus_minus=findViewById(R.id.button_plus_minus);
        button_plus_minus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_0:editText.setText(editText.getText().toString()+0);
                break;
            case R.id.button_1: editText.setText(editText.getText().toString()+1);
                break;
            case R.id.button_2: editText.setText(editText.getText().toString()+2);
                break;
            case R.id.button_3: editText.setText(editText.getText().toString()+3);
                break;
            case R.id.button_4:  editText.setText(editText.getText().toString()+4);
                break;
            case R.id.button_5: editText.setText(editText.getText().toString()+5);
                break;
            case R.id.button_6:editText.setText(editText.getText().toString()+6);
                break;
            case R.id.button_7:editText.setText(editText.getText().toString()+7);
                break;
            case R.id.button_8:editText.setText(editText.getText().toString()+8);
                break;
            case R.id.button_9:editText.setText(editText.getText().toString()+9);
                break;
             case R.id.button_point:
                 if (!editText.getText().toString().contains("."))
                     editText.setText(editText.getText().toString()+".");
                break;
            case R.id.button_plus:
                colculeteData.plus(Double.parseDouble(editText.getText().toString()));
                editText.setText("");
                break;
            case R.id.button_minus:
                if (editText.getText().toString()!="") {
                    colculeteData.minus(Double.parseDouble(editText.getText().toString()));
                    editText.setText("");
                }
                break;
            case R.id.button_divider:
                colculeteData.divider(Double.parseDouble(editText.getText().toString()));
                editText.setText("");
                break;
            case R.id.button_myltiply:
                colculeteData.myltiply(Double.parseDouble(editText.getText().toString()));
                editText.setText("");
                break;
            case R.id.button_percent:
                colculeteData.percent(Double.parseDouble(editText.getText().toString()));
                editText.setText("");
                break;
            case R.id.button_equals:
                editText.setText(""+colculeteData.getAnswer(Double.parseDouble(editText.getText().toString())));
                break;
            case R.id.button_clear:
                if (editText.getText().toString().length()>0)
                    editText.setText(editText.getText().toString().substring(0,editText.getText().toString().length()-1));
                break;
            case R.id.button_delite:
                editText.setText("");
                colculeteData.delite();
                break;

            case R.id.button_plus_minus:
                if(editText.getText().toString().contains("-"))
                   editText.setText(editText.getText().toString().replace("-",""));
                else
                    editText.setText("-"+editText.getText().toString());
                break;
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(keyCounters,colculeteData);
        outState.putString("editText",editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        colculeteData=(ColculeteData)savedInstanceState.getSerializable(keyCounters);
        editText.setText(savedInstanceState.getString("editText"));

    }
}