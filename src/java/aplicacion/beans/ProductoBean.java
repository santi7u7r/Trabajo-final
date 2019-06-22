/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans;

import aplicacion.dao.ProductoDAO;
import aplicacion.dao.imp.ProductoDAOImp;
import aplicacion.modelo.dominio.Producto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author santiago
 */
@ManagedBean
@ViewScoped
public class ProductoBean {
    private ProductoDAO productodao;
    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
    productodao=new ProductoDAOImp();
    }
    public void agregarproduc(Producto r)
    {
      getProductodao().crearProducto(r);
    }
    public void borrarproduct(Producto y)
    {
        getProductodao().borrarProducto(y);
    }
    public void modificarproduct(Producto u)
    {
        getProductodao().modificarProducto(u);
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
