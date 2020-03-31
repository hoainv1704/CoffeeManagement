package vn.com.duan1.coffeemanagement.Bill_item;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import vn.com.duan1.coffeemanagement.R;

public class CostFragment extends Fragment {
    RecyclerView rvCost;
    FloatingActionButton flCost;


    public CostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_cost, container, false);
        flCost=view.findViewById(R.id.addCost);
        rvCost=view.findViewById(R.id.rvCost);




        flCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                LayoutInflater inf=getLayoutInflater();
                View viewdialog=inf.inflate(R.layout.dialog_add_cost,null);
                builder.setView(viewdialog);




                final EditText edtCostName=viewdialog.findViewById(R.id.edtCostName);
                final EditText edtCostPrice=viewdialog.findViewById(R.id.edtCostPrice);
                final Spinner spCostType=viewdialog.findViewById(R.id.spCostType);
                final DatePicker dPCost=viewdialog.findViewById(R.id.dpCost);

                ArrayList<String> arrayCost = new ArrayList<String>();
                arrayCost.add("Staff Salary");
                arrayCost.add("Buy Material");
                //add more cost here

                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item, arrayCost);
                spCostType.setAdapter(arrayAdapter);


                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String Name=edtCostName.getText().toString();
                        String Price=edtCostPrice.getText().toString();
                        String Type=spCostType.toString();
                        String Date=dPCost.toString();
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
