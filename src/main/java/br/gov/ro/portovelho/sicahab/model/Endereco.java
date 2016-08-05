package br.gov.ro.portovelho.sicahab.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.gov.ro.portovelho.sicahab.model.enuns.TipoEndereco;
import br.gov.ro.portovelho.sicahab.model.enuns.TipoLogradouro;

@Entity
@Table(name = "endereco")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoLogradouro tipoLogradouro;
	
	@NotNull
	@Column(length=8, name = "cep", nullable = false)
	private String cep;
	
	@NotNull
	@Column(length=70, name = "logradouro", nullable = false)
	private String logradouro;
	
	@Column(length=80, name = "complemento")
	private String complemento;

	
	@NotNull
	@Column(length=7, name = "numero", nullable = false)
	private String numero;
	
	@NotNull
	@Column(length=40, name = "bairro", nullable = false)
	private String bairro;
	
	@NotNull
	@Column(length=40, name = "bairro", nullable = false)
	private String localidade;
	
	@NotNull
	@Column(length=2, name = "uf", nullable = false)
	private String uf;
	
	@NotNull
	@Column(length=7,name = "ibge", nullable = false)
	private String ibge;
	
	@NotNull
	@Column(name = "gia", nullable = false)
	private String gia;
	
	
	@NotNull
	@Column(length=11, name = "latitude", nullable = false)
	private String latitude;
	
	@NotNull
	@Column(length=11, name = "longitude", nullable = false)
	private String longitude;
	
	

	public Endereco() {
	
	}
	
	

	public Endereco(TipoEndereco tipoEndereco, TipoLogradouro tipoLogradouro, String cep, String logradouro,
			String complemento, String numero, String bairro, String localidade, String uf, String ibge, String gia,
			String latitude, String longitude) {
		super();
		
		this.tipoEndereco = tipoEndereco;
		this.tipoLogradouro = tipoLogradouro;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.ibge = ibge;
		this.gia = gia;
		this.latitude = latitude;
		this.longitude = longitude;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", complemento=" + complemento + ", numero=" + numero
				+ ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf + "]";
	}
	
	
	
	
}
