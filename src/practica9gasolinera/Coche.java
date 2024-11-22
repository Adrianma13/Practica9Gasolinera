/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica9gasolinera;


import java.util.Random;

/**
 *
 * @author usuario
 */
public class Coche extends Thread{
    private 
        int id;
        Gasolinera g;
        int tipo=1;
        
    public Coche(Gasolinera g,int id){
        this.id=id;
        this.g=g;
    }
    @Override
    public void run(){
        System.out.println("soy un coche con id " + id);
        Random aleatorio = new Random();
        aleatorio.setSeed(System.currentTimeMillis());
        int surtidor;
        try {
            surtidor=g.entraCoche(id);
            System.out.println("El coche  " + id + "Ha entrado en el surtidor: " + surtidor );
            sleep(aleatorio.nextInt(2*1000,4*1000));//tiempo de reportar
            g.saleCoche(id,surtidor);
            System.out.println("El coche  " + id + "Ha salido" );
        } catch (InterruptedException ex) {
           
        }
    }
}