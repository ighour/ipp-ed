/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.helpers;

import com.google.common.base.Function;
import ed.trabalho.adt.SocialNetwork;
import ed.trabalho.model.Person;
import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import estg.ed.interfaces.DynamicArrayContract;
import estg.ed.interfaces.NetworkADT;
import java.awt.Dimension;
import javax.swing.JFrame;

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
  private VisualizationViewer<Person,ViewNode> vv;
  
  /**
   * Create a view of input network.
   * @param originalNetwork 
   */
  public void create(NetworkADT<Person> originalNetwork){
    //Convert accessible network
    SocialNetwork<Person> source = (SocialNetwork<Person>) originalNetwork;

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
          ViewNode link = new ViewNode(matrix.get(i).get(j), vertices.get(j).getVisualizations());
          this.viewGraph.addEdge(link, vertices.get(i), vertices.get(j));
        }
    
    //Generate Layout
    Layout<Person, ViewNode> layout = new KKLayout(this.viewGraph);
    layout.setSize(new Dimension(800,800)); // sets the initial size of the space
    
    //Generate Visualization Server
    this.vv = new VisualizationViewer<>(layout);
    this.vv.setPreferredSize(new Dimension(850,850)); //Sets the viewing area size
    
    //Set labels
    this.vv.getRenderContext().setVertexLabelTransformer((Function<Person, String>) i -> {return i.toString();});
    this.vv.getRenderContext().setEdgeLabelTransformer((Function<ViewNode, String>) i -> {return i.toString();});
  
    //Add graph mouse
    DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
    gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
    this.vv.setGraphMouse(gm);
  }
  
  /**
   * Show the view on a new JFrame.
   */
  public void showFrame(){
    JFrame frame = new JFrame("Graph Viewer");
    frame.getContentPane().add(vv);
    frame.pack();
    frame.setVisible(true); 
  }
  
  /**
   * View Node to store edge info.
   */
  class ViewNode {
    public double weight;
    public int visualizations;
    
    public ViewNode(double weight, int visualizations){
      this.weight = weight;
      this.visualizations = visualizations;
    }
    
    @Override
    public String toString(){
      return "1 / " + this.visualizations;
    }
  }
}
