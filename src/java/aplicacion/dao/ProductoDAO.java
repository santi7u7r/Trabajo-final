/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Producto;

/**
 *
 * @author José Luis
 */
public interface ProductoDAO {
    void crearProducto(Producto producto);
    void borrarProducto(Producto producto);
    void modificarProducto(Producto producto);
    
}
