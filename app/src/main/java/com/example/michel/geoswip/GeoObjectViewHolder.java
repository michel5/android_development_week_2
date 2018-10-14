package com.example.michel.geoswip;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GeoObjectViewHolder extends RecyclerView.ViewHolder {

    public ImageView geoImage;

    public View view;

    /**
     *
     * @param itemView
     */
    public GeoObjectViewHolder(View itemView) {
        super(itemView);
        geoImage = itemView.findViewById(R.id.imageView_id);
        view = itemView;
    }


    public ImageView getmGeoImageName() {
        return this.geoImage;
    }
}
