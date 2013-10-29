/*
   Copyright 2011-2012 Wolfgang Koller - http://www.gofg.at/

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

/**
 * Cordova (Android) plugin for accessing the power-management functions of the device
 * @author Wolfgang Koller <viras@users.sourceforge.net>
 */
package org.apache.cordova.plugin.powermanagement;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class PowerManagement extends CordovaPlugin {
  private PowerManager.WakeLock wakeLock = null;
  private PowerManager powerManager = null;

  /**
   * Fetch a reference to the power-service when the plugin is initialized
   */
  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    this.powerManager = (PowerManager) cordova.getActivity().getSystemService(Context.POWER_SERVICE);
  }

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    PluginResult result = null;
    if(action.equals("acquireWakeLock")){
      result = this.acquireWakeLock( PowerManager.PARTIAL_WAKE_LOCK );
    }else if(action.equals("releaseWakeLock")){
      result = this.releaseWakeLock();
    }
    callbackContext.sendPluginResult(result);
    return true;
  }

  /**
   * Acquire a wake-lock
   * @param p_flags Type of wake-lock to acquire
   * @return PluginResult containing the status of the acquire process
   */
  private PluginResult acquireWakeLock( int p_flags ) {
    PluginResult result = null;

    if (this.wakeLock == null) {
      this.wakeLock = this.powerManager.newWakeLock(p_flags, "PowerManagementPlugin");
      try {
        this.wakeLock.acquire();
        result = new PluginResult(PluginResult.Status.OK);
      }
      catch( Exception e ) {
        this.wakeLock = null;
        result = new PluginResult(PluginResult.Status.ERROR,"Can't acquire wake-lock - check your permissions!");
      }
    }
    else {
      result = new PluginResult(PluginResult.Status.ILLEGAL_ACCESS_EXCEPTION,"WakeLock already active - release first");
    }

    return result;
  }

  /**
   * Release an active wake-lock
   * @return PluginResult containing the status of the release process
   */
  private PluginResult releaseWakeLock() {
    PluginResult result = null;

    if( this.wakeLock != null ) {
      this.wakeLock.release();
      this.wakeLock = null;

      result = new PluginResult(PluginResult.Status.OK, "OK");
    }
    else {
      result = new PluginResult(PluginResult.Status.ILLEGAL_ACCESS_EXCEPTION, "No WakeLock active - acquire first");
    }

    return result;
  }
}