package br.gov.ro.portovelho.sicahab.model.enuns;

/**
 * The TipoCelular enumeration.
 */
public enum TipoCelular {
	CELULAR("Celular"),
	FIXO("Fixo"),
	TRABALHO("Trabalho");

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	private TipoCelular(String descricao) {
		this.descricao = descricao;
	}
}
