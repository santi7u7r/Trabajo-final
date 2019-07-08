/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.ModopagoDAO;
import aplicacion.hibernate.configuracion.Hibernateutil;
import aplicacion.modelo.dominio.Modopago;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class ModopagoDAOImp implements ModopagoDAO, Serializable{

    @Override
    public void crearModopago(Modopago modopago) {
        Session session=Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(modopago);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void borrarModopago(Modopago modopago) {
        Session session=Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(modopago);
        session.getTransaction();
        session.close();
    }

    @Override
    public void modificarModopago(Modopago modopago) {
        Session session=Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(modopago);
        session.getTransaction();
        session.close();
    }

    @Override
    public Modopago obtenerModopago(int idmodoPago) {
 Modopago o = null;
         Session session=Hibernateutil.getSessionFactory().openSession();
         session.beginTransaction();
         Criteria criteria = session.createCriteria(Modopago.class);
         criteria.add(Restrictions.like("idmodoPago", true));
         if(!criteria.list().isEmpty()){
             o=(Modopago) criteria.list().get(0);
         }
         session.getTransaction().commit();
         session.close();
         return o;    }

    
    
}
