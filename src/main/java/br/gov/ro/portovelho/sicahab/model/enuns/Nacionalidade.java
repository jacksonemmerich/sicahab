package br.gov.ro.portovelho.sicahab.model.enuns;

import java.util.HashMap;
import java.util.Map;

public enum Nacionalidade {
	BRASILEIRO(1,"Brasileiro"),
	ESTRANGEIRO(2,"Estrangeiro");

	private final Integer dbvalue;
	private final String descricao;
	
	private Nacionalidade(Integer dbvalue,String descricao){
		this.dbvalue = dbvalue;
		this.descricao = descricao;
	}
	
	public Integer getDbvalue() {
		return dbvalue;
	}
	public String getDescricao() {
		return descricao;
	}
	

	public static final Map<Integer, Nacionalidade> dbValues = new HashMap<>();
	
	static {
        for (Nacionalidade value : values()) {
            dbValues.put(value.dbvalue, value);
        }
    }
 
    public static Nacionalidade fromDbValue(Integer dbValue) {
        // this returns null for invalid value, check for null and throw exception if you need it
        return dbValues.get(dbValue);
    }
	
	
}
