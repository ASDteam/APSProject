package com.asp.aspproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.asp.aspproject.utils.Constants;

public class DBHelper extends SQLiteOpenHelper{
	
	public DBHelper(Context context, String name,CursorFactory factory, int version) 
    {		       
		super(context, name, factory, version);
	}
	// Called when no database exists in disk and the helper class needs
	// to create a new one.
	@Override
	public void onCreate(SQLiteDatabase idb) 
	{
		Log.e("DBHelper", "onCreate::begin " + Constants.DATABASE_CREATE);
		
		idb.execSQL(Constants.DATABASE_DROP_TABLE_CACHE);
		idb.execSQL(Constants.DATABASE_CREATE_TABLE_CACHE);
		
		Log.e("DBHelper", "onCreate::end " +Constants.DATABASE_CREATE);

	}
	// Called when there is a database version mismatch meaning that the version
	// of the database on disk needs to be upgraded to the current version.
	@Override
	public void onUpgrade(SQLiteDatabase idb, int _oldVersion, int _newVersion) 
	{
			// Log the version upgrade.
			Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");

			// Upgrade the existing database to conform to the new version. Multiple
			// previous versions can be handled by comparing _oldVersion and _newVersion
			// values.
			// The simplest case is to drop the old table and create a new one.
			idb.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
			// Create a new one.
			onCreate(idb);
	}

}
