package de.unipotsdam.cordova.wifiservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class WifiReader {

	public String[] readWifis() throws IOException {
		InputStream input = startNetsh();
		String[] lines = readLines(input);
		String[] ssids = filterSsids(lines);
		return ssids;
	}

	private InputStream startNetsh() throws IOException {
		String[] startCommand = { "netsh", "wlan", "show", "network" };
		Process process = Runtime.getRuntime().exec(startCommand);
		return process.getInputStream();
	}

	private String[] readLines(InputStream input) {
		ArrayList<String> result = new ArrayList<String>(100);

		Scanner scanner = new Scanner(input, "UTF-8");
		try {
			scanner.useDelimiter("\r\n");
			while (scanner.hasNext()) {
				result.add(scanner.next());
			}
		} finally {
			scanner.close();
		}

		return result.toArray(new String[0]);
	}

	private String[] filterSsids(String[] lines) {
		ArrayList<String> result = new ArrayList<String>();

		for (String line : lines) {
			if (line.startsWith("SSID ")) {
				int start = line.indexOf(" : ");
				String ssid = line.substring(start + 3);
				result.add(ssid);
			}
		}

		return result.toArray(new String[0]);
	}
}
