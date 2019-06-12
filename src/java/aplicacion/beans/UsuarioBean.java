/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.beans;

import aplicacion.dao.imp.UsuarioDAOImp;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import aplicacion.dao.UsuarioDAO;

/**
 *
 * @author José Luis
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {
    UsuarioDAO undao;
    
    
    
    
    
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
        undao= (UsuarioDAO) new UsuarioDAOImp();
        
        
        
    }
    
}
