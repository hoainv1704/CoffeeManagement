package vn.com.duan1.coffeemanagement.Account_item;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.com.duan1.coffeemanagement.R;

public class AccountInforFragment extends Fragment {
    Button btnUpdateInfor, btnChangePass;


    public AccountInforFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_account_infor, container, false);
        btnUpdateInfor=view.findViewById(R.id.btnUpdateInfor);
        btnChangePass=view.findViewById(R.id.btnChangePassword);




        btnUpdateInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                LayoutInflater inf=getLayoutInflater();
                View viewdialog=inf.inflate(R.layout.dialog_update_infor,null);
                builder.setView(viewdialog);



                final EditText edtNameUpdate=viewdialog.findViewById(R.id.edtNameUpdate);
                final EditText edtEmailUpdate=viewdialog.findViewById(R.id.edtEmailUpdate);
                final EditText edtPhoneNumberUpdate=viewdialog.findViewById(R.id.edtPhoneNumberUpdate);
                final EditText edtAddressUpdate=viewdialog.findViewById(R.id.edtAddressUpdate);


                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String Name=edtNameUpdate.getText().toString();
                        String Email=edtEmailUpdate.getText().toString();
                        String PhoneNumber=edtPhoneNumberUpdate.getText().toString();
                        String Address=edtAddressUpdate.getText().toString();
                        capnhatgiaodien();
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



        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                LayoutInflater inf=getLayoutInflater();
                View viewdialog=inf.inflate(R.layout.dialog_change_password,null);
                builder.setView(viewdialog);



                final EditText edtCurrentPass=viewdialog.findViewById(R.id.edtCurrentPass);
                final EditText edtNewPass=viewdialog.findViewById(R.id.edtNewPass);


                builder.setPositiveButton("Change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String Name=edtCurrentPass.getText().toString();
                        String Email=edtNewPass.getText().toString();
                        capnhatgiaodien();
                        Toast.makeText(getActivity(), "Changed", Toast.LENGTH_SHORT).show();
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
