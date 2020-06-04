package br.com.castgroup.documentverification.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.castgroup.documentverification.interfaces.DocumentService;
import br.com.castgroup.documentverification.model.Document;
import br.com.castgroup.documentverification.repositories.DocumentRepository;
import br.com.castgroup.documentverification.utils.ConstantsUtil;
import br.com.castgroup.documentverification.utils.VerifyDocumentUtil;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	public void saveDocument(Document document) {
		Document searchDocument = findDocument(document.getId());

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

	public String compareDocument(long id) {

		Document compareDocument = findDocument(id);

		if (compareDocument != null) {
			String compareDocLeft = VerifyDocumentUtil.decodeDataBase64(compareDocument.getDocLeft());
			String compareDocRight = VerifyDocumentUtil.decodeDataBase64(compareDocument.getDocRight());

			return VerifyDocumentUtil.resultCompareDocument(id, compareDocLeft, compareDocRight);
		} else {
			return ConstantsUtil.DOCUMENT_NOT_FOUND;
		}
	}

	private Document findDocument(long id) {
		Optional<Document> searchDocument = documentRepository.findById(id);
		return searchDocument.isPresent() ? searchDocument.get() : null;
	}

}
