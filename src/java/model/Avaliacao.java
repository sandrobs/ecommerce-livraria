package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Avaliacao implements Serializable {

    @Id
    private int AvaCodigo;

    private String AvaTitulo;

    private int AvaNota;

    private String AvaDescricao;
    
    private int AvaStatus; //1 - Pendente; 2 - Aprovado; 3 - Reprovado

    @ManyToOne
    @JoinColumn(name="prdcodigo")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name="pescodigo")
    private Pessoa pessoa;

    public Avaliacao() {
        
    }

    public int getAvaCodigo() {
        return AvaCodigo;
    }

    public void setAvaCodigo(int AvaCodigo) {
        this.AvaCodigo = AvaCodigo;
    }

    public String getAvaTitulo() {
        return AvaTitulo;
    }

    public void setAvaTitulo(String AvaTitulo) {
        this.AvaTitulo = AvaTitulo;
    }

    public int getAvaNota() {
        return AvaNota;
    }

    public void setAvaNota(int AvaNota) {
        this.AvaNota = AvaNota;
    }

    public String getAvaDescricao() {
        return AvaDescricao;
    }

    public void setAvaDescricao(String AvaDescricao) {
        this.AvaDescricao = AvaDescricao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getAvaStatus() {
        return AvaStatus;
    }

    public void setAvaStatus(int AvaStatus) {
        this.AvaStatus = AvaStatus;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

        
        
}
