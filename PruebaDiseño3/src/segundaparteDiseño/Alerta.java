/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundaparteDiseño;

/**
 *
 * @author Alejandro
 */
public class Alerta implements Observer{
    private String nombre; //Se define una variable para el nombre de la alerta

    public Alerta(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void update(String mensaje) {
        System.out.println(nombre + ":" + mensaje);//En este método se presenta el nombre del observador y el mensaje que se quiera enviar
    }    
}
