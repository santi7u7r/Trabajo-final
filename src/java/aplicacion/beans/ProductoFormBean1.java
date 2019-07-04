/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans;

import aplicacion.modelo.dominio.Producto;
import java.util.ArrayList;
import java.util.Random;
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
public class ProductoFormBean1 {
    private ArrayList<Producto> listoproducto;
    @ManagedProperty(value = "#{probean}")
    private ProductoBean1 probean;
    private Producto Pro1;
    private UploadedFile archivo=null;
    
    /**
     * Creates a new instance of ProductoFormBean1
     */
    public ProductoFormBean1() {
        listoproducto=new ArrayList();
    }
    @PostConstruct
    public void init()
    { setProbean(new ProductoBean1());
       setListoproducto(getProbean().obtenerlista());
    }
    public void agregar ()
    { Random aleatorio = new Random(System.currentTimeMillis());// clase de java para generar numeros aleatorios
        int codigo = (int) aleatorio.nextInt(100);
        getPro1().setCodProducto(codigo);
        getPro1().setEstado(true);
        if(getArchivo()!=null)
        {
            byte[] contents = getArchivo().getContents();
            getPro1().setFoto(contents);
        }
        else
        {
              getPro1().setFoto(null);
        }
        try
        {
            getProbean().agregar(getPro1());
            setListoproducto(getProbean().obtenerlista());
             FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_INFO,"Se cargo correctamente el producto"," :("+ getPro1().getDescripcion()); 
          FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }catch (Exception e)
        {
             FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_WARN,"HUBO UN PROBLEMA AL INTENTAR CARGAR"," :("+ getPro1().getDescripcion()); 
          FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
        setPro1(new Producto());
    }
    /**
     * @return the listoproducto
     */
    public ArrayList<Producto> getListoproducto() {
        return listoproducto;
    }

    /**
     * @param listoproducto the listoproducto to set
     */
    public void setListoproducto(ArrayList<Producto> listoproducto) {
        this.listoproducto = listoproducto;
    }

    /**
     * @return the probean
     */
    public ProductoBean1 getProbean() {
        return probean;
    }

    /**
     * @param probean the probean to set
     */
    public void setProbean(ProductoBean1 probean) {
        this.probean = probean;
    }

    /**
     * @return the Pro1
     */
    public Producto getPro1() {
        return Pro1;
    }

    /**
     * @param Pro1 the Pro1 to set
     */
    public void setPro1(Producto Pro1) {
        this.Pro1 = Pro1;
    }

    /**
     * @return the archivo
     */
    public UploadedFile getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }
            
    
}
