package br.com.castgroup.documentverification.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.castgroup.documentverification.model.Document;
import br.com.castgroup.documentverification.model.DocumentRequestBody;
import br.com.castgroup.documentverification.repositories.DocumentRepository;
import br.com.castgroup.documentverification.services.DocumentServiceImpl;
import br.com.castgroup.documentverification.utils.ConstantsUtilTest;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentControllerTests {

	@Autowired
	private DocumentController documentController;

	@Mock
	private DocumentServiceImpl DocumentServiceImpl;

	@Test
	public void rightDocumentPostTest() {
		Mockito.when(DocumentServiceImpl.saveDocument(new Document(2l, null, ConstantsUtilTest.DOCUMENT_TESTE123)))
				.thenReturn(ConstantsUtilTest.DOCUMENT_SUCESS);

		String resultMessage = this.documentController
				.rightDocumentPost(new DocumentRequestBody(ConstantsUtilTest.DOCUMENT_TESTE123), 2l);

		assertThat(resultMessage, is(ConstantsUtilTest.DOCUMENT_SUCESS));

	}

	@Test
	public void leftDocumentPostTest() {

		Mockito.when(DocumentServiceImpl.saveDocument(new Document(1l, ConstantsUtilTest.DOCUMENT_TESTE, null)))
				.thenReturn(ConstantsUtilTest.DOCUMENT_SUCESS);

		String resultMessage = this.documentController
				.leftDocumentPost(new DocumentRequestBody(ConstantsUtilTest.DOCUMENT_TESTE), 1l);

		assertThat(resultMessage, is(ConstantsUtilTest.DOCUMENT_SUCESS));

	}

	@Test
	public void documentGetPost() {

		Mockito.when(DocumentServiceImpl.findDocument(1l)).thenReturn(new Document());

		String resultMessage = this.documentController.documentGet(1l);

		assertThat(resultMessage, is(ConstantsUtilTest.DOCUMENT_NOT_FOUND));

	}

}
