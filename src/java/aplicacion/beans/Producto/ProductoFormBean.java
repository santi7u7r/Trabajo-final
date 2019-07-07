/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans.Producto;

import aplicacion.modelo.dominio.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author santiago
 */
@ManagedBean
@SessionScoped
public class ProductoFormBean implements Serializable{
 @ManagedProperty (value = "#{productobean}")
    private Productobean productobean;
    private Producto p;
    private ArrayList<Producto> productos;
    private transient UploadedFile u=null;
    /**
     * Creates a new instance of ProductoFormBean
     */
    public ProductoFormBean() {
        p=new Producto();
        productos= new ArrayList();
    }
    @PostConstruct
    public void init()
    {
        productobean=new Productobean();
        productos=getProductobean().obtenerProductos();
    }
    public void agregarProducto()
    { getP().setEstado(true);
    ;
        if(u!=null)
        {
            byte [] content= getU().getContents();
            getP().setFoto(content);
        }
        else
        {
            getP().setFoto(null);
        }
       try {
        getProductobean().agregarProducto(getP());
           FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se agrego un producto", "De forma correcta");
           FacesContext.getCurrentInstance().addMessage(null, facesMessage);
       }catch(Exception e)
       {
               FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hubo un Problema", "No se pudo cumplir la accion");
           FacesContext.getCurrentInstance().addMessage(null, facesMessage);
              
       }
       setP(new Producto());
    }
    public void borrarProducto( Producto producto)
    {
        producto.setEstado(false);
        try{
        getProductobean().eliminarProducto(producto);
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino un producto", "De forma correcta");
           FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }catch(Exception e)
        {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hubo un problema :(", "No se pudo cumplir la accion");
           FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        
    }
    public void modificarProducto(Producto producto)
    {
        try {
            getProductobean().modificarProducto(producto);
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se modifico un producto", "De forma correcta");
           FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }catch(Exception e)
        {
            getProductobean().eliminarProducto(producto);
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hubo un problema :(", "No se pudo realizar la accion");
           FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }
    public Productobean getProductobean() {
        return productobean;
    }

    public void setProductobean(Productobean productobean) {
        this.productobean = productobean;
    }

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public UploadedFile getU() {
        return u;
    }

    public void setU(UploadedFile u) {
        this.u = u;
    }
    
}
