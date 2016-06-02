package com.deity.androidlib;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.deity.customview.widget.NavigationBar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    private List<android.support.v4.app.Fragment> mFragmentList;

    private List<NavigationBar> mNavigationBarList = new ArrayList<NavigationBar>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        pagerAdapter();
        initEvent();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add){
            mNavigationBarList.get(mViewPager.getCurrentItem()).addMessageNumber(1);
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mNavigationBarList.add((NavigationBar)findViewById(R.id.tab_first));
        mNavigationBarList.add((NavigationBar)findViewById(R.id.tab_second));
        mNavigationBarList.add((NavigationBar)findViewById(R.id.tab_third));
        mNavigationBarList.add((NavigationBar)findViewById(R.id.tab_fourth));

        mNavigationBarList.get(0).setAlpha(1.0f);

    }

    private void pagerAdapter() {
        mFragmentList = new ArrayList<android.support.v4.app.Fragment>();
        for (int i=0;i<4;i++){
            mFragmentList.add(new Fragment(i));
        }
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),mFragmentList);
        mViewPager.setAdapter(adapter);
    }

    private void initEvent() {
        for(int i = 0; i < mNavigationBarList.size(); i++){
            mNavigationBarList.get(i).setOnClickListener(this);
            mNavigationBarList.get(i).setTag(i);
        }
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {

        int number = (Integer) v.getTag();
        changeAlpha(number);
        mViewPager.setCurrentItem(number,false);

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffsetPixels != 0){
            mNavigationBarList.get(position).setAlpha(1 - positionOffset);
            mNavigationBarList.get(position+1).setAlpha(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void changeAlpha(int number){
        for (NavigationBar btn:mNavigationBarList){
            btn.setAlpha(0f);
        }
        mNavigationBarList.get(number).setAlpha(1.0f);
    }

}
