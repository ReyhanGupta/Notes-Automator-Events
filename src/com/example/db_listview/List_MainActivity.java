package com.example.db_listview;

import java.util.List;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

//import com.example.tabsnew.FragmentPageAdapter;
//import com.example.tabsnew.R;

//import com.example.tabsnew.FragmentPageAdapter;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.preference.PreferenceManager;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.app.ActionBar.Tab;
import android.app.ActionBar;
import android.widget.ListView;
import android.widget.Toast;
import android.app.FragmentTransaction;
public class List_MainActivity extends FragmentActivity implements TabListener{
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
	String ert="user";
	ImageButton ib;
	//WakeLock wl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//We make the app go ullscree. defined before setContetn View
		//call();
		//wl.acquire();
		
		SharedPreferences getPref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	//	ib=(ImageButton)findViewById(R.id.startIB);
		setContentView(R.layout.main);
		
		
		
		
		//ib.performClick();
		
		
		
		
		
		
		
		
		
		
		
		viewpager= (ViewPager) findViewById(R.id.pager);
		ft=new Adapter(getSupportFragmentManager());
		action=getActionBar();
		viewpager.setAdapter(ft);
		action.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		action.addTab(action.newTab().setText("Notes").setTabListener(this));
		action.addTab(action.newTab().setText("Automator").setTabListener(this));
		action.addTab(action.newTab().setText("Events").setTabListener(this));
viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				action.setSelectedNavigationItem(arg0);
				
			}
//			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//to use check boxes from settings and give them funcyionality: dummy
		
		
		//dummy end
		
		//dummy for usng edit text
		
		//String ert= getPref.getString("name", "User");//if nothing is filled, User will be displayed in name else ert
	//	Toast.makeText(this, ert, 1000).show();
