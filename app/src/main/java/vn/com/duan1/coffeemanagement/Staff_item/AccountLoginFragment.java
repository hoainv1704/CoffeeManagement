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
import android.widget.EditText;
import android.widget.Toast;

import vn.com.duan1.coffeemanagement.R;

public class AccountLoginFragment extends Fragment {
    RecyclerView rvAccountManager;
    FloatingActionButton fl;




    public AccountLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_account_login,null);
        fl=view.findViewById(R.id.addStaffAcount);
        rvAccountManager=view.findViewById(R.id.rvAccountManager);
        capnhatgiaodien();

        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                LayoutInflater inf=getLayoutInflater();
                View viewdialog=inf.inflate(R.layout.dialog_add_account_login,null);
                builder.setView(viewdialog);


                final EditText edtAddUserName=viewdialog.findViewById(R.id.edtAddUserName);
                final EditText edtAddPassword=viewdialog.findViewById(R.id.edtAddPassword);

                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String UserName=edtAddUserName.getText().toString();
                        String Password=edtAddPassword.getText().toString();
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
