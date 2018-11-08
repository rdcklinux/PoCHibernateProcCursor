/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

/**
 *
 * @author developer
 */
public class Cliente {
    private int id;
    private String nombre;
    
    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
}
