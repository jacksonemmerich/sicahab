package br.gov.ro.portovelho.sicahab.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gov.ro.portovelho.sicahab.model.enuns.Nacionalidade;


@Converter
public class NacionalidadeConverter implements AttributeConverter<Nacionalidade, Integer>{

	
	@Override
	public Integer convertToDatabaseColumn(Nacionalidade nacionalidade) {
		return nacionalidade.getDbvalue();
	}

	@Override
	public Nacionalidade convertToEntityAttribute(Integer dbValue) {
		
		return Nacionalidade.fromDbValue(dbValue);
	}
}