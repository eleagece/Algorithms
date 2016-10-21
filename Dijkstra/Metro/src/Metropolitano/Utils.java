/*
 * Utils.java
 *
 * Created on 1 de mayo de 2007, 13:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Metropolitano;
/*
 * Utils.java
 *
 * Created on 20 de marzo de 2007, 11:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Alberto
 */
import java.io.*; 
import java.util.ArrayList;
import javax.xml.parsers.*; 
import javax.xml.transform.*; 
import javax.xml.transform.dom.*; 
import javax.xml.transform.stream.*; 
import org.w3c.dom.*; 
import java.util.Hashtable;
 
public class Utils { 
    

    //El método ReadFile recibe un archivo de texto xml, y lo almacena en un Document 
    public  Document readFile(String filename) { 
       try { 
             DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
             Document doc = factory.newDocumentBuilder().parse(new File(filename)); 
             return doc; 
            } catch (java.lang.Exception e) { 
            } 
       return null; 
    } 
    
    //El método writeFile recibe un Document y un archivo, y almacena la  
    //estructura xml en el archivo dado. 
    public  void writeFile(Document doc, String filename) { 
        try { 
                Source source = new DOMSource(doc); 
                File file = new File(filename); 
                Result result = new StreamResult(file); 
                Transformer xformer = TransformerFactory.newInstance().newTransformer(); 
                xformer.transform(source, result); 
            } catch (java.lang.Exception e) { 
            }  
        } 
    
//El método leer recupera en un ArrayList de arrays de cadenas la información almacenada  en el documento XML 
    public int[][] leer(String filename, Hashtable thEstaciones, Hashtable thCodigos) { 
    //Se obtiene el objeto Document que representa al archivo xml 
    Document doc= readFile(filename); 
    //Se recupera el objeto Element principal del objeto Document 
    Element elemento=(Element)doc.getDocumentElement(); 
    
    //Hashtable thEstaciones = new Hashtable();
    
    ArrayList listaParticipantes;
    listaParticipantes = new ArrayList();
     
    // Crea un NodeList con un partipante en cada nodo
    NodeList lista = elemento.getElementsByTagName("Estacion");
    int matriz[][] = new int[lista.getLength()][lista.getLength()];
    for (int i = 0; i<lista.getLength();i++){
        elemento = (Element) lista.item(i);
        NodeList nombre = elemento.getElementsByTagName("Nombre");
        Element elementoNombre = (Element) nombre.item(0);     
        thEstaciones.put(elementoNombre.getTextContent(),i);
        thCodigos.put(i,elementoNombre.getTextContent());
    }
    for (int i = 0; i<lista.getLength();i++){        
        elemento = (Element) lista.item(i);
        NodeList elconexiones = elemento.getElementsByTagName("Conexiones");
        
        Element conexiones = (Element) elconexiones.item(0);
        NodeList conexion = elemento.getElementsByTagName("Conexion");
        for (int j=0;j<conexion.getLength();j++){
            elemento = (Element) conexion.item(j);
        
            NodeList nombre = elemento.getElementsByTagName("Nombre");
            Element elementoNombre = (Element) nombre.item(0);

            NodeList distancia = elemento.getElementsByTagName("Distancia");
            Element elementoDistancia = (Element) distancia.item(0);            
           
            String distString = elementoDistancia.getTextContent();
            Integer distInt = new Integer(Integer.parseInt(distString));

            matriz[i][(Integer)thEstaciones.get(elementoNombre.getTextContent())] = distInt;
            
        }
    }    

    return matriz;   
    }
    
/*El método escribir almacena en un archivo XML el resultado del procesamiento tomando como 
parámetros de entrada los datos almacenados de la lectura, la tabla con los resultados y el directorio 
donde desea almacenar el archivo XML.*/    
public void escribir(ArrayList datos, int [ ][ ] tabla, String archivo) { 

}     
}
