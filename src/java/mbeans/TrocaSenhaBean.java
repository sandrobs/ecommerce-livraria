/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import dao.PessoaDAO;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Pessoa;
import nucleo.Crypto;

@ManagedBean
@RequestScoped
@SessionScoped
public class TrocaSenhaBean {
    
    private Pessoa pessoa;
    private String senhaAtual;
    private String novaSenha;
    private String novaSenha2;
    private PessoaDAO pesdao = new PessoaDAO();
    private String mensagem;

    public TrocaSenhaBean() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getNovaSenha2() {
        return novaSenha2;
    }

    public void setNovaSenha2(String novaSenha2) {
        this.novaSenha2 = novaSenha2;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public void alterarSenhaUsuario(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        
        Pessoa usuarioAdmin;
        
        usuarioAdmin = (Pessoa)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAdmin");
        
        //System.out.println(">> Usuario: "+usuarioAdmin.getPesCodigo());
        
        
        
        pessoa = pesdao.findById(usuarioAdmin.getPesCodigo());
        
        String senhaAtualMD5 = "";
        String novaSenhaMD5 = "";
        String novaSenha2MD5 = "";
        String senha = "";
        
        try{
            
            senhaAtualMD5 = Crypto.convertToMD5(senhaAtual);
            novaSenhaMD5  = Crypto.convertToMD5(novaSenha);
            novaSenha2MD5 = Crypto.convertToMD5(novaSenha2);
            
            if(novaSenhaMD5.equals(novaSenha2MD5)){
                
                if(senhaAtualMD5.equals(pessoa.getPesSenha())){
                    
                    pessoa.setPesSenha(senha);
                    pesdao.update(pessoa);
                    
                    nav.performNavigation("index.xhtml");
                    
                } else{
                    
                    mensagem = "A senha digita é diferente da senha atual!";
                    
                    nav.performNavigation("frmSenhaErrada");
                    
                }
                
            } else{
                
                mensagem = "Os valores da nova senha não são iguais!";
                    
                nav.performNavigation("frmSenhaErrada");
                
            }
            
            
        } catch( Exception ex){
            mensagem = "Não foi possível trocar a senha!";
                    
            nav.performNavigation("frmSenhaErrada");
        }
        
        
    }
    
    
    
}
