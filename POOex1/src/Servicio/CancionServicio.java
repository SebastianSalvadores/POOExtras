/*
Desarrollar una clase Cancion con los siguientes atributos: titulo y autor. Se deberá́
definir además dos constructores: uno vacío que inicializa el titulo y el autor a cadenas
vacías y otro que reciba como parámetros el titulo y el autor de la canción. Se deberán
además definir los métodos getters y setters correspondientes.
 */
package Servicio;

import Entidad.Cancion;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class CancionServicio {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public Cancion agregarCancion(){
        System.out.println("Ingrese titulo de la cancion:");
        String titulo = leer.next();
        System.out.println("Ingrese autor de la cancion:");
        String autor = leer.next();
        Cancion song = new Cancion(titulo,autor);
        return song;
    }
    
    public void mostrarCancion(Cancion song){
        System.out.println('"'+song.getTitulo()+'"'+" - "+song.getAutor());
    }
}
