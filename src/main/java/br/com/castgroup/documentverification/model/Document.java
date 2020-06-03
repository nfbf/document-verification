package br.com.castgroup.documentverification.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Document {

	@Id
	private long id;
	private String docLeft;
	private String docRight;

	public Document() {

	}

	public Document(long id, String docLeft, String docRight) {
		this.setId(id);
		this.setDocLeft(docLeft);
		this.setDocRight(docRight);

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDocLeft() {
		return docLeft;
	}

	public void setDocLeft(String docLeft) {
		this.docLeft = docLeft;
	}

	public String getDocRight() {
		return docRight;
	}

	public void setDocRight(String docRight) {
		this.docRight = docRight;
	}

}
