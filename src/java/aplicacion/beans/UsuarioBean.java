/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans;

import aplicacion.dao.ClienteDAO;
import aplicacion.dao.UsuarioDAO;
import aplicacion.dao.imp.ClienteDAOImp;
import aplicacion.modelo.dominio.Cliente;
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
    private ClienteDAO clientedao;
    private UsuarioDAO usuariodao;
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
        clientedao=new ClienteDAOImp();
       
    }
    public void agregaruser(Usuario nuevousuario)
    {
        getUsuariodao().crearUsuario(nuevousuario);
    }
    public ArrayList<Usuario> obtenerlista()
    {ArrayList<Usuario> r=new ArrayList();
    for(int i=0;i<getUsuariodao().Listausuario().size();i++)
    {
        if(getUsuariodao().Listausuario().get(i).getEstado()==true)
        {
          r.add(getUsuariodao().Listausuario().get(i));
        }
    }
     return r;   /*en esta parte solo se envian los usuarios que se encuentran con el estado==true.
      esto quiere decir que lo demas que se encuentren desactivados no 
    seran borrados al menos que el administrador elija esa opcion. */
    }
    // supongo yo que en la vista cuando se muestra la lista de usuario.
    public void borrado(Usuario a)
    {
        getUsuariodao().borrarUsuario(a);
    }
    public void modificarusuariobean(Usuario e)
    {
        getUsuariodao().modificarUsuario(e);
    }
    public Usuario validacion_user(String nombre,String pass)
    {
        return getUsuariodao().validarUsuario(nombre, pass);
    }
    /**
     * @return the clientedao
     */
    public ClienteDAO getClientedao() {
        return clientedao;
    }

    /**
     * @param clientedao the clientedao to set
     */
    public void setClientedao(ClienteDAO clientedao) {
        this.clientedao = clientedao;
    }
    /**
     * @return the usuariodao
     */
    public UsuarioDAO getUsuariodao() {
        return usuariodao;
    }

    /**
     * @param usuariodao the usuariodao to set
     */
    public void setUsuariodao(UsuarioDAO usuariodao) {
        this.usuariodao = usuariodao;
    }

}
