package br.gov.ro.portovelho.sicahab.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.springframework.data.elasticsearch.annotations.Document;

import br.gov.ro.portovelho.sicahab.model.enuns.PapelParticipante;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Participante.
 */
@Entity
@Table(name = "participante")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "participante")
public class Participante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 11)
    @Pattern(regexp = "undefined")
    @Column(name = "nis_participante", length = 11, nullable = false)
    private String nisParticipante;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PapelParticipante papelParticipante;

    @ManyToOne
    private GrupoFamiliar grupoFamiliar;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    

    public String getNisParticipante() {
        return nisParticipante;
    }

    public void setNisParticipante(String nisParticipante) {
        this.nisParticipante = nisParticipante;
    }

    

    public PapelParticipante getPapelParticipante() {
		return papelParticipante;
	}
	public void setPapelParticipante(PapelParticipante papelParticipante) {
		this.papelParticipante = papelParticipante;
	}
	public GrupoFamiliar getGrupoFamiliar() {
        return grupoFamiliar;
    }

    public void setGrupoFamiliar(GrupoFamiliar grupoFamiliar) {
        this.grupoFamiliar = grupoFamiliar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participante participante = (Participante) o;
        if(participante.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, participante.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Participante{" +
            "id=" + id +
            ", nisParticipante='" + nisParticipante + "'" +
            ", papelParticipante='" + papelParticipante + "'" +
            '}';
    }
}
