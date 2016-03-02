package com.example.appxone.neuroapc;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by APPXONE on 3/2/2016.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Oncreate extends Fragment {

    WebView webview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View view=inflater.inflate(R.layout.webview, container,false);
       webview= (WebView) view.findViewById(R.id.webView);

        return  view;
       // return super.onCreateView(inflater, container, savedInstanceState);
    }
}
