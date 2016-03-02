package com.example.appxone.neuroapc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    List<String> topsohail;
    Typeface typeface;

    public List<Expandmodel> calculatormodel;
    ImageView back;
    SharedPreferences sharedpreferences, sharedpreferences_expand;
    SharedPreferences.Editor editor, editor_expand;

    HashMap<String, String> list_items;
    TextView title;
Button about_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        title = (TextView) findViewById(R.id.title_main);
//        about_button= (Button) findViewById(R.id.about_button);
//        about_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//Intent intent=new Intent(MainActivity.this,Aboutus.class);
//                startActivity(intent);
//            }
//        });
        typeface = Typeface.createFromAsset(getAssets(), "fonts/AvenirLTStd-Roman.otf");
        title.setTypeface(typeface);
//        list_items=new HashMap<>();
//        list_items.put("Head,Carnial Nerves","0");
//        list_items.put("Muscles and Motor Functions","1");
//        list_items.put("Cutaneous Nerves,Dermatomes","2");
//        list_items.put("SLUMS Mental Status Exam","3");
//        list_items.put("Glasgow Coma Scale","4");
//        list_items.put("Impaired Consciousness","5");
//        list_items.put("Subatachnoid Hemorrhage","6");
//        list_items.put("Parkinson Scale","7");
//        list_items.put("MS Kurtzke Scale","8");
//        list_items.put("Cerebrospinal Fluid","9");
//        list_items.put("CSF/Serum Ratio","10");
//        list_items.put("Ocular Muscles, Innervation","11");
//
//        list_items.put("Ocular Movement Disorders","12");
//
//        // list_items.put("Muscles and their Innervation","14");
//
//        list_items.put("Upper Extremities","13");
//        list_items.put("Lower Extremities","14");
//
//        //  list_items.put("Cerebal Hemispheres","17");
//        list_items.put("Vascular Territories","15");
//
//        list_items.put("Cerebral Arteries","16");
//        list_items.put("Cerebral Veins","17");
//
//        list_items.put("Neuroanatomy of Brain","18");
//
//        list_items.put("Neuroanatomy of Spinal Cord","19");
//
//        list_items.put("Nerves of Upper Extremity","21");
//
//        list_items.put("Nerves of Lower Extremity","22");
//
//        list_items.put("Cutaneous of Nerves, Upper Extr.","23");


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
//typeface=Typeface.createFromAsset(getAssets(),"");

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        expListView.setOnGroupClickListener(new OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

//                sharedpreferences = getSharedPreferences("position_item", Context.MODE_PRIVATE);
//                editor = sharedpreferences.edit();
//                editor.putInt("listposition", groupPosition);
//                //editor.putString("listposition", groupPosition);
//                editor.apply();
//                Log.e("before",String.valueOf(groupPosition));

                //  int groupostion=groupPosition;
                if (groupPosition != 0 && groupPosition != 12 && groupPosition != 13 && groupPosition != 14) {
                    Intent mIntent = new Intent(MainActivity.this, Toc_discription.class);
                    Bundle mBundle = new Bundle();
                    mBundle.putInt("position_group", groupPosition);
                    mBundle.putInt("position_child", -1);
                    //mBundle.putString("position_group", );
                    mIntent.putExtras(mBundle);
                    startActivity(mIntent);
                }
//                Intent i = new Intent(MainActivity.this, Toc_discription.class);
//                startActivity(i);
//                if(groupPosition==0) {
//                    ExpandableListAdapter.img.setImageResource(R.drawable.ic_launcher);
//                }
//                else if(groupPosition==12)
//                {
//                    ExpandableListAdapter.img.setImageResource(R.drawable.ic_launcher);
//
//                }
//                else if(groupPosition==13)
//                {
//                    ExpandableListAdapter.img.setImageResource(R.drawable.ic_launcher);
//
//                }
//                else if(groupPosition==14)
//                {
//                    ExpandableListAdapter.img.setImageResource(R.drawable.ic_launcher);
//
//                }
                return false;
            }
        });
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

//                sharedpreferences_expand = getSharedPreferences("position_expand", Context.MODE_PRIVATE);
//                editor_expand = sharedpreferences_expand.edit();
//                editor_expand.putInt("listposition_expand", groupPosition);
//                //editor.putString("listposition", groupPosition);
//                editor_expand.apply();

                Intent mIntent = new Intent(MainActivity.this, Toc_discription.class);
                Bundle mBundle = new Bundle();
                mBundle.putInt("position_group", groupPosition);
                mBundle.putInt("position_child", childPosition);
                //mBundle.putString("position_group", );
                mIntent.putExtras(mBundle);
                startActivity(mIntent);

                //Intent i = new Intent(MainActivity.this, Toc_discription.class);
                //startActivity(i);
