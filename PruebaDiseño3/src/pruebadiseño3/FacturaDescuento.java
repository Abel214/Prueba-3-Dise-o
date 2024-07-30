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
public class FacturaDescuento implements Factura {
    private StringBuilder descripcion;
    private Scanner Scanner;
    private double descuento;
    public FacturaDescuento(double descuento) {
        this.descripcion = new StringBuilder();   //en este constructor se maneja la entrada del usuario y las descripciones
        this.Scanner = new Scanner(System.in);   //las descripciones se van a ir uniendo a traves del String Builder
        this.descuento= descuento;
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
    @Override
    public double calcularSubtotal(String producto, int cantidad) {
        double precioUnitario = obtenerPrecioUnitario(producto);  //se define una variable para almacenar el precio del producto en base a lo que ingrese el usuario
        int resultado = (int) (precioUnitario * cantidad);  //variable que almacena el resultado a partir de una fórmula
        double calcularDescuento= resultado*descuento;  //se aplica el descuento en la suma de los productos por la cantidad
        float resultadoFinal= (float) (resultado-calcularDescuento); //se restla el calculo del descuento con el resultado
        String formato=String.format("%.2f", resultadoFinal);
        agregarDescripcion(producto, cantidad, resultadoFinal);  
        System.out.println("La cantidad de: " + producto + " es: " + cantidad + " el resultado es: " + formato);
        return resultadoFinal;
    }
    
    @Override
    public float calcularTotal(double subtotal) {
        double iva=0.15;   //se define el Iva con el que se trabajará
        double total=subtotal+(subtotal*iva);     //se realiza el cálculo del IVA 
        String formato2=String.format("%.2f", total);
        double descuentoOperacion=total*descuento;  //se aplica el descuento al total
        String formato1=String.format("%.2f", descuentoOperacion);
        float totalFinal=(float) (total-descuentoOperacion);  //se realiza la operación final para sacar el total final a pagar
        String formato=String.format("%.2f", totalFinal);
        descripcion.append("Total con Iva:$ ").append(formato2).append("\n")
                .append("Su descuento es:$ ").append(formato1).append("\n")
                .append("Total final de la compra es:$ ").append(formato).append("\n");  //se presenta el resultado
        return totalFinal;
    }
    
    @Override
    public String getDescripcion() {
        return descripcion.toString();  //se presenta la descripción de la fáctura que a lo largo del código se ha ido conectando
    }
    private void agregarDescripcion(String producto, int cantidad, double resultado) {  //método para presentar los datos correspondientes de la factura
        String formato=String.format("%.2f", resultado);
        descripcion.append("Producto: ").append(producto)   
                .append(",Cantidad: ").append(cantidad)
                .append(",Subtotal:$ ").append(formato)
                .append("\n");
    }
    /*
    Métodos que servirán para interactuar con el usuario
    */
    private boolean preguntarProductos(){   //método para preguntar al usuario si hay más productos a calcular si no tiene se pasa a su respectico método
        System.out.println("¿Tiene más prodcutos?(Si/No): ");
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
