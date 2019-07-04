/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans;

import aplicacion.modelo.dominio.Producto;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author santiago
 */
@ManagedBean
@ViewScoped
public class ProductoFormBean1 {
    private ArrayList<Producto> listoproducto;
    @ManagedProperty(value = "#{probean}")
    private ProductoBean1 probean;
    private Producto Pro1;
    
    /**
     * Creates a new instance of ProductoFormBean1
     */
    public ProductoFormBean1() {
        listoproducto=new ArrayList();
    }
    @PostConstruct
    void init()
    {setProbean(new ProductoBean1());
       setListoproducto(getProbean().obtenerlista());
    }

    /**
     * @return the listoproducto
     */
    public ArrayList<Producto> getListoproducto() {
        return listoproducto;
    }

    /**
     * @param listoproducto the listoproducto to set
     */
    public void setListoproducto(ArrayList<Producto> listoproducto) {
        this.listoproducto = listoproducto;
    }

    /**
     * @return the probean
     */
    public ProductoBean1 getProbean() {
        return probean;
    }

    /**
     * @param probean the probean to set
     */
    public void setProbean(ProductoBean1 probean) {
        this.probean = probean;
    }

    /**
     * @return the Pro1
     */
    public Producto getPro1() {
        return Pro1;
    }

    /**
     * @param Pro1 the Pro1 to set
     */
    public void setPro1(Producto Pro1) {
        this.Pro1 = Pro1;
    }
            
    
}
