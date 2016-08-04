package br.gov.ro.portovelho.sicahab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ro.portovelho.sicahab.model.Pessoa;

public interface VinhosRepository extends JpaRepository<Pessoa, Long> {
	
}
