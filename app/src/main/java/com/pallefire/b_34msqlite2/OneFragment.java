package com.pallefire.b_34msqlite2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {
    EditText et1,et2;
    Button bt1,bt2;
    TextView tv;
    Mydatabase mydatabase;


    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //open database here in onreate ()
       mydatabase=new Mydatabase(getActivity());
        mydatabase.open();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_one, container, false);
        et1= (EditText) v.findViewById(R.id.et1);
        et2 = (EditText) v.findViewById(R.id.et2);
        bt1= (Button) v.findViewById(R.id.bt1);
        bt2= (Button) v.findViewById(R.id.bt2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here we will insert data into student table
                String name=et1.getText().toString();
                String cource=et2.getText().toString();
                mydatabase.insertStudent(name,cource); //request db for file for insertion
                et1.setText("");
                et2.setText("");
                et1.requestFocus();
                Toast.makeText(getActivity(), "Inserted a row", Toast.LENGTH_SHORT).show();

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here we will read data from student table


            }
        });
        return v;
    }

}
