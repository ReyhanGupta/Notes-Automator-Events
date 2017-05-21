package com.example.db_listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class Frag2 extends Fragment implements View.OnClickListener {
	
	View v;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		
		//Intent ii= new Intent(Frag2.this, Automator.class);
		//startActivity(ii);
		
		
		//Intent intent = new Intent(getActivity(), Automator.class);
		//startActivity(intent);
		ImageButton ib;
		//ib=(ImageButton)findViewById(R.id.startIB);

		
		////////////////return inflater.inflate(R.layout.auto_intro, container,false);
		//return inflater.inflate(R.layout.profiles2, container,false);
		
		
		
		 View v = inflater.inflate(R.layout.auto_intro, container, false);
		 ib=(ImageButton)v.findViewById(R.id.startIB);
		 ib.setOnClickListener(this);
		/// ib.performClick();
		 return v;


	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		Intent intent = new Intent(getActivity(), Automator.class);
				startActivity(intent);
	}

	

}
