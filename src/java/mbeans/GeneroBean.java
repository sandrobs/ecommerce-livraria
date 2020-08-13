
package mbeans;

import dao.GeneroDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Genero;

@ManagedBean
@RequestScoped
public class GeneroBean {
    
    private Genero genero = new Genero();
    private DataModel generos;
    private GeneroDAO gendao = new GeneroDAO();
    
    List<Genero> listageneros = new GeneroDAO().findAll();

    public GeneroBean() {
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public DataModel getGeneros() {
        
        if(generos == null){
            generos = new ListDataModel(gendao.findAll());
        }
        
        return generos;
    }

    public void setGeneros(DataModel generos) {
        
        this.generos = generos;
        
    }

    public List<Genero> getListageneros() {
        return listageneros;
    }

    public void setListageneros(List<Genero> listageneros) {
        this.listageneros = listageneros;
    }
    
    
    public String salvar(){
        
        if(genero.getGenCodigo() > 0){
            gendao.update(genero);
        } else{
            
            gendao.insert(genero);
        }
        return "frmGeneroListar";
    }
    
    public String select(){
        
        genero = (Genero) generos.getRowData();
        
        genero = gendao.findById(genero.getGenCodigo());
        
        return "frmGeneroForm";
    }
    
    public String novoGenero(){
        genero = new Genero();
        return "frmGeneroForm";
    }
    
    public String delete(){
        genero = (Genero) generos.getRowData();
        gendao.delete(genero);
        generos = null;
        return "frmGeneroListar";
    }
    
    
}
