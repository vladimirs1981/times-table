package com.stojanovic.timestables;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mArrayList;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.listView);
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;

                if (progress<min) {
                    timesTable = min;
                    seekBar.setProgress(min);
                }else {
                    timesTable = progress;
                }

                generateTimesTable(seekBar);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void generateTimesTable(SeekBar seekBar) {
        int seekValue = seekBar.getProgress();
        mArrayList = new ArrayList<>();
        for (int i = 1; i <10 ; i++) {
            int res = seekValue * i;
            mArrayList.add(seekValue + " * " +  i +
                    " = " + res);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, mArrayList);
        mListView.setAdapter(arrayAdapter);
    }
}
