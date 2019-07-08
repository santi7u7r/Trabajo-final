/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Factura;
import java.util.Date;
import java.util.List;

/**
 *
 * @author José Luis
 */
public interface FacturaDAO {
   public void crearFactura(Factura factura);
   public void borrarFactura(Factura factura);
  public  void modificarFactura(Factura factura);
      public Factura obtenerFactura(int numFactura);
    public List<Factura> obtenerPorCliente(int dni);
   public  List<Factura> obtenerPorFechas(Date fechaInicio, Date fechaFin);
}
