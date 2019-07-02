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
public interface DetalleDAO_1 {
    void crearDetalle(Detalle detalle);
    void borrarDetalle(Detalle detalle);
    void modificarDetalle(Detalle detalle);
    
}
