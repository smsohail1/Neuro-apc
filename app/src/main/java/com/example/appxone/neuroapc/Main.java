package com.example.appxone.neuroapc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by APPXONE on 3/1/2016.
 */
public class Main extends ActionBarActivity {
    public ArrayList<CalculatorModel> calculatormodel;
    public CalculatorsAdapter calculator_adapter;
    public ListView calculator_List;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activitymain);
        getSupportActionBar().hide();
        calculatormodel = new ArrayList<>();
        calculatormodel.add(new CalculatorModel("Table of contentes", R.drawable.icon_forward));
        calculatormodel.add(new CalculatorModel("Classical View", R.drawable.icon_forward));
        calculatormodel.add(new CalculatorModel("BB aTools", R.drawable.icon_forward));
        calculatormodel.add(new CalculatorModel("About Us", R.drawable.icon_forward));
        calculator_List = (ListView) findViewById(R.id.list_calculator);
        calculator_adapter = new CalculatorsAdapter(getApplicationContext(), calculatormodel);
        calculator_List.setAdapter(calculator_adapter);
        calculator_List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    intent = new Intent(Main.this, MainActivity.class);
                    startActivity(intent);
                } else if (position == 1) {
                    intent = new Intent(Main.this, Classicalview.class);
                    startActivity(intent);
                } else if (position == 2) {
                    intent = new Intent(Main.this, BBatools.class);
                    startActivity(intent);
                } else {
                    intent = new Intent(Main.this, Aboutus.class);
                    startActivity(intent);
                }

            }
        });
    }
}
