package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto implements Serializable {

    @Id
    private int PrdCodigo;

    private String PrdTitulo;

    private String PrdTipo;

    private String PrdDescricao;

    private String PrdISBN;

    private String PrdPaginas;

    private String PrdEdicao;

    private String PrdTipCapa;

    private int PrdAno;

    private String PrdIdioma;

    private Double PrdAltura;

    private Double PrdLargura;

    private Double PrdComprimento;

    @ManyToOne
    @JoinColumn(name="edicodigo")
    private Editora editora;

    @ManyToOne
    @JoinColumn(name="gencodigo")
    private Genero genero;

    private int PrdEstFisico;

    private int PrdEstReservado;

    private String PrdImage;

    private String PrdPromocao;
    
    private Double PrdPreco;

    public Produto() {
    }

    public int getPrdCodigo() {
        return PrdCodigo;
    }

    public void setPrdCodigo(int PrdCodigo) {
        this.PrdCodigo = PrdCodigo;
    }

    public String getPrdTitulo() {
        return PrdTitulo;
    }

    public void setPrdTitulo(String PrdTitulo) {
        this.PrdTitulo = PrdTitulo;
    }

    public String getPrdTipo() {
        return PrdTipo;
    }

    public void setPrdTipo(String PrdTipo) {
        this.PrdTipo = PrdTipo;
    }

    public String getPrdDescricao() {
        return PrdDescricao;
    }

    public void setPrdDescricao(String PrdDescricao) {
        this.PrdDescricao = PrdDescricao;
    }

    public String getPrdISBN() {
        return PrdISBN;
    }

    public void setPrdISBN(String PrdISBN) {
        this.PrdISBN = PrdISBN;
    }

    public String getPrdPaginas() {
        return PrdPaginas;
    }

    public void setPrdPaginas(String PrdPaginas) {
        this.PrdPaginas = PrdPaginas;
    }

    public String getPrdEdicao() {
        return PrdEdicao;
    }

    public void setPrdEdicao(String PrdEdicao) {
        this.PrdEdicao = PrdEdicao;
    }

    public String getPrdTipCapa() {
        return PrdTipCapa;
    }

    public void setPrdTipCapa(String PrdTipCapa) {
        this.PrdTipCapa = PrdTipCapa;
    }

    public int getPrdAno() {
        return PrdAno;
    }

    public void setPrdAno(int PrdAno) {
        this.PrdAno = PrdAno;
    }

    public String getPrdIdioma() {
        return PrdIdioma;
    }

    public void setPrdIdioma(String PrdIdioma) {
        this.PrdIdioma = PrdIdioma;
    }

    public Double getPrdAltura() {
        return PrdAltura;
    }

    public void setPrdAltura(Double PrdAltura) {
        this.PrdAltura = PrdAltura;
    }

    public Double getPrdLargura() {
        return PrdLargura;
    }

    public void setPrdLargura(Double PrdLargura) {
        this.PrdLargura = PrdLargura;
    }

    public Double getPrdComprimento() {
        return PrdComprimento;
    }

    public void setPrdComprimento(Double PrdComprimento) {
        this.PrdComprimento = PrdComprimento;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getPrdEstFisico() {
        return PrdEstFisico;
    }

    public void setPrdEstFisico(int PrdEstFisico) {
        this.PrdEstFisico = PrdEstFisico;
    }

    public int getPrdEstReservado() {
        return PrdEstReservado;
    }

    public void setPrdEstReservado(int PrdEstReservado) {
        this.PrdEstReservado = PrdEstReservado;
    }

    public String getPrdImage() {
        return PrdImage;
    }

    public void setPrdImage(String PrdImage) {
        this.PrdImage = PrdImage;
    }

    public String getPrdPromocao() {
        return PrdPromocao;
    }

    public void setPrdPromocao(String PrdPromocao) {
        this.PrdPromocao = PrdPromocao;
    }

    public Double getPrdPreco() {
        return PrdPreco;
    }

    public void setPrdPreco(Double PrdPreco) {
        this.PrdPreco = PrdPreco;
    }
        
    
}
