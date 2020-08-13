/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.FormaPagamento;
import nucleo.SequencialManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class FormaPagamentoDAO {
    
    public FormaPagamentoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Session session;
    
    public void insert(FormaPagamento registro)
    {
        
        SequencialManager seq = new SequencialManager();
        
        int codigo;
        codigo = seq.getSequencial("formapagamento");
        
        registro.setForPagCodigo(codigo);
        
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    public List<FormaPagamento> findAll(){
        return session.createQuery("from FormaPagamento").list();
    }
    
    public FormaPagamento findById(int id){
        return (FormaPagamento) session.load(FormaPagamento.class, id);
    }
    
    public void update(FormaPagamento registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(FormaPagamento registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
}
