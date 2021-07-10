package ru.samitin.digitalkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[]nubers;
    int[]sings;
    EditText editText;
    CalculatorData calculatorData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editTextNumber);
        calculatorData=new CalculatorData();
        inicialisationButtons();

    }
    private void inicialisationButtons(){
        nubers=new int[]{R.id.button_0,R.id.button_1,R.id.button_2,R.id.button_3,R.id.button_4,
                R.id.button_5,R.id.button_6,R.id.button_7,R.id.button_8,R.id.button_9};
        for (int num:nubers)
            findViewById(num).setOnClickListener(this);

        sings=new int[]{R.id.button_percent,R.id.button_plus,R.id.button_minus,R.id.button_myltiply,
                R.id.button_divider,R.id.button_equals};
        for (int sing:sings)
            findViewById(sing).setOnClickListener(this);

        findViewById(R.id.button_clear).setOnClickListener(this);
        findViewById(R.id.button_delite).setOnClickListener(this);
        findViewById(R.id.button_point).setOnClickListener(this);
        findViewById(R.id.button_plus_minus).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

       clickNumber(view.getId());
       clickPoint(view.getId());
       clickClear(view.getId());
       clickSings(view.getId());
       clickDelite(view.getId());
       clickPlusMinus(view.getId());
    }
    public void clickSings(int id){
        switch (id){
            case R.id.button_percent:
                calculatorData.state=CalculatorData.PERCENT;
                editText.setText(""+calculatorData.clickSing(Double.parseDouble(editText.getText().toString())));
                break;
            case R.id.button_plus:
                calculatorData.state=CalculatorData.PLUS;
                editText.setText(""+calculatorData.clickSing(Double.parseDouble(editText.getText().toString())));
                break;
            case R.id.button_minus:
                calculatorData.state=CalculatorData.MINUS;
                editText.setText(""+calculatorData.clickSing(Double.parseDouble(editText.getText().toString())));
                break;
            case R.id.button_myltiply:
                calculatorData.state=CalculatorData.MULTIPLY;
                editText.setText(""+calculatorData.clickSing(Double.parseDouble(editText.getText().toString())));
                break;
            case R.id.button_divider:
                calculatorData.state=CalculatorData.DIVIDER;
                editText.setText(""+calculatorData.clickSing(Double.parseDouble(editText.getText().toString())));
                break;
            case R.id.button_equals:
                editText.setText(""+calculatorData.getEquals(Double.parseDouble(editText.getText().toString())));
                break;
        }

    }
    private void clickPlusMinus(int id){
        if (id==R.id.button_plus_minus){
            if(editText.getText().toString().contains("-"))
                editText.setText(editText.getText().toString().replace("-",""));
            else
                editText.setText("-"+editText.getText().toString());
        }
    }
    private void clickDelite(int id){
        if (id==R.id.button_delite){
            editText.setText("");
            calculatorData.delite();
        }
    }

    private void clickNumber(int id){
        for (int i=0;i<nubers.length;i++)
            if(nubers[i]==id)
                editText.setText(""+editText.getText().toString()+i);
    }
    private void clickPoint(int id){
        if (id==R.id.button_point)
            if (!editText.getText().toString().contains("."))
                editText.setText(editText.getText().toString()+".");
    }
    private void clickClear(int id){
        if (id==R.id.button_clear)
           if (editText.getText().toString().length()>0)
               editText.setText(editText.getText().toString().substring(0,editText.getText().toString().length()-1));
    }
}