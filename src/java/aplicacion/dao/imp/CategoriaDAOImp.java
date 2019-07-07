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
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;



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
    session.getTransaction().commit();
    session.close();
    System.out.println("c");
    }
    

    @Override
    public void borrarCategoria(Categoria categoria) {
        categoria.setEstado(false);
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

    @Override
    public ArrayList<Categoria> obtenercat() {
Session session = Hibernateutil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Categoria.class);
         Criteria add = criteria.add(Restrictions.like("estado",true));// restricion crea filtros. promero escribo cual es atributo que voy comparar y despues el valo al que debe ser igual para que liste los productos
        ArrayList<Categoria> categoria =(ArrayList) add.list();
        session.close();
        return categoria;   
    }
    
    
}
