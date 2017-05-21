package com.example.db_listview;

//import com.example.my_list_view.List_MainActivity;

//import com.example.my_list_view.List_MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Music_Select extends Activity{
	

String titless[]= {"Meditation", "Sleep & Relaxation", "Binaural Beats"};
String desc[]={"Set your mind towards calmness with the best selection of Meditation musc.",
		"Relax your body and mind with the beautiful high quality soothing music, perfect for relaxation.",
		"A Brainwave Therapy: To help you concentrate better by stimulating special brain regions "
		};
//String titless[];
//String desc[];
int photo[]={R.drawable.spa,R.drawable.sleeping,R.drawable.binaural,R.drawable.excercise};
ListView lv;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.music_select);
		CustomAdapter adapt= new CustomAdapter(this, titless, photo, desc);

	//	Resources rS=getResources();
	//	titless=rS.getStringArray(R.array.titles);
	//	desc=rS.getStringArray(R.array.descriptions);
		
		
		
		
		
		lv= (ListView)findViewById(R.id.musicSel);
	
		lv.setAdapter(adapt);
		
		
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				String value=(String)lv.getItemAtPosition(arg2);
				Toast.makeText(Music_Select.this, "position=  "+arg2+" value:  "+value, 1000);
				switch (arg2) {
				case 0:
					
					Intent zero=new Intent(Music_Select.this, Meditation.class);
					startActivity(zero);
					
					break;

				case 1:
					
					Intent one=new Intent(Music_Select.this, Sleep.class);
					startActivity(one);
					
					break;
					
case 2:
					
					Intent two=new Intent(Music_Select.this, Binaural.class);
					startActivity(two);
					
					break;
					


				default:
					break;
				}
				
			}
		});
		
}
}

		/*lv.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			
			String value=(String)lv.getItemAtPosition(arg2);
			Toast.makeText(Music_Select.this, "position=  "+arg2+" value:  "+value, 1000).show();
			
		}
	});*/
	
	/*lv.setOnItemLongClickListener(new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				int arg2, long arg3) {
			// TODO Auto-generated method stub
			
			Toast.makeText(Music_Select.this, ""+arg2, 1000).show();
			return true;
		}
	});*/
	



