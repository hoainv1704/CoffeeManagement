package vn.com.duan1.coffeemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionLogin extends AppCompatActivity {

    Button btnAdmin, btnStaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_login);

        btnAdmin = findViewById(R.id.btnAdmin);
        btnStaff = findViewById(R.id.btnStaff);

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(OptionLogin.this, AdminLogin.class);
                startActivity(intent1);
            }
        });

        btnStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(OptionLogin.this, StaffLogin.class);
                startActivity(intent2);
            }
        });
    }
}
