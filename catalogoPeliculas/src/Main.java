import servicios.ServicioPeliculaLista;
import servicios.IServicioPelicula;
import dominio.Pelicula;
import servicios.ServicioPeliculasArchivo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        boolean salir = false;
        String opcion;

        //IServicioPelicula iServicioPelicula = new ServicioPeliculaLista();
        IServicioPelicula iServicioPelicula = new ServicioPeliculasArchivo();


        while (!salir) {
            opcion = mostrarMenu();
            switch (opcion) {
                case "1":
                    Pelicula pelicula = new Pelicula(JOptionPane.showInputDialog("Ingrese el nombre de la película"));
                    iServicioPelicula.agregarPelicula(pelicula);
                    break;

                case "2":
                    iServicioPelicula.listarPeliculas();
                    break;

                case "3":
                    String nombrePelicula = JOptionPane.showInputDialog("Ingrese el nombre de la película a buscar");
                    Pelicula pelicula1 = new Pelicula(nombrePelicula);
                    iServicioPelicula.buscarPelicula(pelicula1);
                    break;

                case "4":
                    salir = true;
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar el programa! Hasta luego.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida, por favor intente de nuevo.");
            }
        }
    }

    public static String mostrarMenu() {
        return JOptionPane.showInputDialog(
                "Ingrese la opción de su preferencia:\n" +
                        "1. Agregar Película\n" +
                        "2. Listar Películas\n" +
                        "3. Buscar Película\n" +
                        "4. Salir"
        );
    }
}
