package com.deity.androidlib;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.deity.customview.widget.NavigationBar;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivityBack extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private List<Fragment> mFragmentList;
    private List<NavigationBar> NavigationBarList = new ArrayList<NavigationBar>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        pagerAdapter();
        initEvent();
    }

    public void changeAlpha(int number) {
        for (NavigationBar btn : NavigationBarList) {
            btn.setAlpha(0f);
        }
        NavigationBarList.get(number).setAlpha(1.0f);
    }


    public void getScreenShot(View v) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
        String fname = "/sdcard/" + sdf.format(new Date()) + ".png";
        View view = v.getRootView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        if (bitmap != null) {
            System.out.println("bitmap got !");
            try {
                FileOutputStream out = new FileOutputStream(fname);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                System.out.println("file" + fname + "output done.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("bitmap is NULL !");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            NavigationBarList.get(mViewPager.getCurrentItem()).addMessageNumber(1);
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        NavigationBarList.add((NavigationBar) findViewById(R.id.tab_first));
        NavigationBarList.add((NavigationBar) findViewById(R.id.tab_second));
        NavigationBarList.add((NavigationBar) findViewById(R.id.tab_third));
        NavigationBarList.add((NavigationBar) findViewById(R.id.tab_fourth));
        NavigationBarList.get(0).setAlpha(1.0f);
    }

    private void pagerAdapter() {
        mFragmentList = new ArrayList<android.support.v4.app.Fragment>();
        for (int i=0;i<4;i++){
            mFragmentList.add(new Fragment());
        }
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),mFragmentList);
        mViewPager.setAdapter(adapter);
    }

    private void initEvent() {
        for (int i = 0; i < NavigationBarList.size(); i++) {
            NavigationBarList.get(i).setOnClickListener(this);
            NavigationBarList.get(i).setTag(i);
        }
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        int number = (Integer) v.getTag();
        changeAlpha(number);
        mViewPager.setCurrentItem(number, false);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffsetPixels != 0) {
            NavigationBarList.get(position).setAlpha(1 - positionOffset);
            NavigationBarList.get(position + 1).setAlpha(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
