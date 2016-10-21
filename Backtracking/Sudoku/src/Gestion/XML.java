/*
 * XML.java
 *
 * Created on 9 de mayo de 2007, 22:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Gestion;

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
 
public class XML { 
    
public XML()
{
    
}
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
    public ArrayList leer(String filename) { 
    //Se obtiene el objeto Document que representa al archivo xml 
    Document doc= readFile(filename); 
    //Se recupera el objeto Element principal del objeto Document 
    Element elemento=(Element)doc.getDocumentElement(); 
     
    ArrayList sudoku = new ArrayList();
    
    // Crea un NodeList con un partipante en cada nodo
    NodeList nombre = elemento.getElementsByTagName("nombre");
    Element elementoNombre = (Element) nombre.item(0); 
    //Nombre = elementoNombre.getTextContent();
    sudoku.add(elementoNombre.getTextContent());
    
    NodeList identificador = elemento.getElementsByTagName("identificador");
    Element elementoIdentificador = (Element) identificador.item(0); 
    //Identificador = elementoIdentificador.getTextContent();
    sudoku.add(elementoIdentificador.getTextContent());
    
    NodeList filas = elemento.getElementsByTagName("Fila");
    
    int matriz[][] = new int[9][9];
    
    for (int i = 0; i<9;i++){
        Element elementoFila = (Element) filas.item(i);
        NodeList columnas = elementoFila.getElementsByTagName("columna");
        
        for(int j=0;j<9;j++){
            Element elementoColumna = (Element) columnas.item(j);
            
            String numString = elementoColumna.getTextContent().trim();
            int num = Integer.valueOf(numString);
            matriz[i][j] = num;
        }
    }
    sudoku.add(matriz);
    return sudoku;   
    }
    
/*El método escribir almacena en un archivo XML el resultado del procesamiento tomando como 
parámetros de entrada los datos almacenados de la lectura, la tabla con los resultados y el directorio 
donde desea almacenar el archivo XML.*/    
public void escribir(ArrayList sudoku, String archivo) { 
    Document document=null; 
    try { 
         /*Creación del documento*/ 
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
         DocumentBuilder builder = factory.newDocumentBuilder(); 
         document = builder.newDocument();  
         /*Creación del elemento ráiz*/ 
         Element root = (Element) document.createElement("sudoku");  
         root.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance"); 
         root.setAttribute("xsi:noNamespaceSchemaLocation","Esquema.xsd"); 
         document.appendChild (root); 
         
         Element nombre = (Element) document.createElement("nombre"); 
         nombre.setTextContent((String) sudoku.get(0));
         
         Element identificador = (Element) document.createElement("identificador"); 
         identificador.setTextContent((String) sudoku.get(1));
         
         root.appendChild(nombre);
         root.appendChild(identificador);         
         
         
         int matriz[][] = new int[9][9];
         matriz = (int[][]) sudoku.get(2);
         
         for (int i=0; i<9;i++){
             //Para cada participante se crea un elemento hijo de tipo participante 
             Element fila = (Element) document.createElement("Fila"); 
             
             for(int j=0; j<9; j++){
                Element columna = (Element) document.createElement("columna");
                Integer val = matriz[i][j];
                columna.setTextContent(val.toString());
                
                fila.appendChild(columna);
             }

             root.appendChild(fila);

         }
         //Finalizado el archivo XML se almacena físicamente 
        writeFile(document, archivo); 
        } catch (java.lang.Exception e) { 
            System.out.println(e); 
        }   
}     
}