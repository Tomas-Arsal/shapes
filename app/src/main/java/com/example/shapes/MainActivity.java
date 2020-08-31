package com.example.shapes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.areas_tv_rectangle_wight)
    EditText areasTvRectangleWight;
    @BindView(R.id.areas_tv_rectangle_height)
    EditText areasTvRectangleHeight;
    @BindView(R.id.areas_tv_circle_radios)
    EditText areasTvCircleRadios;
    @BindView(R.id.areas_tv_trangle_base)
    EditText areasTvTrangleBase;
    @BindView(R.id.areas_tv_trangle_height)
    EditText areasTvTrangleHeight;
    @BindView(R.id.areas_bt_calculate)
    Button areasBtCalculate;
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // circle -> pi * r * r        2
        //Rectangle -> W * H        1
        // Trangle -> 0.5 * base *  h      3
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                {
                    switch (i) {
                        //Rectangle
                        case 1:
                            areasTvRectangleHeight.setVisibility(View.VISIBLE);
                            areasTvRectangleWight.setVisibility(View.VISIBLE);
                            areasTvCircleRadios.setVisibility(View.GONE);
                            areasTvTrangleBase.setVisibility(View.GONE);
                            areasTvTrangleHeight.setVisibility(View.GONE);
                            break;
                        // circle
                        case 2:
                            areasTvRectangleHeight.setVisibility(View.GONE);
                            areasTvRectangleWight.setVisibility(View.GONE);
                            areasTvCircleRadios.setVisibility(View.VISIBLE);
                            areasTvTrangleBase.setVisibility(View.GONE);
                            areasTvTrangleHeight.setVisibility(View.GONE);
                            break;
                        // Trangle
                        case 3:
                            areasTvRectangleHeight.setVisibility(View.GONE);
                            areasTvRectangleWight.setVisibility(View.GONE);
                            areasTvCircleRadios.setVisibility(View.GONE);
                            areasTvTrangleBase.setVisibility(View.VISIBLE);
                            areasTvTrangleHeight.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        areasBtCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int indix = spinner.getSelectedItemPosition();
                double area = 0;
                switch (indix) {
                    case 1:
                        //for rectangle
                        double rectang_height = Double.parseDouble(areasTvRectangleHeight.getText().toString());
                        double rectang_weight = Double.parseDouble(areasTvRectangleWight.getText().toString());
                        area = rectang_height * rectang_weight;
                        break;
                    case 2:
                        //for circale
                        double circle_radius = Double.parseDouble(areasTvCircleRadios.getText().toString());
                        area = Math.PI * Math.pow(circle_radius, 2);
                        break;
                    case 3:
                        //for Trangle
                        double Trangle_height = Double.parseDouble(areasTvTrangleBase.getText().toString());
                        double Trangle_base = Double.parseDouble(areasTvTrangleHeight.getText().toString());
                        area = 0.5 * Trangle_height * Trangle_base;
                        break;
                }
                textView.setText(area + "");
            }
        });
    }
}