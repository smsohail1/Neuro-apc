package com.example.appxone.neuroapc;

/**
 * Created by APPXONE on 1/18/2016.
 */
public class CalculatorModel {

    private String text;

    private String count = "0";

    private int img;

    private boolean isCounterVisible = false;

    public CalculatorModel() {
    }

    public CalculatorModel(String text, int img
    ) {

        this.text = text;
        this.img = img;


    }


    public CalculatorModel(String text, int img
            , boolean isCounterVisible, String count

    ) {

        this.text = text;
        this.img = img;


        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }


    public int getimg() {
        return this.img;
    }

    public String gettext() {
        return this.text;
    }

    public void settext(String text) {
        this.text = text;
    }


    public String getCount() {
        return this.count;
    }

    public boolean getCounterVisibility() {
        return this.isCounterVisible;
    }


    public void setimg(int img) {
        this.img = img;
    }


    public void setCount(String count) {
        this.count = count;
    }

    public void setCounterVisibility(boolean isCounterVisible) {
        this.isCounterVisible = isCounterVisible;
    }

}
