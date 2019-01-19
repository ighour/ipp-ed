package ed.trabalho.resources.frame;

import ed.trabalho.helpers.Store;
import ed.trabalho.model.Person;
import ed.trabalho.resources.form.AddSkillForm;
import ed.trabalho.resources.form.EditSkillForm;
import java.util.Iterator;
import javax.swing.DefaultListModel;
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
   * Stores with all application data.
   */
  private Store store;
  
  /**
   * Creates new form PersonInfoFrame
   */
  public PersonInfoFrame() {
    initComponents();
  }
  
  /**
   * Set store access to component.
   * @param store 
   */
  public void setStore(Store store){
    this.store = store;
  }
  /**
   * Set person data to form/view. 
   * @param person
   */
  public void setData(Person person){
    this.person = person;
    this.inputID.setText(String.valueOf(person.getId()));
    this.inputName.setText(person.getName());
    this.inputAge.setText(String.valueOf(person.getAge()));
    this.inputEmail.setText(person.getEmail());
    this.inputVisualizacoes.setText(String.valueOf(person.getVisualizations()));
    this.inputCountMentions.setText(String.valueOf(person.getMentions()));
    this.SkillList.setListData(loadSkill(person));
    this.ProfessionalFormationList.setListData(loadProfessional());
    this.contactList.setListData(loadContacts());
    this.mencionsList.setListData(loadMentions());
    this.academicList.setListData(loadAcademic());
  }

    /**
     * Stores all the skills of a certain person
     * @param person the person to store the skills from
     * @return the array of string containg all the skills
     */
    public String[] loadSkill(Person person) {
      int size = person.getSkillList().size();
      String[] list = new String[size];
      for (int i=0; i<size; i++)
          list[i] = person.getSkillList().get(i).getSkill();
      return list;  
    }
  
    /**
     * Stores all the professional history of a certain person in a array
     * @return the array of string containing all the professional history
     */
    private String[] loadProfessional() {
        int size = person.getProfessionalList().size();
        String[] list = new String[size];
        for (int i=0; i<size; i++)
            list[i] = person.getProfessionalList().get(i).toString();
        return list; 
    }
    
    /**
     * Stores all the contacts names of a person contacts
     * @return the array of strings containing the contacts
     */
    private String[] loadContacts() {
        int size = person.getContactList().size();
        String[] list = new String[size];
        for (int i=0; i<size; i++)
            list[i] = person.getContactList().get(i).getName();
        return list; 
    }
    
    /**
     * Stores all the mentions of a certain person in a array
     * @return the array of String containing all the mentions
     */
    private String[] loadMentions() {
        int size = person.getMentionList().size();
        String[] list = new String[size];
        for (int i=0; i<size; i++)
            list[i] = person.getMentionList().get(i).getName();
        return list; 
    }
    
    /**
     * Stores in an array of Strings all the academic from a person
     * @return the array of string containing the academic history
     */
    private String[] loadAcademic() {
        int size = person.getAcademicList().size();
        String[] list = new String[size];
        for (int i=0; i<size; i++)
            list[i] = person.getAcademicList().get(i).toString();
        return list; 
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inputCountMentions = new javax.swing.JTextField();
        inputVisualizacoes = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SkillList = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        submitSaveName = new javax.swing.JButton();
        submitSaveAge = new javax.swing.JButton();
        submitSaveEmail = new javax.swing.JButton();
        submitSaveVisualizations = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        inputID = new javax.swing.JTextField();
        EditSkillButton = new javax.swing.JButton();
        CreateSkillButton = new javax.swing.JButton();
        DeleteSkillButton = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        academicList = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        ProfessionalFormationList = new javax.swing.JList<>();
        CreateProfessioalFormation = new javax.swing.JButton();
        EditProfessionalFormation = new javax.swing.JButton();
        deleteProfessionalFormation = new javax.swing.JButton();
        createAcademicFormation = new javax.swing.JButton();
        editAcademicFormation = new javax.swing.JButton();
        deleteAcademicFormation = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        mencionsList = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        contactList = new javax.swing.JList<>();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Informações de Gestão");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Idade");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("nº Visualizações");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Informação Geral");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("nº Menções");

        inputCountMentions.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Formação Acadêmica");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Formação Profissional");

        SkillList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        SkillList.setToolTipText("");
        SkillList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                SkillListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(SkillList);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Skills");

        submitSaveName.setText("Salvar");
        submitSaveName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitSaveNameActionPerformed(evt);
            }
        });

        submitSaveAge.setText("Salvar");
        submitSaveAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitSaveAgeActionPerformed(evt);
            }
        });

        submitSaveEmail.setText("Salvar");
        submitSaveEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitSaveEmailActionPerformed(evt);
            }
        });

        submitSaveVisualizations.setText("Salvar");
        submitSaveVisualizations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitSaveVisualizationsActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Lista de Menções");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Lista de Contatos");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("ID");

        inputID.setEditable(false);

        EditSkillButton.setText("Edit");
        EditSkillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditSkillButtonActionPerformed(evt);
            }
        });

        CreateSkillButton.setText("Create");
        CreateSkillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateSkillButtonActionPerformed(evt);
            }
        });

        DeleteSkillButton.setText("Delete");
        DeleteSkillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteSkillButtonActionPerformed(evt);
            }
        });

        academicList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        academicList.setToolTipText("");
        academicList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                academicListValueChanged(evt);
            }
        });
        jScrollPane7.setViewportView(academicList);

        ProfessionalFormationList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ProfessionalFormationList.setToolTipText("");
        ProfessionalFormationList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ProfessionalFormationListValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(ProfessionalFormationList);

        CreateProfessioalFormation.setText("Create");
        CreateProfessioalFormation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateProfessioalFormationActionPerformed(evt);
            }
        });

        EditProfessionalFormation.setText("Edit");
        EditProfessionalFormation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProfessionalFormationActionPerformed(evt);
            }
        });

        deleteProfessionalFormation.setText("Delete");
        deleteProfessionalFormation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProfessionalFormationActionPerformed(evt);
            }
        });

        createAcademicFormation.setText("Create");
        createAcademicFormation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAcademicFormationActionPerformed(evt);
            }
        });

        editAcademicFormation.setText("Edit");
        editAcademicFormation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAcademicFormationActionPerformed(evt);
            }
        });

        deleteAcademicFormation.setText("Delete");
        deleteAcademicFormation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAcademicFormationActionPerformed(evt);
            }
        });

        mencionsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mencionsList.setToolTipText("");
        mencionsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                mencionsListValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(mencionsList);

        contactList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        contactList.setToolTipText("");
        contactList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                contactListValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(contactList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jLabel13)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(inputID, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(268, 268, 268))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                    .addGap(42, 42, 42)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(inputName)
                                                        .addComponent(inputAge, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(46, 46, 46)
                                                .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(submitSaveName)
                                            .addComponent(submitSaveEmail)
                                            .addComponent(submitSaveAge))))
                                .addGap(39, 39, 39))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(76, 76, 76)
                                    .addComponent(inputCountMentions, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(169, 169, 169)
                                            .addComponent(inputVisualizacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(submitSaveVisualizations))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createAcademicFormation)
                                .addGap(18, 18, 18)
                                .addComponent(editAcademicFormation)
                                .addGap(18, 18, 18)
                                .addComponent(deleteAcademicFormation))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CreateProfessioalFormation)
                                .addGap(18, 18, 18)
                                .addComponent(EditProfessionalFormation)
                                .addGap(18, 18, 18)
                                .addComponent(deleteProfessionalFormation))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CreateSkillButton)
                                .addGap(18, 18, 18)
                                .addComponent(EditSkillButton)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteSkillButton)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(inputID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitSaveName))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitSaveAge))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitSaveEmail)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createAcademicFormation)
                            .addComponent(editAcademicFormation)
                            .addComponent(deleteAcademicFormation))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CreateProfessioalFormation)
                            .addComponent(EditProfessionalFormation)
                            .addComponent(deleteProfessionalFormation))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CreateSkillButton)
                            .addComponent(EditSkillButton)
                            .addComponent(DeleteSkillButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(inputVisualizacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitSaveVisualizations))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(inputCountMentions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void submitSaveNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSaveNameActionPerformed
    try{
      if(!inputName.getText().isEmpty() && !inputName.getText().equals(this.person.getName())){
        this.person.setName(inputName.getText());
        
        JOptionPane.showMessageDialog(null, "Nome atualizado.");
      }
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, "Erro ao atualizar o nome.");
    }
  }//GEN-LAST:event_submitSaveNameActionPerformed

  private void submitSaveAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSaveAgeActionPerformed
    try{
      if(!inputAge.getText().isEmpty() && !Integer.valueOf(inputAge.getText()).equals(this.person.getAge())){
        this.person.setAge(Integer.valueOf(inputAge.getText()));
        
        JOptionPane.showMessageDialog(null, "Idade atualizada.");
      }
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, "Erro ao atualizar a idade.");
    }
  }//GEN-LAST:event_submitSaveAgeActionPerformed

  private void submitSaveEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSaveEmailActionPerformed
    try{
      if(!inputEmail.getText().isEmpty() && !inputEmail.getText().equals(this.person.getEmail())){
        this.person.setEmail(inputEmail.getText());
        
        //Update person index on peopleByEmail list
        this.store.getPeopleByEmail().remove(this.person);
        this.store.getPeopleByEmail().add(this.person);
        
        JOptionPane.showMessageDialog(null, "Email atualizado.");
      }
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, "Erro ao atualizar o email.");
    }
  }//GEN-LAST:event_submitSaveEmailActionPerformed

  private void submitSaveVisualizationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSaveVisualizationsActionPerformed
    try{
      if(!inputVisualizacoes.getText().isEmpty() && !Integer.valueOf(inputVisualizacoes.getText()).equals(this.person.getVisualizations())){
        this.person.setVisualizations(Integer.valueOf(inputVisualizacoes.getText()));
        
        //Update edges on network
        Iterator list = this.store.getPeopleById().iterator();
        while(list.hasNext()){
          Person p = (Person) list.next();
          
          //Current Person is a contact of P
          //Update edge weight
          if(p.isContact(this.person))
            this.store.getNetwork().addEdge(p, this.person, Integer.valueOf(inputVisualizacoes.getText()));
        }
        
        JOptionPane.showMessageDialog(null, "Quantidade de visualizações atualizada.");
      }
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, "Erro ao atualizar a quantidade de visualizações.");
    }
  }//GEN-LAST:event_submitSaveVisualizationsActionPerformed


    private void CreateSkillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateSkillButtonActionPerformed
        AddSkillForm form = new AddSkillForm();
        form.setTitle("Edit the Skill");
        form.setData(person, this.SkillList);
        form.pack();
        form.setVisible(true);
    }//GEN-LAST:event_CreateSkillButtonActionPerformed

    private void EditSkillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditSkillButtonActionPerformed
        if (SkillList.getSelectedValue() != null) {
            EditSkillForm form = new EditSkillForm();
            form.setTitle("Edit the Skill");
            form.setData(SkillList.getSelectedValue(), person, SkillList);
            form.pack();
            form.setVisible(true);
        } else
            JOptionPane.showMessageDialog(null, "Please select a skill.");
    }//GEN-LAST:event_EditSkillButtonActionPerformed

    private void DeleteSkillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteSkillButtonActionPerformed
        if (SkillList.getSelectedValue() != null) {
            String delete = SkillList.getSelectedValue();
            for (int i=0; i<person.getSkillList().size(); i++) {
                if (person.getSkillList().get(i).getSkill().equals(delete))
                    person.getSkillList().remove(i);
            }
            this.SkillList.setListData(loadSkill(person));
        } else 
            JOptionPane.showMessageDialog(null, "Please select a skill.");
    }//GEN-LAST:event_DeleteSkillButtonActionPerformed

    private void SkillListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_SkillListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_SkillListValueChanged

    private void academicListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_academicListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_academicListValueChanged

    private void ProfessionalFormationListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ProfessionalFormationListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfessionalFormationListValueChanged

    private void CreateProfessioalFormationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateProfessioalFormationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateProfessioalFormationActionPerformed

    private void EditProfessionalFormationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProfessionalFormationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditProfessionalFormationActionPerformed

    private void deleteProfessionalFormationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProfessionalFormationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteProfessionalFormationActionPerformed

    private void createAcademicFormationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAcademicFormationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createAcademicFormationActionPerformed

    private void editAcademicFormationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAcademicFormationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editAcademicFormationActionPerformed

    private void deleteAcademicFormationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAcademicFormationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteAcademicFormationActionPerformed

    private void mencionsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_mencionsListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_mencionsListValueChanged

    private void contactListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_contactListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_contactListValueChanged

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
    private javax.swing.JButton CreateProfessioalFormation;
    private javax.swing.JButton CreateSkillButton;
    private javax.swing.JButton DeleteSkillButton;
    private javax.swing.JButton EditProfessionalFormation;
    private javax.swing.JButton EditSkillButton;
    private javax.swing.JList<String> ProfessionalFormationList;
    private javax.swing.JList<String> SkillList;
    private javax.swing.JList<String> academicList;
    private javax.swing.JList<String> contactList;
    private javax.swing.JButton createAcademicFormation;
    private javax.swing.JButton deleteAcademicFormation;
    private javax.swing.JButton deleteProfessionalFormation;
    private javax.swing.JButton editAcademicFormation;
    private javax.swing.JTextField inputAge;
    private javax.swing.JTextField inputCountMentions;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputID;
    private javax.swing.JTextField inputName;
    private javax.swing.JTextField inputVisualizacoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JList<String> mencionsList;
    private javax.swing.JButton submitSaveAge;
    private javax.swing.JButton submitSaveEmail;
    private javax.swing.JButton submitSaveName;
    private javax.swing.JButton submitSaveVisualizations;
    // End of variables declaration//GEN-END:variables
}
