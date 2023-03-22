/*
Juego Ahorcado: Crear una clase Ahorcado (como el juego), la cual deberá contener
como atributos, un vector con la palabra a buscar, la cantidad de letras encontradas y la
cantidad jugadas máximas que puede realizar el usuario. Definir los siguientes métodos
con los parámetros que sean necesarios:
 Constructores, tanto el vacío como el parametrizado.
 Metodo crearJuego(): le pide la palabra al usuario y cantidad de jugadas máxima.
Con la palabra del usuario, pone la longitud de la palabra, como la longitud del
vector. Después ingresa la palabra en el vector, letra por letra, quedando cada letra
de la palabra en un índice del vector. Y también, guarda en cantidad de jugadas
máximas, el valor que ingresó el usuario y encontradas en 0.
 Método longitud(): muestra la longitud de la palabra que se debe encontrar. Nota:
buscar como se usa el vector.length.
 Método buscar(letra): este método recibe una letra dada por el usuario y busca sila
letra ingresada es parte de la palabra o no. También informará si la letra estaba o no.
 Método encontradas(letra): que reciba una letra ingresada por el usuario y muestre
cuantas letras han sido encontradas y cuantas le faltan. Este método además deberá
devolver true si la letra estaba y false si la letra no estaba, ya que, cada vez que se
busque una letra que no esté, se le restará uno a sus oportunidades.
 Método intentos(): para mostrar cuantas oportunidades le queda al jugador.
 Método juego(): el método juego se encargará de llamar todos los métodos
previamente mencionados e informará cuando el usuario descubra toda la palabra o
se quede sin intentos. Este método se llamará en el main. (VER EJEMPLO DE EJECUCION EN LA GUIA)
 */
package Servicio;

import Entidad.Ahorcado;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class AhorcadoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Ahorcado crearJuego() {
        System.out.println("Creando juego de Ahorcado. Ingrese una palabra: ");
        String palabra = leer.next();
        System.out.println("Ingrese cantidad de jugadas máximas: ");
        int jugadas = leer.nextInt();
        String array[] = new String[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            array[i] = palabra.substring(i, (i + 1));
        }
        String vector[] = new String[palabra.length()];
        Arrays.fill(vector, "0");
        Ahorcado newGame = new Ahorcado(array, 0, jugadas, vector);
        System.out.println("Juego creado! limpia la consola para ocultar la palabra. (ctrl + L)");
        leer.next();
        return newGame;
    }

    public void longitud(Ahorcado game) {
        int longitud = game.getVector().length;
        System.out.println("Longitud de la palabra: " + longitud);
    }

    public int buscar(Ahorcado game, String letra) {
        int encontradas = 0;
        String letrasEncontradas[] = game.getLetrasEnc();
        boolean repite = false;
        int j = 0;
        for (int i = 0; i < letrasEncontradas.length; i++) {
            if (letrasEncontradas[i].equalsIgnoreCase(letra)) {
                repite = true;
                break;
            }
        }
        if (repite == false) {
            for (int i = 0; i < letrasEncontradas.length; i++) {
                if (letrasEncontradas[i].equals("0")) {
                    j = i;
                    break;
                }

            }

            for (int i = 0; i < game.getVector().length; i++) {
                if (game.getVector()[i].equalsIgnoreCase(letra)) {
                    encontradas++;
                    letrasEncontradas[j] = letra;
                    j++;
                }
            }
            if (encontradas != 0) {
                System.out.println("La letra pertenece a la palabra.");
                game.setLetrasEnc(letrasEncontradas);
            } else {
                System.out.println("La letra no pertenece a la palabra");
            }
        } else {
            System.out.println("La letra no pertenece a la palabra");

        }

        return encontradas;
    }

    public boolean encontradas(Ahorcado game, String letra) {
        int busq = buscar(game, letra);
        int total = game.getCantEncontradas() + busq;
        game.setCantEncontradas(total);
        System.out.println("Número de letras (encontradas, faltantes): (" + game.getCantEncontradas() + ", " + (game.getVector().length - game.getCantEncontradas()) + ")");
        return (busq == 0);
    }

    public void intentos(Ahorcado game, String letra) {
        boolean enc = encontradas(game, letra);
        int intentos = game.getCantJugadasMax();
        if (enc) {
            intentos -= 1;
        }
        game.setCantJugadasMax(intentos);
        System.out.println("Número de oportunidades restantes: " + game.getCantJugadasMax());
    }

    public void juego() {
        Ahorcado juego = crearJuego();

        do {
            System.out.println("Ingrese una letra:");
            String letra = leer.next();
            longitud(juego);
            intentos(juego, letra);
        } while (juego.getCantJugadasMax() > 0 && juego.getCantEncontradas() < juego.getVector().length);
        if (juego.getCantEncontradas() == juego.getVector().length) {
            System.out.println("Felicitaciones! has encontrado la palabra!");
        } else {
            System.out.println("Lo sentimos, no hay más oportunidades");
        }
    }
}
