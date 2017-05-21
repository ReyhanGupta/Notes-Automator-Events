package com.example.db_listview;

//import com.example.database.Message;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DB_Helper extends SQLiteOpenHelper{
	private final static String DATABASE_NAME= "reyhanDB";
	public final static String TABLE_NAME= "table1";

	private final static int DATABASE_VERSION=7;
	public final static String UID="_id";
	public final static String TYPE= "Type";
	public final static String PICTURE= "Picture_ID";
	public final static String ONE="One";
	public final static String TWO="Two";
	public final static String THREE= "Three";
	public final static String PHONE_NO= "Phone";

	public final static String RADIO="Radio";
	public final static String RADIO_VALUE="Radio_Value";
	public final static String REPEAT= "Repeat";
	public final static String MSG= "Msg";

	//public final static String ADDRESS= "Address";
    //public final static String NAME="name";
	private static final String CREATE_TABLE="Create table "+TABLE_NAME+" ( "+UID+ " integer primary key autoincrement," +
			" "+TYPE+" varchar(300), "+PICTURE+" varchar(300), "+ONE+" varchar(300), "+TWO+" varchar(300), " +
					""+THREE+" varchar(300), "+PHONE_NO+" integer(300), "+RADIO+" varchar(300), "+RADIO_VALUE+" varchar(300), "+REPEAT+" varchar(300), "+MSG+" varchar(9000));";
	private static final String DROP_TABLE="Drop table if exists "+TABLE_NAME+";";
	private Context context;	
	
	public DB_Helper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION); 
		
		this.context=context;
		//Message.message(context, "Constructor called");
	}
	
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		
		
		Message.message(context, "onCreate called");

		try {
			arg0.execSQL(CREATE_TABLE);
			//Message.message(context, "onCreate called");

		} catch (SQLException e) {
		
			Message.message(context, ""+ e);
		}
		
		
		
	}
	
		@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		try {
			//Message.message(context, "onUpgrade called");

			arg0.execSQL(DROP_TABLE);
			onCreate(arg0);
			
		} catch (SQLException e) {
			Message.message(context, ""+ e);
		}
	}
	
	
}


