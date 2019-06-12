/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Cliente;

/**
 *
 * @author José Luis
 */
public interface ClienteDAO {
    void crearCliente(Cliente cliente);
    void borrarCliente(Cliente cliente);
    void modificarCliente(Cliente cliente);
}
