/*
 * Dibuja.java
 *
 * Created on 20 de abril de 2007, 19:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Metropolitano;

import java.awt.Color; 
import java.awt.geom.Rectangle2D; 
 
import javax.swing.BorderFactory; 
import javax.swing.JFrame; 
import javax.swing.JScrollPane; 
 
import org.jgraph.JGraph; 
import org.jgraph.graph.DefaultEdge; 
import org.jgraph.graph.DefaultGraphCell; 
import org.jgraph.graph.DefaultGraphModel; 
import org.jgraph.graph.DefaultPort; 
import org.jgraph.graph.GraphConstants; 
import org.jgraph.graph.GraphModel; 
import java.util.Hashtable;

public class Dibuja { 
 
 public Dibuja(int matriz[][], Hashtable th) { 
 
  // Construct Model and Graph 
  GraphModel model = new DefaultGraphModel(); 
  JGraph graph = new JGraph(model); 
 
  // Control-drag should clone selection 
  graph.setCloneable(false); 
 
  // Enable edit without final RETURN keystroke 
  graph.setInvokesStopCellEditing(false); 
 
  // When over a cell, jump to its default port (we only  
  // have one, anyway) 
  graph.setJumpToDefaultPort(true); 
 
  // Insert all three cells in one call, so we need an  
  // array to store them 
  DefaultGraphCell[] cells = new DefaultGraphCell[matriz.length]; 

  for (int i = 0; i<matriz.length / 2;i++){
      String eti = (String)th.get(i);
      cells[i] = createVertex(eti, 100, 80*i, 200, 20, null, false);
  }
  
  int j = 0;
  for (int i = (matriz.length / 2); i < matriz.length;i++){
      String eti = (String)th.get(i);
      cells[i] = createVertex(eti, 500, 80*j, 200, 20, null, false);      
      j++;
  }

        graph.getGraphLayoutCache().insert(cells); 
  for (int i=0;i<matriz.length;i++){
      for (int k=i+1;k<matriz.length;k++){
          int pt = matriz[i][k];
          if(pt != 0){
                  // Create Edge 
                  DefaultEdge edge = new DefaultEdge(); 
                  // Fetch the ports from the new vertices,  
                  // and connect them with the edge 
                  edge.setSource(cells[i].getChildAt(0)); 
                  edge.setTarget(cells[k].getChildAt(0)); 
                  
                  DefaultGraphCell celda = new DefaultGraphCell(); 
                  
                  GraphConstants.setLineStyle(edge.getAttributes(),GraphConstants.STYLE_BEZIER);
                  GraphConstants.setRouting(edge.getAttributes(),GraphConstants.ROUTING_SIMPLE);                  
                  
                  celda = edge;

                  graph.getGraphLayoutCache().insert(celda); 
          }
      }
  }
 
  // Show in Frame 
  JFrame frame = new JFrame(); 
  frame.getContentPane().add(new JScrollPane(graph)); 
  //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  frame.pack(); 
  frame.setVisible(true); 
 } 
 
 public static DefaultGraphCell createVertex(String name, double x, 
  double y, double w, double h, Color bg, boolean raised) { 
 
  // Create vertex with the given name 
  DefaultGraphCell cell = new DefaultGraphCell(name); 
 
  // Set bounds 
  GraphConstants.setBounds(cell.getAttributes(), 
    new Rectangle2D.Double(x, y, w, h)); 
 
  // Set fill color 
  if (bg != null) { 
   GraphConstants.setGradientColor( 
    cell.getAttributes(), Color.orange); 
   GraphConstants.setOpaque( 
    cell.getAttributes(), true); 
  } 
 
  // Set raised border 
  if (raised) 
   GraphConstants.setBorder( 
    cell.getAttributes(),  
    BorderFactory.createRaisedBevelBorder()); 
  else 
   // Set black border 
   GraphConstants.setBorderColor( 
    cell.getAttributes(), Color.black); 
   // Add a Port 
  DefaultPort port = new DefaultPort(); 
  cell.add(port); 
  port.setParent(cell); 
 
  return cell; 
 } 
 
}  