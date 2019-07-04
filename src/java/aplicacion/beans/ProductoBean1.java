/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans;

import aplicacion.dao.DetalleDAO;
import aplicacion.dao.ProductoDAO;
import aplicacion.dao.imp.DetalleDAOImp;
import aplicacion.dao.imp.ProductoDAOImp;
import aplicacion.modelo.dominio.Producto;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author santiago
 */
@ManagedBean
@ViewScoped
public class ProductoBean1 {
    private ProductoDAO productodao;
    DetalleDAO detalledao;
    /**
     * Creates a new instance of ProductoBean1
     */
    public ProductoBean1() {
    productodao=new ProductoDAOImp();
    detalledao=new DetalleDAOImp();
    }
    public void agregar(Producto a)
    {
        getProductodao().crearProducto(a);
    }
    public ArrayList<Producto> obtenerlista()
    {
        return getProductodao().obtenerTodos();
    }

    /**
     * @return the productodao
     */
    public ProductoDAO getProductodao() {
        return productodao;
    }

    /**
     * @param productodao the productodao to set
     */
    public void setProductodao(ProductoDAO productodao) {
        this.productodao = productodao;
    }
    
    
}
