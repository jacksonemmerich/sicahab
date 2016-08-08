package br.gov.ro.portovelho.sicahab.model.enuns;

import java.util.HashMap;
import java.util.Map;

public enum PapelParticipante {
	CONJUGUE(2,"Cônjugue"),
	FILHO_OU_TUTELADO(3,("Filho ou Tutelado")),
	PAI(4,"Pai"),
	MAE(5,"Mãe"),
	IRMA_O(6,"Irmã(o)"),
	AVO(7,"Avó(ô)"),
	TIA_O(8,"Tio(a)"),
	PRIMA_O(9,"Prima(o)"),
	SOBRINHO_A(10,"Sobrinho(a)"),
	OUTRO(99,"Outro");
	
	
private final Integer dbValue;
	
	private final String descricao;
	
	
	
	 private PapelParticipante(Integer dbValue,String descricao){
		 this.dbValue = dbValue;
		 this.descricao = descricao;
	 }

	public Integer getDbValue() {
		return dbValue;
	}
	

	public String getDescricao() {
		return descricao;
	}



	public static final Map<Integer, PapelParticipante> dbValues = new HashMap<>();
	
	static {
        for (PapelParticipante value : values()) {
            dbValues.put(value.dbValue, value);
        }
    }
 
    public static PapelParticipante fromDbValue(Integer dbValue) {
        // this returns null for invalid value, check for null and throw exception if you need it
        return dbValues.get(dbValue);
    }
	
	
	
}
