/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans;
import aplicacion.modelo.dominio.Categoria;
import java.util.ArrayList;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author santiago
 */
@ManagedBean
@ViewScoped
public class CategoriaFormBean {
    @ManagedProperty(value="#{catebean}")
    private CategoriaBean catebean;
    private ArrayList<Categoria> Lista;
    private Categoria a;
    /**
     * Creates a new instance of CategoriaFormBean
     */
    public CategoriaFormBean() {
        Lista=new ArrayList();
         a=new Categoria();
    }
    @PostConstruct
    public void init()
    {
        setCatebean(new CategoriaBean());
        setLista(getCatebean().obtenercategorias());
    }
    public void cantidaddeproporcadauno()
    {
        
    }
    public void agregarcategoria()
    { Random aleatorio = new Random(System.currentTimeMillis());// clase de java para generar numeros aleatorios
        int codigo = (int) aleatorio.nextInt(100);
      getA().setIdcategoria(codigo);
      getA().setCantidadproduc(1);
      getA().setEstado(true);
        try{
           getCatebean().agregar(getA());
           setLista(getCatebean().obtenercategorias());
           FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_INFO,"Se Añadio","Mas para mi :v"+ getA().getNombre()); 
          FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }catch(Exception e)
        {
             FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_WARN,"HUBO UN PROBLEMA AL INTENTAR CARGAR"," :("+ getA().getNombre()); 
          FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
         setA(new Categoria());     
                
    }
    public void borrarcategoria(Categoria t)
    {
        try{
            t.setEstado(false);
           getCatebean().eliminar(t);
          setLista(getCatebean().obtenercategorias());
           FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_INFO,"Se Elimino Correctamente","Menos para mi :("); 
          FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }catch(Exception e)
        {
             FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_WARN,"HUBO UN PROBLEMA AL INTENTAR CARGAR"," :("); 
          FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }   
    }
      public void modificarcategoria()
    {
        try{
           getCatebean().modificar(getA());
           setLista(getCatebean().obtenercategorias());
           FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_INFO,"Se Elimino Correctamente","Menos para mi :("); 
          FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }catch(Exception e)
        {
             FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_WARN,"HUBO UN PROBLEMA AL INTENTAR CARGAR"," :("); 
          FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }   
    }
    /**
     * @return the a
     */
    public Categoria getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Categoria a) {
        this.a = a;
    }

    /**
     * @return the catebean
     */
    public CategoriaBean getCatebean() {
        return catebean;
    }

    /**
     * @param catebean the catebean to set
     */
    public void setCatebean(CategoriaBean catebean) {
        this.catebean = catebean;
    }

    /**
     * @return the Lista
     */
    public ArrayList<Categoria> getLista() {
        return Lista;
    }

    /**
     * @param Lista the Lista to set
     */
    public void setLista(ArrayList<Categoria> Lista) {
        this.Lista = Lista;
    }
}
