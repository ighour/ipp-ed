/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources.menu;

import ed.trabalho.helpers.Data;
import ed.trabalho.helpers.Viewer;
import ed.trabalho.json.Pessoa;
import ed.trabalho.resources.Base;
import ed.trabalho.resources.form.intermediate.CompanyPeopleAndPersonContactsForm;
import ed.trabalho.resources.form.intermediate.FindPersonByEmailForm;
import ed.trabalho.resources.form.intermediate.FindPersonByIdForm;
import ed.trabalho.resources.form.intermediate.MentionContactMediaForm;
import ed.trabalho.resources.form.intermediate.NotReachableUsersByUserForm;
import ed.trabalho.resources.form.intermediate.PathPersonToPersonForm;
import ed.trabalho.resources.form.intermediate.ReachableUsersByUserForm;
import ed.trabalho.resources.form.intermediate.SkillsOrderedByCostForm;
import ed.trabalho.resources.form.intermediate.SpawningTreeOfUserForm;
import ed.trabalho.resources.form.model.PersonCreate;
import ed.trabalho.store.BaseStore;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 * Menu for application using Swing.
 * @author igu
 */
public class JMenu extends Base { 
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
    consoleTextArea = new javax.swing.JTextArea();
    jMenuBar1 = new javax.swing.JMenuBar();
    fileMenu = new javax.swing.JMenu();
    fileMenuOpenJson = new javax.swing.JMenuItem();
    fileMenuExit = new javax.swing.JMenuItem();
    graphMenu = new javax.swing.JMenu();
    graphMenuView = new javax.swing.JMenuItem();
    graphMenuIsComplete = new javax.swing.JMenuItem();
    graphMenuMinimalPathVertices = new javax.swing.JMenuItem();
    graphMenuRechableUsersByUser = new javax.swing.JMenuItem();
    graphMenuNotReachableUsersByUser = new javax.swing.JMenuItem();
    userMenu = new javax.swing.JMenu();
    userMenuAddUser = new javax.swing.JMenuItem();
    userMenuSearchById = new javax.swing.JMenuItem();
    userMenuSearchByEmail = new javax.swing.JMenuItem();
    userMenuCompareCompanyPeopleAndPersonContacts = new javax.swing.JMenuItem();
    userMenuSkillsOrderedByCost = new javax.swing.JMenuItem();
    extraMenu = new javax.swing.JMenu();
    extraMenuMentionContactMedia = new javax.swing.JMenuItem();
    extraMenuSpawningTreeUser = new javax.swing.JMenuItem();
    extraMenuWeightDefault = new javax.swing.JMenuItem();
    extraMenuWeightConstant = new javax.swing.JMenuItem();

    fileChooser.setDialogTitle("Choose a File");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Menu");

    consoleTextArea.setEditable(false);
    consoleTextArea.setColumns(20);
    consoleTextArea.setRows(5);
    jScrollPane1.setViewportView(consoleTextArea);

    fileMenu.setText("File");

