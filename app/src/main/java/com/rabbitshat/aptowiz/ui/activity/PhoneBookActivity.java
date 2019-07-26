package com.rabbitshat.aptowiz.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.rabbitshat.aptowiz.R;
import com.rabbitshat.aptowiz.ui.adapter.ViewPagerAdapter;
import com.rabbitshat.aptowiz.ui.fragment.PhoneBookAdminFragment;
import com.rabbitshat.aptowiz.ui.fragment.PhoneBookResidentesFragment;
import com.rabbitshat.aptowiz.ui.fragment.PhoneBookStaffFragment;

public class PhoneBookActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_book);

        viewPager = (ViewPager) findViewById(R.id.phoneBook_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.phoneBook_tabs);
        setupViewPager(viewPager);
        if (savedInstanceState != null) {
            viewPager.setCurrentItem(savedInstanceState.getInt("item"));
        }
        tabLayout.setupWithViewPager(viewPager);
        setupTabs();
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFrag(new PhoneBookAdminFragment(), "One");
        adapter.addFrag(new PhoneBookResidentesFragment(), "TWO");
        adapter.addFrag(new PhoneBookStaffFragment(), "Three");

        viewPager.setAdapter(adapter);
    }
    private void setupTabs() {


        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Admin");
        tabLayout.getTabAt(0).setCustomView(tabOne);


        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Residents");
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Staff");
        tabLayout.getTabAt(2).setCustomView(tabThree);

    }
}
