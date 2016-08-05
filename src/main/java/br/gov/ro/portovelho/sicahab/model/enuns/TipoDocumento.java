package br.gov.ro.portovelho.sicahab.model.enuns;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;

public enum TipoDocumento {
	RG(8,"Carteira de Identidade"),
	CPTS(9,"Carteira de Trabalho e Previdência Social"),
	PASSAPORTE(13,"Passaporte"),
	CNH(30,"Carteira Nacional de Habilitação"),
	RESERVISTA(101,"Certificado de Reservista"),
	RIC(102,"Registro de Identidade Civil");
	
	@Column(columnDefinition = "int(3) ZEROFILL")
	private Integer dbvalue;
	private String descricao;

	public Integer getValue() {
		return dbvalue;
	}
	
	public String getDescricao() {
		return descricao;
	}

	private TipoDocumento(Integer dbvalue, String descricao) {
		this.dbvalue = dbvalue;
		this.descricao = descricao;
		
	}
	
public static final Map<Integer, TipoDocumento> dbValues = new HashMap<>();
	
	static {
        for (TipoDocumento value : values()) {
            dbValues.put(value.dbvalue, value);
        }
    }
 
    public static TipoDocumento fromDbValue(Integer dbValue) {
        // isso retorna nulo para valor inválido , verifique se há exceção nula e lance se você precisar dele TipoDocumento
        return dbValues.get(dbValue);
    }
	
}


