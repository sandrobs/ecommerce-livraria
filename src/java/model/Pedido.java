package model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido implements Serializable {

    @Id
    private int PedCodigo;

    private Date PedDtaRealizado;

    private int PedStatus;

    private Date PedDtaPagamento;

    @ManyToOne
    @JoinColumn(name="pescodigo")
    private Pessoa pessoa;

    private int PedEndEntrega;

    @ManyToOne
    @JoinColumn(name="forpagcodigo")
    private FormaPagamento formapagamento;

    private Date PedDtaEntrega;

    public Pedido() {
    }

    public int getPedCodigo() {
        return PedCodigo;
    }

    public void setPedCodigo(int PedCodigo) {
        this.PedCodigo = PedCodigo;
    }

    public Date getPedDtaRealizado() {
        return PedDtaRealizado;
    }

    public void setPedDtaRealizado(Date PedDtaRealizado) {
        this.PedDtaRealizado = PedDtaRealizado;
    }

    public int getPedStatus() {
        return PedStatus;
    }

    public void setPedStatus(int PedStatus) {
        this.PedStatus = PedStatus;
    }

    public Date getPedDtaPagamento() {
        return PedDtaPagamento;
    }

    public void setPedDtaPagamento(Date PedDtaPagamento) {
        this.PedDtaPagamento = PedDtaPagamento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getPedEndEntrega() {
        return PedEndEntrega;
    }

    public void setPedEndEntrega(int PedEndEntrega) {
        this.PedEndEntrega = PedEndEntrega;
    }

    public FormaPagamento getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(FormaPagamento formapagamento) {
        this.formapagamento = formapagamento;
    }

    public Date getPedDtaEntrega() {
        return PedDtaEntrega;
    }

    public void setPedDtaEntrega(Date PedDtaEntrega) {
        this.PedDtaEntrega = PedDtaEntrega;
    }


}
