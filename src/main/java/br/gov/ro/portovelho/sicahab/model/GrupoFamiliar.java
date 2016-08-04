package br.gov.ro.portovelho.sicahab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A GrupoFamiliar.
 */
@Entity
@Table(name = "grupo_familiar")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "grupofamiliar")
public class GrupoFamiliar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 1)
    @Column(name = "codigo_atualizacao", length = 1)
    private String codigoAtualizacao;

    @Size(max = 100)
    @Column(name = "motivo_exclusao", length = 100)
    private String motivoExclusao;

    @Size(max = 11)
    @Pattern(regexp = "undefined")
    @Column(name = "nis_titular", length = 11)
    private String nisTitular;

    @OneToMany(mappedBy = "grupoFamiliar")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<CriteriosAdicionaisAutorizadosSnh> criteriosAdicionaisAutorizadosSnhs = new HashSet<>();

    @OneToMany(mappedBy = "grupoFamiliar")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Participante> participantes = new HashSet<>();

    @OneToOne
    @JoinColumn(unique = true)
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoAtualizacao() {
        return codigoAtualizacao;
    }

    public void setCodigoAtualizacao(String codigoAtualizacao) {
        this.codigoAtualizacao = codigoAtualizacao;
    }

    public String getMotivoExclusao() {
        return motivoExclusao;
    }

    public void setMotivoExclusao(String motivoExclusao) {
        this.motivoExclusao = motivoExclusao;
    }

    public String getNisTitular() {
        return nisTitular;
    }

    public void setNisTitular(String nisTitular) {
        this.nisTitular = nisTitular;
    }

    public Set<CriteriosAdicionaisAutorizadosSnh> getCriteriosAdicionaisAutorizadosSnhs() {
        return criteriosAdicionaisAutorizadosSnhs;
    }

    public void setCriteriosAdicionaisAutorizadosSnhs(Set<CriteriosAdicionaisAutorizadosSnh> criteriosAdicionaisAutorizadosSnhs) {
        this.criteriosAdicionaisAutorizadosSnhs = criteriosAdicionaisAutorizadosSnhs;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GrupoFamiliar grupoFamiliar = (GrupoFamiliar) o;
        if(grupoFamiliar.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, grupoFamiliar.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "GrupoFamiliar{" +
            "id=" + id +
            ", codigoAtualizacao='" + codigoAtualizacao + "'" +
            ", motivoExclusao='" + motivoExclusao + "'" +
            ", nisTitular='" + nisTitular + "'" +
            '}';
    }
}
