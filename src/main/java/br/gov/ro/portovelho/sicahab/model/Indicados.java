package br.gov.ro.portovelho.sicahab.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Indicados.
 */
@Entity
@Table(name = "indicados")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "indicados")
public class Indicados implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 11)
    @Column(name = "nis_titular", length = 11, nullable = false)
    private String nisTitular;

    @NotNull
    @Size(max = 1)
    @Column(name = "codigo_atualizacao", length = 1, nullable = false)
    private String codigoAtualizacao;

    @NotNull
    @Size(max = 1)
    @Column(name = "motivo_indicacao", length = 1, nullable = false)
    private String motivoIndicacao;

    @ManyToOne
    private IndicacaoEmpreendimento indicacaoEmpreendimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNisTitular() {
        return nisTitular;
    }

    public void setNisTitular(String nisTitular) {
        this.nisTitular = nisTitular;
    }

    public String getCodigoAtualizacao() {
        return codigoAtualizacao;
    }

    public void setCodigoAtualizacao(String codigoAtualizacao) {
        this.codigoAtualizacao = codigoAtualizacao;
    }

    public String getMotivoIndicacao() {
        return motivoIndicacao;
    }

    public void setMotivoIndicacao(String motivoIndicacao) {
        this.motivoIndicacao = motivoIndicacao;
    }

    public IndicacaoEmpreendimento getIndicacaoEmpreendimento() {
        return indicacaoEmpreendimento;
    }

    public void setIndicacaoEmpreendimento(IndicacaoEmpreendimento indicacaoEmpreendimento) {
        this.indicacaoEmpreendimento = indicacaoEmpreendimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Indicados indicados = (Indicados) o;
        if(indicados.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, indicados.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Indicados{" +
            "id=" + id +
            ", nisTitular='" + nisTitular + "'" +
            ", codigoAtualizacao='" + codigoAtualizacao + "'" +
            ", motivoIndicacao='" + motivoIndicacao + "'" +
            '}';
    }
}
