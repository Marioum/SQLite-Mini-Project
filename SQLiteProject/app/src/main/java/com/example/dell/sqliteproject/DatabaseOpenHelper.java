package com.example.dell.sqliteproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 02/12/2016.
 */

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String SQLCreateTableOs= "CREATE TABLE "+DatabaseContact.Os.tableName+"("+
            DatabaseContact.Os.columnName+" "+
            DatabaseContact.Os.columnNameType+" PRIMARY KEY,"+
            DatabaseContact.Os.columnNbuser+" "+
            DatabaseContact.Os.columnNbuserType+", "+
            DatabaseContact.Os.columnNbversion+" "+
            DatabaseContact.Os.columnNbversionType+", "+
            DatabaseContact.Os.columnNbsmart+" "+
            DatabaseContact.Os.columnNbsmartType+")";

    private  static final String SQLDeleteTableOS="DROP TABLE IF EXISTS"+DatabaseContact.Os.tableName;
    public static final int databaseVersion=1;
    public static String databaseName="oss.db";
    public DatabaseOpenHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLCreateTableOs);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQLDeleteTableOS);
        onCreate(sqLiteDatabase);
    }
    public void insert (AndroidOs androidOs){

        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(DatabaseContact.Os.columnName, androidOs.name);
        values.put(DatabaseContact.Os.columnNbuser, androidOs.nbUser);
        values.put(DatabaseContact.Os.columnNbversion, androidOs.nbVersion);
        values.put(DatabaseContact.Os.columnNbsmart, androidOs.nbsmart);
        long result =   database.insert(DatabaseContact.Os.tableName, null, values);

    }

    public AndroidOs getOs(String name){
        SQLiteDatabase database=this.getReadableDatabase();
        AndroidOs androidos=null;
        //  ContentValues values= new ContentValues();
        String selection=DatabaseContact.Os.columnName+" LIKE ?";
        String [] selectionArgs={"%"+name+"%"};
        String [] columns={DatabaseContact.Os.columnName,
                DatabaseContact.Os.columnNbuser,
                DatabaseContact.Os.columnNbversion,
                DatabaseContact.Os.columnNbsmart};
        Cursor cursor=database.query(DatabaseContact.Os.tableName,columns,selection,selectionArgs,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
        if(!cursor.isAfterLast())
            androidos= new AndroidOs(cursor.getString(0), Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),Integer.parseInt(cursor.getString(3)));
        return androidos;
    }
}

