package com.example.db_listview;

//import com.example.my_list_view.List_MainActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class Functional extends Activity{
	
	
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
	//WakeLock wl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//We make the app go ullscree. defined before setContetn View
		//call();
		//wl.acquire();
		
		SharedPreferences getPref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
if (android.os.Build.VERSION.SDK_INT >= 11)

		
			
			getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.activity_list__main3);
		
		
		
		
		//to use check boxes from settings and give them funcyionality: dummy
		
		
		//dummy end
		
		//dummy for usng edit text
		
		String ert= getPref.getString("name", "User");//if nothing is filled, User will be displayed in name else ert
		//Toast.makeText(this, ert, 1000).show();
//		
//		//dummy end
//		
//		//dummy for list
		String values= getPref.getString("list", "4");
//		
		if(values.contentEquals("1"))
			Toast.makeText(this, "1", 1000);
		else if(values.contentEquals("2"))
			Toast.makeText(this, "2", 1000);
		else if(values.contentEquals("3"))
		Toast.makeText(this, "3", 1000);
		else
			Toast.makeText(this, "4", 1000);
//		
//		
//		//dummy end
//		
//		
//		
		openDB();
		populateListViewFromDB();
		//et=(EditText)findViewById(R.id.editText1);
		//et.setText("fffffffffffffffffffffff");
		registerListClickCallback();
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
			Toast.makeText(this, "false", 1000);
	}



	@Override
	protected void onDestroy() {
		super.onDestroy();	
		closeDB();
	}

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
		//Toast.makeText(this, "text", 1000);
		
		Intent i= new Intent(Functional.this, News.class);
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
		
		et=(EditText)findViewById(R.id.etEm2);
		String info=et.getText().toString();
		
		if(info.equals(" ") || info.equals("")|| info.equals("  ")|| info.equals("   "))
			
		{
			Toast.makeText(this, "No Results Found", Toast.LENGTH_LONG).show();
		}
		
		else
		{
			
			try{
		Cursor csrr= myDb.retID(info);
		
		long id=csrr.getLong(0);
		String nam= csrr.getString(1);
		String tti=csrr.getString(3);
		
		Intent iii= new Intent(Functional.this, Search.class);
		iii.putExtra("one",nam);
		startActivity(iii);
		
			}
			
			catch(CursorIndexOutOfBoundsException e)
			{
				Toast.makeText(Functional.this, "Exception: Not Found", Toast.LENGTH_LONG).show();

			}
			
			catch(IllegalStateException e)
			{
				Toast.makeText(Functional.this, "Exception: Not Found", Toast.LENGTH_LONG);
			}
		}
		
	}
	
	
	public void delNow()
	{

		AlertDialog.Builder abs= new AlertDialog.Builder(Functional.this);
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
		
		startManagingCursor(cursor);
				
		String[] fromFieldNames = new String[] 
				{DBS.KEY_NAME,DBS.KEY_FAVCOLOUR};
		int[] toViewIDs = new int[]
				{R.id.name,           R.id.note};
		
		SimpleCursorAdapter myCursorAdapter = 
				new SimpleCursorAdapter(
						this,		// Context
						R.layout.rel_identity2,	// Row layout template
						cursor,					// cursor (set of DB records to map)
						fromFieldNames,			// DB Column names
						toViewIDs				// View IDs to put information in
						);
		
		// Set the adapter for the list view 
		ListView myList = (ListView) findViewById(R.id.listView1);
		myList.setAdapter(myCursorAdapter);

		
	}
	
	public void registerListClickCallback() {
		ListView myList = (ListView) findViewById(R.id.listView1);
		myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked, 
					int position, long idInDB) {
				//Row=idInDB;
				//updateItemForId(idInDB);
				Toast.makeText(Functional.this, ""+idInDB, 1000);
				displayToastForId(idInDB);
				//Toast.makeText(List_MainActivity.this, ""+Row, 1000).show();
				Intent intent = new Intent(Functional.this, Modify.class); 
				intent.putExtra("arg", message);
				intent.putExtra("Prim", Row);							// getText() SHOULD NOT be static!!!
				intent.putExtra("nota", notess);
				startActivity(intent);
		//done at 11 11		finish();
				//Intent i=new Intent(List_MainActivity.this, Modify.class);
				//startActivity(i);
			}
		});
		
		
		
		myList.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				Toast.makeText(Functional.this, ""+arg3, 1000);
				
				return true;
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
		blow.inflate(R.menu.action, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		
		switch(item.getItemId())
		{
		
		case R.id.verti:
			Intent one= new Intent(Functional.this, Preferences.class);
			startActivity(one);
			break;
		
//		case R.id.newN:
//			
//			floats(v);
//			break;
//			
		case R.id.delete_all:
			delNow();
			
			break;
			
//		case R.id.set:
//			Intent ii= new Intent(List_MainActivity.this, Preferences.class);
//			startActivity(ii);
//			
//			break;
			
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);

		
		break;
		
			
		case R.id.aboutUs:
			Intent i= new Intent(Functional.this, About.class);
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


	
		
	}
	
	








