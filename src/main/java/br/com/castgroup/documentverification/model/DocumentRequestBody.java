package br.com.castgroup.documentverification.model;

public class DocumentRequestBody {

	private String dataJson;

	public DocumentRequestBody() {
	}
	
	public DocumentRequestBody(String dataJson) {
		this.setDataJson(dataJson);
	}
	
	public void setDataJson(String dataJson) {
		this.dataJson = dataJson;
	}

	public String getDataJson() {
		return dataJson;
	}

}
