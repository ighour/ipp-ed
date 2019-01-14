/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.helpers;

import com.google.common.base.Function;
import ed.trabalho.adt.ReverseNetwork;
import ed.trabalho.model.Person;
import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import estg.ed.interfaces.DynamicArrayContract;
import estg.ed.interfaces.NetworkADT;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author igu
 */
public abstract class Viewer {
  public static void create(NetworkADT<Person> original){
    //Get accessible network
    ReverseNetwork<Person> source = (ReverseNetwork<Person>) original;

    //Get matrix
    DynamicArrayContract<DynamicArrayContract<Double>> matrix = source.adjacencyMatrix();
    
    //Get vertices
    DynamicArrayContract<Person> vertices = source.vertices();
    
    //Generate GraphVIEW
    DirectedGraph<Person, ViewNode> view = new DirectedSparseMultigraph<>();
    
    //Get count of vertices
    int size = vertices.size();
    
    //Add vertices
    for(int i = 0; i < size; i++){
      view.addVertex(vertices.get(i));
    }
    
    //Add edges
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        //Has edge
        if(matrix.get(i).get(j) != Double.POSITIVE_INFINITY){
          //Generate link
          ViewNode link = new ViewNode(matrix.get(i).get(j));
          view.addEdge(link, vertices.get(i), vertices.get(j));
        }
      }
    }
    
    //Generate Layout
    Layout<Person, ViewNode> layout = new KKLayout (view);
    layout.setSize(new Dimension(800,800)); // sets the initial size of the space
    
    //Generate Visualization Server
    BasicVisualizationServer<Person,ViewNode> vv = new BasicVisualizationServer<>(layout);
    vv.setPreferredSize(new Dimension(850,850)); //Sets the viewing area size
    
    //Set labels
    vv.getRenderContext().setVertexLabelTransformer((Function<Person, String>) i -> {return i.toString();});
    vv.getRenderContext().setEdgeLabelTransformer((Function<ViewNode, String>) i -> {return i.toString();});
    
    JOptionPane.showMessageDialog(null, vv);
  }
}
