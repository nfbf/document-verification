package br.com.castgroup.documentverification.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.castgroup.documentverification.interfaces.DocumentService;
import br.com.castgroup.documentverification.model.Document;
import br.com.castgroup.documentverification.repositories.DocumentRepository;
import br.com.castgroup.documentverification.utils.ConstantsUtil;
import br.com.castgroup.documentverification.utils.DocumentUtil;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	public String saveDocument(Document document) {

		Document searchDocument = findDocument(document.getId());

		if (searchDocument == null)
			return DocumentUtil.saveDocumentMsg(documentRepository.save(document));
		else
			return DocumentUtil.saveDocumentMsg(documentRepository.save(updateDocument(document)));

	}

	public String compareDocument(long id) {

		Document compareDocument = findDocument(id);

		if (compareDocument != null) {
			String compareDocLeft = DocumentUtil.decodeDataBase64(compareDocument.getDocLeft());
			String compareDocRight = DocumentUtil.decodeDataBase64(compareDocument.getDocRight());

			return resultCompareDocument(id, compareDocLeft, compareDocRight);

		} else {
			return ConstantsUtil.DOCUMENT_NOT_FOUND;
		}
	}

	private Document findDocument(long id) {
		Optional<Document> searchDocument = documentRepository.findById(id);
		return searchDocument.isPresent() ? searchDocument.get() : null;
	}

	private Document updateDocument(Document document) {
		Document searchDocument = findDocument(document.getId());
		if (document.getDocLeft() == null)
			searchDocument.setDocRight(document.getDocRight());
		else
			searchDocument.setDocLeft(document.getDocLeft());

		return searchDocument;
	}

	private String resultCompareDocument(long id, String compareDocLeft, String compareDocRight) {

		if (compareDocLeft.equals(compareDocRight))
			return "Documentos " + id + " idênticos";
		else if (compareDocLeft.length() != compareDocRight.length())
			return "Documentos " + id + " com tamanhos diferentes";
		else
			return documentDiffOffSet(compareDocLeft, compareDocRight);

	}

	private String documentDiffOffSet(String compareDocLeft, String compareDocRight) {
		for (int i = 0; i < compareDocLeft.length(); i++) {
			if (compareDocLeft.charAt(i) != compareDocRight.charAt(i)) {
				return "Os documentos se diferem a partir da posição: " + String.valueOf(i);
			}
		}
		return "Os documetos não sastifazem a condição prevista.";
	}

}
