package com.example.baraa.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private   LineChart[] mchart = new LineChart[2];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_fragmenthome, container, false);
        mchart[0]=view.findViewById(R.id.chart1);
        mchart[1]= view.findViewById(R.id.chart2);

        for(int i=0;i<mchart.length;i++){
            LineData data =getData(36,100);
            setupChart(mchart[i],data,colors[i]);
        }
        return view;

    }//on create


    private LineData getData(int count,int range){
        ArrayList<Entry> yval = new ArrayList<>();
        for (int i=0;i<count;i++){

            float val = (float) (Math.random()*range)+3;
            yval.add(new Entry(i,val)); }

        LineDataSet set = new LineDataSet(yval,"Data set");
        set.setLineWidth(3f);
        set.setCircleRadius(5f);
        set.setCircleHoleRadius(2.5f);
        set.setColor(Color.LTGRAY);
        set.setCircleColor(Color.BLACK);
        set.setHighLightColor(Color.BLACK);
        set.setDrawValues(false);
        LineData data= new LineData(set);
        return data;
    }//get data



    private void setupChart(LineChart chart, LineData data, int c){

        ((LineDataSet)  data.getDataSetByIndex(0)).setCircleColorHole(c);

        chart.getDescription().setEnabled(false);
        chart.setDrawGridBackground(false);
        chart.setScaleEnabled(true);
        chart.setPinchZoom(false);
        chart.setBackgroundColor(c);
        chart.setViewPortOffsets(10,0,10,0);
        chart.setData(data);

    }//set up chart

    private int[]colors = new int[]{
            Color.rgb(255,255,255),Color.rgb(255,255,255)
    };}// colors