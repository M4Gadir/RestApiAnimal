package com.magad.restapianimal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.magad.restapianimal.fragment.Berita;
import com.magad.restapianimal.fragment.Home;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    FragmentManager fm ;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fm = getSupportFragmentManager();

            switch (item.getItemId()) {
                case R.id.Home:
                    fm.beginTransaction().replace(R.id.Container, new Berita()).addToBackStack("").commit();
                    return true;
                case R.id.berita:
                    fm.beginTransaction().replace(R.id.Container, new Home()).addToBackStack("").commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.Container, new Berita() ).addToBackStack("").commit();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
