
package mbeans;

import dao.PedidoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Pedido;

@ManagedBean
@RequestScoped
@SessionScoped
public class PedidoBean {

    private Pedido pedido = new Pedido();
    private DataModel pedidos;
    private PedidoDAO peddao = new PedidoDAO();

    public PedidoBean() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public DataModel getPedidos() {
        
        if(pedidos == null){
            
            pedidos = new ListDataModel(peddao.findAll());
            
        }
        
        return pedidos;
        
    }

    public void setPedidos(DataModel pedidos) {
        this.pedidos = pedidos;
    }

    public String salvar(){

        if(pedido.getPedCodigo() > 0){
            
            peddao.update(pedido);
            
        } else{
            
            peddao.insert(pedido);
            
        }

        return "frmPedidoListar";

    }

    public String select(){
        pedido = (Pedido) pedidos.getRowData();

        return "frmPedidoForm";

    }

    public String novoPedido(){

        pedido = new Pedido();
        return "frmPedidoForm";

    }



}
