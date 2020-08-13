package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FormaPagamento implements Serializable {

    @Id
    private int ForPagCodigo;

    private int ForPagTipo;

    private int ForPagNumVezes;

    private String ForPagDescricao;

    public FormaPagamento() {
        
    }

    public int getForPagCodigo() {
        return ForPagCodigo;
    }

    public void setForPagCodigo(int ForPagCodigo) {
        this.ForPagCodigo = ForPagCodigo;
    }

    public int getForPagTipo() {
        return ForPagTipo;
    }

    public void setForPagTipo(int ForPagTipo) {
        this.ForPagTipo = ForPagTipo;
    }

    public int getForPagNumVezes() {
        return ForPagNumVezes;
    }

    public void setForPagNumVezes(int ForPagNumVezes) {
        this.ForPagNumVezes = ForPagNumVezes;
    }

    public String getForPagDescricao() {
        return ForPagDescricao;
    }

    public void setForPagDescricao(String ForPagDescricao) {
        this.ForPagDescricao = ForPagDescricao;
    }   

}
