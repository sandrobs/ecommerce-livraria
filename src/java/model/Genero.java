package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genero implements Serializable {

    @Id
    private int GenCodigo;

    private String GenDescricao;

    public Genero() {
    }

    public int getGenCodigo() {
        return GenCodigo;
    }

    public void setGenCodigo(int GenCodigo) {
        this.GenCodigo = GenCodigo;
    }

    public String getGenDescricao() {
        return GenDescricao;
    }

    public void setGenDescricao(String GenDescricao) {
        this.GenDescricao = GenDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.GenCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Genero other = (Genero) obj;
        if (this.GenCodigo != other.GenCodigo) {
            return false;
        }
        return true;
    }
   
}
