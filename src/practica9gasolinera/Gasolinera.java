/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica9gasolinera;

/**
 *
 * @author usuario
 */
public class Gasolinera {

    private int s1= 1, s2= 1, s3= 1, s4= 1;
    CanvasGasolinera canvas;
    public Gasolinera(CanvasGasolinera canvas) {
      this.canvas=canvas;
    }

    public synchronized int entraCoche(int id) throws InterruptedException {
        int surtidor = 0;
        canvas.pintarCocheCola(id,0);//pintar canvas en cola
        while (s1 == 0 && s2 == 0 && s3 == 0 && s4 == 0) {
            
            wait();
        }
        canvas.eliminarCocheCola(id, 0);
        if (s2 == 1) {
            //pintar canvas 
            canvas.pintarCocheSurtidor(id, 0 , 2);
            s2 = 0;
            surtidor=2;
        }else
        if (s3 == 1) {
            canvas.pintarCocheSurtidor(id, 0 , 3);
            //pintar canvas 
            s3 = 0;
            surtidor=3;
        }else
        if (s1 == 1) {
            canvas.pintarCocheSurtidor(id, 0 , 1);
            //pintar canvas 
            s1 = 0;
            surtidor=1;
        }else
        if (s4 == 1) {
            canvas.pintarCocheSurtidor(id, 0 , 4);
            //pintar canvas 
            s4 = 0;
            surtidor=4;
        }
        return surtidor;
    }

    public synchronized void saleCoche(int id,int surtidor) {
        switch (surtidor) {
            case 1 -> {
                canvas.eliminarCochesurtidor(id);
                //borrar canvas
                s1=1;
            }
            case 2 -> {
                canvas.eliminarCochesurtidor(id);
                //borrar canvas
                s2=1;
            }
            case 3 -> {
                canvas.eliminarCochesurtidor(id);
                //borrar canvas
                s3=1;
            }
            case 4 -> {
                canvas.eliminarCochesurtidor(id);
                //borrar canvas
                s4=1;
            }
            default -> {
            }
        }
          notifyAll();
    }

    public synchronized int entraCamion(int id) throws InterruptedException {
        int surtidor=0;
        canvas.pintarCamionCola(id,1);
        while (s1 == 0 && s4 == 0 && (s2 == 0 || s3 == 0)) {
            //pintar canvas en cola
            wait();
        }
        canvas.eliminarCamionCola(id, 1);
        //borrar de la cola
        if (s1 == 1) {
            canvas.pintarCamionSurtidor(id, 1 , 1);
            //pintar canvas 
            
            s1 = 0;
            surtidor=1;

        }else
        if (s4 == 1) {
            canvas.pintarCamionSurtidor(id, 1 , 4);
            //pintar canvas 
            s4 = 0;
            surtidor=4;
        }else
        if (s2 == 1 || s3 == 1) {
            canvas.pintarCamionSurtidor(id, 1 , 2);
            //pintar canvas 
            s2 = 0;
            s3 = 0;
            surtidor=2;
        }

        return surtidor;
    }

    public synchronized void saleCamion(int surtidor,int id) {
        switch (surtidor) {
            case 1 -> {
                canvas.eliminarCamionsurtidor(id);
                //borrar canvas
                s1=1;
            }
            case 2 -> {
                canvas.eliminarCamionsurtidor(id);
                //borrar canvas
                s2=1;
                s3=1;
            }
            case 4 -> {
                canvas.eliminarCamionsurtidor(id);
                //borrar canvas
                s4=1;
            }
            default -> {
            }
        }
          notifyAll();
    }

}