//                if (groupPosition == 0 && childPosition == 0) {
//
//                } else if (groupPosition == 0 && childPosition == 1) {
//
//                }
//
//                else if (groupPosition == 1) {
//
//                }
//
//                else if (groupPosition == 2) {
//
//                }
//
//                else if (groupPosition == 3) {
//
//                }


//                Toast.makeText(
//                        getApplicationContext(),
//                        listDataHeader.get(groupPosition)
//                                + " : "
//                                + listDataChild.get(
//                                listDataHeader.get(groupPosition)).get(
//                                childPosition), Toast.LENGTH_SHORT)
//                        .show();
                return false;
            }
        });


        // Listview Group expanded listener
//        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
//
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Expanded",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        calculatormodel = new ArrayList<>();
        // Adding child data
        listDataHeader.add("Neurologic Examination");
        listDataHeader.add("Cutaneous Nerves,Dermatomes");
        listDataHeader.add("SLUMS Mental Status Exam");
        listDataHeader.add("Glasgow Coma Scale");
        listDataHeader.add("Impaired Consciousness");

        listDataHeader.add("Subatachnoid Hemorrhage");

        listDataHeader.add("Parkinson Scale");

        listDataHeader.add("MS Kurtzke Scale");

        listDataHeader.add("Cerebrospinal Fluid");

        listDataHeader.add("CSF/Serum Ratio");

        listDataHeader.add("Ocular Muscles, Innervation");

        listDataHeader.add("Ocular Movement Disorders");

        listDataHeader.add("Muscles and their Innervation");

        listDataHeader.add("Cerebal Hemispheres");


        listDataHeader.add("Neuroanatomy");

        listDataHeader.add("Nerves of Upper Extremity");

        listDataHeader.add("Nerves of Lower Extremity");
        listDataHeader.add("Cutaneous of Nerves, Upper Extr.");


//        calculatormodel.add(new Expandmodel("Neurologic Examination",R.drawable.icon_forward));
//        calculatormodel.add(new Expandmodel("Cutaneous Nerves,Dermatomes",R.drawable.icon_forward));
//        calculatormodel.add(new Expandmodel("SLUMS Mental Status Exam",R.drawable.icon_forward));
//        calculatormodel.add(new  Expandmodel("Glasgow Coma Scale",R.drawable.icon_forward));

        // Adding child data
        List<String> neurologic_expand_list = new ArrayList<String>();
        neurologic_expand_list.add("Head,Carnial Nerves");
        neurologic_expand_list.add("Muscles and Motor Functions");

        List<String> muscles_innervation_expand_list = new ArrayList<String>();
        muscles_innervation_expand_list.add("Upper Extremities");
        muscles_innervation_expand_list.add("Lower Extremities");

        List<String> cerevral_hemishperes_expand_list = new ArrayList<String>();
        cerevral_hemishperes_expand_list.add("Vascular Territories");
        cerevral_hemishperes_expand_list.add("Cerebral Arteries");
        cerevral_hemishperes_expand_list.add("Cerebral Veins");


        List<String> neuroanatomy_expand_list = new ArrayList<String>();
        neuroanatomy_expand_list.add("Neuroanatomy of Brain");
        neuroanatomy_expand_list.add("Neuroanatomy of Spinal Cord");


        topsohail = new ArrayList<String>();

        listDataChild.put(listDataHeader.get(0), neurologic_expand_list); // Header, Child data
        listDataChild.put(listDataHeader.get(1), topsohail);
        listDataChild.put(listDataHeader.get(2), topsohail);
        listDataChild.put(listDataHeader.get(3), topsohail);
        listDataChild.put(listDataHeader.get(4), topsohail);
        listDataChild.put(listDataHeader.get(5), topsohail);
        listDataChild.put(listDataHeader.get(6), topsohail);
        listDataChild.put(listDataHeader.get(7), topsohail);
        listDataChild.put(listDataHeader.get(8), topsohail);
        listDataChild.put(listDataHeader.get(9), topsohail);
        listDataChild.put(listDataHeader.get(10), topsohail);
        listDataChild.put(listDataHeader.get(11), topsohail);


        listDataChild.put(listDataHeader.get(12), muscles_innervation_expand_list);
        listDataChild.put(listDataHeader.get(13), cerevral_hemishperes_expand_list);
        listDataChild.put(listDataHeader.get(14), neuroanatomy_expand_list);
        listDataChild.put(listDataHeader.get(15), topsohail);

        listDataChild.put(listDataHeader.get(16), topsohail);

        listDataChild.put(listDataHeader.get(17), topsohail);

    }


}