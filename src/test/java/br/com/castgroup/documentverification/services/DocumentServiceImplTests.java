package br.com.castgroup.documentverification.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.castgroup.documentverification.model.Document;
import br.com.castgroup.documentverification.repositories.DocumentRepository;
import br.com.castgroup.documentverification.utils.ConstantsUtilTest;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class DocumentServiceImplTests {

	@Mock
	private DocumentRepository documentRepository;

	@InjectMocks
	private DocumentServiceImpl documentServiceImpl;

	
	private static final String IDENTICALS_DOCUMENTS = "Documentos 1 idênticos";
	private static final String DIFF_LENGTH_DOCUMENTS = "Documentos 2 com tamanhos diferentes";
	private static final String DIFF_OFF_SET_DOCUMENTS = "Os documentos se diferem a partir da posição: 5";

	@Test
	public void saveDocumentTestSucess() {

		Mockito.when(documentRepository.findById(2l)).thenReturn(null);
		Mockito.when(documentRepository.save(any(Document.class)))
				.thenReturn(new Document(2l, ConstantsUtilTest.DOCUMENT_TESTE, ConstantsUtilTest.DOCUMENT_TESTE));

		String messageResult = documentServiceImpl.saveDocument(new Document(2l, ConstantsUtilTest.DOCUMENT_TESTE, ConstantsUtilTest.DOCUMENT_TESTE));

		assertThat(messageResult, is(ConstantsUtilTest.DOCUMENT_SUCESS));

	}

	@Test
	public void saveDocumentTestFail() {

		Mockito.when(documentRepository.findById(3l)).thenReturn(null);
		Mockito.when(documentRepository.save(any(Document.class))).thenReturn(new Document());

		String messageResult = documentServiceImpl.saveDocument(new Document());

		assertThat(messageResult, is(ConstantsUtilTest.DOCUMENT_FAIL));

	}

	@Test
	public void updateDocumentLeftTestSucess() {

		Mockito.when(documentRepository.findById(2l)).thenReturn(new Document(2l, ConstantsUtilTest.DOCUMENT_TESTE, null));
		Mockito.when(documentRepository.save(any(Document.class))).thenReturn(new Document(2l, ConstantsUtilTest.DOCUMENT_TESTE, null));

		String messageResult = documentServiceImpl.saveDocument(new Document(2l, ConstantsUtilTest.DOCUMENT_TESTE, ConstantsUtilTest.DOCUMENT_TESTE));

		assertThat(messageResult, is(ConstantsUtilTest.DOCUMENT_SUCESS));

	}

	@Test
	public void updateDocumentRightTestSucess() {

		Mockito.when(documentRepository.findById(2l)).thenReturn(new Document(2l, null, ConstantsUtilTest.DOCUMENT_TESTE));
		Mockito.when(documentRepository.save(any(Document.class))).thenReturn(new Document(2l, ConstantsUtilTest.DOCUMENT_TESTE, null));

		String messageResult = documentServiceImpl.saveDocument(new Document(2l, null, ConstantsUtilTest.DOCUMENT_TESTE));

		assertThat(messageResult, is(ConstantsUtilTest.DOCUMENT_SUCESS));

	}

	@Test
	public void compareDocumentTestDocumentNotFound() {

		Mockito.when(documentRepository.findById(1l)).thenReturn(new Document());

		String messageResult = documentServiceImpl.compareDocument(1l);

		assertThat(messageResult, is(ConstantsUtilTest.DOCUMENT_NOT_FOUND));

	}

	@Test
	public void compareDocumentTestDocumentsEquals() {

		Mockito.when(documentRepository.findById(1l))
				.thenReturn(new Document(1l, ConstantsUtilTest.DOCUMENT_TESTE123, ConstantsUtilTest.DOCUMENT_TESTE123));

		String messageResult = documentServiceImpl.compareDocument(1l);

		assertThat(messageResult, is(IDENTICALS_DOCUMENTS));

	}

	@Test
	public void compareDocumentTestDocumentsDiffLength() {

		Mockito.when(documentRepository.findById(2l)).thenReturn(new Document(2l, ConstantsUtilTest.DOCUMENT_TESTE123, ConstantsUtilTest.DOCUMENT_TESTE));

		String messageResult = documentServiceImpl.compareDocument(2l);

		assertThat(messageResult, is(DIFF_LENGTH_DOCUMENTS));

	}

	@Test
	public void compareDocumentTestDocumentDiffOffSet() {

		Mockito.when(documentRepository.findById(1l))
				.thenReturn(new Document(1l, ConstantsUtilTest.DOCUMENT_TESTE123, ConstantsUtilTest.DOCUMENT_TESTE321));

		String messageResult = documentServiceImpl.compareDocument(1l);

		assertThat(messageResult, is(DIFF_OFF_SET_DOCUMENTS));
	}

	

}
