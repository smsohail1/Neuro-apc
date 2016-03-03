package com.example.appxone.neuroapc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by APPXONE on 3/2/2016.
 */
public class Toc_discription extends ActionBarActivity implements ViewPager.OnPageChangeListener {
    String[] viewpager_disc;
    ViewPagerAdapter pageAdapter;
    ImageView back;
    HashMap<String, String> list_items, list_full;

    ViewPager viewPager;
    PagerAdapter adapter;
    SharedPreferences preferences;
    int ret_pos;
    int group, child;
    TextView Header_title;
    Typeface typeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.headcarnial);
        Header_title = (TextView) findViewById(R.id.Header_title);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/AvenirLTStd-Roman.otf");
        Header_title.setTypeface(typeface);

//        preferences = getSharedPreferences("position_item", Context.MODE_PRIVATE);
//
//        ret_pos=  preferences.getInt("listposition", 0);

        group = getIntent().getExtras().getInt("position_group", 0);


        child = getIntent().getExtras().getInt("position_child", 0);

        Log.e("after", String.valueOf(group));
        Log.e("after", String.valueOf(child));


        back = (ImageView) findViewById(R.id.back);
        getSupportActionBar().hide();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toc_discription.this.finish();
            }
        });

//        WebView webView = (WebView) findViewById(R.id.webView);
//        webView.getSettings().setLoadsImagesAutomatically(true);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//        webView.loadUrl("file:///android_asset/1.0.html");
//        webView.loadUrl("file:///android_asset/1.1.html");
//
//        webView.loadUrl("file:///android_asset/2.0.html");
//
//        webView.loadUrl("file:///android_asset/3.0.html");
//
//        webView.loadUrl("file:///android_asset/4.0.html");
//
//        webView.loadUrl("file:///android_asset/5.0.html");
//
//        webView.loadUrl("file:///android_asset/6.0.html");
//
//        webView.loadUrl("file:///android_asset/7.0.html");
//
//        webView.loadUrl("file:///android_asset/8.0.html");
//
//        webView.loadUrl("file:///android_asset/9.0.html");
//
//        webView.loadUrl("file:///android_asset/10.0.html");
//
//        webView.loadUrl("file:///android_asset/11.0.html");
//
//        webView.loadUrl("file:///android_asset/12.0.html");
//
//        webView.loadUrl("file:///android_asset/13.0.html");
//
//        webView.loadUrl("file:///android_asset/13.1.html");
//
//        webView.loadUrl("file:///android_asset/14.0.html");
//
//        webView.loadUrl("file:///android_asset/14.1.html");
//        webView.loadUrl("file:///android_asset/14.2.html");
//
//        webView.loadUrl("file:///android_asset/14.3.html");
//
//        webView.loadUrl("file:///android_asset/15.0.html");
//        webView.loadUrl("file:///android_asset/15.1.html");
//
//        webView.loadUrl("file:///android_asset/16.0.html");
//
//        webView.loadUrl("file:///android_asset/17.0.html");
//
//        webView.loadUrl("file:///android_asset/18.0.html");
//
//        webView.loadUrl("file:///android_asset/A_1.html");
//        webView.loadUrl("file:///android_asset/A_2.html");
//        webView.loadUrl("file:///android_asset/A_3.html");
//        webView.loadUrl("file:///android_asset/A_4.html");


        list_items = new HashMap<>();
        list_full = new HashMap<>();
        //list_items.put("Neurologic Examination","0");

//        list_items.put("file:///android_asset/1.1.html","0");
        list_items.put("Head,Carnial Nerves", "0");
        list_items.put("Muscles and Motor Functions", "1");
        list_items.put("Cutaneous Nerves,Dermatomes", "2");
        list_items.put("SLUMS Mental Status Exam", "3");
        list_items.put("Glasgow Coma Scale", "4");
        list_items.put("Impaired Consciousness", "5");
        list_items.put("Subatachnoid Hemorrhage", "6");
        list_items.put("Parkinson Scale", "7");
        list_items.put("MS Kurtzke Scale", "8");
        list_items.put("Cerebrospinal Fluid", "9");
        list_items.put("CSF/Serum Ratio", "10");
        list_items.put("Ocular Muscles, Innervation", "11");

        list_items.put("Ocular Movement Disorders", "12");

        // list_items.put("Muscles and their Innervation","14");

        list_items.put("Upper Extremities", "13");
        list_items.put("Lower Extremities", "14");

        //  list_items.put("Cerebal Hemispheres","17");
        list_items.put("Vascular Territories", "15");

        list_items.put("Cerebral Arteries", "16");
        list_items.put("Cerebral Veins", "17");

        list_items.put("Neuroanatomy of Brain", "18");

        list_items.put("Neuroanatomy of Brain", "19");

        list_items.put("Neuroanatomy  of Spinal Cord", "20");
        list_items.put("Nerves of Upper Extremity", "21");

        list_items.put("Nerves of Lower Extremity", "22");

        list_items.put("Cutaneous of Nerves, Upper Extr.", "23");


        viewpager_disc = new String[]{"file:///android_asset/1.0.html",
                "file:///android_asset/1.1.html",

                "file:///android_asset/2.0.html",

                "file:///android_asset/3.0.html",
                "file:///android_asset/4.0.html",


                "file:///android_asset/5.0.html",

                "file:///android_asset/6.0.html",

                "file:///android_asset/7.0.html",

                "file:///android_asset/8.0.html",

                "file:///android_asset/9.0.html",

                "file:///android_asset/10.0.html",

                "file:///android_asset/11.0.html",

                "file:///android_asset/12.0.html",

                "file:///android_asset/13.0.html",
                "file:///android_asset/13.1.html",
                "file:///android_asset/14.0.html",
                "file:///android_asset/14.1.html",
                "file:///android_asset/14.2.html",
                "file:///android_asset/14.3.html",
                "file:///android_asset/15.0.html",
                "file:///android_asset/15.1.html",
                "file:///android_asset/16.0.html",
                "file:///android_asset/17.0.html",
                "file:///android_asset/18.0.html"

        };

        String[][] list_it = new String[500][200];
        list_it[0][0] = "0";


        list_full.put("Neurologic Examination","0");
        list_full.put("Head,Carnial Nerves","1");
        list_full.put("Muscles and Motor Functions","2");
        list_full.put("Cutaneous Nerves,Dermatomes","3");
        list_full.put("SLUMS Mental Status Exam","4");
        list_full.put("Glasgow Coma Scale","5");
        list_full.put("Impaired Consciousness","6");
        list_full.put("Subatachnoid Hemorrhage","7");
        list_full.put("Parkinson Scale","8");
        list_full.put("MS Kurtzke Scale","9");
        list_full.put("Cerebrospinal Fluid","10");
        list_full.put("CSF/Serum Ratio","12");
        list_full.put("Ocular Muscles, Innervation","12");

        list_full.put("Ocular Movement Disorders","13");

        list_full.put("Muscles and their Innervation","14");

        // list_items.put("Muscles and their Innervation","14");

        list_full.put("Upper Extremities","15");
        list_full.put("Lower Extremities","16");

        list_full.put("Cerebal Hemispheres","17");
        //  list_items.put("Cerebal Hemispheres","17");
        list_full.put("Vascular Territories","18");

        list_full.put("Cerebral Arteries","19");
        list_full.put("Cerebral Veins","20");

        list_full.put("Neuroanatomy","21");
        list_full.put("Neuroanatomy of Brain","22");

        list_full.put("Neuroanatomy of Spinal Cord","23");

        list_full.put("Nerves of Upper Extremity","24");

        list_full.put("Nerves of Lower Extremity","25");

        list_full.put("Cutaneous of Nerves, Upper Extr.","26");


        viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(Toc_discription.this, viewpager_disc);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);

