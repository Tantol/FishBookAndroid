package com.example.piotrzarczynski.fishbook.Database;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.example.piotrzarczynski.fishbook.Database.ImgTools.DbBitmapUtility;
import com.example.piotrzarczynski.fishbook.Database.Model.Caught;
import com.example.piotrzarczynski.fishbook.Database.Model.Fish;
import com.example.piotrzarczynski.fishbook.Database.Repo.CaughtRepo;
import com.example.piotrzarczynski.fishbook.Database.Repo.FishRepo;
import com.example.piotrzarczynski.fishbook.R;

/**
 * Created by Piotr on 2018-01-14.
 */

public class DefaultCaughtFishList {

    public DefaultCaughtFishList(Context context, CaughtRepo caughtRepo) {

        Drawable drawable;
        Bitmap bitmap;
        byte[] byteMap;
        Caught caughtFish;

        // (1) Karp
        drawable = context.getResources().getDrawable(R.drawable.default_img_karp);
        bitmap = DbBitmapUtility.drawableToBitmap(drawable);
        byteMap = DbBitmapUtility.getBytes(bitmap);

        caughtFish = new Caught(1, 20, 20, byteMap, "2001-01-01", "Przyklad");
        Fish fish = new Fish();
        fish = FishRepo.getFish(1);
        fish.setCatch(true);
        FishRepo.updateFish(fish);

        caughtRepo.addCaughtFish(caughtFish);
    }
}
