package com.ahmedkgamil.zoomedimageslider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {

    private Context context;
    private List<SliderItem> sliderItems;

    public SliderAdapter(Context context, List<SliderItem> sliderItems) {
        this.context = context;
        this.sliderItems = sliderItems;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(context).inflate(
                        R.layout.item_image,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        if (sliderItems.isEmpty()) {
            return;
        }
        SliderItem item = sliderItems.get(position);
        if (item.getImageUrl() != null) {
            holder.downloadImage(sliderItems.get(position));
        } else {
            holder.loadImage(sliderItems.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView image;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageSlide);
        }

        void downloadImage(SliderItem sliderItem) {
            Glide.with(context).load(sliderItem.getImageUrl()).into(image);
        }

        void loadImage(SliderItem sliderItem) {
            Glide.with(context).load(sliderItem.getImageResId()).into(image);
        }
    }
}
