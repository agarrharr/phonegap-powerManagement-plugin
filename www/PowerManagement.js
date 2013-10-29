var powerManagement = {
  acquireWakeLock: function(callback) {
    try{
      if(wakelocked === false && device.platform.match(/^android/gi)){
        cordova.exec(
          function(){
            if(typeof(callback) == "function"){
              callback();
            }
          },
          function(err) {
            // Do nothing....
          },
          "PowerManagement",
          "acquireWakeLock",
          []
        );
      }
    } catch(e){
      // catch the error to prevent breakage, though we don't do anything
    }
  },
  releaseWakeLock: function() {
    try {
      if(wakelocked === true && device.platform.match(/^android/gi)){
        cordova.exec(
          function(){
            if(typeof(callback) == "function"){
              callback();
            }
          },
          function(err) {
            // Do nothing....
          },
          "PowerManagement",
          "releaseWakeLock",
          []
        );
      }
    } catch(e){
     // catch the error to prevent breakage, though we don't do anything
    }
  }
};

module.exports = powerManagement;