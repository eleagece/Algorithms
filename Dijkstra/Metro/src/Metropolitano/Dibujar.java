/*
 * Main.java
 *
 * Created on 9 de abril de 2007, 13:22
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

public class Dibujar {

	public  Dibujar() {

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
		DefaultGraphCell[] cells = new DefaultGraphCell[3];

		// Create Hello Vertex
		cells[0] = createVertex("Canillas", 20, 20, 40, 20, 
					null, false);

		// Create World Vertex
		cells[1] = createVertex("Esperanza", 140, 140, 40, 20, 
					Color.ORANGE, true);

		// Create Edge
		DefaultEdge edge = new DefaultEdge();
		// Fetch the ports from the new vertices, 
		// and connect them with the edge
		edge.setSource(cells[0].getChildAt(0));
		edge.setTarget(cells[1].getChildAt(0));
		cells[2] = edge;

		// Set Arrow Style for edge
		int arrow = GraphConstants.ARROW_CLASSIC;
		GraphConstants.setLineEnd(edge.getAttributes(), arrow);
		GraphConstants.setEndFill(edge.getAttributes(), true);

		// Insert the cells via the cache, so they get selected
		graph.getGraphLayoutCache().insert(cells);

		// Show in Frame
		JFrame frame = new JFrame();
		frame.getContentPane().add(new JScrollPane(graph));
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public  DefaultGraphCell createVertex(String name, double x,
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