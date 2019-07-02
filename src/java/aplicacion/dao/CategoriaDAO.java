/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Categoria;

/**
 *
 * @author José Luis
 */
public interface CategoriaDAO {
        void crearCategoria(Categoria categoria);
        void borrarCategoria(Categoria categoria);
        void modificarCategoria(Categoria categoria);
}
