package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Endereco implements Serializable {

        @Id
	private int EndCodigo;
        
        @ManyToOne
        @JoinColumn(name="pescodigo")
	private Pessoa pessoa;

	private String EndDescricao;

	private String EndTipo;

	private String EndCEP;

	private String EndEndereco;

	private String EndNumero;

	private String EndComplemento;

	private String EndBairro;

	private String EndPonReferencia;

	private String EndNome;

	private String EndSobrenome;

	private String EndFone;

        @ManyToOne
        @JoinColumn(name="cidcodigo")
	private Cidade cidade;

    public Endereco() {
        
    }

    public int getEndCodigo() {
        return EndCodigo;
    }

    public void setEndCodigo(int EndCodigo) {
        this.EndCodigo = EndCodigo;
    }

    public String getEndDescricao() {
        return EndDescricao;
    }

    public void setEndDescricao(String EndDescricao) {
        this.EndDescricao = EndDescricao;
    }

    public String getEndTipo() {
        return EndTipo;
    }

    public void setEndTipo(String EndTipo) {
        this.EndTipo = EndTipo;
    }

    public String getEndCEP() {
        return EndCEP;
    }

    public void setEndCEP(String EndCEP) {
        this.EndCEP = EndCEP;
    }

    public String getEndEndereco() {
        return EndEndereco;
    }

    public void setEndEndereco(String EndEndereco) {
        this.EndEndereco = EndEndereco;
    }

    public String getEndNumero() {
        return EndNumero;
    }

    public void setEndNumero(String EndNumero) {
        this.EndNumero = EndNumero;
    }

    public String getEndComplemento() {
        return EndComplemento;
    }

    public void setEndComplemento(String EndComplemento) {
        this.EndComplemento = EndComplemento;
    }

    public String getEndBairro() {
        return EndBairro;
    }

    public void setEndBairro(String EndBairro) {
        this.EndBairro = EndBairro;
    }

    public String getEndPonReferencia() {
        return EndPonReferencia;
    }

    public void setEndPonReferencia(String EndPonReferencia) {
        this.EndPonReferencia = EndPonReferencia;
    }

    public String getEndNome() {
        return EndNome;
    }

    public void setEndNome(String EndNome) {
        this.EndNome = EndNome;
    }

    public String getEndSobrenome() {
        return EndSobrenome;
    }

    public void setEndSobrenome(String EndSobrenome) {
        this.EndSobrenome = EndSobrenome;
    }

    public String getEndFone() {
        return EndFone;
    }

    public void setEndFone(String EndFone) {
        this.EndFone = EndFone;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

        
        
        
}
