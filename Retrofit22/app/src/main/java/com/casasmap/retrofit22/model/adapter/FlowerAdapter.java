package com.casasmap.retrofit22.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.casasmap.retrofit22.R;
import com.casasmap.retrofit22.model.Flower;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramiro on 3/27/16.
 */
public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder>{

    private List<Flower> mFlowers;

    public FlowerAdapter(){
        mFlowers = new ArrayList<>();
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Flower currFlower = mFlowers.get(position);
        holder.mTextViewLarge.setText(currFlower.getName());
        holder.mTextViewMedium.setText("$ " + Double.toString(currFlower.getPrice()));

        Picasso.with(holder.mImageView.getContext()).load(
                "http://services.hanselandpetal.com/photos/" + currFlower.getPhoto()).into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mFlowers.size();
    }

    public void addFlower(Flower flower) {
        mFlowers.add(flower);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTextViewLarge;
        private TextView mTextViewMedium;

        public Holder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_flower_photo);
            mTextViewLarge = (TextView) itemView.findViewById(R.id.tv_large);
            mTextViewMedium = (TextView) itemView.findViewById(R.id.tv_medium);
        }
    }
}
