package com.example.gear.myapplication3;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    CourseDBHelper helper;
    SimpleCursorAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new CourseDBHelper(this.getApplicationContext());
    }

    public void buttonClickedMain(View v) {
        int id = v.getId();
        Intent i;

        switch(id) {
            case R.id.button4:
                i = new Intent(this, ListuserActivity.class);
                startActivityForResult(i, 88);
                break;

            case R.id.button:
                i = new Intent(this, AdduserActivity.class);
                startActivity(i);
                break;

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 88) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                int age = data.getIntExtra("age", 0);
                int height = data.getIntExtra("height", 0);
                int weight = data.getIntExtra("weight", 0);
                String gender = data.getStringExtra("gender");

                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues r = new ContentValues();
                r.put("name", name);
                r.put("age", age);
                r.put("height", height);
                r.put("weight", weight);
                r.put("gender", gender);
                r.put("value", genderToValue(gender));
                long newId = db.insert("calculate", null, r);

                if (newId != -1) {
                    Toast t = Toast.makeText(this.getApplicationContext(),
                            "Successfully added a new grade",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
                else {
                    Toast t = Toast.makeText(this.getApplicationContext(),
                            "Unable to add a new grade",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        }

        Log.d("calculate", "onActivityResult");
    }

    static double genderToValue(String g) {
        if (g.equals("Male"))
            return 66;
        else
            return 665;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
