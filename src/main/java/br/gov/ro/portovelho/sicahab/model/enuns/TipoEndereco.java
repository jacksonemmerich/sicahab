package br.gov.ro.portovelho.sicahab.model.enuns;

import java.util.HashMap;
import java.util.Map;

public enum TipoEndereco {
	RESIDENCIAL(1,"Residencial"),
	TRABALHO(2,"Trabalho");
	
private final Integer dbValue;
	
	private final String descricao;
	
	
	
	 private TipoEndereco(Integer dbValue,String descricao){
		 this.dbValue = dbValue;
		 this.descricao = descricao;
	 }

	public Integer getDbValue() {
		return dbValue;
	}
	

	public String getDescricao() {
		return descricao;
	}
	
	
public static final Map<Integer, TipoEndereco> dbValues = new HashMap<>();
	
	static {
        for (TipoEndereco value : values()) {
            dbValues.put(value.dbValue, value);
        }
    }
 
    public static TipoEndereco fromDbValue(Integer dbValue) {
        // this returns null for invalid value, check for null and throw exception if you need it
        return dbValues.get(dbValue);
    }
}
