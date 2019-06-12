/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.ClienteDAO;
import aplicacion.hibernate.configuracion.Hibernateutil;
import aplicacion.modelo.dominio.Cliente;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author José Luis
 */
public class ClienteDAOImp implements ClienteDAO {

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
    
}
