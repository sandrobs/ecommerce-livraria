/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.ProdutoVisitado;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ProdutoVisitadoDAO {
    
    public ProdutoVisitadoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Session session;
    
    public void insert(ProdutoVisitado registro)
    {
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    public List<ProdutoVisitado> findAll(){
        return session.createQuery("from ProdutoVisitado").list();
    }
    
    public ProdutoVisitado findById(int id){
        return (ProdutoVisitado) session.load(ProdutoVisitado.class, id);
    }
    
    public void update(ProdutoVisitado registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(ProdutoVisitado registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
    
}
