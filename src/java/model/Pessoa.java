package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable {

    @Id
    private int PesCodigo;

    private String PesNome;

    private String PesCPF;

    private String PesSobrenome;

    private String PesEmail;

    private String PesSenha;

    private String PesTipo;

    private int PesNvlAcesso;
    
    private String PesFone;

    public Pessoa() {
    }

    public int getPesCodigo() {
        return PesCodigo;
    }

    public void setPesCodigo(int PesCodigo) {
        this.PesCodigo = PesCodigo;
    }

    public String getPesNome() {
        return PesNome;
    }

    public void setPesNome(String PesNome) {
        this.PesNome = PesNome;
    }

    public String getPesCPF() {
        return PesCPF;
    }

    public void setPesCPF(String PesCPF) {
        this.PesCPF = PesCPF;
    }

    public String getPesSobrenome() {
        return PesSobrenome;
    }

    public void setPesSobrenome(String PesSobrenome) {
        this.PesSobrenome = PesSobrenome;
    }

    public String getPesEmail() {
        return PesEmail;
    }

    public void setPesEmail(String PesEmail) {
        this.PesEmail = PesEmail;
    }

    public String getPesSenha() {
        return PesSenha;
    }

    public void setPesSenha(String PesSenha) {
        this.PesSenha = PesSenha;
    }

    public String getPesTipo() {
        return PesTipo;
    }

    public void setPesTipo(String PesTipo) {
        this.PesTipo = PesTipo;
    }

    public int getPesNvlAcesso() {
        return PesNvlAcesso;
    }

    public void setPesNvlAcesso(int PesNvlAcesso) {
        this.PesNvlAcesso = PesNvlAcesso;
    }

    public String getPesFone() {
        return PesFone;
    }

    public void setPesFone(String PesFone) {
        this.PesFone = PesFone;
    }

    
    
}
