package br.gov.ro.portovelho.sicahab.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gov.ro.portovelho.sicahab.model.enuns.TipoDeficiencia;;

@Converter
public class TipoDeficienciaConverter implements AttributeConverter<TipoDeficiencia, Integer>{

	
	@Override
	public Integer convertToDatabaseColumn(TipoDeficiencia tipoDeficiencia) {
		return tipoDeficiencia.getDbValue();
	}

	@Override
	public TipoDeficiencia convertToEntityAttribute(Integer dbValue) {
		
		return TipoDeficiencia.fromDbValue(dbValue);
	}
}
