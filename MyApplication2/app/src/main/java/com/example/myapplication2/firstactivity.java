package com.example.myapplication2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lenovo on 2018/2/27.
 */

public class firstactivity extends Activity {
    private Button bt1;
    private Button bt2;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity);

        /*
           通过点击bt1实现界面之间的跳转
           1.通过startActivity的方式来实现
           1>初始Intent(意图)
         */


        bt1=(Button) findViewById(R.id.bt1__first);
        bt2=(Button)findViewById(R.id.bt2__second);
        tv=(TextView) findViewById(R.id.textView1);
        //给bt1添加点击事件
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                第一个参数:上下文对象this
                第二个参数:目标文件
                 */
                Intent intent = new Intent(firstactivity.this,Secondactivity.class);
                startActivity(intent);

            }
        });

        /*
        2.通过startActivityForResult的方式来实现
         */
        //给bt2添加点击事件
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(firstactivity.this,Secondactivity.class);

                /*
                第一个参数:Intent对象
                第二个参数:请求的一个标识
                 */
                startActivityForResult(intent,1);
            }
        });
    }

    /*
    通过startActivityForResult的方式接受返回数据的方法
    requestCode：请求的标志,给每个页面发出请求的标志不一样，这样以后通过这个标志接受不同的数据
    resultCode：这个参数是setResult(int resultCode,Intent data)方法传来的,这个方法用在传来数据的那个页面
     */
    @Override
    protected  void onActivityResult(int requestCode,int resultCode ,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1&&resultCode==2){//当请求码是1&&返回码是2进行下面操作
            String content=data.getStringExtra("data");
            tv.setText(content);
        }
    }
}