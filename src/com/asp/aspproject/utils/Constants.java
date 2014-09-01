package com.asp.aspproject.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import android.os.Environment;
import android.util.Pair;


public class Constants {

	public static final String PLAYERS_ON_PITCH_FRAGMENTTAG = "PLAYERS_ON_PITCH_FRAGMENT";

	public static final String PLAYERS_SELECTION_FRAGMENTTAG = "PLAYERS_SELECTION_FRAGMENTTAG";

	public static final String EMPTY_SRING="";

	public static final String CACHE_FILE_NAME="temp";
	public static final String CACHE_FILE_EXT=".tmp";

	//public static final String FILE_PLAYER_LIST_KEY="PLAYER_LIST";

	public static enum CACHE_KEY {FILE_PLAYER_LIST_KEY, END}

	//public static final String[] CACHE_KEY_LABELS= {"PLAYER_LIST"};



	public static HashMap<CACHE_KEY, String> CACHE_KEY_LABELS = new HashMap<Constants.CACHE_KEY, String>()
			{
		{put(CACHE_KEY.FILE_PLAYER_LIST_KEY, "PLAYER_LIST"); put(CACHE_KEY.END, null);}
			};




			/* Checks if external storage is available for read and write */
			public boolean isExternalStorageWritable() {
				String state = Environment.getExternalStorageState();
				if (Environment.MEDIA_MOUNTED.equals(state)) {
					return true;
				}
				return false;
			}

			/* Checks if external storage is available to at least read */
			public boolean isExternalStorageReadable() {
				String state = Environment.getExternalStorageState();
				if (Environment.MEDIA_MOUNTED.equals(state) ||
						Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
					return true;
				}
				return false;
			}

			public static final String DATABASE_DROP_TABLE_CACHE = "DROP TABLE IF EXISTS CACHE;";



			public static final String DATABASE_CREATE_TABLE_CACHE =   "CREATE TABLE IF NOT EXISTS CACHE ("+   
					" KEY VARCHAR(255) , ID1  VARCHAR(16) DEFAULT NULL ,"+
					" ID2 VARCHAR(16) DEFAULT NULL, ID3 VARCHAR(16) DEFAULT NULL ,"+
					" ID INTEGER PRIMARY KEY  AUTOINCREMENT, "+
					" DATA  BLOB); ";



			public static final String DATABASE_CREATE = DATABASE_CREATE_TABLE_CACHE;

			public static final String TABLE_NAME_CACHE = "CACHE";


			public static final String DATABASE_NAME = "db.db";
			public static final int DATABASE_VERSION = 1;



}
