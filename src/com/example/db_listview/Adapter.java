package com.example.db_listview;
//import com.example.tabsnew.Fragment1;
///import com.example.tabsnew.Fragment2;
//import com.example.tabsnew.Fragment3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {

	public Adapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		switch (arg0) {
		case 0:
			return new Fragment1();
		case 1:
			return new Frag2();
		case 2: 
			return new Frag3();
	

		default:
			break;
		
	}return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	
	
	

}
