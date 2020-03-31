package vn.com.duan1.coffeemanagement.Staff_item;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import vn.com.duan1.coffeemanagement.R;

public class StaffFragment extends Fragment {
    RecyclerView rvStaff;
    FloatingActionButton fl;


    public StaffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_staff, container, false);
        fl=view.findViewById(R.id.addStaff);
        rvStaff=view.findViewById(R.id.rvStaff);




        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                LayoutInflater inf=getLayoutInflater();
                View viewdialog=inf.inflate(R.layout.dialog_add_staff,null);
                builder.setView(viewdialog);



                final Spinner spAccount=viewdialog.findViewById(R.id.spAccount);
                final Spinner spLevel=viewdialog.findViewById(R.id.spLevel);
                final EditText edtName=viewdialog.findViewById(R.id.edtName);
                final EditText edtEmail=viewdialog.findViewById(R.id.edtEmail);
                final EditText edtPhoneNumber=viewdialog.findViewById(R.id.edtPhoneNumber);
                final EditText edtAddress=viewdialog.findViewById(R.id.edtAddress);

                ArrayList<String> arrayLevel = new ArrayList<String>();
                arrayLevel.add("Manager");
                arrayLevel.add("Staff");

                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item, arrayLevel);
                spLevel.setAdapter(arrayAdapter);


                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String Name=edtName.getText().toString();
                        String Email=edtEmail.getText().toString();
                        String PhoneNumber=edtPhoneNumber.getText().toString();
                        String Address=edtAddress.getText().toString();
                        capnhatgiaodien();
                        Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        return view;
    }

    public void capnhatgiaodien(){}

}
