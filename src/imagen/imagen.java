package imagen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ByteLookupTable;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.awt.image.ShortLookupTable;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.print.event.PrintJobEvent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import static program.design.mos_msj;

/**
 *
 * @author jorge
 */
public class imagen extends javax.swing.JFrame implements ActionListener {

    /**
     * variables globales de tipó bufferedImagen y variables de tipo entero.
     *
     */
    private BufferedImage imagen, imagen_filtro, copia, imagen_Gris;
    int w, h, opcion, grados = 0, contraste = 200;
    double x1, y1;
    String RutaFull;
    RecortarImagen recorte;
    int[][] matrizr, matrizg, matrizb, originalr, originalg, originalb, ruidor, ruidog, ruidob, restar, restag, restab;
    private BufferedImage Nueva_Imagen, Nueva_Imagen2;

    Color colorAuxiliar;

    /**
     * constructor de la clase
     */
    public imagen() {
        initComponents();
        setTitle("Area Imagen");
    }

    /**
     * metodo que devuelve un valor de tipo entero.
     *
     * @param efecto
     */
    public void r_efecto(int efecto) {
        opcion = efecto;
    }

    /**
     * metodo set que recibe dos valores de tipo double
     *
     * @param x
     * @param y
     */
    public void tam(double x, double y) {
        x1 = x;
        y1 = y;
    }

    /**
     * arreglo estatico de tipo flotante para filtro detectar bordes
     */
    public static final float[] valores = {
        0.0f, -1.0f, 0.0f,
        -1.0f, 4.0f, -1.0f,
        0.0f, -1.0f, 0.0f
    };

    //variable estatica tipo short
    public static final short col = 256;
    /**
     * arreglo estatico de tipo flotante para filtro negativo
     */
    public static final short[] coloresInvertidos = new short[col];

    static {
        for (int i = 0; i < col; i++) {
            coloresInvertidos[i] = (short) ((col - 1) - i);
        }
    }

    /**
     * Metodo para abrir la imagen con JfileChooser
     *
     * @return exportPath variable de tipo cadena
     */
    public String agregar_imagen() {

        JFileChooser file = new JFileChooser();//Objeto de tipo File Chosser para seleccionar la ruta de la imagen
        File ruta = null;// como la ruta cambia de direccion, la inicializo a null como contador

        int estado = file.showOpenDialog(null);//guardo el estado en un entero
        if (estado == JFileChooser.APPROVE_OPTION) {//Si presiono en aceptar entonces se procesa a guardar la direccion

            ruta = file.getSelectedFile();
            RutaFull = file.getSelectedFile().getAbsolutePath();
            System.out.println(RutaFull);

            return RutaFull;
        }
        return null;
    }//fin deñ metodo cargar imagen

