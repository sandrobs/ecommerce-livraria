/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import dao.FormaPagamentoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.FormaPagamento;


@ManagedBean
@RequestScoped
@SessionScoped
public class FormaPagamentoBean {
    
    private FormaPagamento forma = new FormaPagamento();
    private DataModel formas;
    private FormaPagamentoDAO fordao = new FormaPagamentoDAO();

    public FormaPagamentoBean() {
    }

    public FormaPagamento getForma() {
        return forma;
    }

    public void setForma(FormaPagamento forma) {
        this.forma = forma;
    }

    public DataModel getFormas() {
        
        if(formas == null){
            formas = new ListDataModel(fordao.findAll());
        }
        
        return formas;
    }

    public void setFormas(DataModel formas) {
        this.formas = formas;
    }
    
    public String salvar(){
        
        if(forma.getForPagCodigo() > 0){
            
            fordao.update(forma);
            
        } else{
            
            fordao.insert(forma);
            
        }
        
        return "frmFormaPagamentoListar";
        
    }
    
    public String select(){
        forma =  (FormaPagamento) formas.getRowData();
        
        forma = fordao.findById(forma.getForPagCodigo());
        
        return "frmFormaPagamentoForm";
        
    }
    
    public String novaForma(){
        forma = new FormaPagamento();
        return "frmFormaPagamentoForm";
    }
    
    
}
