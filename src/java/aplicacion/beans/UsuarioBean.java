/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans;

import aplicacion.dao.ClienteDAO;
import aplicacion.dao.UsuarioDAO;
import aplicacion.dao.imp.ClienteDAOImp;
import aplicacion.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author santiago
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {
     private UsuarioDAO clienteDAO;
        private Usuario a;
        ClienteDAO UsuarioDAO;
    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public UsuarioBean() {
        clienteDAO=new UsuarioDAOImp();
        a=new Usuario();
        UsuarioDAO= new ClienteDAOImp();
    }
    public void agregar(Usuario b)
    {
        getClienteDAO().crearUsuario(b);
    }
    public ArrayList<Usuario> obtenerlistado()
    {
        return getClienteDAO().obtenerlista();
    }
       public void borrado(Usuario a)
    {
        getClienteDAO().borrarUsuario(a);
    }
    public void modificarusuariobean(Usuario e)
    {
        getClienteDAO().modificarUsuario(e);
        System.out.println("hola");
    }
    public Usuario validacion_user(String nombre,String pass)
    {
        return getClienteDAO().validarUsuario(nombre, pass);
    }

    /**
     * @return the clienteDAO
     */
    public UsuarioDAO getClienteDAO() {
        return clienteDAO;
    }

    /**
     * @param clienteDAO the clienteDAO to set
     */
    public void setClienteDAO(UsuarioDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    /**
     * @return the a
     */
    public Usuario getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Usuario a) {
        this.a = a;
    }
}
