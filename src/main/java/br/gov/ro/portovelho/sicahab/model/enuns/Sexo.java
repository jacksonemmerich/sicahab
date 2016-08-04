package br.gov.ro.portovelho.sicahab.model.enuns;

public enum Sexo {
	MASCULINO(1,"Masculino"),
	FEMININO(2,"Feminino");
	
	private int value;
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}

	public int getValue() {
		return value;
	}
	
	
	private Sexo(int value, String descricao){
		this.value = value;
		this.descricao = descricao;
	}
	
}
