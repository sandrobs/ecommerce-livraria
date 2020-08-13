/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.List;
import model.ItensPedido;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ItensPedidoDAO {
    
    public ItensPedidoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Session session;
    
    public void insert(ItensPedido registro)
    {
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    public List<ItensPedido> findAll(){
        return session.createQuery("from ItensPedido").list();
    }
    
    public ItensPedido findById(int id){
        return (ItensPedido) session.load(ItensPedido.class, id);
    }
    
    public void update(ItensPedido registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(ItensPedido registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
    
}
