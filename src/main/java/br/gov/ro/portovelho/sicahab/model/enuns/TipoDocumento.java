package br.gov.ro.portovelho.sicahab.model.enuns;

public enum TipoDocumento {
	RG("008","Carteira de Identidade"),
	CPTS("009","Carteira de Trabalho e Previdência Social"),
	PASSAPORTE("013","Passaporte"),
	CNH("030","Carteira Nacional de Habilitação"),
	RESERVISTA("101","Certificado de Reservista"),
	RIC("102","Registro de Identidade Civil");
	
	
	private String value;
	private String descricao;

	public String getValue() {
		return value;
	}
	
	public String getDescricao() {
		return descricao;
	}

	private TipoDocumento(String value, String descricao) {
		this.value = value;
		this.descricao = descricao;
		
	}
}


