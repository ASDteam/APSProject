package com.asp.aspproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.asp.aspproject.utils.Constants;

public class DBAdapter {
	
	
  
    // TODO: Create public field for each column in your table.

    // Variable to hold the database instance
    public  SQLiteDatabase mDB;
    // Context of the application using the database.
    private final Context mContext;
    // Database open/upgrade helper
    private DBHelper mDBHelper;
    public  DBAdapter(Context iContext) 
    {
        mContext = iContext;
        mDBHelper = new DBHelper(mContext, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }
    public  DBAdapter open() throws SQLException 
    {
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }
    public void close() 
    {
        mDB.close();
    }
    
    public boolean isOpen() 
    {
       return mDB.isOpen();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return mDB;
    }

    public void insertEntry(String key,String id1, String id2, String id3, String data)
    {
       ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("KEY", key);
        newValues.put("ID1",id1);
        //newValues.put("ID2",id2);
        //newValues.put("ID3",id3);
        newValues.put("DATA",data);

        
        // Insert the row into your table
        mDB.insert(Constants.TABLE_NAME_CACHE, null, newValues);
    }
    public int deleteEntry(String key, String id1)
    {
        //String id=String.valueOf(ID);
        String where="KEY=? AND ID1=?";
        int numberOFEntriesDeleted= mDB.delete(Constants.TABLE_NAME_CACHE, where, new String[]{key, id1}) ;
        //Toast.makeText(mContext, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }    
    public String getSinlgeEntry(String key, String id1)
    {
        Cursor cursor=mDB.query(Constants.TABLE_NAME_CACHE, null, " KEY=? AND ID=?", new String[]{key, id1}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();
        String data= cursor.getString(cursor.getColumnIndex("DATA"));
        cursor.close();
        return data;                
    }


    public void  updateEntry(String key,String id1, String id2, String id3, String data)
    {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        
        updatedValues.put("KEY", key);
        updatedValues.put("ID1",id1);
       // updatedValues.put("ID2",id2);
       // updatedValues.put("ID3",id3);
        updatedValues.put("DATA",data);

        String where="KEY = ? AND ID1 = ?";
        mDB.update(Constants.TABLE_NAME_CACHE,updatedValues, where, new String[]{key, id1});               
    }
    
    
    public  void deleteDatase()
    {
        mContext.deleteDatabase(Constants.DATABASE_NAME);
        mContext.deleteDatabase("db2.db");
    }
    
}
