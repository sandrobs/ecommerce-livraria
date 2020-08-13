/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.ProdutoCarrinho;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ProdutoCarrinhoDAO {
    
    public ProdutoCarrinhoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Session session;
    
    public void insert(ProdutoCarrinho registro)
    {
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    public List<ProdutoCarrinho> findAll(){
        return session.createQuery("from ProdutoCarrinho").list();
    }
    
    public ProdutoCarrinho findById(int id){
        return (ProdutoCarrinho) session.load(ProdutoCarrinho.class, id);
    }
    
    public void update(ProdutoCarrinho registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(ProdutoCarrinho registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
}
