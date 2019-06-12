/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.UsuarioDAO;
import aplicacion.hibernate.configuracion.Hibernateutil;
import aplicacion.modelo.dominio.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author José Luis
 */
public class UsuarioDAOImp implements UsuarioDAO {

    @Override
    public Usuario validarUsuario(String nombreUsuario, String password) {

        Usuario u = null;
        Session session = Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuario.class);
        Criterion Restriction;
        criteria.add(Restrictions.like("nombreUsuario", nombreUsuario));
        criteria.add(Restrictions.like("password", password));
        Criteria add = criteria.add(Restrictions.eq("estado", true));
        if (!criteria.list().isEmpty()) {
            u = (Usuario) criteria.list().get(0);
        }
        session.getTransaction().commit();
        session.close();
        return u;
    }

    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
        Usuario u = null;
        Session session = Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("nombreUser", nombreUsuario));
        if (!criteria.list().isEmpty()) {
            u = (Usuario) criteria.list().get(0);
        }
        session.getTransaction().commit();
        session.close();
        return u;

    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        Session session = Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();
        session.close();
        

    }

    @Override
    public void crearUsuario(Usuario usuario) {
        Session session = Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        usuario.setEstado(Boolean.TRUE);
        session.save(usuario);
        session.getTransaction().commit();
        session.close();
        
    }

    @Override
    public void borrarUsuario(Usuario usuario) {
        Session session = Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        usuario.setEstado(Boolean.FALSE);
        session.update(usuario);
        session.getTransaction().commit();
        session.close();
    
    
    }
        

    
    

}
