/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author hanna
 */
public class Producto {
    // Atributos
    private int id;
    private String nombre;
    private int cantidad;
    private Categoria categoria;
    private int precio;

    //Constructor vacio
    public Producto() {
    }

    //Constructor con argumentos
    public Producto(String nombre, int cantidad, Categoria categoria, int precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.precio = precio;
    }

    //get and set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    // Metodos CRUD
    
    public void crearProducto(){
        Conexion objConecDataBase = new Conexion(); 
        objConecDataBase.conectar();
        
        try {
            String sql = "INSERT INTO producto " // mismo nombre de la tabla en la base de datos
                    +"(nombreProducto, cantidadProducto, precioProducto, idCategoriaFK)" // mismo nombre y orden de las columnas en la base de datos
                    +"VALUES (?,?,?,?)";
            PreparedStatement stmt; // con esta libreria entra datos como String, pero en la DB sigue siendo numerico si lo es
            stmt = objConecDataBase.conn.prepareStatement(sql); // aqui conecta
            stmt.setString(1, this.nombre);// el 1 corresponde con el ?numero uno, va en el mismo orden de la base de datos
            stmt.setString(2,String.valueOf(this.cantidad));// una forma de cambiar a String
            stmt.setInt(3, this.precio);                    //otra forma de cambiar a String
            stmt.setInt(4, this.categoria.getIdCategoria()); //Como la categoria es un objeto debo usar get para traer solo el ID
            stmt.execute();
            
        }  catch(Exception error) 
        {
          JOptionPane.showMessageDialog(null,"Error: " + error); 
        }
        objConecDataBase.desconectar();
    }
    
    
    public ResultSet consultarProducto(){ // aplica un filtro, solo nombre de producto
        // retorna un objeto de tipo ResultSet
        Conexion objConecDataBase = new Conexion(); //conectar a base de datos
        objConecDataBase.conectar();
        
        try {
            String sql = "SELECT * FROM producto" //instruccion de sql
                         +" WHERE nombreProducto LIKE ?;"; //aQUI BUSCA PARECIDO, = ?; para buscar igualito
            PreparedStatement stmt5; // con esta libreria entra datos como String, pero en la DB sigue siendo numerico si lo es
            stmt5 = objConecDataBase.conn.prepareStatement(sql); // aqui conecta
            stmt5.setString(1, "%" + this.nombre + "%");
            ResultSet consulta = stmt5.executeQuery(); // queda la consulta guardada en la variable consulta
            return consulta; //retornamos la consulta realizads
            
        }  
        catch(Exception error) 
        {
        JOptionPane.showMessageDialog(null,"Error: " + error); 
        }
        return null;
        // objConecDataBase.desconectar();
    }
    
    
    public ResultSet listarProducto(){
        
        Conexion objConecDataBase = new Conexion(); //conectar a base de datos
        objConecDataBase.conectar();
        
        try {
            String sql = "SELECT * FROM producto "; //instruccion de sql
            PreparedStatement stmt2; // con esta libreria entra datos como String, pero en la DB sigue siendo numerico si lo es
            stmt2 = objConecDataBase.conn.prepareStatement(sql); // aqui conecta
            ResultSet consulta = stmt2.executeQuery(); // queda la consulta guardada en la variable consulta
            return consulta; //retornamos la consulta realizads
            
        }  catch(Exception error) 
        {
           JOptionPane.showMessageDialog(null,"Error: " + error); 
        }
        return null;
        //objConecDataBase.desconectar(); no me dejo
     
    }
    public void actualizarProducto(){
        Conexion objConecDataBase = new Conexion();  //conectar
        objConecDataBase.conectar();
        
        try {
            String sql = "UPDATE producto SET " // comandos del sql
                         + "nombreProducto = ?, "
                         + "cantidadProducto = ?, "
                         + "precioProducto = ? "// mismo nombre y orden de las columnas en la base de datos
                         + "WHERE idProductoPk = ? ;";
            PreparedStatement stmt3; // con esta libreria entra datos como String, pero en la DB sigue siendo numerico si lo es
            stmt3 = objConecDataBase.conn.prepareStatement(sql); // aqui conecta
            stmt3.setString(1, this.nombre);// el 1 corresponde con el ?numero uno, va en el mismo orden de la base de datos
            stmt3.setString(2,String.valueOf(this.cantidad));// una forma de cambiar a String
            stmt3.setInt(3, this.precio);                    //otra forma de cambiar a String
            stmt3.setInt(4, this.id);//Como la categoria es un objeto debo usar get para traer solo el ID
            stmt3.execute();
            
        }  catch(Exception error) 
        {
          JOptionPane.showMessageDialog(null,"Error: " + error); 
        }
        objConecDataBase.desconectar();
           
    }
    
    
    public void eliminarProducto(){
        
        Conexion objConecDataBase = new Conexion();  //conectar
        objConecDataBase.conectar();
        
        try {
            String sql = "DELETE FROM producto " // comandos del sql
                         + "WHERE idProductoPk = ?; ";
            PreparedStatement stmt4; // con esta libreria entra datos como String, pero en la DB sigue siendo numerico si lo es
            stmt4 = objConecDataBase.conn.prepareStatement(sql); // aqui conecta
            stmt4.setString(1, String.valueOf(this.id));// el 1 corresponde con el ?numero uno, va en el mismo orden de la base de datos
            stmt4.execute();
            
        }  catch(Exception error) 
        {
          JOptionPane.showMessageDialog(null,"Error: " + error); 
        }
        objConecDataBase.desconectar(); 
        
    }
    
    //Metodo to String, sobreescrito de la clase cosmica object
    
  @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", categoria=" + categoria + ", precio=" + precio + '}';
    }  
    
}
