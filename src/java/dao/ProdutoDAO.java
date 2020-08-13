/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Produto;
import nucleo.SequencialManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ProdutoDAO {
    
    public ProdutoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Session session;
    
    public void insert(Produto registro)
    {
        
        SequencialManager seq = new SequencialManager();
        
        int codigo;
        codigo = seq.getSequencial("produto");
        
        registro.setPrdCodigo(codigo);
        
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
        
        
    }
    
    public List<Produto> findAll(){
        return session.createQuery("from Produto").list();
    }
    
    public Produto findById(int id){
        return (Produto) session.load(Produto.class, id);
    }
    
    public void update(Produto registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(Produto registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
}
