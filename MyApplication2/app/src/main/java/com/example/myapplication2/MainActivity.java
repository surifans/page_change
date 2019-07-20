package com.example.myapplication2;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MainActivity extends FragmentActivity implements BackHandledInterface {

    private Button btnSecond;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSecond = (Button) findViewById(R.id.btnSecond);
        btnSecond.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment first = new FirstFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.firstFragment, first, "other");
                ft.addToBackStack("tag");
                ft.commit();

                btnSecond.setVisibility(View.GONE);
            }
        });
    }
}