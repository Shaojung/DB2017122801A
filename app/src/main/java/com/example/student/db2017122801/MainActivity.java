package com.example.student.db2017122801;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        reloadData();
    }

    public void reloadData()
    {
        ArrayList<String> data1 = new ArrayList();
        File myfile = new File(getFilesDir(), "data1.txt");

        String str = "";
        try {
            FileReader fr = new FileReader(myfile);
            BufferedReader br = new BufferedReader(fr);
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str.equals(""))
        {
            data1 = new ArrayList<String>();
        }
        else
        {
            Gson gson = new Gson();
            data1 = gson.fromJson(str, new TypeToken<ArrayList<String>>() {}.getType());
        }

        ListView lv = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, data1);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add)
        {
            InputDialog dialog = new InputDialog();
            dialog.show(getFragmentManager(), "InputDialog");
        }
        return super.onOptionsItemSelected(item);
    }
}