    /**
     * metodo que carga la imagen al bufferedImagen ajustando el tamaño de la
     * ventana
     *
     */
    public void cargaImag() {
        try {
            String url = agregar_imagen();
            imagen = ImageIO.read(new File(url));

            w = imagen.getWidth(); // ancho
            h = imagen.getHeight(); //alto
            if (imagen.getType() != BufferedImage.TYPE_INT_RGB) {
                BufferedImage bi2
                        = new BufferedImage(imagen.getWidth(), imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics big = bi2.getGraphics();
                big.drawImage(imagen, 0, 0, w, h, null);
                imagen_filtro = copia = imagen = bi2;
                imagen_Gris = imagen_filtro;
                //mos_msj("Imagen cargada correctamente");
            }
            this.setSize(w, h);
        } catch (IOException e) {
            //la imagen no se pudo leer            
        }
    } //fin del metodo cargarimagen

    /**
     * metodo que ayuda al ruido
     */
    public void inicializa(BufferedImage ima) {
        int i, j, w, h, r, g, b;

        Nueva_Imagen = new BufferedImage(ima.getWidth(), ima.getHeight(), BufferedImage.TYPE_INT_RGB);
        Nueva_Imagen2 = new BufferedImage(ima.getWidth(), ima.getHeight(), BufferedImage.TYPE_INT_RGB);

        w = ima.getWidth();
        h = ima.getHeight();
        matrizr = new int[w][h];
        matrizg = new int[w][h];
        matrizb = new int[w][h];

        for (i = 0; i < ima.getWidth(); i++) {
            for (j = 0; j < ima.getHeight(); j++) {
                colorAuxiliar = new Color(ima.getRGB(i, j));
                r = colorAuxiliar.getRed();
                g = colorAuxiliar.getGreen();
                b = colorAuxiliar.getBlue();
                matrizr[i][j] = r;
                matrizg[i][j] = g;
                matrizb[i][j] = b;
                Nueva_Imagen.setRGB(i, j, new Color(r, g, b).getRGB());

            }
        }
    }

    /**
     * metodo para el ruido
     */
    public BufferedImage Algoritmo(BufferedImage img, double parametro) {
        int con;

        int difemax = (int) ((1 - parametro) * 255);
        int[] arreglor = new int[9];
        int[] arreglog = new int[9];
        int[] arreglob = new int[9];
        int aux1, aux2, aux3;
        for (int i = 1; i < img.getWidth() - 1; i++) {
            for (int j = 1; j < img.getHeight() - 1; j++) {
                aux1 = 0;
                aux2 = 0;
                aux3 = 0;
                con = 0;
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        arreglor[con] = matrizr[i][j] - matrizr[i + x][j + y];
                        arreglog[con] = matrizg[i][j] - matrizg[i + x][j + y];
                        arreglob[con] = matrizb[i][j] - matrizb[i + x][j + y];

                        con++;

                    }
                }
                int maxr = calcula_maximo(arreglor);
                int maxg = calcula_maximo(arreglog);
                int maxb = calcula_maximo(arreglob);

                if (maxr > difemax) {
                    aux1 = Math.abs(matrizr[i][j] + (difemax - maxr));

                } else {
                    aux1 = matrizr[i][j];
                }
                if (maxg > difemax) {
                    aux2 = Math.abs(matrizg[i][j] + (difemax - maxg));
                } else {
                    aux2 = matrizg[i][j];
                }
                if (maxb > difemax) {
                    aux3 = Math.abs(matrizb[i][j] + (difemax - maxb));
                } else {
                    aux3 = matrizb[i][j];
                }
                img.setRGB(i, j, new Color(aux1, aux2, aux3).getRGB());
            }
        }

