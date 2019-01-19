/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho;

import ed.trabalho.resources.menu.JMenu;
import javax.swing.JFrame;

/**
 * Social Graph main entrypoint.
 * @author igu
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    /**
     * Starts menu using Swing
     */
    JFrame menu = new JMenu();
    menu.setVisible(true);
  }
}
