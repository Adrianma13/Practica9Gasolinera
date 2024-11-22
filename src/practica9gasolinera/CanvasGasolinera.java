/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica9gasolinera;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author Adria
 */
class Vehiculos {

    int id;
    int tipo;
    int surtidor;

    public Vehiculos(int id, int tipo, int surtidor) {
        this.id = id;
        this.tipo = tipo;
        this.surtidor = surtidor;
    }
}

public class CanvasGasolinera extends Canvas {

    private Image coche, camion, repostar,escaner;
    private ArrayList<Vehiculos> cola = new ArrayList();
    private ArrayList<Vehiculos> surtidores = new ArrayList();

    public CanvasGasolinera(int alto, int largo) throws InterruptedException {

        // Image offscreen = createImage(getWidth(), getHeight());
        // Graphics og = offscreen.getGraphics();
        this.setSize(alto, largo);
        this.setBackground(Color.cyan);

        coche = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagenes/coche.png"));
        camion = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagenes/camion.png"));
        repostar = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagenes/repostar.png"));
        MediaTracker dibu = new MediaTracker(this);
        dibu.addImage(coche, 0);
        dibu.waitForID(0);
        dibu.addImage(camion, 1);
        dibu.waitForID(0);
        dibu.addImage(repostar, 2);
        dibu.waitForID(0);

    }

    @Override
    public void paint(Graphics g) {
        Image img = createImage(this.getWidth(), this.getHeight());
        Graphics og = img.getGraphics();

        //Area cola
        og.setColor(Color.ORANGE);
        og.fillRect(0, 570, 1200, 200);

        og.drawImage(repostar, 200, 150, 100, 100, this);// creamos imagen 
        og.drawImage(repostar, 200, 300, 100, 100, this);// creamos imagen 
        og.drawImage(repostar, 700, 150, 100, 100, this);// creamos imagen 
        og.drawImage(escaner, 300, 400, 400, 400, this);
        og.drawImage(repostar, 700, 300, 100, 100, this);// creamos imagen 
        Font f1 = new Font("Arial", Font.TYPE1_FONT, 30);
        og.setFont(f1);
        og.setColor(Color.BLACK);
        og.drawString("COLA DE ESPERA", 30, 550);
        g.drawImage(img, 0, 0, this);// pintamos la imagen en el canvas

        for (int i = 0; i < cola.size(); i++) {
            if (cola.get(i).tipo == 0) {
                og.drawImage(coche, 100 * i + 30, 600, 70, 70, this);
            }

            if (cola.get(i).tipo == 1) {
                og.drawImage(camion, 100 * i + 30, 600, 70, 70, this);
            }
        }

        for (int j = 0; j < surtidores.size(); j++) {
            if (surtidores.get(j).surtidor == 1 && surtidores.get(j).tipo == 0){ 
                og.drawImage(coche, 70, 160, 70, 70, this);
                og.drawString("" + surtidores.get(j).id,30 , 220);
            }
            
            if (surtidores.get(j).surtidor == 1 && surtidores.get(j).tipo == 1) {
             
                og.drawImage(camion, 70, 160, 70, 70, this);
                og.drawString("" + surtidores.get(j).id,30 , 220);
            }
            if (surtidores.get(j).surtidor == 2 && surtidores.get(j).tipo == 0){ 
                    og.drawImage(coche, 330, 320, 70, 70, this);
                    og.drawString("" + surtidores.get(j).id, 420 , 380);
            }
                
            if (surtidores.get(j).surtidor == 2 && surtidores.get(j).tipo == 1) {
                    og.drawImage(camion, 330, 320, 70, 70, this);
                    og.drawString("" + surtidores.get(j).id, 420 , 380);
            }
            if (surtidores.get(j).surtidor == 3 && surtidores.get(j).tipo == 0) {
                    og.drawImage(coche, 600, 160, 70, 70, this);
                    og.drawString("" + surtidores.get(j).id,  560 , 220);
            }
                
            if (surtidores.get(j).surtidor == 4 && surtidores.get(j).tipo == 0) {
                    og.drawImage(coche, 820, 320, 70, 70, this);
                    og.drawString("" + surtidores.get(j).id, 900 , 370);
            }
                
            if (surtidores.get(j).surtidor == 4 && surtidores.get(j).tipo == 1) {
                    og.drawImage(camion, 820, 320, 70, 70, this);
                    og.drawString("" + surtidores.get(j).id, 900 , 370);
            }

        }
        g.drawImage(img, 0, 0, this);// pintamos la imagen en el canvas
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public void pintarCocheCola(int id, int tipo) {
        cola.add(new Vehiculos(id, tipo, 0));
        repaint();
    }

    public void eliminarCocheCola(int id, int tipo) {
        int i = 0;
        boolean encontrado = false;

        while (!encontrado) {
            if (cola.get(i).id == id) {
                encontrado = true;
            } else {
                i++;
            }
        }
        cola.remove(i);

        repaint();
    }

    public void pintarCamionCola(int id, int tipo) {
        cola.add(new Vehiculos(id, tipo, 0));
        repaint();
    }

    public void eliminarCamionCola(int id, int tipo) {
        int i = 0;
        boolean encontrado = false;

        while (!encontrado) {
            if (cola.get(i).id == id) {
                encontrado = true;
            } else {
                i++;
            }
        }
        cola.remove(i);

        repaint();
    }

    public void pintarCocheSurtidor(int id, int tipo, int surtidor) {
        surtidores.add(new Vehiculos(id, tipo, surtidor));
        repaint();
    }

    public void eliminarCochesurtidor(int id) {
        int i = 0;
        boolean encontrado = false;

        while (!encontrado) {
            if (surtidores.get(i).id == id) {
                encontrado = true;
            } else {
                i++;
            }
        }
        surtidores.remove(i);

        repaint();
    }

    public void pintarCamionSurtidor(int id, int tipo, int surtidor) {
        surtidores.add(new Vehiculos(id, tipo, surtidor));

        repaint();
    }

    public void eliminarCamionsurtidor(int id) {
        int i = 0;
        boolean encontrado = false;

        while (!encontrado) {
            if (surtidores.get(i).id == id) {
                encontrado = true;
            } else {
                i++;
            }
        }
        surtidores.remove(i);

        repaint();
    }
}
