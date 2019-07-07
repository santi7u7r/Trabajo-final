/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.UsuarioDAO;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;

/**
 *
 * @author santiago
 */
public class test {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO =new UsuarioDAOImp();
        Usuario usuario = new Usuario();
        Cliente cliente = new Cliente();
        usuario.setApellidos("churquina");
        usuario.setCodigo(0);
        usuario.setEstado(true);
        usuario.setNombreUsuario("santiagochurquina");
        usuario.setNombres("Santiago Lucas");
        usuario.setTipoUsuario("Admin");
        usuario.setPassword("43211168s");
        cliente.setDni(43211168);
        cliente.setDomicilio("Alto Comedero");
        cliente.setMail("santiago_luki@hotmail.com");
        cliente.setProvincia("jujuy");
        cliente.setPais("argentina");
        cliente.setTelefono("154861062");
        usuario.setCliente(cliente);
        usuarioDAO.crearUsuario(usuario);
    }
}
