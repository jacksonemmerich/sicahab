package br.gov.ro.portovelho.sicahab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A CondicaoSelecao.
 */
@Entity
@Table(name = "condicao_selecao")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "condicaoselecao")
public class CondicaoSelecao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "reside_area_risco_insalubre")
    private Boolean resideAreaRiscoInsalubre;

    @Column(name = "opcao_empreendimento")
    private Boolean opcaoEmpreendimento;

    @Size(max = 9)
    @Pattern(regexp = "undefined")
    @Column(name = "apf_empreendimento", length = 9)
    private String apfEmpreendimento;

    @NotNull
    @Size(max = 1)
    @Column(name = "tipo_deficiencia", length = 1, nullable = false)
    private String tipoDeficiencia;

    @Column(name = "doenca_cronica_incapacitante")
    private Boolean doencaCronicaIncapacitante;

    @Column(name = "data_inicio_residencia_municipio")
    private LocalDate dataInicioResidenciaMunicipio;

    @Column(name = "beneficio_social")
    private Boolean beneficioSocial;

    @Column(name = "situacao_rua_com_acompanhamento")
    private Boolean situacaoRuaComAcompanhamento;

    @Column(name = "residencia_alugada")
    private Boolean residenciaAlugada;

    @Column(name = "valor_aluguel")
    private Double valorAluguel;

    @Column(name = "recebe_aluguel_social")
    private Boolean recebeAluguelSocial;

    @Column(name = "data_cadastro_habitacional_anterior")
    private LocalDate dataCadastroHabitacionalAnterior;

    @Column(name = "atendida_maria_da_penha")
    private Boolean atendidaMariaDaPenha;

    @Column(name = "situacao_coabitacional_involuntaria")
    private Boolean situacaoCoabitacionalInvoluntaria;

    @OneToOne(mappedBy = "condicaoSelecao")
    @JsonIgnore
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isResideAreaRiscoInsalubre() {
        return resideAreaRiscoInsalubre;
    }

    public void setResideAreaRiscoInsalubre(Boolean resideAreaRiscoInsalubre) {
        this.resideAreaRiscoInsalubre = resideAreaRiscoInsalubre;
    }

    public Boolean isOpcaoEmpreendimento() {
        return opcaoEmpreendimento;
    }

    public void setOpcaoEmpreendimento(Boolean opcaoEmpreendimento) {
        this.opcaoEmpreendimento = opcaoEmpreendimento;
    }

    public String getApfEmpreendimento() {
        return apfEmpreendimento;
    }

    public void setApfEmpreendimento(String apfEmpreendimento) {
        this.apfEmpreendimento = apfEmpreendimento;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiencia(String tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

    public Boolean isDoencaCronicaIncapacitante() {
        return doencaCronicaIncapacitante;
    }

    public void setDoencaCronicaIncapacitante(Boolean doencaCronicaIncapacitante) {
        this.doencaCronicaIncapacitante = doencaCronicaIncapacitante;
    }

    public LocalDate getDataInicioResidenciaMunicipio() {
        return dataInicioResidenciaMunicipio;
    }

    public void setDataInicioResidenciaMunicipio(LocalDate dataInicioResidenciaMunicipio) {
        this.dataInicioResidenciaMunicipio = dataInicioResidenciaMunicipio;
    }

    public Boolean isBeneficioSocial() {
        return beneficioSocial;
    }

    public void setBeneficioSocial(Boolean beneficioSocial) {
        this.beneficioSocial = beneficioSocial;
    }

    public Boolean isSituacaoRuaComAcompanhamento() {
        return situacaoRuaComAcompanhamento;
    }

    public void setSituacaoRuaComAcompanhamento(Boolean situacaoRuaComAcompanhamento) {
        this.situacaoRuaComAcompanhamento = situacaoRuaComAcompanhamento;
    }

    public Boolean isResidenciaAlugada() {
        return residenciaAlugada;
    }

    public void setResidenciaAlugada(Boolean residenciaAlugada) {
        this.residenciaAlugada = residenciaAlugada;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Boolean isRecebeAluguelSocial() {
        return recebeAluguelSocial;
    }

    public void setRecebeAluguelSocial(Boolean recebeAluguelSocial) {
        this.recebeAluguelSocial = recebeAluguelSocial;
    }

    public LocalDate getDataCadastroHabitacionalAnterior() {
        return dataCadastroHabitacionalAnterior;
    }

    public void setDataCadastroHabitacionalAnterior(LocalDate dataCadastroHabitacionalAnterior) {
        this.dataCadastroHabitacionalAnterior = dataCadastroHabitacionalAnterior;
    }

    public Boolean isAtendidaMariaDaPenha() {
        return atendidaMariaDaPenha;
    }

    public void setAtendidaMariaDaPenha(Boolean atendidaMariaDaPenha) {
        this.atendidaMariaDaPenha = atendidaMariaDaPenha;
    }

    public Boolean isSituacaoCoabitacionalInvoluntaria() {
        return situacaoCoabitacionalInvoluntaria;
    }

    public void setSituacaoCoabitacionalInvoluntaria(Boolean situacaoCoabitacionalInvoluntaria) {
        this.situacaoCoabitacionalInvoluntaria = situacaoCoabitacionalInvoluntaria;
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
        CondicaoSelecao condicaoSelecao = (CondicaoSelecao) o;
        if(condicaoSelecao.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, condicaoSelecao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CondicaoSelecao{" +
            "id=" + id +
            ", resideAreaRiscoInsalubre='" + resideAreaRiscoInsalubre + "'" +
            ", opcaoEmpreendimento='" + opcaoEmpreendimento + "'" +
            ", apfEmpreendimento='" + apfEmpreendimento + "'" +
            ", tipoDeficiencia='" + tipoDeficiencia + "'" +
            ", doencaCronicaIncapacitante='" + doencaCronicaIncapacitante + "'" +
            ", dataInicioResidenciaMunicipio='" + dataInicioResidenciaMunicipio + "'" +
            ", beneficioSocial='" + beneficioSocial + "'" +
            ", situacaoRuaComAcompanhamento='" + situacaoRuaComAcompanhamento + "'" +
            ", residenciaAlugada='" + residenciaAlugada + "'" +
            ", valorAluguel='" + valorAluguel + "'" +
            ", recebeAluguelSocial='" + recebeAluguelSocial + "'" +
            ", dataCadastroHabitacionalAnterior='" + dataCadastroHabitacionalAnterior + "'" +
            ", atendidaMariaDaPenha='" + atendidaMariaDaPenha + "'" +
            ", situacaoCoabitacionalInvoluntaria='" + situacaoCoabitacionalInvoluntaria + "'" +
            '}';
    }
}
