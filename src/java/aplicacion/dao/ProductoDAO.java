/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Producto;
import java.util.ArrayList;

/**
 *
 * @author José Luis
 */
public interface ProductoDAO {
    public void crearProducto(Producto producto);
    public void borrarProducto(Producto producto);
    public void modificarProducto(Producto producto);
    public ArrayList<Producto> obtenerTodos();
    public Producto consultarProducto(int cod);
}
