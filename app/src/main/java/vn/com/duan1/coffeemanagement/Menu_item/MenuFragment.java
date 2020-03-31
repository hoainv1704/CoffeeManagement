package vn.com.duan1.coffeemanagement.Menu_item;

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

public class MenuFragment extends Fragment {

    ViewPager viewPagerMenu;
    TabLayout tabLayoutMenu;


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_menu,null);
        viewPagerMenu=view.findViewById(R.id.viewpagerMenu);
        tabLayoutMenu=view.findViewById(R.id.tablayoutMenu);

        MyFragmentAdapter adapter1 = new MyFragmentAdapter(getChildFragmentManager());
        viewPagerMenu.setAdapter(adapter1);
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setText("Coffee"));
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setText("Juice"));
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setText("MilkTea"));
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setText("Food"));
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setText("Others"));

        viewPagerMenu.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutMenu));
        tabLayoutMenu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerMenu.setCurrentItem(tabLayoutMenu.getSelectedTabPosition());

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
                    fragment=new CoffeeFragment();
                    break;
                case 1:
                    fragment=new JuiceFragment();
                    break;
                case 2:
                    fragment=new MilkTeaFragment();
                    break;
                case 3:
                    fragment=new FoodFragment();
                    break;
                case 4:
                    fragment=new OthersFragment();
                    break;
                default:
                    return null;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
