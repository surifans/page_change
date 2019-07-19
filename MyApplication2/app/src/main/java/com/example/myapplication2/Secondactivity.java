package com.example.myapplication2;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by lenovo on 2018/2/27.
 */

public class Secondactivity extends Activity {
    private Button bt;
    String content="你好";//想返回的内容
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity);

        /*
        第二个页面什么时候给第一个页面回传数据
        回传到第一个页面的实际上是一个Intent对象
         */
        bt=(Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                //name相当于一个key,content是返回的内容
                data.putExtra("data",content);
                //resultCode是返回码,用来确定是哪个页面传来的数据，这里设置返回码是2
                //这个页面传来数据,要用到下面这个方法setResult(int resultCode,Intent data)
                setResult(2,data);
                //结束当前页面
                finish();
            }
        });
    }
}