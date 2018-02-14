package com.example.piotrzarczynski.fishbook.Database.Repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.piotrzarczynski.fishbook.Database.DatabaseManager;
import com.example.piotrzarczynski.fishbook.Database.DefaultCaughtFishList;
import com.example.piotrzarczynski.fishbook.Database.Model.Caught;
import com.example.piotrzarczynski.fishbook.Database.Model.Fish;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotr on 2018-01-11.
 */

public class CaughtRepo {

    private Caught m_Caught;
    private Context m_Context;

    public CaughtRepo(Context context){
        this.m_Context = context;
        this.m_Caught = new Caught();
    }

    public static String createTable(){
        return "CREATE TABLE " + Caught.TABLE + "("+
                Caught.KEY_ID + " " + Caught.TYPE_ID + "," +
                Caught.KEY_IDFISH + " " + Caught.TYPE_ID_FISH + "," +
                Caught.KEY_WEIGHT + " " + Caught.TYPE_WEIGHT+ "," +
                Caught.KEY_LENGTH + " " + Caught.TYPE_LENGTH + "," +
                Caught.KEY_IMG + " " + Caught.TYPE_IMG + "," +
                Caught.KEY_CAUGHT_AT + " " + Caught.TYPE_CAUGHT_AT + "," +
                Caught.KEY_DESCRIPTION + " " + Caught.TYPE_DESCRIPTION + ");";
    }

    /* CRUD (Create Read Update Delete) */
    // Adding new caught fish
    public int addCaughtFish(Caught caught) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(Caught.KEY_IDFISH, caught.getIdFish());
        values.put(Caught.KEY_WEIGHT, caught.getWeight());
        values.put(Caught.KEY_LENGTH, caught.getLength());
        values.put(Caught.KEY_IMG, caught.getImg());
        values.put(Caught.KEY_CAUGHT_AT, caught.getCaughtAt());
        values.put(Caught.KEY_DESCRIPTION, caught.getDescription());

        // Inserting Row
        int courseId;
        courseId = (int)db.insert(Caught.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase(); // Closing database connection

        return courseId;
    }

    // Getting one cought fish
    public Caught getCaughtFish(int iId) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        Cursor cursor = db.query(Caught.TABLE, new String[] { Caught.KEY_ID,
                        Caught.KEY_IDFISH, Caught.KEY_WEIGHT, Caught.KEY_LENGTH, Caught.KEY_IMG, Caught.KEY_CAUGHT_AT, Caught.KEY_DESCRIPTION}, Caught.KEY_ID + "=?",
                new String[] { String.valueOf(iId) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Caught caught = new Caught(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)), cursor.getBlob(4),
                cursor.getString(5), cursor.getString(6));

        DatabaseManager.getInstance().closeDatabase();
        // return contact
        return caught;
    }

    // Getting all caught fishes
    public List<Caught> getAllCaughtFishes() {
        List<Caught> caughtArrayList = new ArrayList<Caught>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + Caught.TABLE;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Caught caught = new Caught();
                caught.setId(Integer.parseInt(cursor.getString(0)));
                caught.setIdFish(Integer.parseInt(cursor.getString(1)));
                caught.setWeight(Integer.parseInt(cursor.getString(2)));
                caught.setLength(Integer.parseInt(cursor.getString(3)));
                caught.setImg(cursor.getBlob(4));
                caught.setCaughtAt(cursor.getString(5));
                caught.setDescription(cursor.getString(6));
                // Adding fish to list
                caughtArrayList.add(caught);
            } while (cursor.moveToNext());
        }

        DatabaseManager.getInstance().closeDatabase();
        // return fish list
        return caughtArrayList;
    }

    // Getting fishes count
    public int getCaughtFishesCount() {
        String countQuery = "SELECT  * FROM " + Caught.TABLE;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int iCount = cursor.getCount();
        cursor.close();

        DatabaseManager.getInstance().closeDatabase();
        // return count
        return iCount;
    }
    // Updating single contact
    public int updateCaughtFish(Caught caught) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(Caught.KEY_IDFISH, caught.getIdFish());
        values.put(Caught.KEY_WEIGHT, caught.getWeight());
        values.put(Caught.KEY_LENGTH, caught.getLength());
        values.put(Caught.KEY_IMG, caught.getImg());
        values.put(Caught.KEY_CAUGHT_AT, caught.getCaughtAt());
        values.put(Caught.KEY_DESCRIPTION, caught.getDescription());

        int courseId;
        // updating row
        courseId = (int)db.update(Caught.TABLE, values, Caught.KEY_ID + " = ?",
                new String[] { String.valueOf(caught.getId()) });

        DatabaseManager.getInstance().closeDatabase();
        return courseId;
    }

    // Deleting single fish
    public int deleteCaughtFish(Caught caught) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        int courseId;
        // delete row
        courseId = (int)db.delete(Caught.TABLE, Caught.KEY_ID + " = ?",
                new String[] { String.valueOf(caught.getId()) });

        DatabaseManager.getInstance().closeDatabase();
        return courseId;

    }

    public void clearTable(){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Caught.TABLE, null,null);
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + Caught.TABLE + "'");
        DatabaseManager.getInstance().closeDatabase();
    }

    public void setDefaultCaughtFishes(){
        DefaultCaughtFishList defaultCaughtFishList = new DefaultCaughtFishList(m_Context, this);
    }
}
