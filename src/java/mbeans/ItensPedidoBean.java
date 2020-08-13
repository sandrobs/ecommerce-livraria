
package mbeans;

import dao.ItensPedidoDAO;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.ItensPedido;

public class ItensPedidoBean {
    
    private ItensPedido item = new ItensPedido();
    private DataModel itens;
    private ItensPedidoDAO itedao = new ItensPedidoDAO();

    public ItensPedidoBean() {
    }

    public ItensPedido getItem() {
        return item;
    }

    public void setItem(ItensPedido item) {
        this.item = item;
    }

    public DataModel getItens() {
        
        if(itens == null){
            
            itens = new ListDataModel(itedao.findAll());
            
        }
        
        return itens;
    }

    public void setItens(DataModel itens) {
        this.itens = itens;
    }
    
    public String salvar(){ //somente insere o item no pedido
        
        itedao.insert(item);
   
        return "";
        
    }
    
    public String novoItem(){
        item = new ItensPedido();
        return "";
    }
    
}
