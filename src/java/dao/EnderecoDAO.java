/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Endereco;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
/**
 *
 * @author Sandro
 */
public class EnderecoDAO {
    
    public EnderecoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Session session;
    
    public void insert(Endereco registro)
    {
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    public List<Endereco> findAll(){
        return session.createQuery("from Endereco").list();
    }
    
    public List<Endereco> findByCliente(int id){
        return session.createQuery("from Endereco where pescodigo = "+id).list();
    }
    
    public Endereco findById(int id){
        return (Endereco) session.load(Endereco.class, id);
    }
    
    public void update(Endereco registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(Endereco registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
}
