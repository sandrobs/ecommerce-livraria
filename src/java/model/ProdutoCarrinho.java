package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProdutoCarrinho implements Serializable {

    @Id
    private int ProCarCodigo;

    @ManyToOne
    @JoinColumn(name="prdcodigo")
    private Produto produto;

    private Date ProCarData;

    private String ProCarComprado;

    @ManyToOne
    @JoinColumn(name="pescodigo")
    private Pessoa pessoa;

    public ProdutoCarrinho() {
    }

    public int getProCarCodigo() {
        return ProCarCodigo;
    }

    public void setProCarCodigo(int ProCarCodigo) {
        this.ProCarCodigo = ProCarCodigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getProCarData() {
        return ProCarData;
    }

    public void setProCarData(Date ProCarData) {
        this.ProCarData = ProCarData;
    }

    public String getProCarComprado() {
        return ProCarComprado;
    }

    public void setProCarComprado(String ProCarComprado) {
        this.ProCarComprado = ProCarComprado;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }


}
