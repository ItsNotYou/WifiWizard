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
		String[] wifis = sut.readWifis();
		for (String ssid : wifis) {
			System.out.println(ssid);
		}
	}
}
