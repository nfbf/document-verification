package br.com.castgroup.documentverification.utils;


import br.com.castgroup.documentverification.model.Document;

public class VerifyDocumentUtil {
	
	
	public static Document newDocument(long id, String data, String position) {
		
		
		
		if (position.equals(ConstantsUtil.LEFT)) {
			return new Document(id, data, null);
		} else if (position.equals(ConstantsUtil.RIGHT)) {
			return new Document(id, null, data);
		} else {
			return null;
		}
	}
	
	

	

}
