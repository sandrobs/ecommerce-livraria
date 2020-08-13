package model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProdutoVisitado implements Serializable {

    @Id
    private int PrVCodigo;

    private Date PrVData;

    @ManyToOne
    @JoinColumn(name="procodigo")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name="pescodigo")
    private Pessoa pessoa;

    public ProdutoVisitado() {
    }

    public int getPrVCodigo() {
        return PrVCodigo;
    }

    public void setPrVCodigo(int PrVCodigo) {
        this.PrVCodigo = PrVCodigo;
    }

    public Date getPrVData() {
        return PrVData;
    }

    public void setPrVData(Date PrVData) {
        this.PrVData = PrVData;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
