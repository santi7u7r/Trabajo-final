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
public class prueba {
    public static void main(String[] args) {
       Usuario usuario= new Usuario();
       Cliente cliente = new Cliente();
       UsuarioDAO usuariodao= new UsuarioDAOImp();
       usuario.setCodigo(0);
       usuario.setApellidos("Churquina");
       usuario.setEstado(true);
       usuario.setNombreUsuario("Santiagochurquina");
       usuario.setNombres("Santiago Lucas");
       usuario.setPassword("43211168s");
       usuario.setTipoUsuario("Admin");
       cliente.setDni(43211168);
       cliente.setDomicilio("Alto Comedero");
       cliente.setMail("santiago_luki@hotmail.com");
       cliente.setPais("Argentina");
       cliente.setTelefono("154861062");
       cliente.setProvincia("jujy");
       usuario.setCliente(cliente);
       usuariodao.crearUsuario(usuario);
    }
}
