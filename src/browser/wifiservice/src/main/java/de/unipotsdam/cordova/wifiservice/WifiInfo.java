package de.unipotsdam.cordova.wifiservice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WifiInfo {

	private String ssid;

	public WifiInfo() {
	}

	public WifiInfo(String ssid) {
		this.ssid = ssid;
	}

	@JsonProperty("SSID")
	public String getSSID() {
		return ssid;
	}

	public void setSSID(String ssid) {
		this.ssid = ssid;
	}
}
