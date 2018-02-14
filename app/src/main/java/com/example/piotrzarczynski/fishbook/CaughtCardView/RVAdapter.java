package com.example.piotrzarczynski.fishbook.CaughtCardView;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MenuItem;

import com.example.piotrzarczynski.fishbook.Database.ImgTools.DbBitmapUtility;
import com.example.piotrzarczynski.fishbook.Database.Model.Caught;
import com.example.piotrzarczynski.fishbook.Database.Repo.FishRepo;
import com.example.piotrzarczynski.fishbook.MainActivity;
import com.example.piotrzarczynski.fishbook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotr on 2018-01-13.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    public List<Caught> caught;
    public static List<Caught> selectedCaught;
    private static Context context;

    public RVAdapter(List<Caught> caught, Context context) {
        this.caught = caught;
        this.context = context;
        selectedCaught = new ArrayList<Caught>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_cardview,viewGroup,false);
        //ObiektViewHolder ovh = new ObiektViewHolder(v);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder obiektViewHolder, int i) {
        String descriptionNew = "Waga: " + caught.get(i).getWeight() + "kg " +
                "Dlugosc" + caught.get(i).getLength() + "cm\n" + caught.get(i).getCaughtAt() +
                "\n" + caught.get(i).getDescription();
        obiektViewHolder.caughtName.setText(FishRepo.getFish(caught.get(i).getIdFish()).getName());
        obiektViewHolder.caughtDescription.setText(descriptionNew);
        obiektViewHolder.caughtImg.setImageBitmap(DbBitmapUtility.getImage(caught.get(i).getImg()));
        obiektViewHolder.currentItem = caught.get(i);
        obiektViewHolder.isSelected = false;
        obiektViewHolder.cv.setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    public int getItemCount() {
        return caught.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private TextView caughtName;
        private TextView caughtDescription;
        private ImageView caughtImg;
        public Caught currentItem;
        public boolean isSelected;

        public ViewHolder(View itemView) {

            super(itemView);

            currentItem = new Caught();

            cv =
                    (CardView) itemView.findViewById(R.id.cardView);
            caughtName =
                    (TextView) itemView.findViewById(R.id.cardvievName);
            caughtDescription =
                    (TextView) itemView.findViewById(R.id.cardvievOpis);
            caughtImg =
                    (ImageView) itemView.findViewById(R.id.cardvievFoto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    if (isSelected){
                        caughtName.setTextColor(Color.WHITE);
                        caughtDescription.setTextColor(Color.WHITE);
                        selectedCaught.remove(currentItem);
                        isSelected = false;
                    } else {
                        caughtName.setTextColor(Color.RED);
                        caughtDescription.setTextColor(Color.RED);
                        selectedCaught.add(currentItem);
                        isSelected = true;
                    }
                    CaughtView.deleteVisibility(!selectedCaught.isEmpty());
                }
            });
        }

    }
        /*public void onAttachedToRecyclerVew(RecyclerView rv) {
        super.onAttachedToRecyclerView(rv);
    }*/

}