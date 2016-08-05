package br.gov.ro.portovelho.sicahab.model.enuns;

import java.util.HashMap;
import java.util.Map;

public enum EstadoCivil {
	SOLTEIRO(1,"Solteiro(a)"),
	DIVORCIADO(3,"Divorciado(a)"),
	SEPARADO_JUDICIALMENTE(4,"Separado(a) judicialmente"),
	VIUVO(5,"Viuvo(a)"),
	UNIAO_ESTAVEL(6,"Com união estável"),
	CASADO_COMUNHAO_TOTAL_DE_BENS(7,"Casado com comunhão total de bens"),
	CASADO_SEM_COMUNHAO_TOTAL_DE_BENS(8,"Casado sem comunhão total de bens"),
	CASADO_COMUNHAO_PARCIAL_DE_BENS(9,"Casado - comunhão parcial de bens");
	
	
	private final Integer dbValue;
	
	private final String descricao;
	
	
	
	 private EstadoCivil(Integer dbValue,String descricao){
		 this.dbValue = dbValue;
		 this.descricao = descricao;
	 }

	public Integer getDbValue() {
		return dbValue;
	}
	

	public String getDescricao() {
		return descricao;
	}
	
	
public static final Map<Integer, EstadoCivil> dbValues = new HashMap<>();
	
	static {
        for (EstadoCivil value : values()) {
            dbValues.put(value.dbValue, value);
        }
    }
 
    public static EstadoCivil fromDbValue(Integer dbValue) {
        // this returns null for invalid value, check for null and throw exception if you need it
        return dbValues.get(dbValue);
    }
	
}
