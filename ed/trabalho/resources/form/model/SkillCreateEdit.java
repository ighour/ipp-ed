package ed.trabalho.resources.form.model;

import ed.trabalho.model.Person;
import ed.trabalho.model.Skill;
import ed.trabalho.resources.Base;

/**
 * Create or Edit a skill.
 */
public class SkillCreateEdit extends Base {

    /**
     * The current viewing person.
     */
    private Person person;

    /**
     * The view frame of person. To manipulate data in lists.
     */
    private BasePerson personInfo;

    /**
     * The skill index to edit.
     */
    private int skillIndex;

    /**
     * Instantiates
     */
    public SkillCreateEdit() {
        initComponents();
    }

    /**
     * Set data for creating element.
     *
     * @param personInfo person info
     */
    public void setData(BasePerson personInfo) {
        this.person = personInfo.getPerson();
        this.personInfo = personInfo;
        this.skillIndex = -1;
        submitSkill.setText("Create");
    }

    /**
     * Set data for editing element.
     *
     * @param personInfo person info
     * @param skillIndex index on skill list
     */
    public void setData(BasePerson personInfo, int skillIndex) {
        this.person = personInfo.getPerson();
        this.personInfo = personInfo;
        this.skillIndex = skillIndex;
        submitSkill.setText("Update");
        this.populateResource();
    }

    /**
     * Populates the form with incoming data.
     */
    private void populateResource() {
        Skill skill = this.person.getSkillList().get(this.skillIndex);
        String name = skill.getSkill();

        inputSkill.setText(name);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    inputSkill = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    submitSkill = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jLabel2.setText("Skill");

    submitSkill.setText("Create");
    submitSkill.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitSkillActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(41, 41, 41)
        .addComponent(jLabel2)
        .addGap(57, 57, 57)
        .addComponent(inputSkill, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        .addGap(36, 36, 36))
      .addGroup(layout.createSequentialGroup()
        .addGap(140, 140, 140)
        .addComponent(submitSkill)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(37, 37, 37)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(inputSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
        .addComponent(submitSkill)
        .addGap(32, 32, 32))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void submitSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSkillActionPerformed
        //Check is valid
        if (inputSkill.getText().isEmpty()) {
            this.message("You need to put a skill name first.");
            return;
        } else if (person.hasSkill(inputSkill.getText())) {
            this.message("User already has that skill");
            return;
        }

        //Message to show at end
        String resultMessage;

        //Transform values
        String skillName = "";
        try {
            skillName = inputSkill.getText();
        } catch (Exception e) {
            this.message("Invalid parameter");
            return;
        }

        //Is creating
        if (this.skillIndex == -1) {
            try {
                //Create new skill
                Skill newSkill = new Skill(skillName);

                //Add to person
                this.person.getSkillList().add(newSkill, this.person.getSkillList().size());

                //Updates the list
                this.personInfo.loadSkill();

                resultMessage = "Skill was created.";
            } catch (Exception e) {
                resultMessage = "Error creating the skill.";
            }
        } //Is editing
        else {
            try {
                //Check has updated
                boolean updated = false;

                //Get the original skill
                Skill skill = this.person.getSkillList().get(this.skillIndex);

                //Check need to change
                if (!skillName.equals(skill.getSkill())) {
                    //Update the skill
                    skill.setSkill(skillName);

                    updated = true;
                }

                //Updates the list
                if (updated == true) {
                    this.personInfo.loadSkill();
                    resultMessage = "Skill was updated.";
                } else {
                    resultMessage = "Nothing to update.";
                }
            } catch (Exception e) {
                resultMessage = "Error updating the skill.";
            }
        }

        //Dispose the frame and show message
        this.dispose();
        this.message(resultMessage);
    }//GEN-LAST:event_submitSkillActionPerformed

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
            java.util.logging.Logger.getLogger(SkillCreateEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SkillCreateEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SkillCreateEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SkillCreateEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SkillCreateEdit().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField inputSkill;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JButton submitSkill;
  // End of variables declaration//GEN-END:variables
}
