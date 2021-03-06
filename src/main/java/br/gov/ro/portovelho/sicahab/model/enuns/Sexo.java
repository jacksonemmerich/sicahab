package br.gov.ro.portovelho.sicahab.model.enuns;

import java.util.HashMap;
import java.util.Map;

public enum Sexo {
	MASCULINO(1,"Masculino"),
	FEMININO(2, "Feminino");
	
	private final Integer dbValue;
	
	private final String descricao;
	
	
	
	 private Sexo(Integer dbValue,String descricao){
		 this.dbValue = dbValue;
		 this.descricao = descricao;
	 }

	public Integer getDbValue() {
		return dbValue;
	}
	

	public String getDescricao() {
		return descricao;
	}



	public static final Map<Integer, Sexo> dbValues = new HashMap<>();
	
	static {
        for (Sexo value : values()) {
            dbValues.put(value.dbValue, value);
        }
    }
 
    public static Sexo fromDbValue(Integer dbValue) {
        // this returns null for invalid value, check for null and throw exception if you need it
        return dbValues.get(dbValue);
    }
	
	
	
	
	
	
	
}
