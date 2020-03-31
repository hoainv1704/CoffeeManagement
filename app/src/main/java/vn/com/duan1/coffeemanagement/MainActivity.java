package vn.com.duan1.coffeemanagement;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import vn.com.duan1.coffeemanagement.Account_item.AccountInforFragment;
import vn.com.duan1.coffeemanagement.Bill_item.BillFragment;
import vn.com.duan1.coffeemanagement.Menu_item.MenuFragment;
import vn.com.duan1.coffeemanagement.Staff_item.StaffManagementFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bnv);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl,
                    new StaffManagementFragment()).commit();

            bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if (item.getItemId() == R.id.staff)
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl,
                                new StaffManagementFragment()).commit();
                    if (item.getItemId() == R.id.menu)
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl,
                                new MenuFragment()).commit();
                    if (item.getItemId() == R.id.bill)
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl,
                                new BillFragment()).commit();
                    if (item.getItemId() == R.id.account)
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl,
                                new AccountInforFragment()).commit();
                    return true;
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_in,R.anim.back_out);
    }


}