    fileMenuOpenJson.setText("Open JSON");
    fileMenuOpenJson.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fileMenuOpenJsonActionPerformed(evt);
      }
    });
    fileMenu.add(fileMenuOpenJson);

    fileMenuExit.setText("Exit");
    fileMenuExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fileMenuExitActionPerformed(evt);
      }
    });
    fileMenu.add(fileMenuExit);

    jMenuBar1.add(fileMenu);

    graphMenu.setText("Graph");

    graphMenuView.setText("View");
    graphMenuView.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        graphMenuViewActionPerformed(evt);
      }
    });
    graphMenu.add(graphMenuView);

    graphMenuIsComplete.setText("Check if it is Complete");
    graphMenuIsComplete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        graphMenuIsCompleteActionPerformed(evt);
      }
    });
    graphMenu.add(graphMenuIsComplete);

    graphMenuMinimalPathVertices.setText("Calculate Best Path Between Users");
    graphMenuMinimalPathVertices.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        graphMenuMinimalPathVerticesActionPerformed(evt);
      }
    });
    graphMenu.add(graphMenuMinimalPathVertices);

    graphMenuRechableUsersByUser.setText("Reachable Users by Another User");
    graphMenuRechableUsersByUser.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        graphMenuRechableUsersByUserActionPerformed(evt);
      }
    });
    graphMenu.add(graphMenuRechableUsersByUser);

    graphMenuNotReachableUsersByUser.setText("Not Reachable Users by Another User");
    graphMenuNotReachableUsersByUser.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        graphMenuNotReachableUsersByUserActionPerformed(evt);
      }
    });
    graphMenu.add(graphMenuNotReachableUsersByUser);

    jMenuBar1.add(graphMenu);

    userMenu.setText(" Users");

    userMenuAddUser.setText("New User");
    userMenuAddUser.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        userMenuAddUserActionPerformed(evt);
      }
    });
    userMenu.add(userMenuAddUser);

    userMenuSearchById.setText("Find by ID");
    userMenuSearchById.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        userMenuSearchByIdActionPerformed(evt);
      }
    });
    userMenu.add(userMenuSearchById);

    userMenuSearchByEmail.setText("Find by Email");
    userMenuSearchByEmail.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        userMenuSearchByEmailActionPerformed(evt);
      }
    });
    userMenu.add(userMenuSearchByEmail);

    userMenuCompareCompanyPeopleAndPersonContacts.setText("Company People x Person Contacts");
    userMenuCompareCompanyPeopleAndPersonContacts.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        userMenuCompareCompanyPeopleAndPersonContactsActionPerformed(evt);
      }
    });
    userMenu.add(userMenuCompareCompanyPeopleAndPersonContacts);

    userMenuSkillsOrderedByCost.setText("Skills Ordered By Cost");
    userMenuSkillsOrderedByCost.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        userMenuSkillsOrderedByCostActionPerformed(evt);
      }
    });
    userMenu.add(userMenuSkillsOrderedByCost);

    jMenuBar1.add(userMenu);

    extraMenu.setText("Extra");

    extraMenuMentionContactMedia.setText("Mention/Contact Media (User x Total)");
    extraMenuMentionContactMedia.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        extraMenuMentionContactMediaActionPerformed(evt);
      }
    });
    extraMenu.add(extraMenuMentionContactMedia);

    extraMenuSpawningTreeUser.setText("Spawning Tree of an User");
    extraMenuSpawningTreeUser.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        extraMenuSpawningTreeUserActionPerformed(evt);
      }
    });
    extraMenu.add(extraMenuSpawningTreeUser);

    extraMenuWeightDefault.setText("Change Weights to 1/Visualizations");
    extraMenuWeightDefault.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        extraMenuWeightDefaultActionPerformed(evt);
      }
    });
    extraMenu.add(extraMenuWeightDefault);

    extraMenuWeightConstant.setText("Change Weights To 1");
    extraMenuWeightConstant.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        extraMenuWeightConstantActionPerformed(evt);
      }
    });
    extraMenu.add(extraMenuWeightConstant);

    jMenuBar1.add(extraMenu);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1799, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * Open file chooser to select JSON input.
   * Stores converted JSON info on json attribute.
   * Construct the network after converting JSON.
   * @param evt 
   */
  private void fileMenuOpenJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuOpenJsonActionPerformed
    int returnVal = fileChooser.showOpenDialog(this);
    
    //Selected a file
    if(returnVal == JFileChooser.APPROVE_OPTION){
      File file = fileChooser.getSelectedFile();
      
      Pessoa[] data;
      
      //Get JSON data converted into java classes
      try {
        data = Data.readJson(file.getAbsolutePath());
      }
      catch(IOException ex){
        this.message("Error opening file " + file.getAbsolutePath());
        return;
      }
      catch(Exception e){
        this.message("Error loading this file. Is it a valid JSON file?");
        return;
      }
         
      //Populate store with JSON data
      try {
        Data.populate(data, this.getStore());
        
      } catch (Exception ex) {
        this.message("Error constructing the graph with provided data.");
        return;
      }

      //Success
      if(BaseStore.getStoreType().equals("CONSTANT"))
        this.message("Successfully loaded JSON file and created Graph using weight: 1 (constant).");
      else
        this.message("Successfully loaded JSON file and created Graph using weight: 1/visualizations (of contact).");
    }
    //Cancelled file input
    else{
      consoleTextArea.setText("File load cancelled by user.");
    }
  }//GEN-LAST:event_fileMenuOpenJsonActionPerformed

  private void fileMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuExitActionPerformed
    System.exit(0);
  }//GEN-LAST:event_fileMenuExitActionPerformed

  private void graphMenuViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphMenuViewActionPerformed
    try{
      //Generate view
      Viewer viewer = new Viewer();
      viewer.create(this.getStore().getNetwork(), BaseStore.getStoreType());
      viewer.showFrame("Social Network");

      consoleTextArea.setText("Graph view successfully builded.");
    }
    catch(Exception e){
      this.message("Error creating graph view.");
    }
  }//GEN-LAST:event_graphMenuViewActionPerformed

  private void userMenuSearchByIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userMenuSearchByIdActionPerformed
    FindPersonByIdForm form = new FindPersonByIdForm();
    form.setTitle("Find by ID");
    form.pack();
    form.setVisible(true);
  }//GEN-LAST:event_userMenuSearchByIdActionPerformed

  private void userMenuSearchByEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userMenuSearchByEmailActionPerformed
    FindPersonByEmailForm form = new FindPersonByEmailForm();
    form.setTitle("Find by Email");
    form.pack();
    form.setVisible(true);
  }//GEN-LAST:event_userMenuSearchByEmailActionPerformed

  private void graphMenuIsCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphMenuIsCompleteActionPerformed
    if(this.getStore().getPeopleCount() == 0)
      this.message("Graph is empty (no vertices).");
    else if(this.getStore().graphIsComplete())
      this.message("Graph is complete (all vertices are connected with each other).");
    else
      this.message("Graph is not complete.");
  }//GEN-LAST:event_graphMenuIsCompleteActionPerformed

  private void graphMenuMinimalPathVerticesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphMenuMinimalPathVerticesActionPerformed
    PathPersonToPersonForm form = new PathPersonToPersonForm();
    form.setTitle("Best Path between Users.");
    form.pack();
    form.setVisible(true);
  }//GEN-LAST:event_graphMenuMinimalPathVerticesActionPerformed

  private void graphMenuRechableUsersByUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphMenuRechableUsersByUserActionPerformed
    ReachableUsersByUserForm form = new ReachableUsersByUserForm();
    form.setTitle("Reachable Users by User");
    form.pack();
    form.setVisible(true);
  }//GEN-LAST:event_graphMenuRechableUsersByUserActionPerformed

  private void graphMenuNotReachableUsersByUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphMenuNotReachableUsersByUserActionPerformed
    NotReachableUsersByUserForm form = new NotReachableUsersByUserForm();
    form.setTitle("Not Reachable Users by User");
    form.pack();
    form.setVisible(true);
  }//GEN-LAST:event_graphMenuNotReachableUsersByUserActionPerformed

  private void userMenuCompareCompanyPeopleAndPersonContactsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userMenuCompareCompanyPeopleAndPersonContactsActionPerformed
    CompanyPeopleAndPersonContactsForm form = new CompanyPeopleAndPersonContactsForm();
    form.setTitle("Company People Related to User Contacts");
    form.pack();
    form.setVisible(true);
  }//GEN-LAST:event_userMenuCompareCompanyPeopleAndPersonContactsActionPerformed

  private void userMenuSkillsOrderedByCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userMenuSkillsOrderedByCostActionPerformed
    SkillsOrderedByCostForm form = new SkillsOrderedByCostForm();
    form.setTitle("Users with Skill Ordered by Cost From user");
    form.pack();
    form.setVisible(true);
  }//GEN-LAST:event_userMenuSkillsOrderedByCostActionPerformed

  private void userMenuAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userMenuAddUserActionPerformed
      PersonCreate personView = new PersonCreate();
      personView.setTitle("New User");
      personView.setPerson();
      personView.pack();
      personView.setVisible(true);
  }//GEN-LAST:event_userMenuAddUserActionPerformed

  private void extraMenuSpawningTreeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extraMenuSpawningTreeUserActionPerformed
    SpawningTreeOfUserForm form = new SpawningTreeOfUserForm();
    form.setTitle("Spawning Tree of an User");
    form.pack();
    form.setVisible(true);
  }//GEN-LAST:event_extraMenuSpawningTreeUserActionPerformed

  private void extraMenuMentionContactMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extraMenuMentionContactMediaActionPerformed
    MentionContactMediaForm form = new MentionContactMediaForm();
    form.setTitle("Mention Media Comparative");
    form.pack();
    form.setVisible(true);
  }//GEN-LAST:event_extraMenuMentionContactMediaActionPerformed

  private void extraMenuWeightConstantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extraMenuWeightConstantActionPerformed
    if(BaseStore.getStoreType().equals("CONSTANT")){
      this.message("Graph is already of that type.");
    }
    else{
      BaseStore.setStoreTypeConstant();
      this.message("Graph weight type has changed to constant (1).");
    }
  }//GEN-LAST:event_extraMenuWeightConstantActionPerformed

  private void extraMenuWeightDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extraMenuWeightDefaultActionPerformed
    if(BaseStore.getStoreType().equals("DEFAULT")){
      this.message("Graph is already of that type.");
    }
    else{
      BaseStore.setStoreTypeDefault();
      this.message("Graph weight type has changed to default (1/visualizations).");
    }
  }//GEN-LAST:event_extraMenuWeightDefaultActionPerformed

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
  private javax.swing.JTextArea consoleTextArea;
  private javax.swing.JMenu extraMenu;
  private javax.swing.JMenuItem extraMenuMentionContactMedia;
  private javax.swing.JMenuItem extraMenuSpawningTreeUser;
  private javax.swing.JMenuItem extraMenuWeightConstant;
  private javax.swing.JMenuItem extraMenuWeightDefault;
  private javax.swing.JFileChooser fileChooser;
  private javax.swing.JMenu fileMenu;
  private javax.swing.JMenuItem fileMenuExit;
  private javax.swing.JMenuItem fileMenuOpenJson;
  private javax.swing.JMenu graphMenu;
  private javax.swing.JMenuItem graphMenuIsComplete;
  private javax.swing.JMenuItem graphMenuMinimalPathVertices;
  private javax.swing.JMenuItem graphMenuNotReachableUsersByUser;
  private javax.swing.JMenuItem graphMenuRechableUsersByUser;
  private javax.swing.JMenuItem graphMenuView;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JMenu userMenu;
  private javax.swing.JMenuItem userMenuAddUser;
  private javax.swing.JMenuItem userMenuCompareCompanyPeopleAndPersonContacts;
  private javax.swing.JMenuItem userMenuSearchByEmail;
  private javax.swing.JMenuItem userMenuSearchById;
  private javax.swing.JMenuItem userMenuSkillsOrderedByCost;
  // End of variables declaration//GEN-END:variables
}
