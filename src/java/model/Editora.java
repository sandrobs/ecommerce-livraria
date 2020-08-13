package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Editora implements Serializable {

    @Id
    private int EdiCodigo;

    private String EdiRazSocial;

    private String EdiCNPJ;

    private String EdiNomFantasia;

    private String EdiEndereco;

    private String EdiNumero;

    private String EdiComplemento;

    private String EdiBairro;

    private String EdiCEP;

    private String EdiEmail;

    private String EdiFone;

    private String EdiLinEditorial;
    
    @ManyToOne
    @JoinColumn(name="cidcodigo")
    private Cidade cidade;

    public Editora() {
        
    }

    public int getEdiCodigo() {
        return EdiCodigo;
    }

    public void setEdiCodigo(int EdiCodigo) {
        this.EdiCodigo = EdiCodigo;
    }

    public String getEdiRazSocial() {
        return EdiRazSocial;
    }

    public void setEdiRazSocial(String EdiRazSocial) {
        this.EdiRazSocial = EdiRazSocial;
    }

    public String getEdiCNPJ() {
        return EdiCNPJ;
    }

    public void setEdiCNPJ(String EdiCNPJ) {
        this.EdiCNPJ = EdiCNPJ;
    }

    public String getEdiNomFantasia() {
        return EdiNomFantasia;
    }

    public void setEdiNomFantasia(String EdiNomFantasia) {
        this.EdiNomFantasia = EdiNomFantasia;
    }

    public String getEdiEndereco() {
        return EdiEndereco;
    }

    public void setEdiEndereco(String EdiEndereco) {
        this.EdiEndereco = EdiEndereco;
    }

    public String getEdiNumero() {
        return EdiNumero;
    }

    public void setEdiNumero(String EdiNumero) {
        this.EdiNumero = EdiNumero;
    }

    public String getEdiComplemento() {
        return EdiComplemento;
    }

    public void setEdiComplemento(String EdiComplemento) {
        this.EdiComplemento = EdiComplemento;
    }

    public String getEdiBairro() {
        return EdiBairro;
    }

    public void setEdiBairro(String EdiBairro) {
        this.EdiBairro = EdiBairro;
    }

    public String getEdiCEP() {
        return EdiCEP;
    }

    public void setEdiCEP(String EdiCEP) {
        this.EdiCEP = EdiCEP;
    }

    public String getEdiEmail() {
        return EdiEmail;
    }

    public void setEdiEmail(String EdiEmail) {
        this.EdiEmail = EdiEmail;
    }

    public String getEdiFone() {
        return EdiFone;
    }

    public void setEdiFone(String EdiFone) {
        this.EdiFone = EdiFone;
    }

    public String getEdiLinEditorial() {
        return EdiLinEditorial;
    }

    public void setEdiLinEditorial(String EdiLinEditorial) {
        this.EdiLinEditorial = EdiLinEditorial;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.EdiCodigo;
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
        final Editora other = (Editora) obj;
        if (this.EdiCodigo != other.EdiCodigo) {
            return false;
        }
        return true;
    }
    
    
    
}
