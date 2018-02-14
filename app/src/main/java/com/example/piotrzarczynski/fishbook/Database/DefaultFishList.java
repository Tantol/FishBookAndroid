package com.example.piotrzarczynski.fishbook.Database;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.example.piotrzarczynski.fishbook.Database.ImgTools.DbBitmapUtility;
import com.example.piotrzarczynski.fishbook.Database.Model.Fish;
import com.example.piotrzarczynski.fishbook.Database.Repo.FishRepo;
import com.example.piotrzarczynski.fishbook.R;

/**
 * Created by Piotr on 2018-01-13.
 */

public class DefaultFishList {

    public DefaultFishList(Context context, FishRepo fishRepo){
            // all 33 fishes
            Drawable drawable;
            Bitmap bitmap;
            byte[] byteMap;
            Fish fish;

            // (1) Karp
            drawable = context.getResources().getDrawable(R.drawable.default_img_karp);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Karp");
            fish.setDescription("Swiateczna rybka");
            fish.setOccur("Szukaj w slodkich zalewach wodnych, najczęściej w gęstwinach. Lubi kukurydze i inne 'nie mięsne zanęty'");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (2) Sum
            drawable = context.getResources().getDrawable(R.drawable.default_img_sum);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Sum");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (3) Amur bialy
            drawable = context.getResources().getDrawable(R.drawable.default_img_amur_bialy);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Amur bialy");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (4) Bolen
            drawable = context.getResources().getDrawable(R.drawable.default_img_bolen);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Bolen");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (5) Brzan
            drawable = context.getResources().getDrawable(R.drawable.default_img_brzana);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Brzan");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (6) Certa
            drawable = context.getResources().getDrawable(R.drawable.default_img_certa);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Certa");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);
            /*
            // (7) Jaz
            drawable = context.getResources().getDrawable(R.drawable.default_img_jaz);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Jaz");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (8) Jelec
            drawable = context.getResources().getDrawable(R.drawable.default_img_jelec);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Jelec");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (9) Karas
            drawable = context.getResources().getDrawable(R.drawable.default_img_karas);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Karas");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);
            */
            /*
            // (10) Karas srebrzysty
            drawable = context.getResources().getDrawable(R.drawable.default_img_karas_srebrzysty);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Karas srebrzysty");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (11) Kielb
            drawable = context.getResources().getDrawable(R.drawable.default_img_kielb);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Kielb");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (12) Klen
            drawable = context.getResources().getDrawable(R.drawable.default_img_klen);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Klen");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (13) Koza
            drawable = context.getResources().getDrawable(R.drawable.default_img_koza);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Koza");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (14) Krap
            drawable = context.getResources().getDrawable(R.drawable.default_img_krap);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Krap");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (15) Leszcz
            drawable = context.getResources().getDrawable(R.drawable.default_img_leszcz);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Leszcz");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (16) Lin
            drawable = context.getResources().getDrawable(R.drawable.default_img_lin);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Lin");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (17) Lipien
            drawable = context.getResources().getDrawable(R.drawable.default_img_lipien);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Lipien");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (18) Mietus
            drawable = context.getResources().getDrawable(R.drawable.default_img_mietus);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Mietus");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (19) Okon
            drawable = context.getResources().getDrawable(R.drawable.default_img_okon);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Okon");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (20) Piskorz
            drawable = context.getResources().getDrawable(R.drawable.default_img_piskorz);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Piskorz");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (21) Ploc
            drawable = context.getResources().getDrawable(R.drawable.default_img_ploc);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Ploc");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (22) Pstrag potokowy
            drawable = context.getResources().getDrawable(R.drawable.default_img_pstrag_potokowy);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Pstrag potokowy");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (23) Pstrag zrodlany
            drawable = context.getResources().getDrawable(R.drawable.default_img_pstrag_zrodlany);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Pstrag zrodlany");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (24) Rozanka
            drawable = context.getResources().getDrawable(R.drawable.default_img_rozanka);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Rozanka");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (25) Sandacz
            drawable = context.getResources().getDrawable(R.drawable.default_img_sandacz);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Sandacz");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (26) Sliz
            drawable = context.getResources().getDrawable(R.drawable.default_img_sliz);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Sliz");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (27) Strzebla potkowa
            drawable = context.getResources().getDrawable(R.drawable.default_img_strzebla_potokowa);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Strzebla potkowa");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (28) Swinka
            drawable = context.getResources().getDrawable(R.drawable.default_img_swinka);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Swinka");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (29) Szczupak
            drawable = context.getResources().getDrawable(R.drawable.default_img_szczupak);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Szczupak");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (30) Tolpyga biala
            drawable = context.getResources().getDrawable(R.drawable.default_img_tolpyga_biala);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Tolpyga biala");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (31) Ukleja
            drawable = context.getResources().getDrawable(R.drawable.default_img_ukleja);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Ukleja");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (32) Wegorz europejski
            drawable = context.getResources().getDrawable(R.drawable.default_img_wegorz_europejski);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Wegorz europejski");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);

            // (33) Wzdrega
            drawable = context.getResources().getDrawable(R.drawable.default_img_wzdrega);
            bitmap = DbBitmapUtility.drawableToBitmap(drawable);
            byteMap = DbBitmapUtility.getBytes(bitmap);

            fish = new Fish();
            fish.setName("Wzdrega");
            fish.setDescription("Brak opisu obecnie");
            fish.setOccur("Brak wskazówek, zostanie dodane w przyszłości");
            fish.setImg(byteMap);
            fish.setCatch(false);

            fishRepo.addFish(fish);
            */
    }
}

