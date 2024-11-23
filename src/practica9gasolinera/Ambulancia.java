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
public class Ambulancia extends Thread{
    private 
        int id,tipo;
        Gasolinera g;
        
        
    public Ambulancia(Gasolinera g,int id){
        this.id=id;
        this.g=g;
        this.tipo=2;
    }
    @Override
    public void run(){
        System.out.println("soy un coche con id " + id);
        Random aleatorio = new Random();
        aleatorio.setSeed(System.currentTimeMillis());
        int surtidor;
        try {
            surtidor=g.entraAmbulancia(id);
            System.out.println("La Ambulancia  " + id + "Ha entrado en el surtidor: " + surtidor );
            sleep(aleatorio.nextInt(2*1000,4*1000));//tiempo de reportar
            g.saleAmbulancia(id,surtidor);
            System.out.println("La Ambulancia  " + id + "Ha salido" );
        } catch (InterruptedException ex) {
           
        }
    }
}