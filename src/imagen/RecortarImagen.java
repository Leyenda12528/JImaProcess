/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;


/**
 *
 * @author yuriani
 * @author Francisco Aguilar
 * @author Maricarmen Santos
 * @author Ivan luis Jimenez
 */
public class RecortarImagen extends JLabel implements MouseMotionListener, MouseListener {

    /**
     *  variables generales usadas dentro de la clase
     */
    Image Original;
    BufferedImage Imagen, ImagenR;
    Graphics2D g2;
    Graphics2D g2D;
    boolean con_foto = false;

    /**
     * coordenadas y tamaño del recorte
     */
    float X = 30;
    float Y = 30;
    float clipAncho = 200;
    float clipAlto = 200;

    /**
     * define el tamaño del recorte
     * 
     */
    public void TamañoRecorte(float ancho) {
        this.clipAncho = ancho;
        clipAlto = ancho;
        repaint();
    }

    /**
     * variables para elmovimiento
     */
    private int Pos_Marca_new_X = 0;
    private int Pos_Marca_new_Y = 0;
    private int Pos_Marca_X = 0;
    private int Pos_Marca_Y = 0;
    private int Dist_X = 0;
    private int Dist_Y = 0;

    private Color color_linea = new Color(100, 0, 0);
    private float grosor_linea = 2f;

    public RecortarImagen(BufferedImage f) {
        this.Original = f;
        this.setSize(f.getWidth(), f.getHeight());
        this.setVisible(true);
        this.con_foto = true;
        //eventos del raton
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {

        g2 = (Graphics2D) g;
        if (this.con_foto) {
            //se crea un lienzo del tamaño de la foto
            Imagen = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
            g2D = Imagen.createGraphics();
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //se añade la foto grande original
            g2D.drawImage(Original, 0, 0, Original.getWidth(this), Original.getHeight(this), this);
            //se crea un recuadro que sirve de referencia para el recorte
            g2D.setStroke(new BasicStroke(this.grosor_linea));
            g2D.setColor(color_linea);
            Rectangle2D r2 = new Rectangle2D.Float(X, Y, clipAncho, clipAlto);
            g2D.draw(r2);
            //se dibuja todo
            g2.drawImage(Imagen, 0, 0, this);

        }

    }

    //se extrae una subimagen de la imagen original del tamaño del recuadro rojo
    private void recortar() {
        ImagenR = ((BufferedImage) Original).getSubimage((int) X, (int) Y, (int) clipAncho, (int) clipAlto);
    }

    //metodo que guarda la imagen en disco en formato JPG
    public void guardar_imagen(File f, String formato) {
        recortar();
        try {
            //se escribe en disco            
            ImageIO.write(ImagenR, formato, f);
           
        } catch (IOException e) {
            System.out.println(""+e);
        }
    }

    /* metodos del mouse para el cuadro de recorte */
    public void mouseDragged(MouseEvent e) {
        //nuevas coordenadas
        Pos_Marca_new_X = (int) e.getPoint().getX();
        Pos_Marca_new_Y = (int) e.getPoint().getY();

        //se obtiene distancia del movimiento
        Dist_X = Pos_Marca_new_X - Pos_Marca_X;
        Dist_Y = Pos_Marca_new_Y - Pos_Marca_Y;

        //se coloca la nueva posicion
        X = X + Dist_X;
        Y = Y + Dist_Y;

        //evita que se revace los limites de la imagen
        if (X < 0) {
            X = 0;
        }
        if (Y < 0) {
            Y = 0;
        }
        if ((X + this.clipAncho) > this.getWidth()) {
            X = this.getWidth() - this.clipAncho;
        }
        if ((Y + this.clipAlto) > this.getHeight()) {
            Y = this.getHeight() - this.clipAlto;
        }

        Pos_Marca_X = Pos_Marca_X + Dist_X;
        Pos_Marca_Y = Pos_Marca_Y + Dist_Y;
        this.repaint();
    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        Pos_Marca_X = (int) e.getPoint().getX();
        Pos_Marca_Y = (int) e.getPoint().getY();
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}
