/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans;

import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
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
public class UsuarioFormbean implements Serializable {
  private Cliente uncliente;//contiene los atributos de un cliente. para que no haya confunciones en la vista
    private Usuario unusuario;//contiene los atributos de un usuario. el usuario admin esta cargado por defecto.
    private ArrayList<Usuario> g;// esto unicamente lo usara el administrador para dar baja a los usuario y mostrar en la vista. no se me ocurrio otra idea :(
    private String nombre;//para la validacion 
    private String pass; //del usuario
    private Usuario usuarioactivo;
    @ManagedProperty(value="#{r}")//inyeccion de beans
    private UsuarioBean r;
    /**
     * Creates a new instance of UsuarioFormbean
     */
    public UsuarioFormbean() {
        uncliente=new Cliente();//inicializacion 
        unusuario=new Usuario();
       
    }
    @PostConstruct
    public void init()
    {
        r=new UsuarioBean();
         g=new ArrayList();
    }
    public String validarusuario()
    {String t=null;// aqui pone el nombre de la pagina cuando no se encuentre al usuario
    setUsuarioactivo(getR().validacion_user(getNombre(), getPass()));
        if(getUsuarioactivo()!=null)
        {
            t= "nombrepagina" ;// aqui pone el nombre de la pagina cuando se encuentre al usuario
            
        }
        return t;
    }
    public void altadeusuario()
    {//agregar usuario;
        Random aleatorio = new Random(System.currentTimeMillis());// clase de java para generar numeros aleatorios
        int codigo = (int) aleatorio.nextInt(100);// del 0 al 99
        getUnusuario().setEstado(true);//estos campos no se piden en la vista. ya que al crearse la cuenta, su estado cambiaria a verdadero.
        getUnusuario().setTipoUsuario("Cliente");// esto esta predefinido ya que solo habra un solo administrador. y las demas cuentas seran clientes unicamente
        getUnusuario().setCliente(getUncliente());// ya que las tablas se encuentran relacionas. debido a que existe un atributo en la clase usuario que es del tipo cliente. 
        getUnusuario().setCodigo(868);// espero que lo entiendas cuando vayas hacer la vista.
        
      try
      {
          getR().agregar(getUnusuario());
          FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_INFO,"SIN ERORES",":)"+ getUnusuario().getApellidos()); 
          FacesContext.getCurrentInstance().addMessage(null, facesmessage);
         
      }
      catch(Exception e)
      {
          FacesMessage facesmessage= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al cargar",":("+ getUnusuario().getApellidos()); 
          FacesContext.getCurrentInstance().addMessage(null, facesmessage);
      }
      // para limpiar los campos cuando se termine de cargar un usuario
    }
    public void bajadeusuario(Usuario usuario1)
    {
    getR().borrado(usuario1);
  
    }
    
    public void modificacion(Usuario usuario2)
    {
         // este procedimiento recibira el usuario que haya elegido el administrador al aser click en el icono(segun mi imaginacion). ya que para mostrar un usuario se uso una variable para
        // hacerlo y los datos que se cambien se recibiraan a aqui. como en el tp 4 en Modificar libro. revisar tp4(nombre del archivo"porultimaveztp4"
        getR().modificarusuariobean(usuario2);
    }

    /**
     * @return the uncliente
     */
    public Cliente getUncliente() {
        return uncliente;
    }

    /**
     * @param uncliente the uncliente to set
     */
    public void setUncliente(Cliente uncliente) {
        this.uncliente = uncliente;
    }

    /**
     * @return the unusuario
     */
    public Usuario getUnusuario() {
        return unusuario;
    }

    /**
     * @param unusuario the unusuario to set
     */
    public void setUnusuario(Usuario unusuario) {
        this.unusuario = unusuario;
    }

    /**
     * @return the g
     */
    public ArrayList<Usuario> getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(ArrayList<Usuario> g) {
        this.g = g;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the usuarioactivo
     */
    public Usuario getUsuarioactivo() {
        return usuarioactivo;
    }

    /**
     * @param usuarioactivo the usuarioactivo to set
     */
    public void setUsuarioactivo(Usuario usuarioactivo) {
        this.usuarioactivo = usuarioactivo;
    }

    /**
     * @return the r
     */
    public UsuarioBean getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(UsuarioBean r) {
        this.r = r;
    }

    
}
