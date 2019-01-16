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
 * Creates a view of the network.
 * Using Jung dependency.
 * @author igu
 */
public class Viewer {
  /**
   * Jung graph to receive vertices and edges.
   */
  private DirectedGraph<Person, ViewNode> viewGraph;
  
  /**
   * Jung virtualization server to expose graphic.
   */
  private BasicVisualizationServer<Person,ViewNode> vv;
  
  /**
   * Create a view of input network.
   * @param originalNetwork 
   */
  public void create(NetworkADT<Person> originalNetwork){
    //Convert accessible network
    ReverseNetwork<Person> source = (ReverseNetwork<Person>) originalNetwork;

    //Get matrix
    DynamicArrayContract<DynamicArrayContract<Double>> matrix = source.adjacencyMatrix();
    
    //Get vertices
    DynamicArrayContract<Person> vertices = source.vertices();
    
    //Generate view
    this.viewGraph = new DirectedSparseMultigraph<>();
    
    //Get count of vertices
    int size = vertices.size();
    
    //Add vertices to view
    for(int i = 0; i < size; i++)
      this.viewGraph.addVertex(vertices.get(i));
    
    //Add edges to view
    for(int i = 0; i < size; i++)
      for(int j = 0; j < size; j++)
        //Has edge
        if(matrix.get(i).get(j) != Double.POSITIVE_INFINITY){
          //Generate link
          ViewNode link = new ViewNode(matrix.get(i).get(j));
          this.viewGraph.addEdge(link, vertices.get(i), vertices.get(j));
        }
    
    //Generate Layout
    Layout<Person, ViewNode> layout = new KKLayout(this.viewGraph);
    layout.setSize(new Dimension(800,800)); // sets the initial size of the space
    
    //Generate Visualization Server
    this.vv = new BasicVisualizationServer<>(layout);
    this.vv.setPreferredSize(new Dimension(850,850)); //Sets the viewing area size
    
    //Set labels
    this.vv.getRenderContext().setVertexLabelTransformer((Function<Person, String>) i -> {return i.toString();});
    this.vv.getRenderContext().setEdgeLabelTransformer((Function<ViewNode, String>) i -> {return i.toString();});
  }
  
  /**
   * Show the view as a JOptionPane message dialog.
   */
  public void showMessageDialog(){
    JOptionPane.showMessageDialog(null, this.vv);
  }
}
