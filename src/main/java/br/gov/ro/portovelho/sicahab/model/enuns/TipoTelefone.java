package br.gov.ro.portovelho.sicahab.model.enuns;

import java.util.HashMap;
import java.util.Map;

/**
 * The TipoCelular enumeration.
 */
public enum TipoTelefone {
	RESIDENCIAL(1,"Residencial"),
	CELULAR(2,"Celular"),
	RECADO(3,"Recado"),
	COMERCIAL(4,"Comercial");
	/*FIXO("Fixo"),
	TRABALHO("Trabalho");*/

	private final Integer dbvalue;
	private final String descricao;

	public Integer getDbvalue() {
		return dbvalue;
	}
	public String getDescricao() {
		return descricao;
	}
	

	private TipoTelefone(Integer dbvalue, String descricao) {
		this.descricao = descricao;
		this.dbvalue = dbvalue;
	}
	
	public static final Map<Integer, TipoTelefone> dbValues = new HashMap<>();
	
	static {
        for (TipoTelefone value : values()) {
            dbValues.put(value.dbvalue, value);
        }
    }
 
    public static TipoTelefone fromDbValue(Integer dbValue) {
        // this returns null for invalid value, check for null and throw exception if you need it
        return dbValues.get(dbValue);
    }

}
