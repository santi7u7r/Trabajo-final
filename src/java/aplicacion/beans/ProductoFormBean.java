/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans;

import aplicacion.modelo.dominio.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author santiago
 */
@ManagedBean
@ViewScoped
public class ProductoFormBean {
 @ManagedProperty (value="#{Productobean}")
 private ProductoBean Productobean;
 private Producto u;
 private List<Producto> listapro;
 private transient UploadedFile archivo=null;
    /**
     * Creates a new instance of ProductoFormBean
     */
    public ProductoFormBean() { 
        listapro=new ArrayList();
        u= new Producto();
    }
    @PostConstruct
    public void iniciar()
    {listapro=new ArrayList();
        setListapro(getProductobean().obtenerlistado());// c inicializan despues de que crea el bean
    }
    public void agregar()
    {
       if(getArchivo()!=null)
       {
           byte [] contents = getArchivo().getContents();
           getU().setFoto(contents);
       }
       else
       {
           getU().setFoto(null);
       }
       try{
            getProductobean().agregarproduc(getU());
            FacesMessage facesmenssage = new FacesMessage(FacesMessage.SEVERITY_INFO," Producto agregado correctamente", "producto"+ getU().getDescripcion());
            FacesContext.getCurrentInstance().addMessage(null, facesmenssage);
       }catch (Exception e)
       {
             FacesMessage facesmenssage = new FacesMessage(FacesMessage.SEVERITY_ERROR," Error al cargarlo", "vuelva a intentarlo mas tarde :( ");
            FacesContext.getCurrentInstance().addMessage(null, facesmenssage);
       }
       
       
    }
    public void borrar()
    {
        getProductobean().borrarproduct(getU());
    }
    public void modificar(Producto y)
    {
        getProductobean().modificarproduct(y);
    }
    public void obtenerlista()
    {
        setListapro(getProductobean().obtenerlistado());
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
    public List<Producto> getListapro() {
        return listapro;
    }

    /**
     * @param listapro the listapro to set
     */
    public void setListapro(List<Producto> listapro) {
        this.listapro = listapro;
    }
    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }
    
}
