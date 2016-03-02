package com.example.appxone.neuroapc;

/**
 * Created by APPXONE on 3/2/2016.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter {
    // Declare Variables
    Context context;
    String[] rank;
    String[] country;
    String[] population;
    int[] flag;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, String[] rank) {
        this.context = context;
        this.rank = rank;
        this.country = country;
        this.population = population;
        this.flag = flag;
    }

    @Override
    public int getCount() {
        return rank.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        WebView WEVBIEW;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.webview, container,
                false);

        // Locate the TextViews in viewpager_item.xml
        WEVBIEW = (WebView) itemView.findViewById(R.id.webView);

        WEVBIEW.getSettings().setLoadsImagesAutomatically(true);
        WEVBIEW.getSettings().setJavaScriptEnabled(true);
        WEVBIEW.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        WEVBIEW.loadUrl(rank[position]);

        // Capture position and set to the TextViews
      //  txtrank.setText(rank[position]);


        // Locate the ImageView in viewpager_item.xml

        // Capture position and set to the ImageView
        //imgflag.setImageResource(flag[position]);

        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}