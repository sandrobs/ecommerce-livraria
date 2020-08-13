/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import dao.ProdutoCarrinhoDAO;
import dao.ProdutoDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import model.Carrinho;
import model.Produto;
import model.ProdutoCarrinho;
import nucleo.SequencialManager;


@ManagedBean
@RequestScoped
@SessionScoped
public class CarrinhoBean {

    private Carrinho carrinho;
    private DataModel lista;
    private int numItens;
    private Double total;
    private ProdutoDAO prddao = new ProdutoDAO();
    private int prdcod;
    private ProdutoCarrinhoDAO prdcar = new ProdutoCarrinhoDAO();
    private Produto detProduto = new Produto();
    private int qtdeItens;
    private String existeEstoque;
    private String tipoCapa;
    private Double totalCarrinho;

    public CarrinhoBean() {
        
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public DataModel getLista() {
        return lista;
    }

    public void setLista(DataModel lista) {
        this.lista = lista;
    }

    public int getNumItens() {
        return numItens;
    }

    public void setNumItens(int numItens) {
        this.numItens = numItens;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getPrdcod() {
        return prdcod;
    }

    public void setPrdcod(int prdcod) {
        this.prdcod = prdcod;
    }

    public Produto getDetProduto() {
        
        detProduto = prddao.findById(prdcod);
        
        return detProduto;
    }

    public void setDetProduto(Produto detProduto) {
        this.detProduto = detProduto;
    }

    public int getQtdeItens() {
        
        FacesContext fc = FacesContext.getCurrentInstance();
        
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        
        List<Carrinho> CarrinhoCompra;
        
        CarrinhoCompra = (List<Carrinho>)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("carrinhoUnderground");
        
        int count = 0;
        
        try{
           for(Carrinho d : CarrinhoCompra){ //valida se existe lista de produtos
    
                if(d.getProduto().getPrdCodigo() !=0){

                    count +=1;


                }
            
            }
        } catch (Exception ex){
            
            count = 0;
            
        }
        
        
        
        qtdeItens = count;
        
        return qtdeItens;
    }

    public void setQtdeItens(int qtdeItens) {
        this.qtdeItens = qtdeItens;
    }

    public String getExisteEstoque() {
        
        Produto pest = new Produto();
        
        pest = prddao.findById(prdcod);
        
        if(pest.getPrdEstFisico()>pest.getPrdEstReservado()){
            existeEstoque = "Produto em Estoque";
        } else{
            existeEstoque = "Indisponível no Estoque";
        }
        
        return existeEstoque;
    }

    public void setExisteEstoque(String existeEstoque) {
        this.existeEstoque = existeEstoque;
    }

    public String getTipoCapa() {
        
        Produto pest = new Produto();
        
        pest = prddao.findById(prdcod);
        
        if(pest.getPrdTipCapa().equals("D")){
            tipoCapa = "Capa Dura";
        } else{
            tipoCapa = "Brochura";
        }
        
        return tipoCapa;
    }

    public void setTipoCapa(String tipoCapa) {
        this.tipoCapa = tipoCapa;
    }

    public Double getTotalCarrinho() {
        return totalCarrinho;
    }

    public void setTotalCarrinho(Double totalCarrinho) {
        
        this.totalCarrinho = totalCarrinho;
    }
    
    
    
    public void adicionarCarrinho(){
        
        System.out.println(">> Inicia Processo");
        
        FacesContext fc = FacesContext.getCurrentInstance();
        
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        
        List<Carrinho> CarrinhoCompra = new ArrayList<Carrinho>();
        
        CarrinhoCompra = (List<Carrinho>)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("carrinhoUnderground");
        
        Boolean existeNoCarrinho = false;
        Boolean existeLista = false;
        
        try{
            
            
            for(Carrinho d : CarrinhoCompra){ //valida se existe lista de produtos

                if(d.getProduto().getPrdCodigo() !=0){
                    existeLista = true;
                    break;
                }

            }
        
            
            for(Carrinho d : CarrinhoCompra){ //valida se o produto ja existe no carrinho
    
                if(d.getProduto().getPrdCodigo() == prdcod){
                    existeNoCarrinho = true;
                }
            
            }
            
        } catch (Exception ex){
            
            System.out.println(">> Caiu no Catch");
            
            CarrinhoCompra = new ArrayList<Carrinho>();
            
        }
        
        if(existeNoCarrinho){
            
            System.out.println(">> existe no carrinho true");
            
            nav.performNavigation("frmCarrinho"); //se já existe redireciona pra a tela do carrinho
            
        } else{
            System.out.println(">> existe no carrinho False");      
            
            Produto produto = new Produto();
            produto = prddao.findById(prdcod);

            if(produto.getPrdCodigo() != 0){ // adiciona somente se produto estiver selecionado

                System.out.println(">> Produto selecionado");
                
                Date data = new Date(System.currentTimeMillis());

                SequencialManager seq = new SequencialManager();

                int codigo = 0;
                
                codigo = seq.getSequencial("produtocarrinho");

                System.out.println(">> Codigo Carrinho: "+codigo);
                
                ProdutoCarrinho prdAddCarrinho = new ProdutoCarrinho();

                prdAddCarrinho.setProCarCodigo(codigo);
                prdAddCarrinho.setProduto(produto);
                prdAddCarrinho.setPessoa(null);
                prdAddCarrinho.setProCarComprado("N");
                prdAddCarrinho.setProCarData(data);

                prdcar.insert(prdAddCarrinho);
                
                Carrinho teste = new Carrinho();
                
                teste.setProduto(produto);
                teste.setPrdCarrinho(codigo);
                teste.setQuantidade(1);
                

                CarrinhoCompra.add(teste);
                
                fc.getExternalContext().getSessionMap().remove("carrinhoUnderground");
                
                fc.getExternalContext().getSessionMap().put("carrinhoUnderground", CarrinhoCompra);
                
            }
            
            
            
        }
        
        System.out.println("Chegou aqui");
        
        ConfigurableNavigationHandler hue = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        
        //hue.performNavigation("frmCarrinho"); //depois de adicionar o carrinho na memória volta pra tela :)
        
        System.out.println(">> passou daqui :p");
        
        try {
            go_carrito();
            
            //return "carrinho";
        } catch (IOException ex) {
            Logger.getLogger(CarrinhoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void go_carrito() throws IOException{
        
        
        //FacesContext tt = FacesContext.getCurrentInstance();
        //tt.getExternalContext().getSessionMap().remove("usuarioAdmin");
        
        //ConfigurableNavigationHandler jk = (ConfigurableNavigationHandler) tt.getApplication().getNavigationHandler();
        //jk.performNavigation("frmCarrinho");
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("frmCarrinho.xhtml");
        
    }
    
}
