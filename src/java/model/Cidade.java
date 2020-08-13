package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade implements Serializable {
    
    @Id
    private int CidCodigo;

    private String cidNome;

    @ManyToOne
    @JoinColumn(name="estcodigo")
    private Estado estado;

    public Cidade() {
        
    }

    public int getCidCodigo() {
        return CidCodigo;
    }

    public void setCidCodigo(int CidCodigo) {
        this.CidCodigo = CidCodigo;
    }

    public String getCidNome() {
        return cidNome;
    }

    public void setCidNome(String cidNome) {
        this.cidNome = cidNome;
    }


    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
