/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.DetalleDAO;
import aplicacion.dao.ProductoDAO;
import aplicacion.modelo.dominio.Categoria;
import aplicacion.modelo.dominio.Producto;

/**
 *
 * @author santiago
 */
public class prueba {
    public static void main(String[] args) {
        DetalleDAO r=new DetalleDAOImp();
        Producto e=new Producto();
        Categoria i=new Categoria();
        i.setDescripcion("es una cosa");
        i.setNombre("jugetes");
        i.setIdcategoria(6);
        
        e.setCodProducto(78);
        e.setCategoria(null);
        e.setEstado(true);
        e.setPrecio(6.11);
        e.setStock(8);
      
    }
}
