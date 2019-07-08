/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.CategoriaDAO;
import aplicacion.dao.ProductoDAO;
import aplicacion.modelo.dominio.Categoria;
import aplicacion.modelo.dominio.Producto;

/**
 *
 * @author santiago
 */
public class prueba {
    public static void main(String[] args) {
        Categoria categoria =new Categoria();
        CategoriaDAO categoriaDAO=new CategoriaDAOImp();
        ProductoDAO productoDAO =new ProductoDAOImp();
        Producto producto= new Producto();
        categoria.setCantidadproduc(2);
        categoria.setDescripcion("noc");
        categoria.setEstado(true);
        categoria.setIdcategoria(96);
        categoria.setNombre("jugetesasdas");        
        producto.setCategoria(categoria);
        producto.setCodProducto(6);
        producto.setEstado(true);
        producto.setStock(10);
        producto.setPrecio(21.60);
        producto.setDescripcion("para tu mama");
       productoDAO.crearProducto(producto);
    }
}
