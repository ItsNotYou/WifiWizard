var browser = require('cordova/platform');
var cordova = require('cordova');

var lastResult = undefined;

function ajax(options) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == XMLHttpRequest.DONE ) {
            if(xmlhttp.status >= 200 && xmlhttp.status <= 299){
                lastResult = JSON.parse(xmlhttp.responseText);
                options.success();
            } else {
                options.error();
            }
        }
    };

    xmlhttp.open("GET", options.url, true);
    xmlhttp.send();
}

function startScan(success, error) {
    var url = "http://localhost:8080/wifiservice/rest/ssids";

    ajax({
        url: url,
        success: function() { success(); }
        error: function() { error(); }
    });
}

function getScanResults(params, success, error) {
    success(lastResult);
}

module.exports = {
    startScan: startScan,
    getScanResults: getScanResults
};

require("cordova/exec/proxy").add("WifiWizard", module.exports);
