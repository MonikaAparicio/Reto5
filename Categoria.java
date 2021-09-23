/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author hanna
 */
public class Categoria {
    
    //Atributos
    private int idCategoria;
    private String nombreCategoria;
    
    //Constructor

    public Categoria() {
    }
    
    //get y set encapsular

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    //Metodo consultar categoria
    
    public void consultarCategoria(){
        
    }
    
}
