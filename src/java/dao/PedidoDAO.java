
package dao;

import java.util.List;
import model.Pedido;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PedidoDAO {
    
    public PedidoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Session session;
    
    public void insert(Pedido registro)
    {
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    public List<Pedido> findAll(){
        return session.createQuery("from Pedido").list();
    }
    
    public Pedido findById(int id){
        return (Pedido) session.load(Pedido.class, id);
    }
    
    public void update(Pedido registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(Pedido registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
}
