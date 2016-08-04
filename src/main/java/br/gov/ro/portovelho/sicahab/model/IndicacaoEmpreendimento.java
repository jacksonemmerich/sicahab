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
 * A IndicacaoEmpreendimento.
 */
@Entity
@Table(name = "indicacao_empreendimento")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "indicacaoempreendimento")
public class IndicacaoEmpreendimento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 9)
    @Column(name = "codigo_apf_empreendimento", length = 9, nullable = false)
    private String codigoApfEmpreendimento;

    @OneToMany(mappedBy = "indicacaoEmpreendimento")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Indicados> indicados = new HashSet<>();

    @OneToOne(mappedBy = "indicacaoEmpreendimento")
    @JsonIgnore
    private Empreendimento empreendimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoApfEmpreendimento() {
        return codigoApfEmpreendimento;
    }

    public void setCodigoApfEmpreendimento(String codigoApfEmpreendimento) {
        this.codigoApfEmpreendimento = codigoApfEmpreendimento;
    }

    public Set<Indicados> getIndicados() {
        return indicados;
    }

    public void setIndicados(Set<Indicados> indicados) {
        this.indicados = indicados;
    }

    public Empreendimento getEmpreendimento() {
        return empreendimento;
    }

    public void setEmpreendimento(Empreendimento empreendimento) {
        this.empreendimento = empreendimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IndicacaoEmpreendimento indicacaoEmpreendimento = (IndicacaoEmpreendimento) o;
        if(indicacaoEmpreendimento.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, indicacaoEmpreendimento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "IndicacaoEmpreendimento{" +
            "id=" + id +
            ", codigoApfEmpreendimento='" + codigoApfEmpreendimento + "'" +
            '}';
    }
}
