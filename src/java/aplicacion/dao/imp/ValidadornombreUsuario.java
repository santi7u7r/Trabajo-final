/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.UsuarioDAO;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.validate.ClientValidator;

/**
 *
 * @author santiago
 */
@FacesValidator("validatorusuario")
public class ValidadornombreUsuario implements Validator, ClientValidator{
    String nombre;
    UsuarioDAO usuarioDAO;
    public ValidadornombreUsuario() {
         nombre=null;
         usuarioDAO= new UsuarioDAOImp();
    }
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        if(o==null)
        {
         return;  
        }
    if(usuarioDAO.obtenerUsuario(nombre)!=null)
    {
        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de validacion", "El nombre de usuario"+ o+" ya existe" ));
    }
    }
    @Override
    public Map<String, Object> getMetadata() {
return null;
        }

    @Override
    public String getValidatorId() {
       return "validatorusuario";
    }
    
}
