package br.gov.ro.portovelho.sicahab.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gov.ro.portovelho.sicahab.model.enuns.Sexo;
@Converter
public class SexoConverter implements AttributeConverter<Sexo, Integer>{

	
	@Override
	public Integer convertToDatabaseColumn(Sexo sexo) {
		return sexo.getDbValue();
	}

	@Override
	public Sexo convertToEntityAttribute(Integer dbValue) {
		
		return Sexo.fromDbValue(dbValue);
	}
}