/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans.usuario;

import aplicacion.dao.UsuarioDAO;
import aplicacion.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author santiago
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
     private UsuarioDAO usuariodao;
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
        usuariodao=new UsuarioDAOImp();
    }
    public void agregarUsuario(Usuario usuario)
    {
        getUsuariodao().crearUsuario(usuario);
    }
    public void modificarUsuario(Usuario usuario)
    {
        getUsuariodao().modificarUsuario(usuario);
    }
    public void eliminar(Usuario usuario)
    {
        getUsuariodao().borrarUsuario(usuario);
    }
    public ArrayList<Usuario> obtenerlista()
    {
        return getUsuariodao().obtenerlista();
    }
    public Usuario validarUsuario(String nombre,String pass)
    {
        return getUsuariodao().validarUsuario(nombre, pass);
    }
            
    public UsuarioDAO getUsuariodao() {
        return usuariodao;
    }

    public void setUsuariodao(UsuarioDAO usuariodao) {
        this.usuariodao = usuariodao;
    }
    
}
