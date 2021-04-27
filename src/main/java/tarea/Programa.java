/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleja
 */
public class Programa {

    public static void main(String[] args) throws IOException {

        final String DIRECTORIOTSV = "./appstsv";
        final String DIRECTORIOXML = "./appsxml";
        final String DIRECTORIOJSON = "./appsjson";
        final String DIRECTORIOCOPIAS = "./copias";
        final String DIRECTORIOAPLICACIONES = "./aplicaciones";

        ArrayList<App> listaDeAplicaciones = App.generarListaApp(50);

        listaDeAplicaciones.forEach(aplicaciones -> {
            System.out.println(aplicaciones);
        });

        ServicioFicheroTSV.escribirTSV(listaDeAplicaciones, DIRECTORIOTSV + "/Aplicaciones.tsv");

        ServicioFicheroJSON.escribirFicheroJSON(listaDeAplicaciones, DIRECTORIOJSON + "/Aplicaciones.json");

        JSONporAplicacion(listaDeAplicaciones, DIRECTORIOAPLICACIONES);
    }

    /**
     * Metodo que crea un archivo de extension .json por cada una de las
     * aplicaciones que tengamos en la lista
     *
     * @param listaDeAplicaciones
     */
    private static void JSONporAplicacion(ArrayList<App> listaDeAplicaciones, String directorio) {

        for (App aplicacion : listaDeAplicaciones) {
            
            ArrayList<App> listaUnicaApp = new ArrayList<>();
            listaUnicaApp.add(aplicacion);
            
            String idArchivo = "/" + listaUnicaApp.get(0).getNombre() + ".json";
            
            try {
                ServicioFicheroJSON.escribirFicheroJSON(listaUnicaApp, directorio + idArchivo);
            } catch (IOException ex) {
                Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
    }
}
