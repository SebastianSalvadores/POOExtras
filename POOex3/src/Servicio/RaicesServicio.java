/*
Vamos a realizar una clase llamada Raices, donde representaremos los valores de una
ecuación de 2o grado. Tendremos los 3 coeficientes como atributos, llamémosles a, b y c.
Hay que insertar estos 3 valores para construir el objeto a través de un método
constructor. Luego, las operaciones que se podrán realizar son las siguientes:

 Método getDiscriminante(): devuelve el valor del discriminante (double). El
discriminante tiene la siguiente formula: (b^2)-4*a*c
 Método tieneRaices(): devuelve un booleano indicando si tiene dos soluciones, para
que esto ocurra, el discriminante debe ser mayor o igual que 0.
 Método tieneRaiz(): devuelve un booleano indicando si tiene una única solución, para
que esto ocurra, el discriminante debe ser igual que 0.
 Método obtenerRaices(): llama a tieneRaíces() y si devolvió́ true, imprime las 2
posibles soluciones.
 Método obtenerRaiz(): llama a tieneRaiz() y si devolvió́ true imprime una única raíz.
Es en el caso en que se tenga una única solución posible.
 Método calcular(): esté método llamará tieneRaices() y a tieneRaíz(), y mostrará por
pantalla las posibles soluciones que tiene nuestra ecuación con los métodos
obtenerRaices() o obtenerRaiz(), según lo que devuelvan nuestros métodos y en caso
de no existir solución, se mostrará un mensaje.

Nota: Formula ecuación 2o grado: (-b±√((b^2)-(4*a*c)))/(2*a) Solo varia el signo
delante de -b
 */
package Servicio;

import Entidad.Raices;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class RaicesServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Raices cargarRaices() {
        System.out.println("Para una ecuación de 2° grado, cargar los coeficientes a, b y c");
        System.out.println("Ingrese coeficiente a:");
        double a = leer.nextDouble();
        System.out.println("Ingrese coeficiente b:");
        double b = leer.nextDouble();
        System.out.println("Ingrese coeficiente c:");
        double c = leer.nextDouble();
        Raices roots = new Raices(a, b, c);
        return roots;
    }

    //Método getDiscriminante(): devuelve el valor del discriminante (double). El 
    //discriminante tiene la siguiente formula: (b^2)-4*a*c
    public double getDiscriminante(Raices r) {
        double discriminante = Math.pow(r.getB(), 2) - (4 * r.getA() * r.getC());
        return discriminante;
    }

    //Método tieneRaices(): devuelve un booleano indicando si tiene dos soluciones, para
    //que esto ocurra, el discriminante debe ser mayor o igual que 0. (CORRECCION: si es >= nunca va a entrar a tieneRaiz)
    public boolean tieneRaices(Raices r) {
        double disc = getDiscriminante(r);
        return disc > 0;
    }

    //Método tieneRaiz(): devuelve un booleano indicando si tiene una única solución, para
    //que esto ocurra, el discriminante debe ser igual que 0.
    public boolean tieneRaiz(Raices r) {
        double disc = getDiscriminante(r);
        return disc == 0;
    }

    //Método obtenerRaices(): llama a tieneRaíces() y si devolvió́ true, imprime las 2
    //posibles soluciones. (-b±√((b^2)-(4*a*c)))/(2*a)
    public void obtenerRaices(Raices r) {
        if (tieneRaices(r)) {
            double x1 = (-r.getB() + Math.sqrt((Math.pow(r.getB(), 2)) - (4 * r.getA() * r.getC()))) / (2 * r.getA());
            double x2 = (-r.getB() - Math.sqrt((Math.pow(r.getB(), 2)) - (4 * r.getA() * r.getC()))) / (2 * r.getA());
            System.out.println("Las raices son x1=" + x1 + " y x2=" + x2 + ".");
        }
    }

    //Método obtenerRaiz(): llama a tieneRaiz() y si devolvió́ true imprime una única raíz.
    //Es en el caso en que se tenga una única solución posible. x = -b / 2a
    public void obtenerRaiz(Raices r) {
        if (tieneRaiz(r)) {
            double raiz = -r.getB() / (2 * r.getA());
            System.out.println("La raiz es x=" + raiz);
        }
    }

    //Método calcular(): esté método llamará tieneRaices() y a tieneRaíz(), y mostrará por
    //pantalla las posibles soluciones que tiene nuestra ecuación con los métodos
    //obtenerRaices() o obtenerRaiz(), según lo que devuelvan nuestros métodos y en caso
    //de no existir solución, se mostrará un mensaje.
    public void calcular(Raices r) {
        if (tieneRaices(r)) {
            obtenerRaices(r);
        } else if (tieneRaiz(r)) {
            obtenerRaiz(r);
        } else {
            System.out.println("La ecuacion no tiene raices reales.");
        }
    }
}
