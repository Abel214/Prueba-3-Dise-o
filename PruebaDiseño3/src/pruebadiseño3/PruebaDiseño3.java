/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebadiseño3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alejandro
 */
public class PruebaDiseño3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FacturaFactory facturaFactory=new FacturaFactory();
        Scanner scanner=new Scanner(System.in);
        int cantidadTotal=0;  //se define una variable para almacenar el número total de productos
        List<String>productos=new ArrayList<>(); //una lista que nos ayudará a guardar los productos para los cálculos
        List<Integer>cantidades=new ArrayList<>(); //una lista que guarda las cantidades de los productos correspondientes
        boolean continuar=true;
        while (continuar) {   //bucle que pregunta al usuario los productos y sus cantidades           
            System.out.println("Ingrese un producto (Leche/Huevos/Carne): ");
            String producto=scanner.nextLine();
            System.out.println("Ingrese la cantidad del producto: ");
            int cantidad=scanner.nextInt();
            scanner.nextLine();
            productos.add(producto);  //se añaden los productos a la lista
            cantidades.add(cantidad); //se añaden las cantidades a la lista
            cantidadTotal += cantidad;
            System.out.println("¿Hay mas productos por ingresar?(Si/No): ");
            continuar=scanner.nextLine().equalsIgnoreCase("Si");    //si es no se termina el bucle
        }
        Factura factura=facturaFactory.crearFactura(cantidadTotal); //se crea la factura dependiendo del condicional
        double subtotal=0.0; //variable para almacenar el subtotal
        for (int i = 0; i < productos.size(); i++) {
            subtotal+= factura.calcularSubtotal(productos.get(i),cantidades.get(i)); //se calcula el subtotal de los productos
        } 
        String formato=String.format("%.2f", subtotal);  //se presenta los resultados con 2 decimales
        System.out.println("El subtotal es :$ "+formato);
        float total=factura.calcularTotal(subtotal);
        String formato1=String.format("%.2f", total);
        System.out.println("El total es :$ "+formato1);
        String descripcion=factura.getDescripcion();  //se llama a la función para presentar todos los detalles de la factura
        System.out.println("Descripción de los productos:\n" +descripcion);
    }
    
}
