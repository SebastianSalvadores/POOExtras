/*
Crea una clase en Java donde declares una variable de tipo array de Strings que
contenga los doce meses del año, en minúsculas. A continuación, declara una variable
mesSecreto de tipo String, y hazla igual a un elemento del array (por ejemplo,
mesSecreto = mes[9]. El programa debe pedir al usuario que adivine el mes secreto. Si el
usuario acierta mostrar un mensaje, y si no lo hace, pedir que vuelva a intentar adivinar
el mes secreto. 
Un ejemplo de ejecución del programa podría ser este:
Adivine el mes secreto. Introduzca el nombre del mes en minúsculas: febrero
No ha acertado. Intente adivinarlo introduciendo otro mes: agosto
¡Ha acertado!
 */
package Servicio;

import Entidad.MesSecreto;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class MesSecretoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void advinarMes() {
        MesSecreto secretMonth = new MesSecreto();
        System.out.print("Adivine el mes secreto. Introduzca el nombre del mes en minúsclulas: ");
        String mes = leer.next();
        while (!mes.equals(secretMonth.getMesSecreto())) {
            System.out.print("\nNo ha acertado. Intente adivinarlo introduciendo otro mes: ");
            mes = leer.next();
        }
        System.out.println("\n¡Ha acertado!");
    }
}
