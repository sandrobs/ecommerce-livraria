/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ItensPedidoId implements Serializable {
    
    private Pedido pedido;
    private Produto produto;

    @ManyToOne
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @ManyToOne
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public boolean equals(Object o){
        
        if(this == o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        ItensPedidoId that = (ItensPedidoId) o;
        if(pedido != null ? !pedido.equals(that.pedido) : that.pedido != null) return false;
        if(produto != null ? !produto.equals(that.produto) : that.produto != null)
            return false;

        return true;
    }
    
    public int hashCode(){
       int result;
       result = (pedido != null ? pedido.hashCode() : 0);
       result = 31 * result + (produto != null ? produto.hashCode():0);
       return result;
    }
    
}
