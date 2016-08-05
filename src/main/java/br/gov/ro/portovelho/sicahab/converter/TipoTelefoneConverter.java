package br.gov.ro.portovelho.sicahab.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gov.ro.portovelho.sicahab.model.enuns.TipoTelefone;



@Converter
public class TipoTelefoneConverter implements AttributeConverter<TipoTelefone, Integer>{

	
	@Override
	public Integer convertToDatabaseColumn(TipoTelefone tipoTelefone) {
		return tipoTelefone.getDbvalue();
	}

	@Override
	public TipoTelefone convertToEntityAttribute(Integer dbValue) {
		
		return TipoTelefone.fromDbValue(dbValue);
	}
}