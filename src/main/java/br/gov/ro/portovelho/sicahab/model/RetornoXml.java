package br.gov.ro.portovelho.sicahab.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A RetornoXml.
 */
@Entity
@Table(name = "retorno_xml")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "retornoxml")
public class RetornoXml implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "versao_leiaute_xml", nullable = false)
    private String versaoLeiauteXml;

    @NotNull
    @Size(max = 7)
    @Pattern(regexp = "undefined")
    @Column(name = "codigo_municipio", length = 7, nullable = false)
    private String codigoMunicipio;

    @Size(max = 14)
    @Column(name = "cnpj_prefeitura", length = 14)
    private String cnpjPrefeitura;

    @NotNull
    @Column(name = "data_geracao", nullable = false)
    private LocalDate dataGeracao;

    @NotNull
    @Column(name = "hora_geracao", nullable = false)
    private ZonedDateTime horaGeracao;

    @Lob
    @Column(name = "xml")
    private byte[] xml;

    @Column(name = "xml_content_type")
    private String xmlContentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersaoLeiauteXml() {
        return versaoLeiauteXml;
    }

    public void setVersaoLeiauteXml(String versaoLeiauteXml) {
        this.versaoLeiauteXml = versaoLeiauteXml;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getCnpjPrefeitura() {
        return cnpjPrefeitura;
    }

    public void setCnpjPrefeitura(String cnpjPrefeitura) {
        this.cnpjPrefeitura = cnpjPrefeitura;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public ZonedDateTime getHoraGeracao() {
        return horaGeracao;
    }

    public void setHoraGeracao(ZonedDateTime horaGeracao) {
        this.horaGeracao = horaGeracao;
    }

    public byte[] getXml() {
        return xml;
    }

    public void setXml(byte[] xml) {
        this.xml = xml;
    }

    public String getXmlContentType() {
        return xmlContentType;
    }

    public void setXmlContentType(String xmlContentType) {
        this.xmlContentType = xmlContentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RetornoXml retornoXml = (RetornoXml) o;
        if(retornoXml.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, retornoXml.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "RetornoXml{" +
            "id=" + id +
            ", versaoLeiauteXml='" + versaoLeiauteXml + "'" +
            ", codigoMunicipio='" + codigoMunicipio + "'" +
            ", cnpjPrefeitura='" + cnpjPrefeitura + "'" +
            ", dataGeracao='" + dataGeracao + "'" +
            ", horaGeracao='" + horaGeracao + "'" +
            ", xml='" + xml + "'" +
            ", xmlContentType='" + xmlContentType + "'" +
            '}';
    }
}
