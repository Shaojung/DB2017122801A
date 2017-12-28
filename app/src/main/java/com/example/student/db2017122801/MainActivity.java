package com.example.student.db2017122801;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        ArrayList<String> mylist = new ArrayList();
        File myfile = new File(getFilesDir(), "myfile.txt");
        try {
            FileReader fr = new FileReader(myfile);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null)
            {
                mylist.add(str);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ListView lv = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
            android.R.layout.simple_list_item_1, mylist);
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
