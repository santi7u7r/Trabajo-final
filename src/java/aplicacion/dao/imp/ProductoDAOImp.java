/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.ProductoDAO;
import aplicacion.hibernate.configuracion.Hibernateutil;
import aplicacion.modelo.dominio.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author José Luis
 */
public class ProductoDAOImp implements ProductoDAO, Serializable {

    @Override
    public void crearProducto(Producto producto) {
        Session session = Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(producto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void borrarProducto(Producto producto) {
        Session session = Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(producto);
        session.getTransaction();
        session.close();
    }

    @Override
    public void modificarProducto(Producto producto) {
        Session session = Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(producto);
        session.getTransaction();
        session.close();
    }

    @Override
    public ArrayList<Producto> obtenerTodos() {
       Session session = Hibernateutil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("estado", true));// restricion crea filtros. promero escribo cual es atributo que voy comparar y despues el valo al que debe ser igual para que liste los productos
        ArrayList<Producto> productos =(ArrayList) criteria.list();
        session.close();
        return productos;
    }
     
     
     
     
    
}
