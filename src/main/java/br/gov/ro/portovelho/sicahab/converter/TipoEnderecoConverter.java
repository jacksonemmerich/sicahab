package br.gov.ro.portovelho.sicahab.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gov.ro.portovelho.sicahab.model.enuns.TipoEndereco;



@Converter
public class TipoEnderecoConverter implements AttributeConverter<TipoEndereco, Integer>{

	
	@Override
	public Integer convertToDatabaseColumn(TipoEndereco tipoEndereco) {
		return tipoEndereco.getDbValue();
	}

	@Override
	public TipoEndereco convertToEntityAttribute(Integer dbValue) {
		
		return TipoEndereco.fromDbValue(dbValue);
	}
}
