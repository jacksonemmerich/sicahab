package br.gov.ro.portovelho.sicahab.model.enuns;

import java.util.HashMap;
import java.util.Map;

public enum TipoDeficiencia {
	SEM_DEFICIENCIA(0,"Sem deficiência"),
	AUDITIVA(1,"Auditiva"),
	VISUAL(2,"Visual"),
	INTELECTUAL(3,"Intelectual"),
	FISICA(4,"Física"),
	NANISMO(5,"Nanismo");
	
	private final Integer dbValue;
	
	private final String descricao;
	
	
	
	 private TipoDeficiencia(Integer dbValue,String descricao){
		 this.dbValue = dbValue;
		 this.descricao = descricao;
	 }

	public Integer getDbValue() {
		return dbValue;
	}
	

	public String getDescricao() {
		return descricao;
	}



	public static final Map<Integer, TipoDeficiencia> dbValues = new HashMap<>();
	
	static {
        for (TipoDeficiencia value : values()) {
            dbValues.put(value.dbValue, value);
        }
    }
 
    public static TipoDeficiencia fromDbValue(Integer dbValue) {
        // this returns null for invalid value, check for null and throw exception if you need it
        return dbValues.get(dbValue);
    }
	
}
