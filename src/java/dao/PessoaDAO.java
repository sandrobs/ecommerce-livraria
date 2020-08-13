package dao;

import java.util.List;
import model.Pessoa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PessoaDAO {
    
    public PessoaDAO() {
        
        session = HibernateUtil.getSessionFactory().openSession();
        
    }
    
    private Session session;
    
    public void insert(Pessoa registro)
    {
        Transaction t = session.beginTransaction();
        session.save(registro);
        t.commit();
    }
    
    public List<Pessoa> findAllUsuarios(){
        
        return session.createQuery("from Pessoa where pestipo = '1'").list();
        
    }
    public List<Pessoa> findAllClientes(){
        return session.createQuery("from Pessoa where pestipo = '2'").list();
    }
    
    public Pessoa findById(int id){
        return (Pessoa) session.load(Pessoa.class, id);
    }
    
    public void update(Pessoa registro){
        Transaction t = session.beginTransaction();
        session.merge(registro);
        t.commit();
    }
    
    public void delete(Pessoa registro){
        Transaction t = session.beginTransaction();
        session.delete(registro);
        t.commit();
    }
    
    public List<Pessoa> findUsuarioAdmin(String email){
        
        return session.createQuery("from Pessoa where pestipo = '1' and pesemail = '"+email+"'").list();
        
    }
}
