/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TermoPesquisado;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class TermoPesquisadoDAO {
    
    public TermoPesquisadoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Session session;
    
    public void insert(TermoPesquisado registro)
    {
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    public List<TermoPesquisado> findAll(){
        return session.createQuery("from TermoPesquisado").list();
    }
    
    public TermoPesquisado findById(int id){
        return (TermoPesquisado) session.load(TermoPesquisado.class, id);
    }
    
    public void update(TermoPesquisado registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(TermoPesquisado registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
}