//		
//		//dummy end
//		
//		//dummy for list
//		String values= getPref.getString("list", "4");
////		
//		if(values.contentEquals("1"))
//			Toast.makeText(this, "1", 1000).show();
//		else if(values.contentEquals("2"))
//			Toast.makeText(this, "2", 1000).show();
//		else if(values.contentEquals("3"))
//		Toast.makeText(this, "3", 1000).show();
//		else
//			Toast.makeText(this, "4", 1000).show();
////		
//		
//		//dummy end
//		
//		
//		
		
	//Intent i= new Intent(List_MainActivity.this, Functional.class);
	//	startActivity(i);
		//openDB();
		//populateListViewFromDB();
		//et=(EditText)findViewById(R.id.editText1);
		//et.setText("fffffffffffffffffffffff");
		//registerListClickCallback();
	}
	
	
	
	private void call() {
		// TODO Auto-generated method stub
		
		//setting up a wakelock first
		
		//PowerManager pm= (PowerManager)getSystemService(Context.POWER_SERVICE);
		//WakeLock wl= pm.newWakeLock(PowerManager.FULL_WAKE_LOCK,"" );
		
		//DOne with wake lock. Starting with full screen now
		SharedPreferences getPref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music=getPref.getBoolean("check", false); //if nothing has been set yet, set default value as true
		if(music==true)
			{requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
			}
		else
		{
			
		}
			//Toast.makeText(this, "false", 1000).show();
	}



	//@Override
	//protected void onDestroy() {
	//	super.onDestroy();	
		//closeDB();
	//}

	public void openDB() {
		myDb = new DBS(this);
		myDb.open();
	}
	private void closeDB() {
		myDb.close();
	}

	/* 
	 * UI Button Callbacks
	 */
	
	
	
	
	
	
	
	public void start (View v)
	{
		Intent ii= new Intent(List_MainActivity.this, Automator.class);
		//startActivity(ii);
	}
	
	public void go(View v)
	{
		EditText et= (EditText)findViewById(R.id.pass);
		String pass= et.getText().toString();
		SharedPreferences getPref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String ert= getPref.getString("name", "user");//if nothing is filled, User will be displayed in name else ert
			//Toast.makeText(this, ert, 1000).show();
//			
		
		if(ert.equals("")|| ert.equals(" "))
		{
			ert= "user";
		}
		
		
		if(ert.contentEquals(pass))
		{
			et.setText("");
		Intent i= new Intent(List_MainActivity.this, Functional.class);
		startActivity(i);
		}
		else
		{
			Toast.makeText(this, "Incorrect Password", 10000).show();
		}
	}
	
	public void enterBT(View v)
	{
		
		/*EditText ett= (EditText)findViewById(R.id.enterET);
		String pass= ett.getText().toString();
		SharedPreferences getPref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String ert= getPref.getString("name", "user");//if nothing is filled, User will be displayed in name else ert
			Toast.makeText(this, ert, 1000).show();
//			
		
		if(ert.equals("")|| ert.equals(" "))
		{
			ert= "user";
		}
		
		
		if(ert.contentEquals(pass))
		{
			ett.setText("");*/
		Intent i= new Intent(List_MainActivity.this, TimerTasks.class);
		startActivity(i);
		/*}
		else
		{
			Toast.makeText(this, "Incorrect Password", 10000).show();
		}
		*/
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void onClick_AddRecord(View v) {
		int imageId = imageIDs[nextImageIndex];
		nextImageIndex = (nextImageIndex + 1) % imageIDs.length;
		et=(EditText)findViewById(R.id.etEm2);
		String info=et.getText().toString();
		//Toast.makeText(this, info, Toast.LENGTH_LONG).show();
		// Add it to the DB and re-draw the ListView
		
		if(info.equals(" ") || info.equals("")|| info.equals("  ")|| info.equals("   "))
		
		{
			Toast.makeText(this, "Please enter text to save", Toast.LENGTH_LONG).show();
		}
		else
		{
		myDb.insertRow(info, imageId, "Green");
		populateListViewFromDB();
		et.setText("");
		}
	}

	public void floats(View v)
	{
//		int imageId = imageIDs[nextImageIndex];
//		nextImageIndex = (nextImageIndex + 1) % imageIDs.length;
//		et=(EditText)findViewById(R.id.editText1);
//		String info=et.getText().toString();
//		//Toast.makeText(this, info, Toast.LENGTH_LONG).show();
//		// Add it to the DB and re-draw the ListView
//		
//		if(info.equals(" ") || info.equals("")|| info.equals("  ")|| info.equals("   "))
//		
//		{
//			Toast.makeText(this, "Please enter text to save", Toast.LENGTH_LONG).show();
//		}
//		else
//		{
//		myDb.insertRow(info, imageId, "Green");
//		populateListViewFromDB();
//		et.setText("");
//		}
		//Toast.makeText(this, "text", 1000).show();
		
		Intent i= new Intent(List_MainActivity.this, Functional.class);
		startActivity(i);
	}
	public void done(View v)
	{
		
		//registerListClickCallback() ;
		Toast.makeText(this, "Dysfunctional Right Now"+Row, 1000).show();
		myDb.open();
		myDb.deleteRow(Row);
		populateListViewFromDB();
		
		
		}
	public void onClick_ClearAll(View v) {
//		
		et=(EditText)findViewById(R.id.etEm2);
		String info=et.getText().toString();
		Cursor csrr= myDb.retID(info);
		
		long id=csrr.getLong(0);
		String nam= csrr.getString(1);
		String tti=csrr.getString(3);
		//Toast.makeText(this, "helllllo"+nam+tti, 1000).show();
		
		Intent iii= new Intent(List_MainActivity.this, Search.class);
		iii.putExtra("one",nam);
		//iii.putExtra("two", tti);
	//	iii.putExtra("three", id);
		startActivity(iii);
//		
//		AlertDialog.Builder abs= new AlertDialog.Builder(List_MainActivity.this);
//		abs.setMessage("Delete All Tasks?").setCancelable(false)
//		.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//			
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				// TODO Auto-generated method stub
//				myDb.deleteAll();
//		populateListViewFromDB();
//			}
//		})
//		.setNegativeButton("No", new DialogInterface.OnClickListener() {
//			
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				// TODO Auto-generated method stub
//				dialog.cancel();
//			}
//		});
//		AlertDialog alert= abs.create();
//		alert.setTitle("Confirm Delete?");
//		alert.show();
		
		
	}
	
	
	public void delNow()
	{

		AlertDialog.Builder abs= new AlertDialog.Builder(List_MainActivity.this);
		abs.setMessage("Delete All Tasks?").setCancelable(false)
		.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				myDb.deleteAll();
		populateListViewFromDB();
			}
		})
		.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		AlertDialog alert= abs.create();
		alert.setTitle("Confirm Delete?");
		alert.show();
	}


	public void populateListViewFromDB() {
		Cursor cursor = myDb.getAllRows();
		
		// Allow activity to manage lifetime of the cursor.
		// DEPRECATED! Runs on the UI thread, OK for small/short queries.
		startManagingCursor(cursor);
		
		// Setup mapping from cursor to view fields:
		
		
		
		
		String[] fromFieldNames = new String[] 
				{DBS.KEY_NAME,DBS.KEY_FAVCOLOUR};
		int[] toViewIDs = new int[]
				{R.id.name,           R.id.note};
		
		// ++++++Start
		
		// Create adapter to may columns of the DB onto elemesnt in the UI.
		SimpleCursorAdapter myCursorAdapter = 
				new SimpleCursorAdapter(
						this,		// Context
						R.layout.rel_identity,	// Row layout template
						cursor,					// cursor (set of DB records to map)
						fromFieldNames,			// DB Column names
						toViewIDs				// View IDs to put information in
						);
//		
//		// Set the adapter for the list view 
		ListView myList = (ListView) findViewById(R.id.listView1);
		//Toast.makeText(this, ""+myCursorAdapter.toString(), 100000).show();
		myList.setAdapter(myCursorAdapter);
		
		
		// +++++++End
	
//		String name[]={"1","2"};
//		listss=(ListView)findViewById(R.id.listView1);
//		ArrayAdapter<String> data= new ArrayAdapter<String>(this, R.layout.rel_identity, name);
//		listss.setAdapter(data);
	
		
		
		
		
	}
	
	public void registerListClickCallback() {
		ListView myList = (ListView) findViewById(R.id.listView1);
		myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked, 
					int position, long idInDB) {
				//Row=idInDB;
				//updateItemForId(idInDB);
				
				displayToastForId(idInDB);
				//Toast.makeText(List_MainActivity.this, ""+Row, 1000).show();
				Intent intent = new Intent(List_MainActivity.this, Modify.class); 
				intent.putExtra("arg", message);
				intent.putExtra("Prim", Row);							// getText() SHOULD NOT be static!!!
				intent.putExtra("nota", notess);
				startActivity(intent);
		//done at 11 11		finish();
				//Intent i=new Intent(List_MainActivity.this, Modify.class);
				//startActivity(i);
			}
		});
	}
	
	public void updateItemForId(long idInDB) {
		Cursor cursor = myDb.getRow(idInDB);
		if (cursor.moveToFirst()) {
			long idDB = cursor.getLong(DBS.COL_ROWID);
			String name = cursor.getString(DBS.COL_NAME);
			int studentNum = cursor.getInt(DBS.COL_STUDENTNUM);
			String favColour = cursor.getString(DBS.COL_FAVCOLOUR);

			favColour += "!";
			myDb.updateRow(idInDB, name, studentNum, favColour);
		}
		cursor.close();
		populateListViewFromDB();		
	}
	
	public void displayToastForId(long idInDB) {
		Cursor cursor = myDb.getRow(idInDB);
		if (cursor.moveToFirst()) {
			long idDB = cursor.getLong(DBS.COL_ROWID);
			String name = cursor.getString(DBS.COL_NAME);
			int studentNum = cursor.getInt(DBS.COL_STUDENTNUM);
			String fac = cursor.getString(DBS.COL_FAVCOLOUR);
			
			message=name;
			
			String message = "ID: " + idDB + "\n" 
					+ "Name: " + name + "\n"
					+ "Std#: " + studentNum + "\n"
					+ "FavColour: " + fac;
			//Toast.makeText(List_MainActivity.this, message, Toast.LENGTH_LONG).show();
			Row=idDB;
			notess=fac;
			//message=name;
		}
		cursor.close();
	}
	public long send(long idDB) {
		// TODO Auto-generated method stub
		return idDB;
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		MenuInflater blow= getMenuInflater();
		blow.inflate(R.menu.menu_main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		
		switch(item.getItemId())
		{
		
		case R.id.power:
			finish();
			break;
		
//		case R.id.newN:
//			
//			floats(v);
//			break;
//			
		//case R.id.delete_all:
		//	delNow();
		//	
		//	break;
			
//		case R.id.set:
//			Intent ii= new Intent(List_MainActivity.this, Preferences.class);
//			startActivity(ii);
//			
//			break;
			
		case R.id.aboutUs:
			Intent i= new Intent(List_MainActivity.this, About.class);
			startActivity(i);
			break;
			
//		case R.id.exit:
//			finish();
//			break;
			
		}
		return false;
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//can be used to leave wakelock wl.release();
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

//
//
//	@Override
//	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//	@Override
//	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//	@Override
//	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
//		// TODO Auto-generated method stub
//		
//	}
//


	//@Override
//	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		//
		//Toast.makeText(this, "long click", 1000).show();
		
		//return false;
	//}


//
//	@Override
//	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//	@Override
//	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
//		// TODO Auto-generated method stub
//		viewpager.setCurrentItem(arg0.getPosition());
//	}
//
//
//
//	@Override
//	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
//		// TODO Auto-generated method stub
//		
//	}
//	
	
		
	}
	
	












	


