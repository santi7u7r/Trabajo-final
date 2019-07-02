/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.DetalleDAO;
import aplicacion.hibernate.configuracion.Hibernateutil;
import aplicacion.modelo.dominio.Detalle;
import java.io.Serializable;
import org.hibernate.Session;


/**
 *
 * @author José Luis
 */

public class DetalleDAOImp implements DetalleDAO, Serializable{

    @Override
    public void crearDetalle(Detalle detalle) {
        Session session=Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(detalle);
        session.getTransaction().commit();
        session.close();
        
    }

    @Override
    public void borrarDetalle(Detalle detalle) {
        Session session=Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(detalle);
        session.getTransaction();
        session.close();
    }

    @Override
    public void modificarDetalle(Detalle detalle) {
        Session session=Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(detalle);
        session.getTransaction();
        session.close();
    }



}

   
