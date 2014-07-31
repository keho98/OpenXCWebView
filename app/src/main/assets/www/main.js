deviceReady = false;

function renderData(msg) {
    document.getElementById("speed").innerHTML = msg;
    console.log("Rendering data");
}

document.addEventListener('deviceready', function() {
    deviceReady = true;
    var count = 0;
    document.getElementById("content").innerHTML = "Running cordova version: " + cordova.version;
    function cordovaLoop(m) {
        document.getElementById("logs").innerHTML = count;
        count++;
        renderData(m);
        setTimeout(cordovaLoop, 50);
    }
    /*cordova.exec(cordovaLoop,
    function(e) {
        alert("Error" + e);
    },
    "OpenXCMessage",
    "message",
    []);*/

});
