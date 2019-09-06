package com.prajan.peertechz.activity;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;
import com.prajan.peertechz.R;
import com.prajan.peertechz.fragments.Articles;
import com.prajan.peertechz.fragments.Editors;
import com.prajan.peertechz.fragments.Journals;
import com.prajan.peertechz.fragments.Notifications;
import com.prajan.peertechz.fragments.Reviews;
import com.prajan.peertechz.fragments.TabAdapter;

public class Dashboard extends AppCompatActivity implements Articles.OnFragmentInteractionListener,
        Journals.OnFragmentInteractionListener, Editors.OnFragmentInteractionListener, Reviews.OnFragmentInteractionListener,
        Notifications.OnFragmentInteractionListener
{
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new Articles(), "Articles");
        adapter.addFragment(new Journals(), "Journals");
        adapter.addFragment(new Editors(), "Editors");
        adapter.addFragment(new Reviews(), "Reviews");
        adapter.addFragment(new Notifications(), "Notifications");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
