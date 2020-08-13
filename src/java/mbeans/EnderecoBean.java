/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import dao.EnderecoDAO;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Endereco;


public class EnderecoBean {
    
    private Endereco endereco = new Endereco();
    private DataModel enderecos;
    private EnderecoDAO enddao = new EnderecoDAO();

    public EnderecoBean() {
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public DataModel getEnderecos() {
        
        if(enderecos == null){
            enderecos = new ListDataModel(enddao.findAll());
        }
        
        return enderecos;
    }

    public void setEnderecos(DataModel enderecos) {
        this.enderecos = enderecos;
    }
    
    public String salvar(){
        
        if(endereco.getEndCodigo() > 0){
            enddao.update(endereco);
        } else {
            enddao.insert(endereco);
        }
        
        return "";
        
    }
    
    public String select(){
        endereco = (Endereco) enderecos.getRowData();
        
        return "";
        
    }
    
    public String novoEndereco(){
        endereco = new Endereco();
        return "";
    }
    
}
