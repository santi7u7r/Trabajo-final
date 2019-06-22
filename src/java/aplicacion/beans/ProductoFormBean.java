/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans;

import aplicacion.modelo.dominio.Producto;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author santiago
 */
@ManagedBean
@ViewScoped
public class ProductoFormBean {
 @ManagedProperty (value="Productobean")
 private ProductoBean Productobean;
 private Producto u;
 private ArrayList<Producto> listapro;
    /**
     * Creates a new instance of ProductoFormBean
     */
    public ProductoFormBean() { 
        Productobean=new ProductoBean();
        listapro=new ArrayList();
        u= new Producto();
    }
    public void agregar()
    {
        getProductobean().agregarproduc(getU());
    }
    public void borrar()
    {
        getProductobean().borrarproduct(getU());
    }
    public void modificar(Producto y)
    {
        getProductobean().modificarproduct(y);
    }
    /**
     * @return the Productobean
     */
    public ProductoBean getProductobean() {
        return Productobean;
    }

    /**
     * @param Productobean the Productobean to set
     */
    public void setProductobean(ProductoBean Productobean) {
        this.Productobean = Productobean;
    }

    /**
     * @return the u
     */
    public Producto getU() {
        return u;
    }

    /**
     * @param u the u to set
     */
    public void setU(Producto u) {
        this.u = u;
    }

    /**
     * @return the listapro
     */
    public ArrayList<Producto> getListapro() {
        return listapro;
    }

    /**
     * @param listapro the listapro to set
     */
    public void setListapro(ArrayList<Producto> listapro) {
        this.listapro = listapro;
    }
    
}
