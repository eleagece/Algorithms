package XML;
import java.io.*; 
import java.util.ArrayList;
import javax.xml.parsers.*; 
import javax.xml.transform.*; 
import javax.xml.transform.dom.*; 
import javax.xml.transform.stream.*; 
import org.w3c.dom.*; 
 
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
    public ArrayList leer(String filename) 
     { 
     //Se obtiene el objeto Document que representa al archivo xml 
    Document doc= readFile(filename); 
    //Se recupera el objeto Element principal del objeto Document 
    Element elemento=(Element)doc.getDocumentElement(); 
    
    ArrayList listaParticipantes;
    listaParticipantes = new ArrayList();
     
    // Crea un NodeList con un partipante en cada nodo
    NodeList lista = elemento.getElementsByTagName("Participante");

    for (int i = 0; i<lista.getLength();i++){
        String participante[];
        participante = new String [4];
        elemento = (Element) lista.item(i);
        
        // Recuperamos el nombre
        NodeList nombre = elemento.getElementsByTagName("Nombre");
        Element elementoNombre = (Element) nombre.item(0);
        participante[0] = elementoNombre.getTextContent();
        
        // Recuperamos el apellido1
        NodeList apellido1 = elemento.getElementsByTagName("Apellido1");
        Element elementoApellido1 = (Element) apellido1.item(0);
        participante[1] = elementoApellido1.getTextContent();   
        
        // Recuperamos el apellido2
        NodeList apellido2 = elemento.getElementsByTagName("Apellido2");
        Element elementoApellido2 = (Element) apellido2.item(0);
        participante[2] = elementoApellido2.getTextContent();   
        
        // Recuperamos el dni
        NodeList dni = elemento.getElementsByTagName("dni");
        Element elementoDni = (Element) dni.item(0);
        participante[3] = elementoDni.getTextContent();          
        
        listaParticipantes.add(participante);
    }

    return listaParticipantes;
    
    }
    
/*El método escribir almacena en un archivo XML el resultado del procesamiento tomando como 
parámetros de entrada los datos almacenados de la lectura, la tabla con los resultados y el directorio 
donde desea almacenar el archivo XML.*/    
public void escribir(ArrayList datos, int [ ][ ] tabla, String archivo) { 
    Document document=null; 
    try { 
         /*Creación del documento*/ 
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
         DocumentBuilder builder = factory.newDocumentBuilder(); 
         document = builder.newDocument();  
         /*Creación del elemento ráiz*/ 
         Element root = (Element) document.createElement("Resultados");  
         root.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance"); 
         root.setAttribute("xsi:noNamespaceSchemaLocation","Esquema2.xsd"); 
         document.appendChild (root); 
         
         for (int i=0; i<datos.size();i++){
             String [] datosParticipante = new String [4];
             datosParticipante = (String[]) datos.get(i);
             
             //Para cada participante se crea un elemento hijo de tipo participante 
             Element participante = (Element) document.createElement("Participante"); 
             //Rellenar el participante de acuerdo a la estructura dada y con los datos que se han obtenido 
             Element nombre = (Element) document.createElement("Nombre");
             nombre.setTextContent(datosParticipante[0]);
             Element apellido1 = (Element) document.createElement("Apellido1");
             apellido1.setTextContent(datosParticipante[1]);
             Element apellido2 = (Element) document.createElement("Apellido2");
             apellido2.setTextContent(datosParticipante[2]);              
             Element dni = (Element) document.createElement("Dni");
             dni.setTextContent(datosParticipante[3]);              

             Element enfrentamientos = (Element) document.createElement("Enfrentamientos");
             for (int j=0;j<tabla[0].length;j++){

                 if(tabla[i][j] - 1 != tabla[0].length){
                    Element oponente = (Element) document.createElement("Oponente");                     
                    String [] Oponente = new String [4];
                    Element dniEnfrentamientos = (Element) document.createElement("Dni");                    
                    Oponente = (String[]) datos.get(tabla[i][j] - 1);
                    dniEnfrentamientos.setTextContent(Oponente[3]);                     
                     Element diaEnfrentamientos = (Element) document.createElement("Dia");
                     diaEnfrentamientos.setTextContent(Integer.toString(j+1));

                     oponente.appendChild(dniEnfrentamientos);
                     oponente.appendChild(diaEnfrentamientos);

                     enfrentamientos.appendChild(oponente);
                 }
                 

             }
             
             participante.appendChild(nombre);
             participante.appendChild(apellido1);
             participante.appendChild(apellido2);
             participante.appendChild(dni);
             participante.appendChild(enfrentamientos);

             root.appendChild (participante);
         }
         //Finalizado el archivo XML se almacena físicamente 
        writeFile(document, archivo); 
        } catch (java.lang.Exception e) { 
            System.out.println(e); 
        }   
}     
}