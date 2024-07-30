/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package segundaparteDiseño;

import java.util.Scanner;

/**
 *
 * @author Alejandro
 */
public class PruebaDiseño {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EncargadoInventario inventario=new EncargadoInventario();
        Alerta alerta1=new Alerta("Alerta 1");
        inventario.addObserver(alerta1);
        Scanner scanner=new Scanner(System.in);
        boolean continuar=true;
        while (continuar) {            
            System.out.println("Ingrese un producto porfavor(Leche/Huevos/Carne): ");
            String producto1=scanner.nextLine().toLowerCase();
            System.out.println("Ingrese la cantidad del producto: ");
            int cantidad=scanner.nextInt();
            scanner.nextLine();
            inventario.reabastecerStock(producto1, cantidad);
            System.out.println("Hay mas productos que desea ingresar?(si/no): ");
            continuar= scanner.nextLine().equalsIgnoreCase("si");
            
        }
        
    }
    
}
