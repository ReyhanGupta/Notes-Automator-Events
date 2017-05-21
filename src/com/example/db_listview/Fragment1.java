package com.example.db_listview;

//import com.example.tabsnew.R;

//import com.example.tabsnew.R;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class Fragment1 extends Fragment {
	int[] imageIDs = {R.drawable.a,R.drawable.b,R.drawable.c};
	int nextImageIndex = 0;
	EditText et;
	DBS myDb;
	long Row;
	String message, note, notess;
	View v;
	ActionBar action;
	ViewPager viewpager;
	Adapter ft;ListView listss;
	
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		
//		
//		
//		
//		
//	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		
//List_MainActivity ht= new List_MainActivity();
//		
//		ht.et.setText("ef");
		
		 View v = inflater.inflate(R.layout.password, container, false);
		// Intent i=new Intent(Fragment1.this, Functional.class);

	      
	        return v;
	}



}
