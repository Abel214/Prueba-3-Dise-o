/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundaparteDiseño;

/**
 *
 * @author Alejandro
 */
public class Producto {
    private String nombre;
    private int stock; //variable para alamcenar la cantidad de productos
    private int medio; //cantidad de productos que están a la mitad o número definidio por el cual se debe abastecer
    private int reabastecimiento;  //variable que almacena productos a abastecer

    public Producto(String nombre, int stock, int medio, int reabastecimiento) {
        this.nombre = nombre;
        this.stock = stock;
        this.medio = medio;
        this.reabastecimiento = reabastecimiento;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    

    public int getMedio() {
        return medio;
    }

    public int getReabastecimiento() {
        return reabastecimiento;
    }
      
    public void reabastecer(){
        this.stock= reabastecimiento;
    }
    
    
    
}
