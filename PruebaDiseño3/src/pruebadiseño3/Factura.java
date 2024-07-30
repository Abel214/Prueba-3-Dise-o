/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pruebadiseño3;

/**
 *
 * @author Alejandro
 */
public interface Factura {
    double calcularSubtotal(String producto,int cantidad);  //metodo para calcular el subtotal del producto 
    float calcularTotal(double subtotal);  // metodo para calcular el total de los productos en base al subtotal y el iva aplicado
    String getDescripcion(); //metodo para obtener la descripción de la factura
}
