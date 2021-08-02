package ru.samitin.digitalkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int[]nambersId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    private void init(){
        nambersId=getIdsFromArray(R.array.numbers);
        for (int nam:nambersId)
            findViewById(nam).setOnClickListener(this::onClick);

        for (int sing:getIdsFromArray(R.array.sings))
            findViewById(sing).setOnClickListener(this);
    }
    private int[] getIdsFromArray(int arrayId){
        TypedArray ta=getResources().obtainTypedArray(arrayId);
        int[]arry=new int[ta.length()];
        for (int i=0;i<arry.length;i++)
            arry[i]=ta.getResourceId(i,0);
        return arry;
    }

    @Override
    public void onClick(View view) {

    }
}