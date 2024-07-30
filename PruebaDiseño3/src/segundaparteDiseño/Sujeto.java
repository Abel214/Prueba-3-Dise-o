/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package segundaparteDiseño;

/**
 *
 * @author Alejandro
 */
public interface Sujeto {
    void addObserver(Observer observador); //método para añadir al observador
    void removeObserver(Observer observador); //metodo para remover al observador
    void notifyObserver(String mensaje); //método que envia el mensaje al observador notificando sobre algún cambio producido
}
