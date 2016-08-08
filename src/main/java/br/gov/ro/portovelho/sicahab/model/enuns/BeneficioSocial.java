package br.gov.ro.portovelho.sicahab.model.enuns;

import java.util.HashMap;
import java.util.Map;

public enum BeneficioSocial {
	SEM_BENEFICIO(0,"Sem benefício"),
	BPC(1,"BCP"),
	BOLSA_FAMILIA(2,("Bolsa família"));
	
private final Integer dbValue;
	
	private final String descricao;
	
	
	
	 private BeneficioSocial(Integer dbValue,String descricao){
		 this.dbValue = dbValue;
		 this.descricao = descricao;
	 }

	public Integer getDbValue() {
		return dbValue;
	}
	

	public String getDescricao() {
		return descricao;
	}



	public static final Map<Integer, BeneficioSocial> dbValues = new HashMap<>();
	
	static {
        for (BeneficioSocial value : values()) {
            dbValues.put(value.dbValue, value);
        }
    }
 
    public static BeneficioSocial fromDbValue(Integer dbValue) {
        // this returns null for invalid value, check for null and throw exception if you need it
        return dbValues.get(dbValue);
    }
	
}
