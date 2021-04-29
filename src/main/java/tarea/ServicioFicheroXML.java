/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author aleja
 */
public class ServicioFicheroXML {

    /**
     * <html><pre>
     *Metodo que crea un fichero con extension xml a partir de un catologo con
     *una lista de objetos de tipo App en un directorio determinado.
     *
     *El archivo se genera de la siguiente forma:
     *
     *Primero:
     *    Crea el contexto JAXB. Se encarga de definir los objetos que vamos
     *    a guardar. En nuestro caso de tipo App
     *    (linea 64)
     *
     *Segundo:
     *    El contexto JAXB permite crear un objeto Marshaller, que sirve
     *    para generar la estructura del fichero XML El proceso de pasar objetos
     *    Java (CatalogoMuebles) a ficheros XML se conoce como "marshalling" o
     *    "serialización"
     *    (linea 66)
     * 
     *Tercero:
     *    Especificamos que la propiedad del formato de salida del
     *    serializador sea true, lo que implica que el formato se realiza con
     *    indentación y saltos de línea
     *    (linea 68)
     * 
     *Cuarto:
     *    Generacion del archivo en el directorio
     *    (linea 70)
     * 
     * 
     *Apunte:
     *    Llamando al método de serialización marshal (sobrecargado) se pueden 
     *    serializar objetos java en formato XML y volcarlos donde necesitemos 
     *    (consola, ficheros, etc) . El proceso consiste en que el contexto es 
     *    el encargo de leer los objetos java, pasarlos al serializador y éste 
     *    crear la salida de serialización
     * </pre>
     * 
     * @param catalogo Catalogo con todas las aplicaciones
     * @param directorio Lugar donde generaremos el archivo
     * @throws JAXBException
     * </html>
     */
    public static void escribirXML(CatalogoApp catalogo, String directorio) throws JAXBException {

        JAXBContext contexto = JAXBContext.newInstance(CatalogoApp.class);
        
        Marshaller serializador = contexto.createMarshaller();
        
        serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        serializador.marshal(catalogo, new File(directorio));
    }
}