        return img;
    }//fin algoritmo

    public int calcula_maximo(int valores[]) {
        int maximo = 0;
        int indice;

        for (indice = 0; indice < valores.length; indice++) {
            if (Math.abs(valores[indice]) > Math.abs(maximo)) {
                maximo = valores[indice];

            }
        }

        return maximo;
    }

    /**
     * metodo que aplica filtros sobre la imagen original
     */
    public void agrega_filtro() {
        //declaracion de un buffered image
        BufferedImageOp destino = null;
        //estructura de seleccion switch
        switch (opcion) {
            case 9:
                /* Negativo */
                LookupTable lt = new ShortLookupTable(0, coloresInvertidos);
                destino = new LookupOp(lt, null);
                break;
            case 10:
                /*Detecta bordes*/
                float[] data1 = valores;
                destino = new ConvolveOp(new Kernel(3, 3, data1), ConvolveOp.EDGE_NO_OP, null);
                break;
            default:
        }
        try {
            imagen_filtro = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            destino.filter(imagen, imagen_filtro);
        } catch (Exception e) {
            System.out.print("");
        }

    } // fin metodo agrega filtro

    /**
     * metetodo que pinta sobre el panel
     *
     */
    @Override
    public void paint(Graphics g) {
        //limpia contenido de contexto grafico
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        switch (opcion) {
            case 0:
                /*Imagen Original*/
                imagen_filtro = imagen;
                g.drawImage(imagen, 0, 0, null);
                break;
            case 3:
                /*Escala Gris*/
                ColorConvertOp ccop = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
                imagen_filtro = ccop.filter(imagen, null);
                g.drawImage(imagen_filtro, 0, 0, null);

                break;
            case 4:
                /*Girar*/
                double r = Math.toRadians(grados); //se convierte a radianes lo grados
                AffineTransform a = new AffineTransform();
                a.rotate(r, this.getWidth() / 2, this.getHeight() / 2); //se asigna el angulo y centro de rotacion
                ((Graphics2D) g).setTransform(a);
                g.drawImage(imagen_filtro, 0, 0, this);
                break;
            case 7:
                /*Efecto Espejo Horizontal*/
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-copia.getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                imagen_filtro = op.filter(imagen_filtro, null);
                g.drawImage(imagen_filtro, 0, 0, null);
                break;
            case 8:
                /*Efecto Espejo Horizontal*/
                AffineTransform tx1 = AffineTransform.getScaleInstance(1, -1);
                tx1.translate(0, -copia.getHeight(null));
                AffineTransformOp op1 = new AffineTransformOp(tx1, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                imagen_filtro = op1.filter(imagen_filtro, null);
                g.drawImage(imagen_filtro, 0, 0, null);
                break;
            case 12:
                /*Cambiar el Contraste*/
                float brightenFactor = (float) contraste / 100;
                //System.out.println("" + brightenFactor);
                BufferedImageOp operacion = new RescaleOp(brightenFactor, 0, null);
                imagen_filtro = operacion.filter(imagen_Gris, null);
                g.drawImage(imagen_filtro, 0, 0, null);
                //System.out.println("CAMBIO Contraste");
                break;
            case 1:
                inicializa(imagen);
                imagen_filtro = Algoritmo(Nueva_Imagen, 0.9);
                g.drawImage(imagen_filtro, 0, 0, null);
                break;
            default:
                //apĺica los filtros  que estan dentro del metodo agrega_filtro
                agrega_filtro();
                g.drawImage(imagen_filtro, 0, 0, null);
                break;
        }
        if (opcion != 12) {
            imagen_Gris = imagen_filtro;
        }
    }// fin de paint

    /**
     * este metodo rota la imagen recibibiendo los grados de tipo double
     * llamando los metodos rotar y translacion final de la clase transformar
     * imagen
     *
     */
    public BufferedImage rotacionImagen(double grados) {
        //crea un objeto  transformar de la clase transformar imagen
        TransformarImagen Transformar = new TransformarImagen(imagen.getHeight(), imagen.getWidth());
        //llama al metodo rotar
        Transformar.rotar(grados);
        //llama al metodo tranlacion final
        Transformar.Traslacionfinal();
        //se crea un objeto de la clase AffineTransformOp
        AffineTransformOp nuevo = new AffineTransformOp(Transformar.Trans(), AffineTransformOp.TYPE_BILINEAR);
        /*
        	createCompatibleDestImage(BufferedImage src, ColorModel destCM)
                Crea una imagen de destino puesto a cero con el tamaño y número de bandas correcta.
         */
        imagen_filtro = nuevo.createCompatibleDestImage(imagen, imagen.getColorModel());
        /*
            filter(BufferedImage src, BufferedImage dest)
            Realiza una operación con una sola entrada / salida única en una BufferedImage.
         */
        imagen = nuevo.filter(imagen, imagen_filtro);
        //retorna imagen
        return imagen;
    }

    /**
     * metodo set que actualiza el frame
     */
    public void actualiza_frame() {
        this.setSize(imagen.getWidth(), imagen.getHeight());
    }

    /**
     * metodo que modifica los grados a girar
     *
     * @param grados variable de tipo entero
     */
    public void Grados(int grados) {
        this.grados = grados;
        repaint();
    }

    /**
     * metodo que modifica el contraste
     *
     * @param contraste variable de tipo entero
     */
    public void Contraste(int contraste) {
        this.contraste = contraste;
        repaint();
    }

    /**
     * metodo que devuelve el objeto imagen filtro
     *
     * @return imagen_filtro variable de tipo bufferedImage
     */
    public BufferedImage getBi() {
        return imagen_filtro;
    }

    /**
     * metodo que recorta una parte de la imagen
     */
    public void RecortarImagen() {
        recorte = new RecortarImagen(imagen_filtro);
        this.label.removeAll();
        this.label.add(recorte);

        recorte.TamañoRecorte(Procesar.TAncho.getValue());
        Procesar.TAncho.setMaximum(imagen_filtro.getHeight());

        this.label.repaint();

    }

    /**
     * metodo que guarda el recorte
     */
    public void GuardarRecorte() {
        String formato = "png";
        File saveFile = new File("Recorte." + formato);
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(saveFile);
        int rFormato = chooser.showSaveDialog(null);
        if (rFormato == JFileChooser.APPROVE_OPTION) {
            saveFile = chooser.getSelectedFile();
            recorte.guardar_imagen(saveFile, formato);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        label.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
