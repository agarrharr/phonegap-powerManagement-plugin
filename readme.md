# phonegap-powerManagement-plugin

Plugin for Cordova (3.0+)

This code is from https://github.com/phonegap/phonegap-plugins/tree/master/Android/PowerManagement by Wolfgang Koller, edited by Kevin Frey, and put together with the directory structure and plugin.xml file by Adam Harris.

The PowerManagement plugin offers access to the devices power-management functionality.
It should be used for applications which keep running for a long time without any user interaction.

For details on power functionality see:

* Android: [PowerManager](http://developer.android.com/reference/android/os/PowerManager.html)
* iOS: [idleTimerDisabled](http://developer.apple.com/library/ios/documentation/UIKit/Reference/UIApplication_Class/Reference/Reference.html#//apple_ref/occ/instp/UIApplication/idleTimerDisabled)
* WindowsPhone: [UserIdleDetectionMode](http://msdn.microsoft.com/en-US/library/windowsphone/develop/microsoft.phone.shell.phoneapplicationservice.useridledetectionmode%28v=vs.105%29.aspx)

## Installation

Install with the Phonegap CLI:

```bash
phonegap local plugin install https://github.com/aharris88/phonegap-powerManagement-plugin.git
```

Also, make sure that you have the phonegap device plugin installed or it won't work:

```bash
phonegap local plugin install org.apache.cordova.device
```

## Contribution

Feel free to contribute any fixes, updates, or new features. If you notice anything wrong or have any requests, please add an issue.

Possible contributions:

* Add ability to keep wifi awake [#3](/../../issues/3)

## Usage

You might want to set up a variable to keep track of whether or not the wake lock is on:

```js
var wakelocked = false;
```

Then, you can turn on the wake lock like this. Inside the callback function, you can do whatever you want:

```js
powerManagement.acquireWakeLock(function() {
  wakelocked = true;
});
```

Similarly, you can turn off the wake lock:

```js
powerManagement.releaseWakeLock(function() {
  wakelocked = false;
});
```

<a href="https://app.codesponsor.io/link/3owRGftAkghuGdjHaa955zEJ/agarrharr/phonegap-powerManagement-plugin" rel="nofollow"><img src="https://app.codesponsor.io/embed/3owRGftAkghuGdjHaa955zEJ/agarrharr/phonegap-powerManagement-plugin.svg" style="width: 888px; height: 68px;" alt="Sponsor" /></a>
