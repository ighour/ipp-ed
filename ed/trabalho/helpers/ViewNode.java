/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.helpers;

/**
 *
 * @author igu
 */
public class ViewNode {
    public double weight;
    
    public ViewNode(double weight){
      this.weight = weight;
    }
    
    public String toString(){
      return String.valueOf((int)this.weight);
    }
}
