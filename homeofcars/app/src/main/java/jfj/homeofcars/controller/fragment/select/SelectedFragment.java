package jfj.homeofcars.controller.fragment.select;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import jfj.homeofcars.R;
import jfj.homeofcars.controller.activity.SearchActivity;
import jfj.homeofcars.controller.adapter.viewpager.SelectFraViewpagerAdapter;
import jfj.homeofcars.controller.base.AbsBaseFragment;


/**
 * 一级界面:选车
 */
public class SelectedFragment extends AbsBaseFragment implements OnClickListener {

    private List<Fragment> mFragments;
    private List<String> mTitles;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private SelectFraViewpagerAdapter mAdapter;
    private ImageView searchImg;

    public static SelectedFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SelectedFragment fragment = new SelectedFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fra_select;
    }

    @Override
    protected void initView() {
        mFragments=new ArrayList<>();
        mTitles=new ArrayList<>();
        mTabLayout=bindView(R.id.fra_select_tablayout);
        mViewPager=bindView(R.id.fra_select_viewpager);
        mAdapter=new SelectFraViewpagerAdapter(getChildFragmentManager(),mContext);
        searchImg=bindView(R.id.fra_select_search_img);
    }

    @Override
    protected void initDatas() {
        mFragments.add(new SelectNewCarFragment().newInstance());
        mFragments.add(new SeletSecondFragment().newInstance());
        mTitles.add("新车");
        mTitles.add("二手车");
        mAdapter.setFragments(mFragments);
        mAdapter.setTitles(mTitles);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        searchImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fra_select_search_img:
                goTo(mContext, SearchActivity.class);
                break;
        }
    }
}
