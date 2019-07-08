/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Categoria;
import java.util.ArrayList;

/**
 *
 * @author José Luis
 */
public interface CategoriaDAO {
        public void crearCategoria(Categoria categoria);
        public void borrarCategoria(Categoria categoria);
        public void modificarCategoria(Categoria categoria);
        public ArrayList<Categoria> obtenercat();
        public Categoria obtenerCategoria(int idcategoria);
        
}
