/*
Dígito Verificador. Crear una clase NIF que se usará para mantener DNIs con su
correspondiente letra (NIF). Los atributos serán el número de DNI (entero largo) y la
letra (String o char) que le corresponde. 

Dispondrá de los siguientes métodos:
 Métodos getters y setters para el número de DNI y la letra.
 Método crearNif(): le pide al usuario el DNI y con ese DNI calcula la letra que le
corresponderá. Una vez calculado, le asigna la letra que le corresponde según el
resultado del calculo.
 Método mostrar(): que nos permita mostrar el NIF (ocho dígitos, un guion y la letra
en mayúscula; por ejemplo: 00395469-F).

La letra correspondiente al dígito verificador se calculará a traves de un método que
funciona de la siguiente manera: Para calcular la letra se toma el resto de dividir el
número de DNI por 23 (el resultado debe ser un número entre 0 y 22). El método debe
buscar en un array (vector) de caracteres la posición que corresponda al resto de la
división para obtener la letra correspondiente. (VER TABLA EN GUIA)
 */
package Servicio;

import Entidad.NIF;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class NIFService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public NIF crearNif() {
        NIF nif = new NIF();
        String DNIcad;
        do {
            System.out.println("Ingrese DNI:");
            DNIcad = leer.next();
            if (DNIcad.length() > 8 || DNIcad.length() < 6) {
                System.out.println("Ingrese un DNI valido.");
            }
            if (DNIcad.length() == 7) {
                DNIcad = "0".concat(DNIcad);
            } else if (DNIcad.length() == 6) {
                DNIcad = "00".concat(DNIcad);
            }
        } while (DNIcad.length() > 8 || DNIcad.length() < 6);
        long DNI = Long.parseLong(DNIcad);
        nif.setDNI(DNI);
        char letra = buscarLetra(DNI);
        nif.setLetra(letra);
        return nif;
    }

    public void mostrar(NIF Nif) {
        System.out.println("NIF: " + Nif.getDNI() + "-" + Nif.getLetra());
    }

    public char buscarLetra(long DNI) {
        char vector[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = (int) (DNI % 23);
        char letra = vector[resto];
        return letra;
    }
}
