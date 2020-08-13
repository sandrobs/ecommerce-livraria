/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Avaliacao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Sandro
 */
public class AvaliacaoDAO {

    public AvaliacaoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Session session;
    
    public void insert(Avaliacao registro)
    {
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    public List<Avaliacao> findAll(){
        return session.createQuery("from Avaliacao").list();
    }
    
    public Avaliacao findById(int id){
        return (Avaliacao) session.load(Avaliacao.class, id);
    }
    
    public void update(Avaliacao registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(Avaliacao registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
        
    }
    
    public List<Avaliacao> avaliacoesStatus(int status){
        
        Query que = session.createQuery("from Avaliacao where avastatus = "+status);
        return que.list();
    }
    
    public void aprovaAvaliacao(int codigo){
        
        Query query = session.createQuery("update Avaliacao set avastatus = 2 where avacodigo = "+codigo);
        
        int i = query.executeUpdate();
        
        session.getTransaction().commit();
        
    }
    
    public void reprovaAvaliacao(int codigo){
        
        Query query = session.createQuery("update Avaliacao set avastatus = 3 where avacodigo = "+codigo);
        
        int i = query.executeUpdate();
        
        session.getTransaction().commit();
        
    }
    
}
