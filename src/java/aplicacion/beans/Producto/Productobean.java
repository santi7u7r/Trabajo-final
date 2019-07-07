/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans.Producto;

import aplicacion.dao.ProductoDAO;
import aplicacion.dao.imp.ProductoDAOImp;
import aplicacion.modelo.dominio.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author santiago
 */
@ManagedBean
@SessionScoped
public class Productobean implements Serializable{
    private ProductoDAO productoDAO;
    /**
     * Creates a new instance of Productobean
     */
    public Productobean() {
    productoDAO=new ProductoDAOImp();
    }
 public void agregarProducto(Producto producto)
 {
     getProductoDAO().crearProducto(producto);
 }
 public void modificarProducto(Producto producto)
 {
     getProductoDAO().modificarProducto(producto);
 }
 public  void eliminarProducto(Producto producto)
 {
     getProductoDAO().borrarProducto(producto);
 }
 public ArrayList<Producto> obtenerProductos()
 {
     return getProductoDAO().obtenerTodos();
 }
    public ProductoDAO getProductoDAO() {
        return productoDAO;
    }

    public void setProductoDAO(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }
    
}
