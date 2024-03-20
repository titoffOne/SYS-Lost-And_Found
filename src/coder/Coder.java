package coder;

import java.nio.charset.StandardCharsets;

public class Coder {
	private Coder() {

	}

	public static String toUTF8(String isoString) {
		byte[] bytes = isoString.getBytes(StandardCharsets.ISO_8859_1);
		return new String(bytes, StandardCharsets.UTF_8);
	}

}
