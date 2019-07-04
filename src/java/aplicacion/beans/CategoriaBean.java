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
import javax.annotation.PostConstruct;
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
    private ArrayList<Categoria> ui;
    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
         categoriadao=new CategoriaDAOImp();
         ui=new ArrayList();
    }
    @PostConstruct
    public void init()
    {
        ui=obtenercategorias();
    }
    public void agregar(Categoria r)
    {
        System.out.println("b");
        getCategoriadao().crearCategoria(r);
        
    }
    public ArrayList<Categoria> obtenercategorias()
{
    return getCategoriadao().obtenercat();
}
public void eliminar(Categoria u)
{
    getCategoriadao().borrarCategoria(u);
}
public void modificar(Categoria r)
{
    getCategoriadao().modificarCategoria(r);
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

    /**
     * @return the ui
     */
    public ArrayList<Categoria> getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(ArrayList<Categoria> ui) {
        this.ui = ui;
    }
}
