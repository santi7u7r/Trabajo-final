/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans.usuario;

import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
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
public class UsuarioFormBean implements Serializable{
 @ManagedProperty (value = "#{usuariobean}")
 private UsuarioBean usuariobean;
 private Usuario unusuario;
 private String nombre;
 private String pass;
 private ArrayList<Usuario> listado;
 private Cliente cliente;
 /**
     * Creates a new instance of UsuarioFormBean
     */
    public UsuarioFormBean() { 
        unusuario=new Usuario();
        cliente=new Cliente();
        usuariobean=new UsuarioBean();
    }
    
    @PostConstruct
   public void init()
   {   
        usuariobean=new UsuarioBean();
        setListado(getUsuariobean().obtenerlista());
   }
   

  public String validarusuario()
  {
      String a=null;
      setUnusuario(getUsuariobean().validarUsuario(nombre, pass));
          
      if(getUnusuario()!=null)
      {
          if(getUnusuario().getTipoUsuario().equals("Admin"))
          {
                  a="vistaAdministrador?faces-redirect=true";
          }
          else
          {
               a="paginausuarionormal?faces-redirect=true";
          }
               
      }
      return a;
  }
  public  void agregarusuarios()
  {
         Random r= new Random(System.currentTimeMillis());
         int codigo = (int) r.nextInt(200);
        getUnusuario().setCodigo(codigo);
        getUnusuario().setTipoUsuario("Cliente");{
        getUnusuario().setCliente(getCliente());
  }
        try {
            getUsuariobean().agregarUsuario(getUnusuario());
            listado=usuariobean.obtenerlista();
            FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_INFO,"Se Cargo un nuevo usuario", "Bienvenido "+getUnusuario().getNombreUsuario());
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
           
        }catch(Exception e)
        {
              FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al cargar", "ocurrio un error al registrarse ");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
          
        }
  
  }
  public void onRowEdit(RowEditEvent event)
  {   Usuario usuario= (Usuario) event.getObject();
         modificarUsuario(usuario);
  }
   public void onRowEditCancel(RowEditEvent event)
  {   FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_INFO,"C cancelo la edicion", "Cambios no guardados");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
  }
    public void borrarUsuario(Usuario usuario)
    {
       
        try {
            getUsuariobean().eliminar(usuario);
            listado=usuariobean.obtenerlista();
            FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_INFO,"Se le quito el acceso al usuario", "si desea permitirle denuevo el acceso a el ingrese a la base de datos de forma manual y efectue los cambios");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }catch( Exception e)
        {
         FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_WARN,"Ups...Ocurrio un problema", "No se pudo eliminar al usuario ");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);   
        }
    }
    public void modificarUsuario(Usuario usuario)
    {
        try 
        {
            getUsuariobean().modificarUsuario(usuario);
            FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_INFO,"Se modifico correctamente", "el usuario: "+getUnusuario().getNombreUsuario());
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }catch( Exception e)
        {
            FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_WARN,"Hubo un problema al intentar modificar ","Intentelo mas tarde ");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
    }
    public UsuarioBean getUsuariobean() {
        return usuariobean;
    }
    public void setUsuariobean(UsuarioBean usuariobean) {
        this.usuariobean = usuariobean;
    }
    public Usuario getUnusuario() {
        return unusuario;
    }
    public void setUnusuario(Usuario unusuario) {
        this.unusuario = unusuario;
    }
    public ArrayList<Usuario> getListado() {
        return listado;
    }
    public void setListado(ArrayList<Usuario> listado) {
        this.listado = listado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    } 

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   
}
