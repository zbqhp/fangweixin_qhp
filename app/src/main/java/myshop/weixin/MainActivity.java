package myshop.weixin;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mviewPager;
    private TextView  chat,con,me;

    private FragmentPagerAdapter adpter;
    private List<Fragment>  datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mviewPager= (ViewPager) findViewById(R.id.viewpage);
        chat= (TextView) findViewById(R.id.tv_chat);
        con= (TextView) findViewById(R.id.tv_con);
        me= (TextView) findViewById(R.id.tv_me);

        //为viewpager添加数据
        datas =new ArrayList<Fragment>();
        //初始化三个Fragment
        ChatMainActvity top_1=new ChatMainActvity();
        ConMainActvity top_2=new ConMainActvity();
        MeMainActvity top_3=new MeMainActvity();

        //开始添加数据
        datas.add(top_1);
        datas.add(top_2);
        datas.add(top_3);

        //初始化适配器
        adpter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return datas.get(position);
            }


            @Override
            public int getCount() {
                return datas.size();
            }
        };

        mviewPager.setAdapter(adpter);
        //给Viewpager添加滑动事件
        mviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            //初始化
            @Override
            public void onPageSelected(int position) {

                resetTextView();
                switch (position){
                    case 0:
                        chat.setTextColor(Color.GREEN);
                        break;
                    case 1:
                        con.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        me.setTextColor(Color.GREEN);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    //滑动改变字体
       private void resetTextView() {
           chat.setTextColor(Color.BLACK);
           con.setTextColor(Color.BLACK);
           me.setTextColor(Color.BLACK);
    }
}
