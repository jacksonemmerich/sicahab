package br.gov.ro.portovelho.sicahab.model.enuns;

public enum CodigoAtualizacao {
	I("Inclusão"),
	A("Alteração"),
	E("Exclusão");
	
	private String descricao;
	
	
	
	public String getDescricao() {
		return descricao;
	}



	private CodigoAtualizacao(String descricao) {
		this.descricao = descricao; 
	}
	
	
}
