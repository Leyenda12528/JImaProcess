package imagen;

/**
 * importando las librerias
 */
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

/**
 *
 * @author jorge
 */
public class TransformarImagen {

    /**
     * declaracion de variables globales
     */
    //se crea un objeto 
    AffineTransform trans;

    int alturaImagen;
    int anchoImagen;
    double grados;

    /**
     * metodo que devuelve la altura y la anchura de la imagen
     *
     * @param alturaImagen variable de tipo entero
     * @param anchuraImagen variable de tipo entero
     */
    public TransformarImagen(int alturaImagen, int anchuraImagen) {
        trans = new AffineTransform();
        this.alturaImagen = alturaImagen;
        this.anchoImagen = anchuraImagen;
    }

    /**
     * metodo que devuelve los grados
     *
     * @param grados variable de tipo double
     */
    public void rotar(double grados) {
        this.grados = grados;
        //calcula el angulo  y el punto de rotacion 
        trans.rotate(Math.toRadians(grados), anchoImagen / 2.0, alturaImagen / 2.0);
    }

    /**
     * metodo que devuelve el objeto AffineTransform llamado trans
     *
     * @return
     */
    public AffineTransform Trans() {
        return trans;
    }

    /**
     * metodo que calcula la translacion de la imagen
     */
    public void Traslacionfinal() {
        /*
         * variable de tipo point2D
         * Point2Dclase define un punto que representa una ubicación en el (x,y)espacio de coordenadas.
         */
        Point2D puntoA, puntoB;
        //calcula el ṕunto A
        puntoA = hallarPtoATraslacion();
        puntoB = trans.transform(puntoA, null);
        //variable de tipo double
        double ytrans = puntoB.getY();

        puntoA = hallarPtoBTraslacion();
        puntoB = trans.transform(puntoA, null);
        //        variable de tipo double
        double xtrans = puntoB.getX();
        //se crea un objeto nuego de tipo affine
        AffineTransform a = new AffineTransform();
        // el objeto obtiene las coordenadas de X y Y
        a.translate(-xtrans, -ytrans);
        trans.preConcatenate(a);
    }

    /**
     * metodo que obtiene el punto A
     *
     * @return devuelve un objeto de tipo point2D
     */
    private Point2D hallarPtoATraslacion() {
        Point2D puntoA;
        if (grados >= 0 && grados <= 90) {
            puntoA = new Point2D.Double(0.0, 0.0);
        } else if (grados > 90 && grados <= 180) {
            puntoA = new Point2D.Double(0.0, alturaImagen);
        } else if (grados > 180 && grados <= 270) {
            puntoA = new Point2D.Double(anchoImagen, alturaImagen);
        } else {
            puntoA = new Point2D.Double(anchoImagen, 0.0);
        }
        return puntoA;
    }

    /**
     * metodo que obtiene el punto B
     *
     * @return devuelve un Objeto de tipo point2D
     */
    private Point2D hallarPtoBTraslacion() {
        Point2D puntoB;
        if (grados >= 0 && grados <= 90) {
            puntoB = new Point2D.Double(0.0, alturaImagen);
        } else if (grados > 90 && grados <= 180) {
            puntoB = new Point2D.Double(anchoImagen, alturaImagen);
        } else if (grados > 180 && grados <= 270) {
            puntoB = new Point2D.Double(anchoImagen, 0.0);
        } else {
            puntoB = new Point2D.Double(0.0, 0.0);
        }
        return puntoB;
    }
}
