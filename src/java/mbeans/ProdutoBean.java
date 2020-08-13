
package mbeans;

import dao.EditoraDAO;
import dao.GeneroDAO;
import dao.ProdutoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Editora;
import model.Genero;
import model.Produto;


@ManagedBean
@RequestScoped
@SessionScoped
public class ProdutoBean {
    
    private Produto produto = new Produto();
    private DataModel produtos;
    private ProdutoDAO prddao = new ProdutoDAO();
    private GeneroDAO gendao = new GeneroDAO();
    private List<Genero> generos;
    private EditoraDAO edidao = new EditoraDAO();
    private List<Editora> editoras;
    private int codigo;
    private int generoSearch;
    private String prdDescSearch;
    private int idSearch;

    public ProdutoBean() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public DataModel getProdutos() {
        
        if(produtos == null){
            produtos = new ListDataModel(prddao.findAll());
        }
        
        return produtos;
    }

    public void setProdutos(DataModel produtos) {
        this.produtos = produtos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getGeneroSearch() {
        return generoSearch;
    }

    public void setGeneroSearch(int generoSearch) {
        this.generoSearch = generoSearch;
    }

    public String getPrdDescSearch() {
        return prdDescSearch;
    }

    public void setPrdDescSearch(String prdDescSearch) {
        this.prdDescSearch = prdDescSearch;
    }

    public int getIdSearch() {
        return idSearch;
    }

    public void setIdSearch(int idSearch) {
        this.idSearch = idSearch;
    }
    
    
    
    public String salvar(){
        if(produto.getPrdCodigo() > 0){
            prddao.update(produto);
        } else{
            prddao.insert(produto);
        }
        
        return "frmProdutoListar";
        
    }
    
    public String select(){
        produto = (Produto) produtos.getRowData();
        produto = prddao.findById(produto.getPrdCodigo());
        setCodigo(produto.getPrdCodigo());
        
        return "frmProdutoForm";
        
    }
    
    public String novoProduto(){
        produto = new Produto();
        setCodigo(0);
        return "frmProdutoForm";
    }

    public List<Genero> getGeneros() {
        generos = gendao.findAll();
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Editora> getEditoras() {
        editoras = edidao.findAll();
        return editoras;
    }

    public void setEditoras(List<Editora> editoras) {
        this.editoras = editoras;
    }
    
    public String busca(){
        return "frmProdutoForm.xhtml?descprd="+prdDescSearch;
    }
    
}
