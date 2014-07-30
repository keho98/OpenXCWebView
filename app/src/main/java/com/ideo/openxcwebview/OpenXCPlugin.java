package com.ideo.openxcwebview;

import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

class OpenXCPlugin extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.i("OPENXCPLUGIN", action);
        if(action.equals("message")) {
            MainActivity activity = (MainActivity) cordova.getActivity();
            sendOpenSCMessage(activity.getEngineSpeed(), callbackContext);
            return true;
        }
        return false;
    }

    private void sendOpenSCMessage(String message, CallbackContext callbackContext) {
        if(message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Error in processing");
        }
    }
}