package model;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

@Entity
@AssociationOverrides({
    @AssociationOverride(name="pk.pedido",
            joinColumns = @JoinColumn(name="pedcodigo")),
    @AssociationOverride(name="pk.produto",
            joinColumns = @JoinColumn(name="procodigo"))
})

public class ItensPedido implements Serializable {

   // private Pedido pedido;

   // private Produto produto;

    private ItensPedidoId pk = new ItensPedidoId();
    
    private Double PedVlrItem;

    private int PedQtdItem;

    public ItensPedido() {
    }

    @EmbeddedId
    public ItensPedidoId getPk() {
        return pk;
    }

    public void setPk(ItensPedidoId pk) {
        this.pk = pk;
    }

    @Transient
    public Pedido getPedido(){
        return getPk().getPedido();
    }
    
    public void setPedido(Pedido pedido){
        
        getPk().setPedido(pedido);
        
    }
    
    @Transient
    public Produto getProduto(){
        return getPk().getProduto();
    }
    
    public void setProduto(Produto produto){
        getPk().setProduto(produto);
    }
    
    
    public Double getPedVlrItem() {
        return PedVlrItem;
    }

    public void setPedVlrItem(Double PedVlrItem) {
        this.PedVlrItem = PedVlrItem;
    }

    public int getPedQtdItem() {
        return PedQtdItem;
    }

    public void setPedQtdItem(int PedQtdItem) {
        this.PedQtdItem = PedQtdItem;
    }
    
    public boolean equals(Object o){
        
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        
        ItensPedido that = (ItensPedido) o;
        
        if(getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;
        
        return true;
        
    }
    
    public int hashCode(){
        return (getPk() != null ? getPk().hashCode() : 0);
    }

}
