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
import javax.xml.bind.JAXBException;

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
        
        escribirFicheroXML(listaDeAplicaciones, DIRECTORIOXML);
        
        

        JSONporAplicacion(listaDeAplicaciones, DIRECTORIOAPLICACIONES);
    }

    /**
     * Metodo que crea un archivo de extension .json por cada una de las
     * aplicaciones que tengamos en la lista
     *
     * @param listaDeAplicaciones Lista con los objetos de tipo App
     * @param directorio Destino de creacion del archivo
     */
    private static void JSONporAplicacion(ArrayList<App> listaDeAplicaciones, String directorio) {

        listaDeAplicaciones.forEach(aplicacion -> {

            String idArchivo = "/" + aplicacion.getNombre() + ".json";

            try {
                ServicioFicheroJSON.escribirFicheroJSON(aplicacion, directorio + idArchivo);
            } catch (IOException ex) {
                Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    /**<html>
     * Metodo que crea un archivo de extension .xml con todas las
     * aplicaciones que tengamos en la lista.
     * <pre>
     *Se crea por medio de la instanciacion de un objeto de tipo "CatalogoApp"
     * </pre>
     * @param listaDeAplicaciones Lista con los objetos de tipo App
     * @param directorio Destino de creacion del archivo
     */
    private static void escribirFicheroXML(ArrayList<App> listaDeAplicaciones, String directorio) {
        
        CatalogoApp catalogo = new CatalogoApp(listaDeAplicaciones);
        
        try {
            ServicioFicheroXML.escribirXML(catalogo, directorio + "/Aplicaciones.xml");
        }catch (JAXBException e){
            System.out.println(e.getMessage());
        }
    }
}
