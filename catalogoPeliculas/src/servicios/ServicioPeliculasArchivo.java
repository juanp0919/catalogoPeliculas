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
    boolean anexar = false;
    var archivo = new File(NOMBRE_ARCHIVO);
    try {
    //Se revisa si el archivo existe
        anexar = archivo.exists();
        var salida = new PrintWriter(new FileWriter(archivo, anexar));
        JOptionPane.showMessageDialog(null, pelicula);
        salida.close();
        JOptionPane.showMessageDialog(null, "Se agrego correctamente la pelicula: " + pelicula);


    }catch (Exception e)
    {
        JOptionPane.showMessageDialog(null, "Ocurrio un error al agregar pelicula" + e.getMessage());
    }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //Abrimos el archivo para la lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();
            while (lineaTexto != null)
            {
                //Buscamos sin importar tipo de escritura
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto))
                {
                    encontrada = true;
                    break;
                }
                lineaTexto = entrada.readLine();
                indice++;
            }
            //Se imprimen los resultados
            if (entrada)
            {
                JOptionPane.showMessageDialog(null, "pelicula " + lineaTexto + "encontrada - linea" + indice);
            }else {
                JOptionPane.showMessageDialog(null, "la pelicula no fue encotrada");
            }
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al buscar la pelicula" + e.getMessage());
        }
    }
}
