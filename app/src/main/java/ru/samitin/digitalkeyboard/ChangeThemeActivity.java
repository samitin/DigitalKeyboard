package ru.samitin.digitalkeyboard;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeThemeActivity extends AppCompatActivity {

    private TextView mTextView;
    public static final String NIGHT="NIGHT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_theme);

        findViewById(R.id.btn_night).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentResult = new Intent();
                intentResult.putExtra(NIGHT, true);
                setResult(RESULT_OK, intentResult);
                // Метод finish() завершает активити
                finish();
            }
        });
        findViewById(R.id.btn_no_night).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentResult = new Intent();
                intentResult.putExtra(NIGHT, false);
                setResult(RESULT_OK, intentResult);
                // Метод finish() завершает активити
                finish();
            }
        });

    }
}