package com.example.myapplication2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
public class FirstFragment extends BackHandledFragment {
    private View myView;
    private Button btnSecond;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_first, null);
        initView();
        return myView;
    }
    private void initView() {
        btnSecond = (Button) myView.findViewById(R.id.btnSecond);
        btnSecond.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment second = new SecondFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.firstFragment, second);
                ft.addToBackStack("tag");
                ft.commit();
            }
        });
    }
    @Override
    protected boolean onBackPressed() {
        return false;
    }
}