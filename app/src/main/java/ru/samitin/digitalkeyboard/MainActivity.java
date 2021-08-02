package ru.samitin.digitalkeyboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.google.android.material.switchmaterial.SwitchMaterial;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;
    private static final String KEY_EDIT_TEXT="KEY_EDIT_TEXT";
    private static final String KEY_CALCULATOR_DATA="KEY_CALCULATOR_DATA";
    private boolean isNight=false;
    int[]nubers;
    EditText editText;
    CalculatorData calculatorData;
    SwitchMaterial switchTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
        setContentView(R.layout.activity_main);

        switchTheme=findViewById(R.id.swith_theme);
        switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                else
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
        findViewById(R.id.btn_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent runSettings = new Intent(MainActivity.this, ChangeThemeActivity.class);
                runSettings.putExtra(ChangeThemeActivity.NIGHT,false);
                startActivityForResult(runSettings, REQUEST_CODE_SETTING_ACTIVITY);
            }
        });

        editText=findViewById(R.id.editTextNumber);
        calculatorData=new CalculatorData();
        inicialisationButtons();
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        if (bundle==null)
            return;
        String text=bundle.getString("PARAM");
        editText.setText(text);
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != REQUEST_CODE_SETTING_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        if (resultCode == RESULT_OK){
            isNight = data.getBooleanExtra(ChangeThemeActivity.NIGHT,false);
            switchTheme.setClickable(isNight);
            if (isNight)
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            else
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
    private void inicialisationButtons(){
        nubers=getResourceArrayId(R.array.numbers);
        for (int number:nubers)
            findViewById(number).setOnClickListener(this);

        for (int sing:getResourceArrayId(R.array.sings))
            findViewById(sing).setOnClickListener(this);
    }
    private int[] getResourceArrayId(int arrayId){
        TypedArray typedArray=getResources().obtainTypedArray(arrayId);
        int[]resArrayId=new int[getResources().getIntArray(arrayId).length];
        for (int i=0;i<resArrayId.length;i++)
            resArrayId[i]=typedArray.getResourceId(i,-1);
        return resArrayId;
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY_CALCULATOR_DATA,calculatorData);
        outState.putString(KEY_EDIT_TEXT,editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculatorData=savedInstanceState.getParcelable(KEY_CALCULATOR_DATA);
        editText.setText(savedInstanceState.getString(KEY_EDIT_TEXT));
    }
}