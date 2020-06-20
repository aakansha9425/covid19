package com.example.covid_19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.covid_19.Fragment.DashboardFragment;
import com.example.covid_19.Fragment.StateFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Covid19Activity extends AppCompatActivity implements  BottomNavigationView.OnNavigationItemSelectedListener{
private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.covid19_dashboard);

        loadFragment(new DashboardFragment());
        initView();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void initView() {
        bottomNavigationView=findViewById(R.id.bottomNavigation);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        Activity activity=null;

        switch (item.getItemId()) {
            case R.id.dashboard:
                fragment = new DashboardFragment();
                break;

            case R.id.state:

                fragment = new StateFragment();
                break;

        }
        return loadFragment(fragment);
    }

    public void talk_to_us(View view) {

    }
}
