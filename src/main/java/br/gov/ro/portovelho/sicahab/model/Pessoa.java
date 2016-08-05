package br.gov.ro.portovelho.sicahab.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.ro.portovelho.sicahab.model.enuns.CodigoAtualizacao;
import br.gov.ro.portovelho.sicahab.model.enuns.EstadoCivil;
import br.gov.ro.portovelho.sicahab.model.enuns.Nacionalidade;
import br.gov.ro.portovelho.sicahab.model.enuns.Sexo;

/**
 * A Pessoa.
 */
@Entity
@Table(name = "pessoa")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "data_cadastro", nullable = false)
    private ZonedDateTime dataCadastro;

    
    @NotNull
    @Enumerated(EnumType.STRING)
    private CodigoAtualizacao codigoAtualizacao;

    @NotNull
    @Size(max = 11)
    @Column(name = "nis", length = 11, nullable = false)
    private String nis;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @Size(max = 11)
    @Column(name = "cpf", length = 11)
    private String cpf;

    @NotNull
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Size(max = 7)
    @Column(name = "naturalidade", length = 7)
    private String naturalidade;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    //TODO obrigatório se estadoCivil seja 7,8 ou 9.
    @Column(name = "data_casamento")
    private LocalDate dataCasamento;

    @NotNull
    @Column(name = "renda_declarada", nullable = false)
    private Double rendaDeclarada;

    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "ocupacao", nullable = false)
    private String ocupacao;

    @Size(max = 70)
    @Column(name = "nome_mae", length = 70)
    private String nomeMae;

    @Column(name = "data_nascimento_mae")
    private LocalDate dataNascimentoMae;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "pessoa_empreendimento",
               joinColumns = @JoinColumn(name="pessoas_id", referencedColumnName="ID"),
               inverseJoinColumns = @JoinColumn(name="empreendimentos_id", referencedColumnName="ID"))
    private Set<Empreendimento> empreendimentos = new HashSet<>();

    @OneToMany(mappedBy = "pessoa")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Telefone> telefones = new HashSet<>();

    @OneToOne
    @JoinColumn(unique = true)
    private PaisNacionalidade paisNacionalidade;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private Nacionalidade nacionalidade;

    @OneToOne
    @JoinColumn(unique = true)
    private CondicaoSelecao condicaoSelecao;

    @OneToOne
    @JoinColumn(unique = true)
    private DocumentoIdentificao documentoIdentificao;

    @OneToOne
    @JoinColumn(unique = true)
    private TelefoneMae telefoneMae;

    @OneToOne(mappedBy = "pessoa")
    @JsonIgnore
    private GrupoFamiliar grupoFamiliar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(ZonedDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    

    public CodigoAtualizacao getCodigoAtualizacao() {
		return codigoAtualizacao;
	}

	public void setCodigoAtualizacao(CodigoAtualizacao codigoAtualizacao) {
		this.codigoAtualizacao = codigoAtualizacao;
	}

	public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
    public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    

    public LocalDate getDataCasamento() {
        return dataCasamento;
    }

    public void setDataCasamento(LocalDate dataCasamento) {
        this.dataCasamento = dataCasamento;
    }

    public Double getRendaDeclarada() {
        return rendaDeclarada;
    }

    public void setRendaDeclarada(Double rendaDeclarada) {
        this.rendaDeclarada = rendaDeclarada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public LocalDate getDataNascimentoMae() {
        return dataNascimentoMae;
    }

    public void setDataNascimentoMae(LocalDate dataNascimentoMae) {
        this.dataNascimentoMae = dataNascimentoMae;
    }

    public Set<Empreendimento> getEmpreendimentos() {
        return empreendimentos;
    }

    public void setEmpreendimentos(Set<Empreendimento> empreendimentos) {
        this.empreendimentos = empreendimentos;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    public PaisNacionalidade getNacionalidade() {
        return paisNacionalidade;
    }

    public void setNacionalidade(PaisNacionalidade nacionalidade) {
        this.paisNacionalidade = nacionalidade;
    }

    public CondicaoSelecao getCondicaoSelecao() {
        return condicaoSelecao;
    }

    public void setCondicaoSelecao(CondicaoSelecao condicaoSelecao) {
        this.condicaoSelecao = condicaoSelecao;
    }

    public DocumentoIdentificao getDocumentoIdentificao() {
        return documentoIdentificao;
    }

    public void setDocumentoIdentificao(DocumentoIdentificao documentoIdentificao) {
        this.documentoIdentificao = documentoIdentificao;
    }

    public TelefoneMae getTelefoneMae() {
        return telefoneMae;
    }

    public void setTelefoneMae(TelefoneMae telefoneMae) {
        this.telefoneMae = telefoneMae;
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
        Pessoa pessoa = (Pessoa) o;
        if(pessoa.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
            "id=" + id +
            ", dataCadastro='" + dataCadastro + "'" +
            ", codigoAtualizacao='" + codigoAtualizacao + "'" +
            ", nis='" + nis + "'" +
            ", nome='" + nome + "'" +
            ", cpf='" + cpf + "'" +
            ", dataNascimento='" + dataNascimento + "'" +
            ", sexo='" + sexo + "'" +
            ", naturalidade='" + naturalidade + "'" +
            ", estadoCivil='" + estadoCivil + "'" +
            ", dataCasamento='" + dataCasamento + "'" +
            ", rendaDeclarada='" + rendaDeclarada + "'" +
            ", email='" + email + "'" +
            ", ocupacao='" + ocupacao + "'" +
            ", nomeMae='" + nomeMae + "'" +
            ", dataNascimentoMae='" + dataNascimentoMae + "'" +
            '}';
    }
}
