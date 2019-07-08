/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.ClienteDAO;
import aplicacion.hibernate.configuracion.Hibernateutil;
import aplicacion.modelo.dominio.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author José Luis
 */
public class ClienteDAOImp implements ClienteDAO, Serializable {

    @Override
    public void crearCliente(Cliente cliente) {
        Session session = Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();
        session.close();
        
    }

    @Override
    public void borrarCliente(Cliente cliente) {
        Session session = Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(cliente);
        session.getTransaction();
        session.close();
    }

    @Override
    public void modificarCliente(Cliente cliente) {
        Session session = Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(cliente);
        session.getTransaction();
        session.close();
    }

    @Override
    public Cliente obtenerCliente(int dni) {
 Cliente q = null;
         Session session=Hibernateutil.getSessionFactory().openSession();
         session.beginTransaction();
         Criteria criteria = session.createCriteria(Cliente.class);
         criteria.add(Restrictions.like("dni", true));
         if(!criteria.list().isEmpty()){
             q=(Cliente) criteria.list().get(0);
         }
         session.getTransaction().commit();
         session.close();
         return q;    }

    @Override
    public ArrayList<Cliente> obtenerCliente() {
         Session session = Hibernateutil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        Criteria add = criteria.add(Restrictions.like("dni", true));
        ArrayList<Cliente> cliente = (ArrayList) criteria.list();
        session.close();
        return cliente;
    }
    
}
