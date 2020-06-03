package br.com.castgroup.documentverification.utils;

import java.util.Base64;

public class VerifyDocumentUtil {
	
	

	public static String decodeDataBase64(String data) {
		Base64.Decoder decoder = Base64.getDecoder();
		return new String (decoder.decode(data.getBytes()));
	}
	
	
	public static String resultCompareDocument(String compareDocLeft, String compareDocRight ) {
		
		return null;
	}

}
