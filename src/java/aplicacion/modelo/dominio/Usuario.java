package aplicacion.modelo.dominio;
// Generated 08/06/2019 10:53:24 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int codigo;
     private Cliente cliente;
     private String nombreUsuario;
     private String password;
     private String tipoUsuario;
     private String apellidos;
     private String nombres;
     private Boolean estado;
     private Set facturas = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(int codigo, Cliente clientes) {
        this.codigo = codigo;
        this.cliente = clientes;
    }
    public Usuario(int codigo, Cliente clientes, String nombreUsuario, String password, String tipoUsuario, String apellidos, String nombres, Boolean estado, Set facturas) {
       this.codigo = codigo;
       this.cliente = clientes;
       this.nombreUsuario = nombreUsuario;
       this.password = password;
       this.tipoUsuario = tipoUsuario;
       this.apellidos = apellidos;
       this.nombres = nombres;
       this.estado = estado;
       this.facturas = facturas;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTipoUsuario() {
        return this.tipoUsuario;
    }
    
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set facturas) {
        this.facturas = facturas;
    }




}


