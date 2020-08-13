/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import dao.CidadeDAO;
import dao.EditoraDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Cidade;
import model.Editora;

@ManagedBean
@RequestScoped
@SessionScoped
public class EditoraBean {
    
    private Editora editora = new Editora();
    private DataModel editoras;
    private EditoraDAO edidao = new EditoraDAO();
    private String ibge;
    private String nomeCid;
    private CidadeDAO ciddao = new CidadeDAO();
    private int codigo;

    public EditoraBean() {
        
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public DataModel getEditoras() {
        
        if(editoras == null){
            editoras = new ListDataModel(edidao.findAll());
        }
        
        return editoras;
    }

    public void setEditoras(DataModel editoras) {
        this.editoras = editoras;
    }
    
     public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getNomeCid() {
        return nomeCid;
    }
    

    public void setNomeCid(String nomeCid) {
        this.nomeCid = nomeCid;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
    public String salvar(){
        
        System.out.println(">> Codigo IBGE: "+ibge);
        
        Cidade cid = new Cidade();
        
        cid = ciddao.findById(Integer.parseInt(ibge));
        
        editora.setCidade(cid);
        
        System.out.println(">> Codigo editora: "+editora.getEdiCodigo()+"");
        
        if(editora.getEdiCodigo() > 0){
            System.out.println(">> Entrou UPDATE");
            edidao.update(editora);
            
        } else{
            
            System.out.println(">> Entrou INSERT");
            edidao.insert(editora);
            
        }
        
        return "frmEditoraListar";
        
    }
    
    public String select(){
        
        editora = (Editora) editoras.getRowData();
        editora = edidao.findById(editora.getEdiCodigo());
        
        setNomeCid(editora.getCidade().getCidNome());
        setIbge(editora.getCidade().getCidCodigo()+"");
        
        return "frmEditoraForm";
        
    }
    
    public String novaEditora(){
        editora = new Editora();
        setNomeCid("");
        setIbge("");
        
        return "frmEditoraForm";
    }
    
}
