/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Detalle;

/**
 *
 * @author José Luis
 */
public interface DetalleDAO {
    public void crearDetalle(Detalle detalle);
    public void borrarDetalle(Detalle detalle);
   public void modificarDetalle(Detalle detalle);
    public Detalle obtenerDetalle(int iddetalle);
}