//        if(child==-1) {
        if ((group == 0 && (child == 0 || child == 1))) {
            viewPager.setCurrentItem(child);
        } else if (group == 14 && (child == 0 || child == 1)) {
            if (child == 0) {
                viewPager.setCurrentItem(group + 5);
            } else if (child == 1) {
                viewPager.setCurrentItem(group + 6);
            }

        } else if (group == 13 && (child == 0 || child == 1 || child == 2)) {

            if (child == 0) {
                viewPager.setCurrentItem(group + 2);
            } else if (child == 1) {
                viewPager.setCurrentItem(group + 3);
            } else if (child == 2) {
                viewPager.setCurrentItem(group + 4);
            }

            // viewPager.setCurrentItem(group+1);
        } else if (group == 12 && (child == 0 || child == 1)) {
            if (child == 0) {
                viewPager.setCurrentItem(group + 1);
            } else if (child == 1) {
                viewPager.setCurrentItem(group + 2);
            }
        } else if (group == 15) {
            viewPager.setCurrentItem(group + 6);
        } else if (group == 16) {
            viewPager.setCurrentItem(group + 6);
        } else if (group == 17) {
            viewPager.setCurrentItem(group + 7);
        } else {
            viewPager.setCurrentItem(group + 1);
        }

        //}
//        else
//        {
        // viewPager.setCurrentItem(child);
        //  }
//        for (Map.Entry<String, String> entry1 : list_items.entrySet()) {
//
//            //     String str = String.valueOf(et.getText().toString().toCharArray()[count1]);
//            //  CharSequence char_sequence=(CharSequence) str;
//
//            if (entry1.getValue().equalsIgnoreCase(String.valueOf(group))) {
//                String    get_key = entry1.getKey().toString();
//                Header_title.setText(get_key.toString());
//
//
//            }
//
//        }

//        Toast y = Toast.makeText(Toc_discription.this, group + " group", Toast.LENGTH_SHORT);
//        y.show();
//
//        Toast y1 = Toast.makeText(Toc_discription.this, child + " child", Toast.LENGTH_SHORT);
//        y1.show();

        //  List<Fragment> fragments = getFragments();
        // pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        //ViewPager pager =
        //   (ViewPager)findViewById(R.id.pager);
        //  pager.setAdapter(pageAdapter);


        // viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
//        adapter = new ViewPagerAdapter(Toc_discription.this, rank);
//        // Binds the Adapter to the ViewPager
//        viewPager.setAdapter(adapter);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {


        for (Map.Entry<String, String> entry1 : list_items.entrySet()) {

            //     String str = String.valueOf(et.getText().toString().toCharArray()[count1]);
            //  CharSequence char_sequence=(CharSequence) str;
//            if(position==18)
//            {
//                Header_title.setText("Neuroanatomy of brain");
//                viewPager.setCurrentItem(position+1);
//
//            }

                if (entry1.getValue().equalsIgnoreCase(String.valueOf(position))) {
                    String get_key = entry1.getKey().toString();
                    Header_title.setText(get_key.toString());


                }

        }
//        Toast y = Toast.makeText(Toc_discription.this, String.valueOf(position), Toast.LENGTH_SHORT);
//        y.show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toc_discription.this.finish();
    }
    //    @Override
//    public void onPageScrolled(int i, float v, int i1) {
//
//    }
//
//    @Override
//    public void onPageSelected(int i) {
//
//        Toast y=Toast.makeText(Toc_discription.this,"sds",Toast.LENGTH_SHORT);
//        y.show();
////        mPager = (ViewPager)findViewById(R.id.pager);
////        ((TestFragmentAdapter)mPager.getAdapter()).set_current_position(i);
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }
}
