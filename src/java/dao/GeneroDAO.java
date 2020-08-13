/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Genero;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import nucleo.SequencialManager;

public class GeneroDAO {
    
    public GeneroDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Session session;
    
    public void insert(Genero registro)
    {
        
        SequencialManager seq = new SequencialManager();
        
        int codigo;
        codigo = seq.getSequencial("genero");
        
        registro.setGenCodigo(codigo);
        
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    public List<Genero> findAll(){
        return session.createQuery("from Genero").list();
    }
    
    public Genero findById(int id){
        return (Genero) session.load(Genero.class, id);
    }
    
    public void update(Genero registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(Genero registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
    
}
