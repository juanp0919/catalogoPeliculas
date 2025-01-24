package servicios;

import dominio.Pelicula;

import javax.swing.*;
import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPelicula{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo()
    {
        var archivo = new File(NOMBRE_ARCHIVO);
        //Si el archivo exite no se vuelve a crear
        try {
        if (archivo.exists())
        {
            JOptionPane.showMessageDialog(null, "El archivo ya existe");
        }
        //Si no existe, se crea desde cero
            else{
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                JOptionPane.showMessageDialog(null, "Se ha creado el archivo");
        }
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "ocurrio un problrma en el archivo: " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
    var archivo = new File(NOMBRE_ARCHIVO);
    try {
    JOptionPane.showMessageDialog();
    //se abre el arcivo para leerlo
    var entrada = new BufferedReader(new FileReader(archivo));

    //Se lee linea a linea el archivo
    String linea;
    linea = entrada.readLine();

    //ciclo para leer las lineas
        while (linea != null)
        {
            var pelicula = new Pelicula(linea);
            JOptionPane.showMessageDialog(null, pelicula);
            linea = entrada.readLine(); // Se solicita la siguiente linea
        }
        entrada.close(); //se cierra el archivo

    }catch (Exception e)
    {
        JOptionPane.showMessageDialog(null, "Ocurrio un error al abrir el archivo" + e.getMessage());
    }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

    }
}
