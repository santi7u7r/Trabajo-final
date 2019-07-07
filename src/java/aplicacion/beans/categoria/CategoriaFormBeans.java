/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans.categoria;

import aplicacion.modelo.dominio.Categoria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author santiago
 */
@ManagedBean
@SessionScoped
public class CategoriaFormBeans implements Serializable{
    @ManagedProperty(value = "#{categoriabean}")
    CategoriaBean categoriabean;
    Categoria categoria ;
    ArrayList<Categoria> listaCategoria;
    /**
     * Creates a new instance of CategoriaFormBeans
     */
    public CategoriaFormBeans() {
    }
    @PostConstruct
    public void  init()
    {
        categoriabean=new CategoriaBean();
        listaCategoria= categoriabean.obtenerListado();
    }
    public void agregarCategoria ()
    {
        Random r= new Random(System.currentTimeMillis());
         int codigo = (int) r.nextInt(200);
         categoria.setIdcategoria(codigo);
         categoria.setEstado(true);
         try {
             getCategoriabean().agregarCategoria(categoria);
             listaCategoria= categoriabean.obtenerListado();
             FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se cargo una nueva categoria", "la nueva categoria es: "+ categoria.getNombre());
             FacesContext.getCurrentInstance().addMessage(null, facesMessage);
                     }catch (Exception e)
         {
             FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "hubo un error", " :( ");
             FacesContext.getCurrentInstance().addMessage(null, facesMessage);
         }
    }
    public void onRowEdit(RowEditEvent event)
  {   Categoria c=(Categoria) event.getObject();
         modificarCategoria(c); 
                 }
   public void onRowEditCancel(RowEditEvent event)
  {   FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_INFO,"C cancelo la edicion", "Cambios no guardados");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
  }
    public void modificarCategoria(Categoria categoria1)
    {
        try {
             getCategoriabean().modificarCategoria(categoria1);
             listaCategoria= categoriabean.obtenerListado();
             FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se modifico con exito", "No hubo problemas al modificar :) ");
             FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            }catch (Exception e)
            {
             FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "hubo un error", " :( ");
             FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            }
    }
     public void eliminarCategoria(Categoria c)
     {
         try {
             getCategoriabean().eliminarCategoria(c);
             listaCategoria= categoriabean.obtenerListado();
             FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino una categoria", ":D");
             FacesContext.getCurrentInstance().addMessage(null, facesMessage);
                     }catch (Exception e)
         {
             FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "hubo un error", " :( ");
             FacesContext.getCurrentInstance().addMessage(null, facesMessage);
         }
     }
    public CategoriaBean getCategoriabean() {
        return categoriabean;
    }

    public void setCategoriabean(CategoriaBean categoriabean) {
        this.categoriabean = categoriabean;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(ArrayList<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
    
}
