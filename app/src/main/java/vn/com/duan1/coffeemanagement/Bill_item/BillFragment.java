package vn.com.duan1.coffeemanagement.Bill_item;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.com.duan1.coffeemanagement.R;
import vn.com.duan1.coffeemanagement.Staff_item.AccountLoginFragment;
import vn.com.duan1.coffeemanagement.Staff_item.StaffFragment;
import vn.com.duan1.coffeemanagement.Staff_item.StaffManagementFragment;

public class BillFragment extends Fragment {
    ViewPager viewPagerBill;
    TabLayout tabLayoutBill;


    public BillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_bill,null);
        viewPagerBill=view.findViewById(R.id.viewpagerBill);
        tabLayoutBill=view.findViewById(R.id.tablayoutBill);

        MyFragmentAdapter adapter2 =new MyFragmentAdapter(getChildFragmentManager());
        viewPagerBill.setAdapter(adapter2);
        tabLayoutBill.addTab(tabLayoutBill.newTab().setText("History"));
        tabLayoutBill.addTab(tabLayoutBill.newTab().setText("Cost"));
        tabLayoutBill.addTab(tabLayoutBill.newTab().setText("Statistical"));

        viewPagerBill.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutBill));
        tabLayoutBill.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerBill.setCurrentItem(tabLayoutBill.getSelectedTabPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    public class MyFragmentAdapter extends FragmentStatePagerAdapter
    {

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment;
            switch (position)
            {
                case 0:
                    fragment=new BillHistoryFragment();
                    break;
                case 1:
                    fragment=new CostFragment();
                    break;
                case 2:
                    fragment=new StatisticalFragment();
                    break;
                default:
                    return null;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
