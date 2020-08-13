
package mbeans;

import dao.EstadoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Estado;


@ManagedBean
@RequestScoped
@SessionScoped
public class EstadoBean {
    
    private Estado estado = new Estado();
    private DataModel estados;
    private EstadoDAO estdao = new EstadoDAO();

    public EstadoBean() {
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public DataModel getEstados() {
        
        if(estados == null){
            estados = new ListDataModel(estdao.findAll());
        }
        
        return estados;
    }

    public void setEstados(DataModel estados) {
        this.estados = estados;
    }
    
    
    
}
