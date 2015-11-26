package com.example.ljgsonx.firstapp;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private List<View> mViews = new ArrayList<>();
    //TAB
    private LinearLayout mTabHome;
    private LinearLayout mTabUser;
    private LinearLayout mTabContact;
    private LinearLayout mTabSearch;

    private ImageButton mHomeImg;
    private ImageButton mUserImg;
    private ImageButton mContactImg;
    private ImageButton mSearchImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        getWindow().setContentView(getLayoutInflater().inflate(R.layout.activity_main, null));
        initView();
        initEvent();


    }

    private void initEvent() {
        mTabHome.setOnClickListener(this);
        mTabSearch.setOnClickListener(this);
        mTabUser.setOnClickListener(this);
        mTabContact.setOnClickListener(this);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                (new Thread(){
                    @Override
                    public void run() {
                        super.run();
                    }
                }).start();

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem=mViewPager.getCurrentItem();
                resetImg();
                switch(currentItem){
                    case 0:
                        mHomeImg.setImageResource(R.drawable.home_pressed);
                        break;
                    case 1:
                        mSearchImg.setImageResource(R.drawable.search_pressed);
                        break;
                    case 2:
                        mUserImg.setImageResource(R.drawable.user_pressed);
                        break;
                    case 3:
                        mContactImg.setImageResource(R.drawable.contact_pressed);
                        break;
                    default:break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mTabHome= (LinearLayout) findViewById(R.id.tab_home);
        mTabContact = (LinearLayout) findViewById(R.id.tab_contact);
        mTabUser = (LinearLayout) findViewById(R.id.tab_user);
        mTabSearch = (LinearLayout) findViewById(R.id.tab_search);

        mHomeImg = (ImageButton) findViewById(R.id.tab_home_img);
        mUserImg = (ImageButton) findViewById(R.id.tab_user_img);
        mSearchImg = (ImageButton) findViewById(R.id.tab_search_img);
        mContactImg = (ImageButton) findViewById(R.id.tab_contact_img);

        LayoutInflater mInflater = LayoutInflater.from(this);
        View tab01=mInflater.inflate(R.layout.tab01, null);
        View tab02=mInflater.inflate(R.layout.tab02,null);
        View tab03=mInflater.inflate(R.layout.tab03,null);
        View tab04=mInflater.inflate(R.layout.tab04,null);
        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);

        mAdapter=new PagerAdapter() {
            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view=mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }
        };

        mViewPager.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()){
            case R.id.tab_home:
                mViewPager.setCurrentItem(0);
                mHomeImg.setImageResource(R.drawable.home_pressed);
                break;
            case R.id.tab_search:
                mViewPager.setCurrentItem(1);
                mSearchImg.setImageResource(R.drawable.search_pressed);
                break;
            case R.id.tab_user:
                mViewPager.setCurrentItem(2);
                mUserImg.setImageResource(R.drawable.user_pressed);
                break;
            case R.id.tab_contact:
                mViewPager.setCurrentItem(3);
                mContactImg.setImageResource(R.drawable.contact_pressed);
                break;
            default:break;
        }
    }

    private void resetImg() {
        mHomeImg.setImageResource(R.drawable.home_normal);
        mSearchImg.setImageResource(R.drawable.search_normal);
        mUserImg.setImageResource(R.drawable.user_normal);
        mContactImg.setImageResource(R.drawable.contact_normal);
    }
}
