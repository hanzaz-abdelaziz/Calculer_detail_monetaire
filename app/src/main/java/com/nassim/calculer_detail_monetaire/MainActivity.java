package com.nassim.calculer_detail_monetaire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<RowItem> mList = new ArrayList<>();
    private int[] results ;
    private ListView mListView;
    private EditText editText_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_calculate).setOnClickListener(view -> {
                setupListView();
        });

    }

    private void setupListView(){
        setupListResult();
        mListView = findViewById(R.id.myListView);
        ResultArrayAdapter adapter = new ResultArrayAdapter(this, mList);
        mListView.setAdapter(adapter);
    }

    private void setupListResult(){
        mList.clear();
        editText_total = findViewById(R.id.edit_text_montant);
        if(editText_total.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter total amount!", Toast.LENGTH_SHORT).show();
            return ;
        }
        double total = Double.parseDouble(editText_total.getText().toString());

        //int[] numbers = getResources().getIntArray(R.array.numbers);
        double[] numbers = arrayOfDev();
        results = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] <= total){
                results[i] = (int)(total / numbers[i]);
                //double rest = total / numbers[i];
                //results[i] = (int)(rest % numbers[i]);
                total = total - numbers[i] * results[i];
            }else {
                results[i] = 0;
            }
            String title = getResources().getStringArray(R.array.titles)[i];
            mList.add(new RowItem(title, results[i]));
        }
        Toast.makeText(this, ""+total, Toast.LENGTH_SHORT).show();

    }

    private double[] arrayOfDev(){

        return new double[] {
                200,
                100,
                50,
                20,
                10,
                5,
                2,
                1,
                0.50,
                0.20,
                0.10,
                0.5
        };

    }


}