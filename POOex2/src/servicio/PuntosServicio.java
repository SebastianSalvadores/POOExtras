/*
Definir una clase llamada Puntos que contendrá las coordenadas de dos puntos, sus
atributos serán, x1, y1, x2, y2, siendo cada x e y un punto. Generar un objeto puntos
usando un método crearPuntos() que le pide al usuario los dos números y los ingresa en
los atributos del objeto. Después, a través de otro método calcular y devolver la distancia
que existe entre los dos puntos que existen en la clase Puntos. 

Para conocer como calcular la distancia entre dos puntos consulte el siguiente link:
http://www.matematicatuya.com/GRAFICAecuaciones/S1a.html
 */
package servicio;

import entidad.Puntos;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class PuntosServicio {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public Puntos crearPuntos(){
        System.out.println("Para generar un punto P1(x1, y1), ingresar ambas coordenadas:");
        System.out.println("Ingresar coordenada x1:");
        int x1 = leer.nextInt();
        System.out.println("Ingresar coordenada y1:");
        int y1 = leer.nextInt();
        
        System.out.println("Para P2(x2,y2):");
        System.out.println("Ingresar x2:");
        int x2 = leer.nextInt();
        System.out.println("Ingresar y2:");
        int y2 = leer.nextInt();
        
        Puntos points = new Puntos(x1,y1,x2,y2);
        return points;
    }
    
    public double calcularDistancia(Puntos P){
        double distancia = Math.sqrt(Math.pow(P.getX2() - P.getX1(), 2)+ Math.pow(P.getY2() - P.getY1(), 2));
        return distancia;
    }
}
