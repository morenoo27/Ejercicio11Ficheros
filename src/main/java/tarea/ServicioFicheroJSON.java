/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class ServicioFicheroJSON {

    public static void main(String[] args) throws IOException {

        ArrayList<App> listaAplicaciones = App.generarListaApp(10);

        String idArchivo = "aplicaciones.json";

        ServicioFicheroJSON.escribirFicheroJSON(listaAplicaciones, idArchivo);
    }

    public static void escribirFicheroJSON(ArrayList<App> listaAplicaciones, String idArchivo) throws IOException {

        ObjectMapper mapeador = new ObjectMapper();

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File(idArchivo), App.generarListaApp(10));
        
        System.out.println("El fichero " + idArchivo + " se ha creado correctamente");
    }
}
