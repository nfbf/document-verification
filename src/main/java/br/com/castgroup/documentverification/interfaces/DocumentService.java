package br.com.castgroup.documentverification.interfaces;

import br.com.castgroup.documentverification.model.Document;

public interface DocumentService {

	public String saveDocument(Document document);

	public String compareDocument(long id);
	
	public Document findDocument(long id);

}
