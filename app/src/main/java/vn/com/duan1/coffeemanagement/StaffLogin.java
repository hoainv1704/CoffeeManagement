package vn.com.duan1.coffeemanagement;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StaffLogin extends AppCompatActivity {

    Button btnLogin1;
    EditText edtUsername1, edtPassword1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);
        edtUsername1=findViewById(R.id.edtUsername1);
        edtPassword1=findViewById(R.id.edtPassword1);
        btnLogin1=findViewById(R.id.btnLogin1);
        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtUsername1.getText().toString().equals("") || edtUsername1.getText().toString().equals(""))
                {
                    Toast.makeText(StaffLogin.this,"Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(edtUsername1.getText().toString().equals("staff") && edtPassword1.getText().toString().equals("123"))
                    {
                        Intent i=new Intent(StaffLogin.this,MainActivity.class);
                        startActivity(i);
                        Toast.makeText(StaffLogin.this,"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
