package servicios;

import dominio.Pelicula;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

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

    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

    }
}
