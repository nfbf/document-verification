package br.com.castgroup.documentverification.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.castgroup.documentverification.interfaces.DocumentService;
import br.com.castgroup.documentverification.model.Document;
import br.com.castgroup.documentverification.repositories.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	public void saveDocument(Document document) {
		Document searchDocument = findDocument(document);

		if (searchDocument == null) {
			documentRepository.save(document);
		} else {
			if (document.getDocLeft() == null) {
				searchDocument.setDocRight(document.getDocRight());
			} else {
				searchDocument.setDocLeft(document.getDocLeft());
			}
			documentRepository.save(searchDocument);
		}

	}

	private Document findDocument(Document document) {
		Optional<Document> searchDocument = documentRepository.findById(document.getId());
		return searchDocument.isPresent() ? searchDocument.get() : null;
	}
	
	public String compareDocument (long id) {
		
		return null;
	}
	
	
	

}
