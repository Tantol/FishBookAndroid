package com.example.piotrzarczynski.fishbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.piotrzarczynski.fishbook.Database.Model.Caught;
import com.example.piotrzarczynski.fishbook.Database.Model.Fish;
import com.example.piotrzarczynski.fishbook.Database.Repo.CaughtRepo;
import com.example.piotrzarczynski.fishbook.Database.Repo.FishRepo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

/**
 * Created by Piotr on 2018-01-14.
 */

public class CaughtAddForm extends AppCompatActivity {

    private Spinner spAddCaughtFishId;
    private EditText txtAddCaughtWeight;
    private EditText txtAddCaughtLength;
    private EditText txtAddCaughtDescription;
    private Button btnImgTtriger;
    private ImageView imgAddCaughtImg;

    private Caught caught;
    private CaughtRepo caughtRepo;
    private FishRepo fishRepo;
    private byte[] arrayFoto;
    private SpinAdapter adapter;
    private List<Fish> fishList;
    private Date currentTime;
    private Fish selectedFish;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_caught_fish);

        fishRepo = new FishRepo(this);
        fishList = fishRepo.getAllFishes();
        selectedFish = new Fish();

        Fish[]  fishes = new Fish[fishList.size()];
        for (int i = 0; i < fishList.size(); i++){
            fishes[i] = fishList.get(i);
        }


        adapter = new SpinAdapter(CaughtAddForm.this,
                android.R.layout.simple_spinner_item,
                fishes);

        spAddCaughtFishId = (Spinner) findViewById(R.id.spAddCaughtFishId);
        txtAddCaughtWeight = (EditText) findViewById(R.id.addCaughtWeight);
        txtAddCaughtLength = (EditText) findViewById(R.id.addCaughtLength);
        txtAddCaughtDescription = (EditText) findViewById(R.id.addCaughtDescription);
        btnImgTtriger = (Button) findViewById(R.id.addCaughtImgTriger);
        imgAddCaughtImg = (ImageView) findViewById(R.id.addCaughtImg);

        caughtRepo = new CaughtRepo(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAddTriger);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabAddTriger();
            }
        });

        spAddCaughtFishId.setAdapter(adapter); // Set the custom adapter to the spinner
        // You can create an anonymous listener to handle the event when is selected an spinner item
        spAddCaughtFishId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                selectedFish = adapter.getItem(position);
                // Here you can do the action you want to...
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });
    }

    public void btnFotoTriger(View view){
        EasyImage.openChooserWithGallery(CaughtAddForm.this, "Wybierz źródło: ", 0);
    }

    public void fabAddTriger(){
        int weight = Integer.parseInt(txtAddCaughtWeight.getText().toString());
        int length = Integer.parseInt(txtAddCaughtLength.getText().toString());
        String description = txtAddCaughtDescription.getText().toString();

        currentTime = Calendar.getInstance().getTime();

        String at = currentTime.toString();

        caught = new Caught(selectedFish.getId(), weight, length, arrayFoto, at, description);

        caughtRepo.addCaughtFish(caught);

        selectedFish.setCatch(true);
        fishRepo.updateFish(selectedFish);

        CaughtAddForm.this.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                Toast.makeText(CaughtAddForm.this, "Problem z pobieraniem zdjecia...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 70, stream);
                arrayFoto = stream.toByteArray();

                if (imgAddCaughtImg != null){
                    imgAddCaughtImg.setVisibility(View.VISIBLE);
                    imgAddCaughtImg.setImageBitmap(bitmap);
                }

            }

        });
    }

}
