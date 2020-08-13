/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleo;

import dao.UltimoNumeroDAO;
import model.UltimoNumero;

/**
 *
 * @author Sandro
 */
public class SequencialManager {
    
    public SequencialManager(){
        
    }
    
    public int getSequencial(String tabela){
        
        UltimoNumeroDAO dao = new UltimoNumeroDAO();
        
        UltimoNumero ultimonumero = new UltimoNumero();
        
        UltimoNumero registro = new UltimoNumero();
        
        int sequencial = 0;
        
        try{
            ultimonumero = dao.findById(tabela);
            sequencial = ultimonumero.getUltTabSequencial();
        }
        catch (Exception ex){
            sequencial = 0;
        }
        
        int sequencialAux = sequencial;
        
        sequencial +=1;
        
        registro.setUltTabNome(tabela);
        registro.setUltTabSequencial(sequencial);
        
        if(sequencialAux == 0)
        {
            dao.insert(registro);
        }
        else{
            dao.update(registro);
        }
        
        return sequencial;
    }
    
}
