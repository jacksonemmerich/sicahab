package br.gov.ro.portovelho.sicahab.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gov.ro.portovelho.sicahab.model.enuns.EstadoCivil;

@Converter
public class EstadoCivilConverter implements AttributeConverter<EstadoCivil, Integer>{

	
	@Override
	public Integer convertToDatabaseColumn(EstadoCivil estadoCivil) {
		return estadoCivil.getDbValue();
	}

	@Override
	public EstadoCivil convertToEntityAttribute(Integer dbValue) {
		
		return EstadoCivil.fromDbValue(dbValue);
	}
}