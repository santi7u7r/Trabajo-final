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
    void crearFactura(Factura factura);
    void borrarFactura(Factura factura);
    void modificarFactura(Factura factura);
    List<Factura> obtenerPorCliente(int dni);
    List<Factura> obtenerPorFechas(Date fechaInicio, Date fechaFin);
}
