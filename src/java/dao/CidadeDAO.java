package dao;

import java.util.List;
import model.Cidade;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CidadeDAO {
    public CidadeDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Session session;
    
    public void insert(Cidade registro)
    {
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    public List<Cidade> findAll(){
        return session.createQuery("from Cidade").list();
    }
    
    public Cidade findById(int id){
        return (Cidade) session.load(Cidade.class, id);
    }
    
    public void update(Cidade registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(Cidade registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
}
