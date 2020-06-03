package br.com.castgroup.documentverification.interfaces;


import br.com.castgroup.documentverification.model.Document;

public interface DocumentService {

	public void saveDocument(Document document);
	public Document findDocument(Document document);

}
