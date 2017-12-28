package com.example.student.db2017122801;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by student on 2017/12/28.
 */

public class InputDialog extends DialogFragment {
    EditText ed;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = getActivity().getLayoutInflater().inflate(R.layout.myinputdialog, null);
        Button btn = view.findViewById(R.id.button);
        ed = view.findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File myfile = new File(getActivity().getFilesDir(), "myfile.txt");
                try {
                    FileWriter fw = new FileWriter(myfile, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(ed.getText().toString() + "\r\n");
                    bw.close();
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Toast.makeText(getActivity(), "Click", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
        // return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        ((MainActivity) getActivity()).reloadData();
    }
}
