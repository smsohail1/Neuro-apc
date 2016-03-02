package com.example.appxone.neuroapc;

/**
 * Created by APPXONE on 3/1/2016.
 */
public class Expand_list {
    private String text_expand;

    private String count = "0";

    private int img_expand;

    private boolean isCounterVisible = false;

    public Expand_list() {
    }

    public Expand_list(String text, int img
    ) {

        this.text_expand = text;
        this.img_expand = img;


    }


    public Expand_list(String text, int img
            , boolean isCounterVisible, String count

    ) {

        this.text_expand = text;
        this.img_expand = img;


        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }


    public int getimg() {
        return this.img_expand;
    }

    public String gettext() {
        return this.text_expand;
    }

    public void settext(String text) {
        this.text_expand = text;
    }


    public String getCount() {
        return this.count;
    }

    public boolean getCounterVisibility() {
        return this.isCounterVisible;
    }


    public void setimg(int img) {
        this.img_expand = img;
    }


    public void setCount(String count) {
        this.count = count;
    }

    public void setCounterVisibility(boolean isCounterVisible) {
        this.isCounterVisible = isCounterVisible;
    }

}
