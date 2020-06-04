package br.com.castgroup.documentverification.utils;

import java.util.Base64;

public class VerifyDocumentUtil {

	public static String decodeDataBase64(String data) {
		Base64.Decoder decoder = Base64.getDecoder();
		return new String(decoder.decode(data.getBytes()));
	}

	public static String resultCompareDocument(long id, String compareDocLeft, String compareDocRight) {

		if (compareDocLeft.equals(compareDocRight)) {
			return "Documentos " + id + " idênticos";
		} else if (compareDocLeft.length() != compareDocRight.length()) {
			return "Documentos " + id + " com tamanhos diferentes";
		} else {
			for (int i = 0; i < compareDocLeft.length(); i++) {
				if (compareDocLeft.charAt(i) != compareDocRight.charAt(i)) {
					return "Os documentos se diferem a partir da posição " + String.valueOf(i);
				}
			}
			return "Os documetos não sastifazem as condições previstas.";
		}
	}

}
