package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UltimoNumero implements Serializable {

    @Id
    private String UltTabNome;

    private int UltTabSequencial;

    public UltimoNumero() {
        
        
    }

    public String getUltTabNome() {
        return UltTabNome;
    }

    public void setUltTabNome(String UltTabNome) {
        this.UltTabNome = UltTabNome;
    }

    public int getUltTabSequencial() {
        return UltTabSequencial;
    }

    public void setUltTabSequencial(int UltTabSequencial) {
        this.UltTabSequencial = UltTabSequencial;
    }

}
