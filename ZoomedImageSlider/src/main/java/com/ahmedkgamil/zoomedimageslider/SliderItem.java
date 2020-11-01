package com.ahmedkgamil.zoomedimageslider;

class SliderItem {

    private String imageUrl;
    private int imageResId;

    public SliderItem(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public SliderItem(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getImageResId() {
        return imageResId;
    }
}
