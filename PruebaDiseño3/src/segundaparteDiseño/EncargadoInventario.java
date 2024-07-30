/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundaparteDiseño;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class EncargadoInventario implements Sujeto {
    private List<Observer> observadores= new ArrayList<>(); //Se define una lista dinámica para guardar los observadores y sus diferentes alertas que produzcan
    private List<Producto> productos;

    public EncargadoInventario() {
        productos=new ArrayList<>();
        productos.add(new Producto("leche",15,3,15));   //se define el producto y los valores que representa stock,medio y reabastecimiento
        productos.add(new Producto("huevos",10,5,10));
        productos.add(new Producto("carne",12,8,12));
    }  
    @Override
    public void addObserver(Observer observador) {
        observadores.add(observador);  //metodo para añadir al observador
    }
    @Override
    public void removeObserver(Observer observador) {
        observadores.remove(observador);  //método para apartar al observador
    }
    @Override
    public void notifyObserver(String mensaje) {  //método para notificar a los demás observadores
        for (Observer observador:observadores) {
            observador.update(mensaje);
        }
    }
    public void reabastecerStock(String nombreProducto,int cantidad){
        Producto producto= buscarProducto(nombreProducto);  //buscamos el producto a reabastecer
        if(producto!=null){
            int stock= producto.getStock()-cantidad;  //se almacena el stock del producto cuando se pide una cantidad del producto para descontar al stock y enviar una alerta
            producto.setStock(stock);
            
            if (stock<producto.getMedio()) {
                //se envia una notificación de alerta al observador cuando el stock es menor al número medio que se define
                notifyObserver("Es necesario reabastecer los productos. El sotck actual de "+ nombreProducto + " es de:" + stock);
                producto.reabastecer(); //se reabastece el producto
                //se envia una nofitificación indicando el reabastecimiento del producto
                notifyObserver("El sotck de "+ nombreProducto + " reabastecido!!. El stock actual es de " + producto.getStock());
            
            }
        }else{
                System.out.println("Producto no registrado: "+ nombreProducto);
        }
    }        
    public Producto buscarProducto(String producto){
        for (Producto producto1:productos) {   //Se busca el producto en la lista 
            if (producto1.getNombre().equalsIgnoreCase(producto)) { //si el producto en este caso es igual al producto almacenado nos devolvera el mismo producto
                return producto1;
            }
        }
        return null;
    }
}
