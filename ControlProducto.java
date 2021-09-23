/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hanna
 */
public class ControlProducto {
    
    //atributos
    Producto objProducto = new Producto();
    
    //metodos
    public void crear (String nombre, String cantidad, 
            int precio, Categoria categoria)// la vista entrega los datos de tipo String
    {
    
        try{
            objProducto.setNombre(nombre);
            objProducto.setCantidad(Integer.parseInt(cantidad));
            objProducto.setPrecio(precio); // ojo aca, es una prueba porque la vista lo entrega String
            objProducto.setCategoria(categoria);
            objProducto.crearProducto();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null,"Error: " + error);
        }
    }
    public ArrayList listar(){
        try{
            ResultSet consulta = objProducto.listarProducto();// Este viene del modelo Producto
            ArrayList<Producto> listaProducto = new ArrayList<>(); // este va hacia la vista, es la tabla
            
            while (consulta.next()){ // va recoriendo toda la base de datos con el metodo next hasta que no encuentra nada mas
            objProducto = new Producto(); // guarda los datos de la consulta, si no se crea como nueva borra lo anterior
            objProducto.setId(consulta.getInt(1));
            objProducto.setNombre(consulta.getString(2));
            objProducto.setCantidad(consulta.getInt(3));
            objProducto.setPrecio(consulta.getInt(4));
            listaProducto.add(objProducto); // vamos agregando cada objeto a la lista
            }
            return listaProducto;
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null,"Error: " + error);
        }
        return null; // si nada coincide con la busqueda se retorna nulo
    }
     public void actualizar (String id, String nombre, String cantidad, 
            int precio)// la vista entrega los datos de tipo String
    {
    
        try{
            objProducto.setId(Integer.parseInt(id)); // datos que vienen de set Producto
            objProducto.setNombre(nombre);
            objProducto.setCantidad(Integer.parseInt(cantidad));
            objProducto.setPrecio(precio); // ojo aca, es una prueba porque la vista lo entrega String
            objProducto.actualizarProducto();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null,"Error: " + error);
        }
     }
     
     public void eliminar (String id)// la vista entrega los datos de tipo String
    {
        try{
            objProducto.setId(Integer.parseInt(id)); // datos que vienen de set Producto
            objProducto.eliminarProducto();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null,"Error: " + error);
        }
     }
     
      public ArrayList consultar(String nombre){ // la cunsulta se hace por el nombre
        try{
            objProducto.setNombre(nombre);
            ResultSet consulta = objProducto.consultarProducto();// Este viene del modelo Producto
            ArrayList<Producto> consultaProducto = new ArrayList<>(); // este va hacia la vista, es la tabla
            
            while (consulta.next()){ // va recoriendo toda la base de datos con el metodo next hasta que no encuentra nada mas
            objProducto = new Producto(); // guarda los datos de la consulta, si no se crea como nueva borra lo anterior
            objProducto.setId(consulta.getInt(1));
            objProducto.setNombre(consulta.getString(2));
            objProducto.setCantidad(consulta.getInt(3));
            objProducto.setPrecio(consulta.getInt(4));
            consultaProducto.add(objProducto); // vamos agregando cada objeto a la lista
            }
            return consultaProducto;
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null,"Error: " + error);
        }
        return null; // si nada coincide con la busqueda se retorna nulo
    }
}
