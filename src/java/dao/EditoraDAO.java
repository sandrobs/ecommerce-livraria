
package dao;

import java.util.List;
import model.Editora;
import nucleo.SequencialManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EditoraDAO {
    
    public EditoraDAO() {
        
        session = HibernateUtil.getSessionFactory().openSession();
        
    }
    
    
    private Session session;
    
    public void insert(Editora registro)
    {
        
        SequencialManager seq = new SequencialManager();
        
        int codigo;
        codigo = seq.getSequencial("editora");
        
        registro.setEdiCodigo(codigo);
        
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
        
    }
    
    public List<Editora> findAll(){
        return session.createQuery("from Editora").list();
    }
    
    public Editora findById(int id){
        return (Editora) session.load(Editora.class, id);
    }
    
    public void update(Editora registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(Editora registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
}
