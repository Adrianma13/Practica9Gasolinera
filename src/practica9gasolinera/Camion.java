/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica9gasolinera;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author usuario
 */
public class Camion implements Runnable {

    private int id;
    Gasolinera g;

    public Camion(Gasolinera g, int id) {
        this.id = id;
        this.g = g;
    }

    @Override
    public void run() {
        System.out.println("soy un camion con id " + id);
        Random aleatorio = new Random();
        
        aleatorio.setSeed(System.currentTimeMillis());
        int surtidor;
        try {
            surtidor = g.entraCamion(id);
             System.out.println("El camion  " + id + "Ha entrado en el surtidor "+ surtidor );
            sleep(aleatorio.nextInt(2*1000, 4*1000));//teimpo de reportar
            g.saleCamion(surtidor,id);
             System.out.println("El camion  " + id + "Ha salido" );
        } catch (InterruptedException ex) {

        }
    }

}
//Toolkit.getDefaultToolkit().getImage(getClass().getResource("DIRECCION"))
