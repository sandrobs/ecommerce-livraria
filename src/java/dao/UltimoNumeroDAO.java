/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.UltimoNumero;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Sandro
 */
public class UltimoNumeroDAO {
    
    public UltimoNumeroDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Session session;
    
    public void insert(UltimoNumero registro)
    {
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    public List<UltimoNumero> findAll(){
        return session.createQuery("from UltimoNumero").list();
    }
    
    public UltimoNumero findById(String id){
        return (UltimoNumero) session.load(UltimoNumero.class, id);
    }
    
    public void update(UltimoNumero registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(UltimoNumero registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
}
