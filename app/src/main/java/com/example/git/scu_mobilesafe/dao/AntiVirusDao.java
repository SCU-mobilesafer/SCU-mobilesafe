package com.example.git.scu_mobilesafe.dao;

import java.io.File;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class AntiVirusDao {


	static SQLiteDatabase db;

	public String AntivirusDao() {

		String path = "data/data/com.jess.mobilesafe/files/antivirus.db";

		db = SQLiteDatabase.openDatabase(path, null,
				SQLiteDatabase.OPEN_READONLY);
		return path;
	}

	public static String checkVirus(String md5) {
		String result = null;
		Cursor cursor = db.rawQuery("select desc from datable where md5 = ?", new String[]{md5});
		if (cursor.moveToNext()) {
			result = cursor.getString(0);

		}
		cursor.close();
		db.close();
		return result;
	}
}


