/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.CategoriaDAO;
import aplicacion.dao.DetalleDAO;
import aplicacion.modelo.dominio.Categoria;
import aplicacion.modelo.dominio.Producto;

/**
 *
 * @author santiago
 */
public class prueba {
    public static void main(String[] args) {
        DetalleDAO r=new DetalleDAOImp();
       
        CategoriaDAO k=new CategoriaDAOImp();
      for(int y=0;y<k.obtenercat().size();y++)
      {
          System.out.println(k.obtenercat().get(y).getNombre());
      }
    }
}
