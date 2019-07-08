/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Cliente;
import java.util.ArrayList;

/**
 *
 * @author José Luis
 */
public interface ClienteDAO {
    public void crearCliente(Cliente cliente);
    public void borrarCliente(Cliente cliente);
    public void modificarCliente(Cliente cliente);
    public Cliente obtenerCliente(int dni);
    public ArrayList<Cliente> obtenerCliente();
}
