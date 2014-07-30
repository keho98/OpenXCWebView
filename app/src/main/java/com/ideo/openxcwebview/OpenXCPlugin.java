package com.ideo.openxcwebview;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

class OpenXCPlugin extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("OpenXCMessage")) {
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