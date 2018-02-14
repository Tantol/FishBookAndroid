package com.example.piotrzarczynski.fishbook.app;

import android.app.Application;
import android.content.Context;

import com.example.piotrzarczynski.fishbook.Database.DatabaseHandler;
import com.example.piotrzarczynski.fishbook.Database.DatabaseManager;
import com.example.piotrzarczynski.fishbook.Database.Repo.CaughtRepo;
import com.example.piotrzarczynski.fishbook.Database.Repo.FishRepo;

/**
 * Created by Piotr on 2018-01-11.
 */

public class  App extends Application {
    private static Context context;
    private static DatabaseHandler dbHelper;
    private static FishRepo fishRepo;
    private static CaughtRepo caughtRepo;

    @Override
    public void onCreate(){
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new DatabaseHandler(context);
        fishRepo = new FishRepo(this);
        caughtRepo = new CaughtRepo(this);
        DatabaseManager.initializeInstance(dbHelper);
        setDefaultFishes();
        setDefaultCaught();

    }

    public static Context getContext(){
        return context;
    }

    private void setDefaultFishes(){

        if(fishRepo.getFishesCount() <= 0){
            fishRepo.clearTable();
            fishRepo.setDefaultFishes();
        }

    }

    private void setDefaultCaught(){

        if(caughtRepo.getCaughtFishesCount() <= 0){
            caughtRepo.clearTable();
            //caughtRepo.setDefaultCaughtFishes();
        }

    }

}
