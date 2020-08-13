package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado implements Serializable {

    @Id
    private int EstCodigo;

    private String EstNome;

    private String EstUF;

    public Estado() {
        
    }

    public int getEstCodigo() {
        return EstCodigo;
    }

    public void setEstCodigo(int EstCodigo) {
        this.EstCodigo = EstCodigo;
    }

    public String getEstNome() {
        return EstNome;
    }

    public void setEstNome(String EstNome) {
        this.EstNome = EstNome;
    }

    public String getEstUF() {
        return EstUF;
    }

    public void setEstUF(String EstUF) {
        this.EstUF = EstUF;
    }

    
}
