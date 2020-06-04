package br.com.castgroup.documentverification.utils;

import java.util.Base64;

import br.com.castgroup.documentverification.model.Document;

public class DocumentUtil {

	public static String saveDocumentMsg(Document document) {

		return document == null ? ConstantsUtil.DOCUMENT_FAIL : ConstantsUtil.DOCUMENT_SUCESS;

	}

	public static String decodeDataBase64(String data) {
		Base64.Decoder decoder = Base64.getDecoder();
		return new String(decoder.decode(data.getBytes()));
	}

}
