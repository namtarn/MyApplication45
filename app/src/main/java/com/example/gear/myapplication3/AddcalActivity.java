package com.example.gear.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;


public class AddcalActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cal);
    }





    public void addClicked1(View v) {

        RadioGroup rg = (RadioGroup)findViewById(R.id.cal);
        int cals = rg.getCheckedRadioButtonId();


        //int age =  Integer.parseInt(inage.getText().toString());
        //int height=  Integer.parseInt(inh.getText().toString());
        //int weight =  Integer.parseInt(inw.getText().toString());
        Intent result = new Intent();

        double x =0.0;
        switch (cals) {

            case R.id.radioButton3:
                x =1.2;
                break;
            case R.id.radioButton4:
                x =1.375;
                break;
            case R.id.radioButton5:
                x =1.55;
                break;
            case R.id.radioButton6:
                x =1.7;
                break;
            case R.id.radioButton7:
                x =1.9;
                break;
        }
        result.putExtra("todo",x);
        this.setResult(RESULT_OK, result);
        this.finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_cal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
