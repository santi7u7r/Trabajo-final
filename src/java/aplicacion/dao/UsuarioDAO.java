/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;

/**
 *
 * @author José Luis
 */
public interface UsuarioDAO {
    public void crearUsuario(Usuario usuario);
    public void borrarUsuario(Usuario usuario);// franco daun no pusiste public. por eso los beans no podian acceder y estaba bien.
    public Usuario validarUsuario(String nombreUsuario, String password);
    public Usuario obtenerUsuario(String nombreUsuario);
   public  void modificarUsuario(Usuario usuario);
}
