package br.gov.ro.portovelho.sicahab.model.enuns;

public enum TipoLogradouro {
	AL("Alameda"),
	R("Rua"),
	AV("Avenida"),
	BAL("Balneário"),
	BC("Beco"),
	BSQ("Bosque"),
	CAM("Caminho"),
	COM("Condomínio"),
	ETC("Estacionamento"),
	ETR("Entrada"),
	ILH("Ilha"),
	JD("Jardim"),
	LAD("Ladeira"),
	LGO("Lago"),
	LAO("Largo"),
	LOT("Loteamento"),
	MAR("Marginal"),
	PRQ("Parque"),
	PCA("Praça"),
	RDV("Rodovia"),
	S("Setor"),
	SIT("Sítio"),
	TR("Travessa"),
	V("Via"),
	VI("Vila"),
	VRS("Vila Residencial"),
	FAV("Favela"),
	FAZ("Fazenda"),
	Q("Quadra"),
	TRC("Trecho"),
	VLE("Vale"),
	BL("Bloco"),
	CJ("Conjunto"),
	PAR("Paralela"),
	AE("Área Especial");
	

	
	private final String descricao;
	
	
	
	 private TipoLogradouro(String descricao){
		 this.descricao = descricao;
	 }

	

	public String getDescricao() {
		return descricao;
	}
	

	
	
	
}
