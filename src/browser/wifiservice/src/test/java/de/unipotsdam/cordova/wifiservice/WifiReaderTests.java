package de.unipotsdam.cordova.wifiservice;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class WifiReaderTests {

	private WifiReader sut;

	@Before
	public void before() {
		sut = new WifiReader();
	}

	@Test
	public void shouldListWifis() throws IOException {
		WifiInfo[] wifis = sut.readWifis();
		for (WifiInfo wifi : wifis) {
			System.out.println(wifi.getSSID());
		}
	}
}
