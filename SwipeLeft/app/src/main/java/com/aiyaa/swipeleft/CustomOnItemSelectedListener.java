package com.aiyaa.swipeleft;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        parent.setSelection(pos);
        View v = parent.getSelectedView();
        ((TextView)v).setTextColor(view.getResources().getColor(R.color.colorPrimaryDark));
        ((TextView)v).setTextSize(25);

//        Toast.makeText(parent.getContext(),
//                parent.getItemAtPosition(pos).toString() + " plan selected",
//                Toast.LENGTH_SHORT).show();
        MainActivity.selectedPlan = pos;


    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {


    }

}