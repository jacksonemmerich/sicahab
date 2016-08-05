package br.gov.ro.portovelho.sicahab.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Nacionalidade.
 */
@Entity
@Table(name = "pais_nacionalidade")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "nacionalidade")
public class PaisNacionalidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 3)
    @Column(name = "codigo_pais", length = 3)
    private String codigoPais;

    @Column(name = "nome_nacionalidade")
    private String nomeNacionalidade;

    @Size(max = 3)
    @Column(name = "codigo_iso_alpha_3", length = 3)
    private String codigoIsoAlpha3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNomeNacionalidade() {
        return nomeNacionalidade;
    }

    public void setNomeNacionalidade(String nomeNacionalidade) {
        this.nomeNacionalidade = nomeNacionalidade;
    }

    public String getCodigoIsoAlpha3() {
        return codigoIsoAlpha3;
    }

    public void setCodigoIsoAlpha3(String codigoIsoAlpha3) {
        this.codigoIsoAlpha3 = codigoIsoAlpha3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaisNacionalidade nacionalidade = (PaisNacionalidade) o;
        if(nacionalidade.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, nacionalidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Nacionalidade{" +
            "id=" + id +
            ", codigoPais='" + codigoPais + "'" +
            ", nomeNacionalidade='" + nomeNacionalidade + "'" +
            ", codigoIsoAlpha3='" + codigoIsoAlpha3 + "'" +
            '}';
    }
}
