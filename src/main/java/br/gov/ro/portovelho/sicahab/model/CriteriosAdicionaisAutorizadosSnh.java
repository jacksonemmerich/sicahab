package br.gov.ro.portovelho.sicahab.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A CriteriosAdicionaisAutorizadosSnh.
 */
@Entity
@Table(name = "criterios_adicionais_autorizados_snh")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "criteriosadicionaisautorizadossnh")
public class CriteriosAdicionaisAutorizadosSnh implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 8)
    @Column(name = "codigo_autorizacao", length = 8, nullable = false)
    private String codigoAutorizacao;

    @NotNull
    @Column(name = "resultado_enquadramento_familia", nullable = false)
    private Boolean resultadoEnquadramentoFamilia;

    @ManyToOne
    private GrupoFamiliar grupoFamiliar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoAutorizacao() {
        return codigoAutorizacao;
    }

    public void setCodigoAutorizacao(String codigoAutorizacao) {
        this.codigoAutorizacao = codigoAutorizacao;
    }

    public Boolean isResultadoEnquadramentoFamilia() {
        return resultadoEnquadramentoFamilia;
    }

    public void setResultadoEnquadramentoFamilia(Boolean resultadoEnquadramentoFamilia) {
        this.resultadoEnquadramentoFamilia = resultadoEnquadramentoFamilia;
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
        CriteriosAdicionaisAutorizadosSnh criteriosAdicionaisAutorizadosSnh = (CriteriosAdicionaisAutorizadosSnh) o;
        if(criteriosAdicionaisAutorizadosSnh.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, criteriosAdicionaisAutorizadosSnh.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CriteriosAdicionaisAutorizadosSnh{" +
            "id=" + id +
            ", codigoAutorizacao='" + codigoAutorizacao + "'" +
            ", resultadoEnquadramentoFamilia='" + resultadoEnquadramentoFamilia + "'" +
            '}';
    }
}
