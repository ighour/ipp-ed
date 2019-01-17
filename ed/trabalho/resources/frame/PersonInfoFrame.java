/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources.frame;

import ed.trabalho.model.Person;
import estg.ed.interfaces.NetworkADT;
import estg.ed.interfaces.OrderedListADT;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author igu
 */
public class PersonInfoFrame extends javax.swing.JFrame {

  /**
   * Person information.
   */
  private Person person;
  
  /**
   * Network with people obtained from JSON input.
   */
  private NetworkADT<Person> network;
  
  /**
   * People ordered list by id.
   */
  private OrderedListADT<Person> peopleById;
  
  /**
   * Creates new form PersonInfoFrame
   */
  public PersonInfoFrame() {
    initComponents();
  }
  
  public void setData(Person person, NetworkADT<Person> network, OrderedListADT<Person> peopleById){
    this.person = person;
    this.inputName.setText(person.getName());
    this.inputAge.setText(String.valueOf(person.getAge()));
    this.inputEmail.setText(person.getEmail());
    this.inputVisualizacoes.setText(String.valueOf(person.getVisualizations()));
    this.inputCountMentions.setText(String.valueOf(person.getMentions()));
    this.network = network;
    this.peopleById = peopleById;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    inputName = new javax.swing.JTextField();
    inputAge = new javax.swing.JTextField();
    inputEmail = new javax.swing.JTextField();
    submitUpdate = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    inputCountMentions = new javax.swing.JTextField();
    inputVisualizacoes = new javax.swing.JTextField();

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("Informações de Gestão");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel2.setText("Nome");

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel3.setText("Idade");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel4.setText("Email");

    submitUpdate.setText("Atualizar Dados");
    submitUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitUpdateActionPerformed(evt);
      }
    });

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel5.setText("Visualizações");

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel6.setText("Informação Geral");

    jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel7.setText("nº Menções");

    inputCountMentions.setEditable(false);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(28, 28, 28)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel2)
              .addComponent(jLabel5)
              .addComponent(jLabel7)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel4)
                .addComponent(jLabel3)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(inputAge, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(inputVisualizacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(inputCountMentions, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
          .addGroup(layout.createSequentialGroup()
            .addGap(4, 4, 4)
            .addComponent(jLabel1)))
        .addContainerGap(952, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(submitUpdate)
        .addGap(44, 44, 44))
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(38, 38, 38)
          .addComponent(jLabel6)
          .addContainerGap(1317, Short.MAX_VALUE)))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(68, 68, 68)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(23, 23, 23)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(inputAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(23, 23, 23)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 483, Short.MAX_VALUE)
        .addComponent(jLabel1)
        .addGap(31, 31, 31)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(inputVisualizacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(30, 30, 30)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel7)
          .addComponent(inputCountMentions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(62, 62, 62)
        .addComponent(submitUpdate)
        .addGap(29, 29, 29))
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(26, 26, 26)
          .addComponent(jLabel6)
          .addContainerGap(882, Short.MAX_VALUE)))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void submitUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitUpdateActionPerformed
    //Check has data to update
    try{
      if(!inputName.getText().isEmpty() && !inputName.getText().equals(this.person.getName()))
        this.person.setName(inputName.getText());
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, "Error updating name.");
      return;
    }
    
    try{
      if(!inputAge.getText().isEmpty() && !Integer.valueOf(inputAge.getText()).equals(this.person.getAge()))
        this.person.setAge(Integer.valueOf(inputAge.getText()));
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, "Error updating age.");
      return;
    }
    
    try{
      if(!inputEmail.getText().isEmpty() && !inputEmail.getText().equals(this.person.getEmail()))
        this.person.setName(inputEmail.getText());
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, "Error updating email.");
      return;
    }
    
    try{
      if(!inputVisualizacoes.getText().isEmpty() && !Integer.valueOf(inputVisualizacoes.getText()).equals(this.person.getVisualizations())){
        this.person.setVisualizations(Integer.valueOf(inputVisualizacoes.getText()));
        
        //Update edges on network
        Iterator list = this.peopleById.iterator();
        while(list.hasNext()){
          Person p = (Person) list.next();
          
          //Current Person is a contact of P
          //Update edge weight
          if(p.isContact(this.person))
            this.network.addEdge(p, this.person, Integer.valueOf(inputVisualizacoes.getText()));
        }
      }
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, "Error updating visualizações.");
      return;
    }
    
    JOptionPane.showMessageDialog(null, "Person updated.");
  }//GEN-LAST:event_submitUpdateActionPerformed

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
      java.util.logging.Logger.getLogger(PersonInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(PersonInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(PersonInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PersonInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new PersonInfoFrame().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField inputAge;
  private javax.swing.JTextField inputCountMentions;
  private javax.swing.JTextField inputEmail;
  private javax.swing.JTextField inputName;
  private javax.swing.JTextField inputVisualizacoes;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JButton submitUpdate;
  // End of variables declaration//GEN-END:variables
}
