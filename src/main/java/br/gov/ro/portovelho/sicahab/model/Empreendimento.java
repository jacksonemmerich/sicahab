package br.gov.ro.portovelho.sicahab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Empreendimento.
 */
@Entity
@Table(name = "empreendimento")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "empreendimento")
public class Empreendimento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tipo_empreendimento")
    private String tipoEmpreendimento;

    @Column(name = "quantidade_unidades")
    private Integer quantidadeUnidades;

    @Column(name = "previsao_entrega")
    private LocalDate previsaoEntrega;

    @OneToOne
    @JoinColumn(unique = true)
    private IndicacaoEmpreendimento indicacaoEmpreendimento;

    @ManyToMany(mappedBy = "empreendimentos")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Pessoa> pessoas = new HashSet<>();

    @ManyToOne
    private Programa programa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoEmpreendimento() {
        return tipoEmpreendimento;
    }

    public void setTipoEmpreendimento(String tipoEmpreendimento) {
        this.tipoEmpreendimento = tipoEmpreendimento;
    }

    public Integer getQuantidadeUnidades() {
        return quantidadeUnidades;
    }

    public void setQuantidadeUnidades(Integer quantidadeUnidades) {
        this.quantidadeUnidades = quantidadeUnidades;
    }

    public LocalDate getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(LocalDate previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

    public IndicacaoEmpreendimento getIndicacaoEmpreendimento() {
        return indicacaoEmpreendimento;
    }

    public void setIndicacaoEmpreendimento(IndicacaoEmpreendimento indicacaoEmpreendimento) {
        this.indicacaoEmpreendimento = indicacaoEmpreendimento;
    }

    public Set<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Empreendimento empreendimento = (Empreendimento) o;
        if(empreendimento.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, empreendimento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Empreendimento{" +
            "id=" + id +
            ", nome='" + nome + "'" +
            ", tipoEmpreendimento='" + tipoEmpreendimento + "'" +
            ", quantidadeUnidades='" + quantidadeUnidades + "'" +
            ", previsaoEntrega='" + previsaoEntrega + "'" +
            '}';
    }
}
