package br.com.castgroup.documentverification.interfaces;


import br.com.castgroup.documentverification.model.Document;

public interface DocumentService {

	String saveDocument(Document document);
	String compareDocument(long id);

}
