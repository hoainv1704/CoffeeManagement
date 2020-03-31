package vn.com.duan1.coffeemanagement.Staff_item;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.com.duan1.coffeemanagement.R;

public class StaffManagementFragment extends Fragment {
    ViewPager viewPagerStaff;
    TabLayout tabLayoutStaff;


    public StaffManagementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_staff_management,null);
        viewPagerStaff=view.findViewById(R.id.viewpagerStaff);
        tabLayoutStaff=view.findViewById(R.id.tablayoutStaff);

        MyFragmentAdapter adapter=new MyFragmentAdapter(getChildFragmentManager());
        viewPagerStaff.setAdapter(adapter);
        tabLayoutStaff.addTab(tabLayoutStaff.newTab().setText("Login Manager"));
        tabLayoutStaff.addTab(tabLayoutStaff.newTab().setText("Staff Manager"));

        viewPagerStaff.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutStaff));
        tabLayoutStaff.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerStaff.setCurrentItem(tabLayoutStaff.getSelectedTabPosition());

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
                    fragment=new AccountLoginFragment();
                    break;
                case 1:
                    fragment=new StaffFragment();
                    break;
                default:
                    return null;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
