package servicios;

import dominio.Pelicula;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculaLista  implements IServicioPelicula
{
    private final List<Pelicula> peliculas;

    public  ServicioPeliculaLista()
    {
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        if (peliculas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay películas en la lista.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Listado de Películas: ");
        peliculas.forEach(pelicula -> JOptionPane.showMessageDialog(null, pelicula.toString()));
    }



    @Override
    public void agregarPelicula(Pelicula pelicula)
    {
        peliculas.add(pelicula);
        JOptionPane.showMessageDialog(null, "Se agrego la pelicula: " + pelicula.getNombre());

    }

    @Override
    public void buscarPelicula(Pelicula pelicula)
    {

        var indice = peliculas.indexOf(pelicula);
        if (indice != -1)
        {
            JOptionPane.showMessageDialog(null, "Pelicula encontrada en el catalogo en la posicion: " + indice);
        }else
        {
            JOptionPane.showMessageDialog(null, "Pelicula no encontrada en el catalogo");

        }

    }
}
