/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import dao.PessoaDAO;
import java.util.List;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Usuario;
import model.Pessoa;
import nucleo.Crypto;

@ManagedBean
@RequestScoped
@SessionScoped
public class SessaoAdminBean {
    
    private String usuario;
    private String senha;
    private PessoaDAO pesdao = new PessoaDAO();
    private Usuario tc_usuario = new Usuario();
    private Pessoa tc_pessoa = new Pessoa();
    private Pessoa o_pessoa = new Pessoa();

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public void aoCarregarPagina(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        
        Pessoa usuarioAdmin;
        
        usuarioAdmin = (Pessoa)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAdmin");
        
        try{
            
            //System.out.println("usuarioAdmin: "+usuarioAdmin.getPesEmail());
        
            if(usuarioAdmin.getPesTipo().equals("1")){

                //System.out.println("usuarioAdmin: "+usuarioAdmin.getPesEmail());

                //nav.performNavigation("index");

            } else{

                nav.performNavigation("frmlogin");

            }
            
        } catch (Exception ex){
            
            nav.performNavigation("frmlogin");
            
        }
        

        
        
    }
    
    public void efetuarLogin(){
        
        Crypto cript = new Crypto();
        
        FacesContext fc = FacesContext.getCurrentInstance();
        
        List<Pessoa> usuarioList= pesdao.findUsuarioAdmin(usuario);
        
        Boolean existeUsuario = false;
        
        for(Pessoa p : usuarioList){
            if(p.getPesCodigo() != 0){
                existeUsuario = true;
                tc_pessoa = p;
            }
        }
        
        Boolean senhaConfere = false;
        
        if(existeUsuario){
            senhaConfere = cript.senhaOK(senha, tc_pessoa.getPesSenha());
        }
        
        
        
        if(!existeUsuario || !senhaConfere){
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("frmerror");
        }
        else{
            
            fc.getExternalContext().getSessionMap().put("usuarioAdmin", tc_pessoa);
            
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("index");
            
        }
        
        
        
    }
    
    public void efetuarLogout(){

        
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().remove("usuarioAdmin");
        
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        nav.performNavigation("frmlogout");
        
        
    }
    
    
    
}
