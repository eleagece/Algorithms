package IO;
import java.io.File;
import java.io.*;
import java.util.zip.*;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.ArrayList;
import java.util.Iterator;
public class Zip
 {
 private static final int BUFFER_SIZE=1024;  // tamaño del buffer
 public ArrayList unzip(String carpetaDestino,String ficheroZIP)
  {
  // ---------------------------------------------------------------------------------//
  // MÉTODO que descomprime el archivo zip de la ruta 'ficheroZIP' en la carpeta      //
  // 'carpetaDestino'. Deja en un 'ArrayList' los nombres de todos los ficheros des-  //
  // comprimidos.                                                                     //
  // ---------------------------------------------------------------------------------//
  // *param* carpetaDestino: Carpeta en la que se descomprimirá el archivo (destino)  //
  // *param* ficheroZIP: Ruta del fichero ZIP a descomprimir                          //
  // *return* ArrayList: Guarda los nombres de los ficheros descomprimidos            //
  // ---------------------------------------------------------------------------------//
  try 
   {
   //-- ArrayList de ficheros descomprimidos, vacío en principio
   ArrayList arrayFicherosDescomp=new ArrayList();
   //-- Flujo de entrada de archivos zip con buffer
   ZipInputStream zis=new ZipInputStream(new BufferedInputStream(new FileInputStream(ficheroZIP)));
   int count;
   byte data[]=new byte[BUFFER_SIZE];
   ZipEntry entrada=zis.getNextEntry();
   while (entrada!=null)  // Mientras existan 'entries' en el flujo de entrada 'zis'...
    {
    if(!entrada.isDirectory())  // Si no son directorios (son archivos)...
     {
     String nombreDeEntrada=entrada.getName();  // ...Sacamos el nombre del archivo (hlocal/txt.txt || txt.txt)  
     int indice=nombreDeEntrada.lastIndexOf('/');  // Devuelve la posición del último '/' empezando por 0 (6 || -1)  
     if (indice>=0)  // Si lastIndexOf devuelve >=0 es debido a que el archivo está dentro de algún directorio.
      {              // Si no devolvería -1 y se saltaría este if que simplemente sirve para crear las carpetas de esa ruta.
      String rutaOrigen=nombreDeEntrada.substring(0,indice);  // Saca el nombre de la ruta (hlocal/) 
      String rutaDestino=carpetaDestino+File.separator+rutaOrigen;  // Nombre de la carpeta destino (destino/hlocal/)  
      File directorioDestino=new File(rutaDestino);  // Hacemos que directorioDestino indique un directorio que aún no existe (destino/hlocal/)
      boolean dir=directorioDestino.mkdirs();  // Creamos el direcotrio con mkdirs() por si en la ruta hay varios directorios
      }                                        // Si sólo hubiera uno sería con mkdir()
     String archivoDestino=carpetaDestino+File.separator+nombreDeEntrada;  // (destino/hlocal/txt.txt || destino/txt.txt)
     arrayFicherosDescomp.add(archivoDestino);  // Guardamos la ruta (destino/hlocal/txt.txt || destino/txt.txt) al final del ArrayList
     //-- Flujo de salida con buffer de tamaño BUFFER_SIZE 
     BufferedOutputStream dest=new BufferedOutputStream(new FileOutputStream(archivoDestino),BUFFER_SIZE);
     //-- Trasvasamos los datos a la nueva ubicación
     count=zis.read(data,0,BUFFER_SIZE);  // Sacamos los datos del zip de origen
     while (count!=-1) // Si count!=-1 seguimos sacando datos del flujo de entrada de archivos zip con buffer
      {                // para meterlos en el flujo de salida con buffer
      dest.write(data,0,count);  // Guardamos los datos en el archivo descomprimido
      count=zis.read(data,0,BUFFER_SIZE);  // Seguimos sacando del archivo o 'entry' actual
      }  // Si count==-1 es que se ha acabado esta 'entry' o archivo con lo cual nos salimos del while para ir a la siguiente
     dest.flush();
     dest.close();  // Cerramos el flujo de salida
     }  // fin del if de comprobar si es directorio
    //zis.closeEntry();  ¿¿NO DEBERÍAMOS CERRAR UNA ENTRADA ANTES DE ABRIR OTRA??
    entrada=zis.getNextEntry();
    }  // salimos del while porque no hay más 'entries'
   zis.close();  // Cerramos el flujo de entrada de archivos zip con buffer, porque ya no hay más 'entries'
   return arrayFicherosDescomp;  // Devuelve la lista de ficheros descomprimidos
   }  // try
  catch(Exception e)
   {
   e.printStackTrace();
   return null;
   }  // catch
  }
 public File creacarpeta(String ruta)
  {
  // ---------------------------------------------------------------------------------//
  // MÉTODO que crea una carpeta según la ruta dada y la devuelve en File             //
  // ---------------------------------------------------------------------------------//
  // *param* ruta: Ruta dada (hlocal/practica1/ejemplo/)                              //
  // *return* File: Devuelve el objeto carpeta en sí                                  //
  // ---------------------------------------------------------------------------------//
  File directorio=new File(ruta);  // Hacemos que carpeta indique un directorio que aún no existe (destino/hlocal/)
  boolean dir=directorio.mkdirs();  // Creamos el direcotrio con mkdirs() por si en la ruta hay varios directorios
  return directorio;  // Devolvemos la ruta
  }
 public String[] listaarchivos(String rutaComprimidos) 
  {
  // ---------------------------------------------------------------------------------//
  // MÉTODO que dado un directorio recupera todos los nombres de los archivos .zip    //
  // de un directorio, devolviéndolos en un array de Strings                          //
  // ---------------------------------------------------------------------------------// 
  // *param* rutaComprimidos: Ruta donde se encuentran los archivos zip de los cuales //
  //   vamos a sacar una lista con sus rutas                                          //
  // *return* String[]: Array de Strings con las rutas de todos los archivos zip      //
  // ---------------------------------------------------------------------------------//
  ExtensionFilter filtroZIP=new ExtensionFilter("zip");  // Creamos un filtro de archivos zip
  File directorioComprimidos=new File(rutaComprimidos);  // Hacemos que 'directorioComprimidos' indique el directorio de la ruta 'rutaComprimidos' 
  return directorioComprimidos.list(filtroZIP);
  }
 public void descomprime(String[] lista,File directorioComprimidos,String rutaDestino) 
  {
  // ---------------------------------------------------------------------------------//
  // MÉTODO que dado una lista de archivos zip (lista) y un directorio donde se en-   //
  // cuentra la lista (directorio) saca todos los archivos en una misma ruta (ruta)   //
  // ---------------------------------------------------------------------------------// 
  // *param* String[]: Array con los nombres de los archivos zip a descomprimir       //
  // *param* directorioComprimidos: Directorio que contiene los archivos zip a des-   //
  //   comprimir                                                                      //
  // *param* rutaDestino: Ruta donde vamos a dejar las carpetas correspondientes a    //
  //   cada archivo zip, que a su vez contendran los archivos descomprimidos xml      //
  // ---------------------------------------------------------------------------------//
  for (int i=0; i<lista.length; i++)  // Recorremos toda la lista
   {
   String archivoActual=lista[i];  // Sacamos nombre del archivo zip i de todos los que hay (zip.zip)
   String rutaDestinoArchivo=rutaDestino+File.separator+archivoActual.substring(0,archivoActual.length()-4);
   String rutaOrigenArchivo=directorioComprimidos.getPath();
   creacarpeta(rutaDestinoArchivo);  // Creamos carpeta destino (destino/zip/)
   unzip(rutaDestinoArchivo,rutaOrigenArchivo+File.separator+archivoActual);  // Cada archivo en su carpeta destino/zipA/xmlA
   }
  }   
 }