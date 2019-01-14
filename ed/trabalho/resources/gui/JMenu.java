/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources.gui;

import ed.trabalho.adt.ReverseNetwork;
import ed.trabalho.helpers.JSON;
import ed.trabalho.helpers.Viewer;
import ed.trabalho.json.Pessoa;
import ed.trabalho.model.Person;
import estg.ed.exceptions.ElementNotFoundException;
import estg.ed.exceptions.VertexIsNotAccessibleException;
import estg.ed.interfaces.NetworkADT;
import estg.ed.interfaces.OrderedListADT;
import estg.ed.list.OrderedArrayList;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author igu
 */
public class JMenu extends javax.swing.JFrame {

  private Pessoa[] json;
  
  private NetworkADT<Person> network;
  
  private OrderedListADT<Person> peopleList;
  
  /**
   * Creates new form JMenu
   */
  public JMenu() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    fileChooser = new javax.swing.JFileChooser();
    jScrollPane1 = new javax.swing.JScrollPane();
    testTextarea = new javax.swing.JTextArea();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    openJson = new javax.swing.JMenuItem();
    testJson = new javax.swing.JMenuItem();
    Exit = new javax.swing.JMenuItem();
    viewMenu = new javax.swing.JMenu();
    viewNetwork = new javax.swing.JMenuItem();

    fileChooser.setDialogTitle("Choose a File");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Menu");

    testTextarea.setColumns(20);
    testTextarea.setRows(5);
    jScrollPane1.setViewportView(testTextarea);

    jMenu1.setText("File");

    openJson.setText("Open JSON");
    openJson.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        openJsonActionPerformed(evt);
      }
    });
    jMenu1.add(openJson);

    testJson.setText("Test JSON");
    testJson.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        testJsonActionPerformed(evt);
      }
    });
    jMenu1.add(testJson);

    Exit.setText("Exit");
    Exit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ExitActionPerformed(evt);
      }
    });
    jMenu1.add(Exit);

    jMenuBar1.add(jMenu1);

    viewMenu.setText("View");

    viewNetwork.setText(" Network");
    viewNetwork.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        viewNetworkActionPerformed(evt);
      }
    });
    viewMenu.add(viewNetwork);

    jMenuBar1.add(viewMenu);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1685, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void openJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openJsonActionPerformed
    int returnVal = fileChooser.showOpenDialog(this);
    if(returnVal == JFileChooser.APPROVE_OPTION){
      File file = fileChooser.getSelectedFile();
      try {
        //Parse JSON and store
        this.json = JSON.readJson(file.getAbsolutePath());
        
        //Starts App Base
        this.bootApp();
      }
      catch(IOException ex){
        System.out.println("Problem acessing file" + file.getAbsolutePath());
      }
      catch(Exception e){
        testTextarea.setText("Error loading file. Is it a valid JSON?");
        throw e;
      }
    }
    else{
      System.out.println("File access cancelled by user.");
    }
  }//GEN-LAST:event_openJsonActionPerformed

  private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
    System.exit(0);
  }//GEN-LAST:event_ExitActionPerformed

  private void testJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testJsonActionPerformed
    try {
      testTextarea.setText(JSON.testNetwork(this.network, this.peopleList));
    } catch (ElementNotFoundException | VertexIsNotAccessibleException ex) {
      testTextarea.setText("Error testing JSON.");
    }
  }//GEN-LAST:event_testJsonActionPerformed

  private void viewNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewNetworkActionPerformed
    try{
      //Generate view
      Viewer.create(this.network);

      testTextarea.setText("Successfully created network view!");
    }
    catch(Exception e){
      testTextarea.setText("Error creating Network View!");
      throw e;
    }
  }//GEN-LAST:event_viewNetworkActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(JMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(JMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(JMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(JMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new JMenu().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuItem Exit;
  private javax.swing.JFileChooser fileChooser;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JMenuItem openJson;
  private javax.swing.JMenuItem testJson;
  private javax.swing.JTextArea testTextarea;
  private javax.swing.JMenu viewMenu;
  private javax.swing.JMenuItem viewNetwork;
  // End of variables declaration//GEN-END:variables

  public void bootApp(){
    //Generates Empty Directional Network
    //It is reverse, so more weight is the best cost
    this.network = new ReverseNetwork<>();
    
    //Add pool of people to an ordered list (to get relations after)
    this.peopleList = new OrderedArrayList<>();
    
    //Populate data
    JSON.populateData(this.json, this.network, this.peopleList);
    
    //Show ok
    testTextarea.setText("Successfully imported JSON file and populated Network!");
  }
}