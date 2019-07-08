/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.FacturaDAO;
import aplicacion.hibernate.configuracion.Hibernateutil;
import aplicacion.modelo.dominio.Factura;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class FacturaDAOImp implements FacturaDAO, Serializable{

    @Override
    public void crearFactura(Factura factura) {
        Session session=Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(factura);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void borrarFactura(Factura factura) {
        Session session=Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(factura);
        session.getTransaction();
        session.close();
    }

    @Override
    public void modificarFactura(Factura factura) {
        Session session=Hibernateutil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(factura);
        session.getTransaction();
        session.close();
    }

    @Override
    public List<Factura> obtenerPorCliente(int dni) {
        Session session = Hibernateutil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Factura.class);
        criteria.createAlias("usuario", "u"); //es una etiqueta para clases que llamamos u  , sirven de restriccion 
        criteria.createAlias("u.cliente", "c");//
        criteria.add(Restrictions.like("c.dni", dni));
        List<Factura> facturas = criteria.list();
        session.close();
        return facturas;
                 
    }

    @Override
    public List<Factura> obtenerPorFechas(Date fechaInicio, Date fechaFin) {// gacer test revisar los daos buscar en internet si tengo dudasd
        
        Session session = Hibernateutil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Factura.class);
        criteria.add(Restrictions.between("DATE(fecha)", fechaInicio, fechaFin));
        List<Factura> facturas = criteria.list();
        session.close();
        return facturas;
    }

    @Override
    public Factura obtenerFactura(int numFactura) {
  Factura n = null;
         Session session=Hibernateutil.getSessionFactory().openSession();
         session.beginTransaction();
         Criteria criteria = session.createCriteria(Factura.class);
         criteria.add(Restrictions.like("numFactura", true));
         if(!criteria.list().isEmpty()){
             n=(Factura) criteria.list().get(0);
         }
         session.getTransaction().commit();
         session.close();
         return n;
        }

    
}
