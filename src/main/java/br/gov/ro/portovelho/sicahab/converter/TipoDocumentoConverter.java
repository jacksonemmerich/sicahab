package br.gov.ro.portovelho.sicahab.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gov.ro.portovelho.sicahab.model.enuns.TipoDocumento;


@Converter
public class TipoDocumentoConverter implements AttributeConverter<TipoDocumento, Integer>{

	
	@Override
	public Integer convertToDatabaseColumn(TipoDocumento tipoDocumento) {
		return tipoDocumento.getValue();
	}

	@Override
	public TipoDocumento convertToEntityAttribute(Integer dbValue) {
		
		return TipoDocumento.fromDbValue(dbValue);
	}
}