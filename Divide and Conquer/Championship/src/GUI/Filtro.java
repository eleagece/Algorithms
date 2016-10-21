package GUI;
import java.io.File;
import javax.swing.filechooser.FileFilter;
public class Filtro extends FileFilter
 {
 public boolean accept(File f)
  {
  // Devuelve true cuando el archivo acaba en .zip o es directorio
  return f.getName().toLowerCase().endsWith(".zip") || f.isDirectory();
  }
 public String getDescription()
  {
  return "Ficheros zip de competición" ;
  }
 }