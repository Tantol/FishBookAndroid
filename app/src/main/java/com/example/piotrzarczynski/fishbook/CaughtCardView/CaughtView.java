package com.example.piotrzarczynski.fishbook.CaughtCardView;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.piotrzarczynski.fishbook.CaughtAddForm;
import com.example.piotrzarczynski.fishbook.Database.ImgTools.DbBitmapUtility;
import com.example.piotrzarczynski.fishbook.Database.Model.Caught;
import com.example.piotrzarczynski.fishbook.Database.Model.Fish;
import com.example.piotrzarczynski.fishbook.Database.Repo.CaughtRepo;
import com.example.piotrzarczynski.fishbook.Database.Repo.FishRepo;
import com.example.piotrzarczynski.fishbook.R;
import com.example.piotrzarczynski.fishbook.SettingsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotr on 2018-01-14.
 */

public class CaughtView extends AppCompatActivity {

    //private List<Caught> caughts;
    private RecyclerView rv;
    private RecyclerView.LayoutManager linearLayoutMenaeger;
    private RVAdapter adapter;
    private CaughtRepo caughtRepo;
    private FishRepo fishRepo;
    private static MenuItem itemDelete;

    private PopupWindow mPopupWindow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caught);

        rv = (RecyclerView)findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        caughtRepo = new CaughtRepo(this);
        fishRepo = new FishRepo(this);
        linearLayoutMenaeger = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutMenaeger);
        adapter = new RVAdapter(new ArrayList<Caught>(),this);
        rv.setAdapter(adapter);
    }

    protected void onResume(){
        super.onResume();
        if (caughtRepo.getCaughtFishesCount() > 0){
            adapter.caught = caughtRepo.getAllCaughtFishes();
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_collection, menu);
        itemDelete = menu.findItem(R.id.deleteCaughtFish);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        } else if (id == R.id.addCaughtFish){
            startActivity(new Intent(this, CaughtAddForm.class));
        } else if (id == R.id.deleteCaughtFish){
            // Initialize a new instance of LayoutInflater service
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);

            // Inflate the custom layout/view
            View customView = inflater.inflate(R.layout.activity_delete_triger,null);

                /*
                    public PopupWindow (View contentView, int width, int height)
                        Create a new non focusable popup window which can display the contentView.
                        The dimension of the window must be passed to this constructor.

                        The popup does not provide any background. This should be handled by
                        the content view.

                    Parameters
                        contentView : the popup's content
                        width : the popup's width
                        height : the popup's height
                */
            // Initialize a new instance of popup window
            mPopupWindow = new PopupWindow(
                    customView,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );

            // Set an elevation value for popup window
            // Call requires API level 21
            if(Build.VERSION.SDK_INT>=21){
                mPopupWindow.setElevation(5.0f);
            }

            // Get a reference for the custom view close button
            Button noButton = (Button) customView.findViewById(R.id.deleteNo);
            Button yesButton = (Button) customView.findViewById(R.id.deleteYes);

            // Set a click listener for the popup window no button
            noButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Dismiss the popup window
                    mPopupWindow.dismiss();
                }
            });

            // Set a click listener for the popup window yes button
            yesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!adapter.selectedCaught.isEmpty()){
                        for(int i = 0; i < adapter.selectedCaught.size(); i++){
                            caughtRepo.deleteCaughtFish(adapter.selectedCaught.get(i));
                            Fish fish = new Fish();
                            fish = fishRepo.getFish(adapter.selectedCaught.get(i).getIdFish());
                            fish.setCatch(false);
                            fishRepo.updateFish(fish);
                        }
                    }
                    adapter.selectedCaught.clear();
                    if(caughtRepo.getCaughtFishesCount() > 0){
                        List<Caught> caughts = caughtRepo.getAllCaughtFishes();
                        for (int i = 0; i < caughts.size(); i++){
                            Fish fish = new Fish();
                            fish = fishRepo.getFish(caughts.get(i).getIdFish());
                            fish.setCatch(true);
                            fishRepo.updateFish(fish);
                        }
                    }
                    // Dismiss the popup window
                    Intent intent = getIntent();
                    overridePendingTransition(0, 0);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(intent);

                    mPopupWindow.dismiss();
                }
            });

                /*
                    public void showAtLocation (View parent, int gravity, int x, int y)
                        Display the content view in a popup window at the specified location. If the
                        popup window cannot fit on screen, it will be clipped.
                        Learn WindowManager.LayoutParams for more information on how gravity and the x
                        and y parameters are related. Specifying a gravity of NO_GRAVITY is similar
                        to specifying Gravity.LEFT | Gravity.TOP.

                    Parameters
                        parent : a parent view to get the getWindowToken() token from
                        gravity : the gravity which controls the placement of the popup window
                        x : the popup's x location offset
                        y : the popup's y location offset
                */
            // Finally, show the popup window at the center location of root relative layout
            mPopupWindow.showAtLocation(rv, Gravity.CENTER,0,0);
        }

        return super.onOptionsItemSelected(item);
    }

    public static void deleteVisibility(boolean is){
        itemDelete.setVisible(is);
    }
}
