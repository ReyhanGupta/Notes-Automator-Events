package com.example.db_listview;

import android.content.Context;
import android.widget.Toast;

public class Message {
	public static void message(Context context, String message)
	{
		Toast.makeText(context, message, 5000).show();
	}

}
