package br.com.castgroup.documentverification.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.castgroup.documentverification.model.Document;
import br.com.castgroup.documentverification.model.DocumentRequestBody;
import br.com.castgroup.documentverification.services.DocumentServiceImpl;
import br.com.castgroup.documentverification.utils.ConstantsUtil;

@RestController
public class DocumentController {

	@Autowired
	private DocumentServiceImpl documentService;

	@PostMapping(ConstantsUtil.POST_DOCUMENT_RIGHT)
	public String rightDocumentPost(@RequestBody DocumentRequestBody data, @PathVariable long id) {
		return documentService.saveDocument(new Document(id, null, data.getDataJson()));
	}

	@PostMapping(ConstantsUtil.POST_DOCUMENT_LEFT)
	public String leftDocumentPost(@RequestBody DocumentRequestBody data, @PathVariable long id) {
		return documentService.saveDocument(new Document(id, data.getDataJson(), null));
	}

	@GetMapping(ConstantsUtil.GET_DOCUMENT)
	public String documentGet(@PathVariable("id") Long id) {
		return documentService.compareDocument(id);
	}

}
