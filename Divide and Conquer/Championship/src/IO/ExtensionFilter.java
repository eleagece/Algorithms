package IO;
import java.io.*;
public class ExtensionFilter implements FilenameFilter 
 {
 public ExtensionFilter(String ext)
  {
  // ---------------------------------------------------------------------------------//
  // CONSTRUCTOR del filtro de extensiones. Recibe un String con la extensión y lo    //
  // guarda en su atributo privado 'extension'.                                       //
  // ---------------------------------------------------------------------------------//
  // *param* ext: String que lleva la extensión del archivo a filtrar                 //
  // ---------------------------------------------------------------------------------//
  extension="."+ext;
  }
 public boolean accept(File dir, String name)
  {
  // ---------------------------------------------------------------------------------//
  // MÉTODO que devuelve true si un archivo termina con la extensión filtrada         //
  // ---------------------------------------------------------------------------------//
  // *param* dir: Directorio en el que se encuentra el archivo que queremos filtrar   //
  // *param* name: String que contiene un nombre                                      //
  // *return* boolean: devuelve true si el String 'name' acaba con el String          //
  // 'extension'                                                                      //
  // ---------------------------------------------------------------------------------//
  return name.endsWith(extension);
  }
 private String extension;
 }