package br.gov.ro.portovelho.sicahab.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gov.ro.portovelho.sicahab.model.enuns.BeneficioSocial;
@Converter
public class BeneficioSocialConverter implements AttributeConverter<BeneficioSocial, Integer>{

	
	@Override
	public Integer convertToDatabaseColumn(BeneficioSocial beneficioSocial) {
		return beneficioSocial.getDbValue();
	}

	@Override
	public BeneficioSocial convertToEntityAttribute(Integer dbValue) {
		
		return BeneficioSocial.fromDbValue(dbValue);
	}
}