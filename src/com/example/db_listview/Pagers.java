package com.example.db_listview;

//import com.example.tabsnew.FragmentPageAdapter;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class Pagers extends FragmentActivity implements ActionBar.TabListener{
	ActionBar action;Adapter ft;
	ViewPager viewpager;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);	
		setContentView(R.layout.main);
		viewpager= (ViewPager) findViewById(R.id.pager);
		ft=new Adapter(getSupportFragmentManager());
		action=getActionBar();
		viewpager.setAdapter(ft);
		action.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		action.addTab(action.newTab().setText("One").setTabListener(this));
		action.addTab(action.newTab().setText("Two").setTabListener(this));
		action.addTab(action.newTab().setText("Three").setTabListener(this));
viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				action.setSelectedNavigationItem(arg0);
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		viewpager.setCurrentItem(arg0.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

}
