package br.gov.ro.portovelho.sicahab.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

import br.gov.ro.portovelho.sicahab.model.enuns.TipoCelular;;;

/**
 * A Telefone.
 */
@Entity
@Table(name = "telefone")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "telefone")
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 3)
    @Column(name = "ddd", length = 3)
    private String ddd;

    @Size(max = 9)
    @Column(name = "numero", length = 9)
    private String numero;

    @Size(max = 4)
    @Column(name = "ramal", length = 4)
    private String ramal;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_celular")
    private TipoCelular tipoCelular;

    @ManyToOne
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public TipoCelular getTipoCelular() {
        return tipoCelular;
    }

    public void setTipoCelular(TipoCelular tipoCelular) {
        this.tipoCelular = tipoCelular;
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
        Telefone telefone = (Telefone) o;
        if(telefone.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, telefone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Telefone{" +
            "id=" + id +
            ", ddd='" + ddd + "'" +
            ", numero='" + numero + "'" +
            ", ramal='" + ramal + "'" +
            ", tipoCelular='" + tipoCelular + "'" +
            '}';
    }
}
