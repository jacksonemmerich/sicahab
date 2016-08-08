package br.gov.ro.portovelho.sicahab.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gov.ro.portovelho.sicahab.model.enuns.PapelParticipante;
@Converter
public class PapelParticipanteConverter implements AttributeConverter<PapelParticipante, Integer>{

	
	@Override
	public Integer convertToDatabaseColumn(PapelParticipante papelParticipante) {
		return papelParticipante.getDbValue();
	}

	@Override
	public PapelParticipante convertToEntityAttribute(Integer dbValue) {
		
		return PapelParticipante.fromDbValue(dbValue);
	}
}