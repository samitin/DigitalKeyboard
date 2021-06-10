package ru.samitin.digitalkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializeButton();

    }
    private void inicializeButton(){
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
            case R.id.button_0:
            case R.id.button_1:
            case R.id.button_2:
            case R.id.button_3:
            case R.id.button_4:
            case R.id.button_5:
            case R.id.button_6:
            case R.id.button_7:
            case R.id.button_8:
            case R.id.button_9:
                break;
            case R.id.button_plus:
            case R.id.button_minus:
            case R.id.button_divider:
            case R.id.button_myltiply:
            case R.id.button_percent:
                break;
            case R.id.button_equals:
                break;
            case R.id.button_clear:
                break;
            case R.id.button_delite:
                break;
            case R.id.button_point:
                break;
            case R.id.button_plus_minus:
                break;
        }

    }
}