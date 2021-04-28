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

    /** <html>
     * Genera un fichero con la extension json a partir de una lista que
     * recibimos como parametro.
     * <pre>
     *Se genera un archivo con la informacion de todos los objetos que tenemos
     *en la lista
     * </pre>
     *
     * @param listaAplicaciones Lista de objetos de tipo App
     * @param idArchivo Directorio del archivo
     * @throws IOException Excepcion de malformacion del archivo
     * </html>
     */
    public static void escribirFicheroJSON(ArrayList<App> listaAplicaciones, String idArchivo) throws IOException {

        ObjectMapper mapeador = new ObjectMapper();

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File(idArchivo), App.generarListaApp(10));

        System.out.println("El fichero " + idArchivo + " se ha creado correctamente");
    }

    /** <html>
     * Genera un fichero con la extension json a partir de un objeto de tipo App
     * que recibimos como parametro.
     * <pre>
     *Se genera un archivo con la informacion del objeto que tenemos en la lista
     * </pre>
     *
     * @param aplicaion Objeto de tipo App
     * @param idArchivo Directorio donde se creara el archivo
     * @throws IOException Excepcion de malformacion del archivo
     * </html>
     */
    public static void escribirFicheroJSON(App aplicaion, String idArchivo) throws IOException {

        ObjectMapper mapeador = new ObjectMapper();

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File(idArchivo), aplicaion);

        System.out.println("El fichero " + idArchivo + " se ha creado correctamente");
    }
    
    /*HEMOS HECHO UNA SOBRECARGA DEL METODO PARA QUE SE PUDIERA REALIZAR EL 
    ULTIMO APARTADO DEL EJERICIO*/
}
