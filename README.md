phonegap-powerManagement-plugin
===============================
Plugin for Cordova (3.0+)

This code is from https://github.com/phonegap/phonegap-plugins/tree/master/Android/PowerManagement by Wolfgang Koller, edited by Kevin Frey, and put together with the directory structure and plugin.xml file by Adam Harris.

The PowerManagement plugin offers access to the devices power-management functionality.
It should be used for applications which keep running for a long time without any user interaction.

For details on power functionality see:

* Android: [PowerManager](http://developer.android.com/reference/android/os/PowerManager.html)
* iOS: [idleTimerDisabled](http://developer.apple.com/library/ios/documentation/UIKit/Reference/UIApplication_Class/Reference/Reference.html#//apple_ref/occ/instp/UIApplication/idleTimerDisabled)
* WindowsPhone: [UserIdleDetectionMode](http://msdn.microsoft.com/en-US/library/windowsphone/develop/microsoft.phone.shell.phoneapplicationservice.useridledetectionmode%28v=vs.105%29.aspx)

Installation
---------
Install with the Phonegap CLI:

    phonegap local plugin install https://github.com/aharris88/phonegap-powerManagement-plugin.git

Also, make sure that you have the phonegap device plugin installed or it won't work:

    phonegap local plugin install org.apache.cordova.device

Contribution
---------
Feel free to contribute any fixes, updates, or new features. If you notice anything wrong or have any requests, please add an issue.

Possible contributions:
* Add ability to keep wifi awake [#3](/../../issues/3)

Usage
---------

You might want to set up a variable to keep track of whether or not the wake lock is on:

    var wakelocked = false;

Then, you can turn on the wake lock like this. Inside the callback function, you can do whatever you want:

    powerManagement.acquireWakeLock(function() {
        wakelocked = true;
    });

Similarly, you can turn off the wake lock:

    powerManagement.releaseWakeLock(function() {
        wakelocked = false;
    });

License
---------
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
