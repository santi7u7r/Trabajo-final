/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans.categoria;

import aplicacion.dao.CategoriaDAO;
import aplicacion.dao.imp.CategoriaDAOImp;
import aplicacion.modelo.dominio.Categoria;
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
public class CategoriaBean implements Serializable{
    private CategoriaDAO categoriaDAO;
    
    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
        categoriaDAO= new CategoriaDAOImp();
    }
    public void agregarCategoria(Categoria categoria)
    {
        categoriaDAO.crearCategoria(categoria);
    }
    public void modificarCategoria(Categoria categoria)
    {
        categoriaDAO.modificarCategoria(categoria);
    }
    public void eliminarCategoria ( Categoria c)
    {
        categoriaDAO.borrarCategoria(c);
    }
    public ArrayList<Categoria> obtenerListado()
    {
        return categoriaDAO.obtenercat();
    }
    public CategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }
    
}
