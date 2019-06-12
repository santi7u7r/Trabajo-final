/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Usuario;

/**
 *
 * @author José Luis
 */
public interface UsuarioDAO {
    void crearUsuario(Usuario usuario);
    void borrarUsuario(Usuario usuario);
    Usuario validarUsuario(String nombreUsuario, String password);
    Usuario obtenerUsuario(String nombreUsuario);
    void modificarUsuario(Usuario usuario);
}
