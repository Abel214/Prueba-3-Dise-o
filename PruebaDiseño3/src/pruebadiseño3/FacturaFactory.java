/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebadiseño3;

/**
 *
 * @author Alejandro
 */
public class FacturaFactory {
    public Factura crearFactura(int cantidadTotal){  //método para crear la factura correspondiente 
        if(cantidadTotal<=30){  //si la cantidad total de productos es menor o igual a 30  se crea una factura sin descuento
            System.out.println("Creacion de Factura Estandar");
            return new FacturaEstandar();
        }else{
            System.out.println("Creacion de Factura con Descuento");
            return new FacturaDescuento(0.1); //0.1 representa el descuento de la factura a aplicar
        }
    }
}
