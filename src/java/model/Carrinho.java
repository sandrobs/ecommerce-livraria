
package model;

/**
 *
 * @author Sandro
 */
public class Carrinho {
    
    
    
    private Produto produto;
    
    private int prdCarrinho;
    
    private int quantidade;

    public Carrinho() {
        
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getPrdCarrinho() {
        return prdCarrinho;
    }

    public void setPrdCarrinho(int prdCarrinho) {
        this.prdCarrinho = prdCarrinho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
}
