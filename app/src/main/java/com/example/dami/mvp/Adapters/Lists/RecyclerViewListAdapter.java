package com.example.dami.mvp.Adapters.Lists;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dami.mvp.Helpers.ItemColors;
import com.example.dami.mvp.Models.RandomItem;
import com.example.dami.mvp.R;

import java.util.ArrayList;

public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewListAdapter.ViewHolder> {
    private ArrayList<RandomItem> mRandomItems;

    /**
     * Konstruktor dla głównego adaptera
     * @param randomItems Lista itemów
     */
    public RecyclerViewListAdapter(ArrayList<RandomItem> randomItems) {
        this.mRandomItems = randomItems;
    }

    /**
     *  Metoda tworząca widok dla jednej komórki w liście
     * @param parent
     * @param viewType
     * @return zwraca widok
     */

    @Override
    public RecyclerViewListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_random_list, null, false);
        RecyclerViewListAdapter.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView colorImageView;
        TextView counterTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            colorImageView = itemView.findViewById(R.id.color_image_view);
            counterTextView = itemView.findViewById(R.id.counter_text_view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerViewListAdapter.ViewHolder holder, int position) {
        RandomItem randomItem = mRandomItems.get(position);
        if (randomItem.getColor() == ItemColors.Blue)
            holder.counterTextView.setText(String.valueOf(randomItem.getCounter() * 3));
        else
            holder.counterTextView.setText(String.valueOf(randomItem.getCounter()));

        GradientDrawable drawable;
        switch (randomItem.getColor()){
            case Blue:
                holder.colorImageView.setImageResource(R.drawable.sh_circle);
                drawable = (GradientDrawable) holder.colorImageView.getDrawable();
                drawable.setColor(ItemColors.Blue.getColor());
                break;
            case Red:
                holder.colorImageView.setImageResource(R.drawable.sh_circle);
                drawable = (GradientDrawable) holder.colorImageView.getDrawable();
                drawable.setColor(ItemColors.Red.getColor());
                break;


        }
    }

    /**
     * Metoda pobierająca ilość elementów w liście
     * @return
     */
    @Override
    public int getItemCount() {
        return mRandomItems.size();
    }
}
