/*
Desarrollar una clase Cancion con los siguientes atributos: titulo y autor. Se deberá́
definir además dos constructores: uno vacío que inicializa el titulo y el autor a cadenas
vacías y otro que reciba como parámetros el titulo y el autor de la canción. Se deberán
además definir los métodos getters y setters correspondientes.
 */
package pooex1;

import Entidad.Cancion;
import Servicio.CancionServicio;

/**
 *
 * @author Sebastian
 */
public class POOex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CancionServicio cs = new CancionServicio();
        Cancion c1 = cs.agregarCancion();
        Cancion c2 = cs.agregarCancion();
        cs.mostrarCancion(c1);
        cs.mostrarCancion(c2);
    }
    
}
