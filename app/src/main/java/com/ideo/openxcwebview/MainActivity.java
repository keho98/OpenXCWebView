package com.ideo.openxcwebview;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.apache.cordova.Config;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends Activity implements CordovaInterface {

    CordovaWebView cwv;
    private final ExecutorService mThreadPool = Executors.newCachedThreadPool();

    /* Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cwv = (CordovaWebView) findViewById(R.id.openxc_web_view);
        Config.init(this);
        hideActionBar();
        cwv.loadUrl(Config.getStartUrl());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void startActivityForResult(org.apache.cordova.CordovaPlugin cordovaPlugin, android.content.Intent intent, int i) {

    }

    public void setActivityResultCallback(org.apache.cordova.CordovaPlugin cordovaPlugin) {

    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public Object onMessage(String s, Object o) {
        return null;
    }

    @Override
    public ExecutorService getThreadPool() {
        return mThreadPool;
    }

    private void hideActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.hide();
    }
}


