/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebadiseño3;

import java.util.Scanner;

/**
 *
 * @author Alejandro
 */
public class FacturaEstandar implements Factura {

    private StringBuilder descripcion;
    private Scanner Scanner;    
    public FacturaEstandar() {
        this.descripcion = new StringBuilder();   //en este constructor se maneja la entrada del usuario y las descripciones
        this.Scanner = new Scanner(System.in);   //las descripciones se van a ir uniendo a traves del String Builder
    }      
    @Override
    public double calcularSubtotal(String producto, int cantidad) {
        double precioUnitario = obtenerPrecioUnitario(producto);  //se define una variable para almacenar el precio del producto en base a lo que ingrese el usuario
        float resultado = (float) (precioUnitario * cantidad);  //variable que almacena el resultado a partir de una fórmula
        String formato=String.format("%.2f", resultado);
        agregarDescripcion(producto, cantidad, resultado);  
        //System.out.printf("La cantidad de %s es: %d,el resultado es: %f%n",producto,cantidad,resultado);
        return resultado;
    }   
    @Override
    public float calcularTotal(double subtotal) {
        double iva=0.15;   //se define el Iva con el que se trabajará
        float total=(float) (subtotal+(subtotal*iva));     //se realiza el cálculo del IVA 
        String formato=String.format("%.2f", total);
        descripcion.append("Total con Iva :$ ").append(formato).append("\n");  //se presenta el resultado
        return total;
    }   
    @Override
    public String getDescripcion() {
        return descripcion.toString();  //se presenta la descripción de la fáctura que a lo largo del código se ha ido conectando
    }
    private double obtenerPrecioUnitario(String producto) { //Método para añadir el precio unitario de los productos
        switch (producto) {
            case "leche":
                return 1.25;
            case "huevos":
                return 0.5;
            case "carne":
                return 1.50;
            default:
                System.out.println("No existe el producto que se ingreso");;
                return 0;
        }
    }
    private void agregarDescripcion(String producto, int cantidad, float resultado) {  //método para presentar los datos correspondientes de la factura
        String formato=String.format("%.2f", resultado); 
        descripcion.append("Producto: ").append(producto)   
                .append(",Cantidad: ").append(cantidad)
                .append(",Subtotal :$ ").append(formato)
                .append("\n");
    }
    /*
    Métodos que servirán para interactuar con el usuario
    */
    private boolean preguntarProductos(){   //método para preguntar al usuario si hay más productos a calcular si no tiene se pasa a su respectico método
        System.out.println("¿Tiene más productos?(Si/No): ");
        return Scanner.nextLine().equalsIgnoreCase("Si");
    }
    private String nombreProducto(){ //método para que el usuario ingrese el nombre del producto correspondiente a las opciones que se le presentan
        System.out.println("Ingrese el nombre del producto (Leche/Huevos/Carne): ");
        return Scanner.nextLine();  
    }
    private int cantidadProducto(){  //método para que ingrese el usuario la cantidad de productos anteriormente escritos
        System.out.println("Ingrese la cantidad de los productos: ");
        int cantidad=Scanner.nextInt();
        Scanner.nextLine();
        return cantidad;
    }
}
