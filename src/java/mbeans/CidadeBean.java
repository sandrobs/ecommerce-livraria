
package mbeans;

import dao.CidadeDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Cidade;

@ManagedBean
@RequestScoped
@SessionScoped
public class CidadeBean {
    
    private Cidade cidade = new Cidade();
    private DataModel cidades;
    private CidadeDAO ciddao = new CidadeDAO();
    
    public CidadeBean(){
        
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public DataModel getCidades() {
        
        if(cidades == null){
            cidades = new ListDataModel(ciddao.findAll());
        }
        
        return cidades;
    }

    public void setCidades(DataModel cidades) {
        this.cidades = cidades;
    }
    
}
