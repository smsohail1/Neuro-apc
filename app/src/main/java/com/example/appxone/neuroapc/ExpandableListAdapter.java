package com.example.appxone.neuroapc;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by APPXONE on 3/1/2016.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    Typeface typeface;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
    public static ImageView img;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
            typeface = Typeface.createFromAsset(_context.getAssets(), "fonts/AvenirLTStd-Roman.otf");
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);
        txtListChild.setTypeface(typeface);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

//    public class ViewHolder {
//        public RelativeLayout im;
//        public  ImageView img;
//    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        //ViewHolder viewHolder = null;

        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
            //viewHolder = new ViewHolder();
            // viewHolder.im = (RelativeLayout) convertView.findViewById(R.id.layout);
            // viewHolder.img = (ImageView) convertView.findViewById(R.id.icon_right1);
            typeface = Typeface.createFromAsset(_context.getAssets(), "fonts/AvenirLTStd-Roman.otf");
//            convertView.setTag(viewHolder);
        }
//        else {
//
//            viewHolder = (ViewHolder) convertView.getTag();
//        }

//        viewHolder.im.setTag(groupPosition+"");
//        viewHolder.img.setTag(groupPosition+"");
//
//        final ViewHolder finalViewHolder = viewHolder;
//        viewHolder.im.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finalViewHolder.img.setImageResource(R.drawable.icon_minus);
//               // v.getTag();
//            }
//        });

        TextView txt = (TextView) convertView.findViewById(R.id.lblListHeader);
        txt.setTypeface(typeface);
        //  String pos= MainActivity.topsohail.get(groupPosition);
        int imageResourceId = isExpanded ? R.drawable.icon_minus
                : R.drawable.icon_plus;
        img = (ImageView) convertView.findViewById(R.id.icon_right1);
        if (groupPosition == 0) {
            img.setImageResource(imageResourceId);
        } else if (groupPosition == 12) {
            img.setImageResource(imageResourceId);

        } else if (groupPosition == 13) {
            img.setImageResource(imageResourceId);

        } else if (groupPosition == 14) {
            img.setImageResource(imageResourceId);

        }
        else
        {
            img.setImageResource(R.drawable.icon_forward);
        }
//if(groupPosition==0)
//{
//    img.setImageResource(R.drawable.ic_launcher);
//}
//        else if(groupPosition==12)
//{
//    img.setImageResource(R.drawable.ic_launcher);
//}
//else if(groupPosition==13)
//{
//    img.setImageResource(R.drawable.ic_launcher);
//}
//else if(groupPosition==14)
//{
//    img.setImageResource(R.drawable.ic_launcher);
//}
//        if(isExpanded && pos=="0")
//        {
//            int imageResourceId1 = isExpanded ?  R.drawable.ic_launcher
//                    : R.drawable.ic_launcher;
//            img.setImageResource(imageResourceId1);
//        }
//        else if(isExpanded && pos=="12")
//        {
//            int imageResourceId2 = isExpanded ?  R.drawable.ic_launcher
//                    : R.drawable.ic_launcher;
//            img.setImageResource(imageResourceId2);
//        }
//        else if(isExpanded && pos=="13")
//        {
//            int imageResourceId3 = isExpanded ?  R.drawable.ic_launcher
//                    : R.drawable.ic_launcher;
//            img.setImageResource(imageResourceId3);
//        }
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        //  lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        // img.setImageResource(imageResourceId);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}