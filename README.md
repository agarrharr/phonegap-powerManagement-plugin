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

Contribution
---------
Feel free to contribute any fixes, updates, or new features. If you notice anything wrong or have any requests, please add an issue.

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

License from 
=======
Copyright (C) 2011-2013 Wolfgang Koller

This file is part of GOFG Sports Computer - http://www.gofg.at/.

GOFG Sports Computer is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

GOFG Sports Computer is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with GOFG Sports Computer.  If not, see <http://www.gnu.org/licenses/>.