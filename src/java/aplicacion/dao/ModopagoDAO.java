/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Modopago;

/**
 *
 * @author José Luis
 */
public interface ModopagoDAO {
    public void crearModopago(Modopago modopago);
    public void borrarModopago(Modopago modopago);
   public  void modificarModopago(Modopago modopago);
   public Modopago obtenerModopago(int idmodoPago);
}
