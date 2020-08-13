
package mbeans;

import dao.EnderecoDAO;
import dao.PessoaDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Pessoa;
import nucleo.Crypto;


@ManagedBean
@RequestScoped
@SessionScoped
public class PessoaBean {
    
    private Pessoa pessoa = new Pessoa();
    private Pessoa pessoauxx = new Pessoa();
    private DataModel pessoas;
    private PessoaDAO pesdao = new PessoaDAO();
    private EnderecoDAO enddao = new EnderecoDAO();
    private DataModel clientes;
    private DataModel enderecos;
    private int codigo;

    public PessoaBean() {
    }

    public Pessoa getPessoa() {
        
        return pessoa;
        
    }

    public void setPessoa(Pessoa pessoa) {
        
        this.pessoa = pessoa;
        
    }

    public DataModel getPessoas() {
        
        if(pessoas == null){
            pessoas = new ListDataModel(pesdao.findAllUsuarios());
        }
        
        return pessoas;
        
    }

    public void setPessoas(DataModel pessoas) {
        this.pessoas = pessoas;
    }

    public DataModel getClientes() {
        
        if(clientes == null){
            
            clientes = new ListDataModel(pesdao.findAllClientes());
        }
        
        return clientes;
    }

    public void setClientes(DataModel clientes) {
        this.clientes = clientes;
    }

    public Pessoa getPessoauxx() {
        return pessoauxx;
    }

    public void setPessoauxx(Pessoa pessoauxx) {
        this.pessoauxx = pessoauxx;
    }

    public DataModel getEnderecos() {
        
        if (enderecos ==null){
            try{
                enderecos = new ListDataModel(enddao.findByCliente(pessoa.getPesCodigo()));
            } catch (Exception ex){
                enderecos = null;
            }
            
        }
        
        return enderecos;
    }

    public void setEnderecos(DataModel enderecos) {
        this.enderecos = enderecos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
    public String salvarUsuario(){
        
        if(pessoa.getPesCodigo() > 0){
            
            pesdao.update(pessoa);
            
        } else{
            
            String senha = convertMD5(pessoa.getPesSenha());
            
            pessoa.setPesSenha(senha);
            
            pesdao.insert(pessoa);
        }
        
        return "frmPessoaListar";
        
    }
    
        public String salvarCliente(){
        pesdao.update(pessoa);
        return "frmClienteListar";
    }
    
    public String select(){
        
        pessoa = (Pessoa) pessoas.getRowData();
        pessoa = pesdao.findById(pessoa.getPesCodigo());
        return "frmPessoaForm";
        
    }
    
    public String selectCliente(){
        pessoa = (Pessoa) clientes.getRowData();
        pessoa = pesdao.findById(pessoa.getPesCodigo());
        setCodigo(pessoa.getPesCodigo());
        return "frmClienteForm";
    }
    
    public String selectClienteEnderecos(){
        pessoa = (Pessoa) clientes.getRowData();
        pessoa = pesdao.findById(pessoa.getPesCodigo());
        return "frmClienteEnderecos";
    }
    
    public String novaPessoa(){
        pessoa = new Pessoa();
        return "frmPessoaForm";
    }
    
    private String convertMD5(String senha){
        
        String senhaMD5;
        
        try{
        
            senhaMD5 = Crypto.convertToMD5(senha);
        } catch (Exception e){
            senhaMD5 = "";
        }
        
        return senhaMD5;
        
    }
    
    
}
