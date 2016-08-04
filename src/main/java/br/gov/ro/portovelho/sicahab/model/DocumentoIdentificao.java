package br.gov.ro.portovelho.sicahab.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DocumentoIdentificao.
 */
@Entity
@Table(name = "documento_identificao")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "documentoidentificao")
public class DocumentoIdentificao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 3)
    @Column(name = "tipo_documento_identificao", length = 3, nullable = false)
    private String tipoDocumentoIdentificao;

    @NotNull
    @Size(max = 15)
    @Pattern(regexp = "undefined")
    @Column(name = "numero", length = 15, nullable = false)
    private String numero;

    @NotNull
    @Size(max = 5)
    @Column(name = "orgao_expedicao", length = 5, nullable = false)
    private String orgaoExpedicao;

    @Size(max = 2)
    @Column(name = "uf_emissor", length = 2)
    private String ufEmissor;

    @NotNull
    @Column(name = "data_expedicao", nullable = false)
    private LocalDate dataExpedicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDocumentoIdentificao() {
        return tipoDocumentoIdentificao;
    }

    public void setTipoDocumentoIdentificao(String tipoDocumentoIdentificao) {
        this.tipoDocumentoIdentificao = tipoDocumentoIdentificao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOrgaoExpedicao() {
        return orgaoExpedicao;
    }

    public void setOrgaoExpedicao(String orgaoExpedicao) {
        this.orgaoExpedicao = orgaoExpedicao;
    }

    public String getUfEmissor() {
        return ufEmissor;
    }

    public void setUfEmissor(String ufEmissor) {
        this.ufEmissor = ufEmissor;
    }

    public LocalDate getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(LocalDate dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DocumentoIdentificao documentoIdentificao = (DocumentoIdentificao) o;
        if(documentoIdentificao.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, documentoIdentificao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "DocumentoIdentificao{" +
            "id=" + id +
            ", tipoDocumentoIdentificao='" + tipoDocumentoIdentificao + "'" +
            ", numero='" + numero + "'" +
            ", orgaoExpedicao='" + orgaoExpedicao + "'" +
            ", ufEmissor='" + ufEmissor + "'" +
            ", dataExpedicao='" + dataExpedicao + "'" +
            '}';
    }
}
