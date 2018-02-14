package com.example.piotrzarczynski.fishbook.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.piotrzarczynski.fishbook.Database.Model.Caught;
import com.example.piotrzarczynski.fishbook.Database.Model.Fish;
import com.example.piotrzarczynski.fishbook.Database.Repo.CaughtRepo;
import com.example.piotrzarczynski.fishbook.Database.Repo.FishRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotr on 2018-01-11.
 */

public class DatabaseHandler extends SQLiteOpenHelper{

    // All static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "fishBook";
    private static final String TAG = DatabaseHandler.class.getSimpleName();

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FishRepo.createTable());
        db.execSQL(CaughtRepo.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Fish.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Caught.TABLE);

        // Create tables again
        onCreate(db);
    }

}
