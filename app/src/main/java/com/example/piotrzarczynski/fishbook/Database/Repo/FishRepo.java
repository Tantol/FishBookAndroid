package com.example.piotrzarczynski.fishbook.Database.Repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import com.example.piotrzarczynski.fishbook.Database.DatabaseManager;
import com.example.piotrzarczynski.fishbook.Database.DefaultFishList;
import com.example.piotrzarczynski.fishbook.Database.ImgTools.DbBitmapUtility;
import com.example.piotrzarczynski.fishbook.Database.Model.Fish;
import com.example.piotrzarczynski.fishbook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotr on 2018-01-11.
 */

public class FishRepo {

    private Fish m_Fish;
    private Context m_Context;

    public FishRepo(Context context){
        this.m_Context = context;
        this.m_Fish = new Fish();
    }

    public static String createTable(){
        return "CREATE TABLE " + Fish.TABLE + "("+
                Fish.KEY_ID + " " + Fish.TYPE_ID + "," +
                Fish.KEY_NAME + " " + Fish.TYPE_NAME + "," +
                Fish.KEY_DESCRIPTION + " " + Fish.TYPE_DESCRIPTION + "," +
                Fish.KEY_OCCUR + " " + Fish.TYPE_OCCUR + "," +
                Fish.KEY_IMG + " " + Fish.TYPE_IMG + "," +
                Fish.KEY_CATCH + " " + Fish.TYPE_CATCH + ");";
    }

    /* CRUD (Create Read Update Delete) */
    // Adding new fish
    public int addFish(Fish fish) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(Fish.KEY_NAME, fish.getName());
        values.put(Fish.KEY_DESCRIPTION, fish.getDescription());
        values.put(Fish.KEY_OCCUR, fish.getOccur());
        values.put(Fish.KEY_IMG, fish.getImg());
        values.put(Fish.KEY_CATCH, fish.isCatch());

        // Inserting Row
        int courseId;
        courseId = (int)db.insert(Fish.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase(); // Closing database connection

        return courseId;
    }

    // Getting one fish
    public static Fish getFish(int iId) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        Cursor cursor = db.query(Fish.TABLE, new String[] { Fish.KEY_ID,
                        Fish.KEY_NAME, Fish.KEY_DESCRIPTION, Fish.KEY_OCCUR, Fish.KEY_IMG, Fish.KEY_CATCH }, Fish.KEY_ID + "=?",
                new String[] { String.valueOf(iId) }, null, null, null, null);
        if (cursor.moveToFirst() && cursor != null)
            cursor.moveToFirst();

        Fish fish = new Fish(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getBlob(4),
                Byte.parseByte(cursor.getString(5)));

        DatabaseManager.getInstance().closeDatabase();
        // return contact
        return fish;
    }

    // Getting one fish
    public Fish getFish(String sName) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        Cursor cursor = db.query(Fish.TABLE, new String[] { Fish.KEY_ID,
                        Fish.KEY_NAME, Fish.KEY_DESCRIPTION, Fish.KEY_OCCUR, Fish.KEY_IMG, Fish.KEY_CATCH }, Fish.KEY_NAME + "=?",
                new String[] { String.valueOf(sName) }, null, null, null, null);
        if (cursor.moveToFirst() && cursor != null)
            cursor.moveToFirst();

        Fish fish = new Fish(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getBlob(4),
                Byte.parseByte(cursor.getString(5)));

        DatabaseManager.getInstance().closeDatabase();
        // return contact
        return fish;
    }

    // Getting all fishes
    public List<Fish> getAllFishes() {
        List<Fish> fishArrayList = new ArrayList<Fish>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + Fish.TABLE;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Fish fish = new Fish();
                fish.setId(Integer.parseInt(cursor.getString(0)));
                fish.setName(cursor.getString(1));
                fish.setDescription(cursor.getString(2));
                fish.setOccur(cursor.getString(3));
                fish.setImg(cursor.getBlob(4));
                fish.setCatch(Byte.parseByte(cursor.getString(5)));
                // Adding contact to list
                fishArrayList.add(fish);
            } while (cursor.moveToNext());
        }

        DatabaseManager.getInstance().closeDatabase();
        // return fish list
        return fishArrayList;
    }

    // Getting fishes count
    public int getFishesCount() {
        String countQuery = "SELECT  * FROM " + Fish.TABLE;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int iCursorCount = cursor.getCount();
        cursor.close();

        DatabaseManager.getInstance().closeDatabase();
        // return count
        return iCursorCount;
    }
    // Updating single contact
    public static int updateFish(Fish fish) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(Fish.KEY_NAME, fish.getName());
        values.put(Fish.KEY_DESCRIPTION, fish.getDescription());
        values.put(Fish.KEY_OCCUR, fish.getOccur());
        values.put(Fish.KEY_IMG, fish.getImg());
        values.put(Fish.KEY_CATCH, fish.isCatch());

        int courseId;
        // updating row
        courseId = (int)db.update(Fish.TABLE, values, Fish.KEY_ID + " = ?",
                new String[] { String.valueOf(fish.getId()) });

        DatabaseManager.getInstance().closeDatabase();
        return courseId;
    }

    // Deleting single fish
    public int deleteFish(Fish fish) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        int courseId;
        // delete row
        courseId = (int)db.delete(Fish.TABLE, Fish.KEY_ID + " = ?",
                new String[] { String.valueOf(fish.getId()) });

        DatabaseManager.getInstance().closeDatabase();
        return courseId;

    }
    public void clearTable(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Fish.TABLE, null,null);
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + Fish.TABLE + "'");
        DatabaseManager.getInstance().closeDatabase();
    }

    public void setDefaultFishes(){
        DefaultFishList defaultFishList = new DefaultFishList(m_Context, this);
    }
}
