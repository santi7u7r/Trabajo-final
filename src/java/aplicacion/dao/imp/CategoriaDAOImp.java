/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.CategoriaDAO;
import aplicacion.hibernate.configuracion.Hibernateutil;
import aplicacion.modelo.dominio.Categoria;
import java.io.Serializable;
import org.hibernate.Session;



/**
 *
 * @author José Luis
 */


public class CategoriaDAOImp implements CategoriaDAO, Serializable{

    

    @Override
    public void crearCategoria(Categoria categoria) {
    Session session= Hibernateutil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(categoria);
    session.getTransaction().commit();;
    session.close();
    }
    

    @Override
    public void borrarCategoria(Categoria categoria) {
        Session session=Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(categoria);
        session.getTransaction();
        session.close();
    }

    @Override
    public void modificarCategoria(Categoria categoria) {
    Session session=Hibernateutil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(categoria);
    session.getTransaction();
    session.close();
    }
    
    
}
