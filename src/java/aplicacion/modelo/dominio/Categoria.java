package aplicacion.modelo.dominio;
// Generated 08/06/2019 10:53:24 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Categorias generated by hbm2java
 */
public class Categoria  implements java.io.Serializable {


     private int idcategoria;
     private String nombre;
     private String descripcion;
     private Set productos = new HashSet(0);
             private int cantidadproduc;
             private boolean estado;
    public Categoria() {
    }

	
    public Categoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
    public Categoria(int idcategoria, String nombre, String descripcion, Set productoses) {
       this.idcategoria = idcategoria;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.productos = productoses;
    }
   
    public int getIdcategoria() {
        return this.idcategoria;
    }
    
    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Categoria{" + "idcategoria=" + getIdcategoria() + ", nombre=" + getNombre() + ", descripcion=" + getDescripcion() + ", productos=" + getProductos() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.getIdcategoria();
        hash = 47 * hash + Objects.hashCode(this.getNombre());
        hash = 47 * hash + Objects.hashCode(this.getDescripcion());
        hash = 47 * hash + Objects.hashCode(this.getProductos());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (this.getIdcategoria() != other.getIdcategoria()) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.productos, other.productos)) {
            return false;
        }
        return true;
    }

    /**
     * @return the cantidadproduc
     */
    public int getCantidadproduc() {
        return cantidadproduc;
    }

    /**
     * @param cantidadproduc the cantidadproduc to set
     */
    public void setCantidadproduc(int cantidadproduc) {
        this.cantidadproduc = cantidadproduc;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }




}


