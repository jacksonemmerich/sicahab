package br.gov.ro.portovelho.sicahab.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A TelefoneMae.
 */
@Entity
@Table(name = "telefone_mae")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Document(indexName = "telefonemae")
public class TelefoneMae implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 2)
    @Column(name = "ddd", length = 2, nullable = false)
    private String ddd;

    @NotNull
    @Size(max = 9)
    @Column(name = "numero", length = 9, nullable = false)
    private String numero;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelefoneMae telefoneMae = (TelefoneMae) o;
        if(telefoneMae.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, telefoneMae.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "TelefoneMae{" +
            "id=" + id +
            ", ddd='" + ddd + "'" +
            ", numero='" + numero + "'" +
            '}';
    }
}
