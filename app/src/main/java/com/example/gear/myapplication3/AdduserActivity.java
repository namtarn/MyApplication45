package com.example.gear.myapplication3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AdduserActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_adduser);

        Intent i = this.getIntent();
        if (i.hasExtra("name")) {
            String name = i.getStringExtra("name");
            int age = i.getIntExtra("age", 0);
            int height = i.getIntExtra("height", 0);
            int weight = i.getIntExtra("weight", 0);

            String gender = i.getStringExtra("gender");

            EditText inname = (EditText)findViewById(R.id.inname);
            inname.setText(name);

            EditText inage = (EditText)findViewById(R.id.inage);
            inage.setText(Integer.toString(age));

            EditText inh = (EditText)findViewById(R.id.inh);
            inh.setText(Integer.toString(height));

            EditText inw = (EditText)findViewById(R.id.inw);
            inw.setText(Integer.toString(weight));

            RadioGroup rg= (RadioGroup)findViewById(R.id.rg);
            if (gender.equals("Male")) {
                rg.check(R.id.radioButton);
            }
            else {
                rg.check(R.id.radioButton2);
            }


            Button btAdd = (Button)findViewById(R.id.button);
            btAdd.setText("Edit Course");
        }

    }


    public void buttonClickedadduser(View v) {
        int id = v.getId();
        Intent i;

        switch(id) {

            case R.id.button:
                i = new Intent(this, AddcalActivity.class);
                startActivity(i);
                break;

        }
    }



   public void addClicked(View v) {

        EditText inname = (EditText)findViewById(R.id.inname);
        EditText inage = (EditText)findViewById(R.id.inage);
        EditText inh = (EditText)findViewById(R.id.inh);
        EditText inw= (EditText)findViewById(R.id.inw);
        RadioGroup rg = (RadioGroup)findViewById(R.id.rg);

        String sname = inname.getText().toString();
        String sage = inage.getText().toString();
        String sheight = inh.getText().toString();
        String sweight = inw.getText().toString();

        //int age =  Integer.parseInt(inage.getText().toString());
        //int height=  Integer.parseInt(inh.getText().toString());
        //int weight =  Integer.parseInt(inw.getText().toString());



        if (sname.trim().length() == 0 || sage.trim().length() == 0 || sheight.trim().length() == 0 || sweight.trim().length() == 0) {
            Toast t = Toast.makeText(this.getApplicationContext(),
                    "All information are necessary.",
                    Toast.LENGTH_SHORT);
            t.show();
        }
        else {
            Intent result = new Intent(this, AddcalActivity.class);
            result.putExtra("name", sname);
            result.putExtra("age", Integer.valueOf(sage));
            result.putExtra("height", Integer.valueOf(sheight));
            result.putExtra("weight", Integer.valueOf(sweight));

            int rID = rg.getCheckedRadioButtonId();
            String gender = ((RadioButton)findViewById(rID)).getText().toString();
            result.putExtra("gender", gender);

            this.setResult(RESULT_OK, result);
            this.finish();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_user, menu);
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
