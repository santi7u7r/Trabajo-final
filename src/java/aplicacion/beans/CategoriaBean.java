/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans;

import aplicacion.dao.CategoriaDAO;
import aplicacion.dao.imp.CategoriaDAOImp;
import aplicacion.modelo.dominio.Categoria;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author santiago
 */
@ManagedBean
@ViewScoped
public class CategoriaBean {
    private CategoriaDAO categoriadao;
    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
         categoriadao=new CategoriaDAOImp();
    }
    public void agregar(Categoria r)
    {
        getCategoriadao().crearCategoria(r);
    }
    public ArrayList<Categoria> obtenercategorias()
{
    return getCategoriadao().obtenercat();
}

    /**
     * @return the categoriadao
     */
    public CategoriaDAO getCategoriadao() {
        return categoriadao;
    }

    /**
     * @param categoriadao the categoriadao to set
     */
    public void setCategoriadao(CategoriaDAO categoriadao) {
        this.categoriadao = categoriadao;
    }
}
