/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author hanna
 */

public class Conexion {
    
    //atributos
    public Connection conn; // una conexion a usar despues
    private String host = "localhost:3306"; //Es constante, es el puerto de la base de datos (Port)
    private String dataBase= "productosmisiontic1"; //nombre de mi base de datos
    private String user ="root"; //usuario de la base de datos verificado en simbolo del sistema)
    private String password = "";//contraseña de la base de datos verificado en simbolo del sistema)
    
    // metodos
    public void conectar(){
        // comprobar conexion
        try // prueba 
        {
          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
          conn = DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.dataBase+"?zeroDateTimeBehavior=CONVERT_TO_NULL",this.user,this.password); //direccion de la pestaña Services - Databases jbdc...
          //JOptionPane.showMessageDialog(null, "CONECCTION OK");  //prueba para comprobar conexion correcta el inicio
        }
        catch(Exception error) //Captura un objeto error del tipo exception
        {
          JOptionPane.showMessageDialog(null,"Error: " + error); //Joption = desde la terminal
        }
    }
    public void desconectar(){
        conn = null;
        
    }
}
