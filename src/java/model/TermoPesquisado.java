package model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TermoPesquisado implements Serializable {

    @Id
    private int TerPesCodigo;

    private String TerPesTexto;

    private Date TerPesData;

    private int TerPesTipo;

    @ManyToOne
    @JoinColumn(name="pescodigo")
    private Pessoa pessoa;

    public TermoPesquisado() {
    }

    public int getTerPesCodigo() {
        return TerPesCodigo;
    }

    public void setTerPesCodigo(int TerPesCodigo) {
        this.TerPesCodigo = TerPesCodigo;
    }

    public String getTerPesTexto() {
        return TerPesTexto;
    }

    public void setTerPesTexto(String TerPesTexto) {
        this.TerPesTexto = TerPesTexto;
    }

    public Date getTerPesData() {
        return TerPesData;
    }

    public void setTerPesData(Date TerPesData) {
        this.TerPesData = TerPesData;
    }

    public int getTerPesTipo() {
        return TerPesTipo;
    }

    public void setTerPesTipo(int TerPesTipo) {
        this.TerPesTipo = TerPesTipo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
        
        

}
