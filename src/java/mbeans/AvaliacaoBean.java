/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import dao.AvaliacaoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Avaliacao;
import nucleo.VariaveisGlobais;


@ManagedBean
@RequestScoped
@SessionScoped
public class AvaliacaoBean {
   
    private Avaliacao avaliacao = new Avaliacao();
    private DataModel avaliacoes;
    private DataModel avaliacoesFiltradas;
    private AvaliacaoDAO avadao = new AvaliacaoDAO();
    private int statusConsulta;
    private int codigo;
    
    public AvaliacaoBean(){
        
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public DataModel getAvaliacoesFiltradas() {
        
        //System.err.println(">> GET AVALIACOES");
        
        if(avaliacoes == null){
            
            if(statusConsulta > 0 ){
                //System.err.println(">> STATUS CONSULTA <> 0");
                avaliacoesFiltradas = new ListDataModel(avadao.avaliacoesStatus(statusConsulta));
                
            } else{
                //System.err.println(">> BUSCA OS DADOS");
                avaliacoesFiltradas = new ListDataModel(avadao.findAll());
                
            }
            
        }
        
        return avaliacoesFiltradas;
        
    }

    public void setAvaliacoesFiltradas(DataModel avaliacoesFiltradas) {
        this.avaliacoesFiltradas = avaliacoesFiltradas;
    }

    public DataModel getAvaliacoes() {//retorna na consulta somente
        
        if(avaliacoes == null){
            if(statusConsulta == 0){
                avaliacoes = new ListDataModel(avadao.avaliacoesStatus(1)); //pendentes de aprovação
            } else{
                //System.out.print("saida - Filtro");
                avaliacoes = new ListDataModel(avadao.avaliacoesStatus(statusConsulta));
            }            
        }
        
        return avaliacoes;
    }

    public void setAvaliacoes(DataModel avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public int getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(int statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
    public String salvar(){
        
        if(avaliacao.getAvaCodigo() > 0){
            
            avadao.update(avaliacao);
            
        } else{
            
            avadao.insert(avaliacao);
            
        }
        
        return "";
        
    }
    
    public String aprovar(){
        
        Avaliacao aval = avadao.findById(VariaveisGlobais.codigoAvaliacao);
        
        aval.setAvaStatus(2);
        
        avadao.update(aval);
        
        
        return "frmAvaliacoesListar";
        
    }
    
    
    public String naoAprovar(){

        Avaliacao aval = avadao.findById(VariaveisGlobais.codigoAvaliacao);
        
        aval.setAvaStatus(3);
        
        avadao.update(aval);
        
        return "frmAvaliacoesListar";
        
    }
    
    public String select(){
        
        avaliacao = (Avaliacao) avaliacoesFiltradas.getRowData();
        avaliacao = avadao.findById(avaliacao.getAvaCodigo());
        
        this.setCodigo(avaliacao.getAvaCodigo());
        
        VariaveisGlobais.codigoAvaliacao = avaliacao.getAvaCodigo();
        
        return "frmAvaliacoesForm";
        
    }
    
    public String novaAvaliacao(){
        
        avaliacao = new Avaliacao();
        return "";
        
    }
    
    public String teste(){
        return "frmAvaliacoesListar";
    }
                                                                                                      
    
    
}
