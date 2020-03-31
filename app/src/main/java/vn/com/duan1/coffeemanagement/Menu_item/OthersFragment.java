package vn.com.duan1.coffeemanagement.Menu_item;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import vn.com.duan1.coffeemanagement.R;

public class OthersFragment extends Fragment {
    RecyclerView rvCoffee;
    FloatingActionButton flAddOthers, flCart;


    public OthersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_coffee, container, false);
        flAddOthers=view.findViewById(R.id.addOthers);
        flCart=view.findViewById(R.id.cart);
        rvCoffee=view.findViewById(R.id.rvOthers);




        flAddOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                LayoutInflater inf=getLayoutInflater();
                View viewdialog=inf.inflate(R.layout.dialog_add_menu,null);
                builder.setView(viewdialog);



                final ImageView ivPhoto=viewdialog.findViewById(R.id.ivPhoto);
                final EditText edtItemName=viewdialog.findViewById(R.id.edtItemName);
                final EditText edtItemPrice=viewdialog.findViewById(R.id.edtItemPrice);
                final EditText edtItemDescribe=viewdialog.findViewById(R.id.edtItemDescribe);


                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //image input here
                        String Name=edtItemName.getText().toString();
                        String Price=edtItemPrice.getText().toString();
                        String Describe=edtItemDescribe.getText().toString();
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

        flCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                LayoutInflater inf=getLayoutInflater();
                View viewdialog=inf.inflate(R.layout.dialog_cart,null);
                builder.setView(viewdialog);


                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //do something here

                        Toast.makeText(getActivity(), "Updated", Toast.LENGTH_SHORT).show();
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
