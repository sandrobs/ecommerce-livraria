/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Estado;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
/**
 *
 * @author Sandro
 */
public class EstadoDAO {
    
    public EstadoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Session session;
    
    public void insert(Estado registro)
    {
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    public List<Estado> findAll(){
        return session.createQuery("from Estado").list();
    }
    
    public Estado findById(int id){
        return (Estado) session.load(Estado.class, id);
    }
    
    public void update(Estado registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(Estado registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
}
