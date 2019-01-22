/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources.form.model;

import ed.trabalho.resources.Base;
import ed.trabalho.model.Person;
import javax.swing.JTextField;

/**
 * Base for person frame.
 * @author igu
 */
public abstract class BasePerson extends Base {
  /**
   * Person information.
   */
  protected Person person;
  
  /**
   * Get the current person.
   * To manipulate in forms.
   * @return 
   */
  public Person getPerson(){
    return this.person;
  }
  
  /**
   * Loads all the skills of a certain person.
   */
  public abstract void loadSkill();
  
  /**
   * Loads all the professional information of a certain person.
   */
  public abstract void loadProfessional();
  
  /**
   * Loads all the contacts of a certain person.
   */
  public abstract void loadContacts();
  
  /**
   * Loads all the mentions of a certain person.
   */
  public abstract void loadMentions();
    
  /**
   * Loads all the academic information of a certain person.
   */
  public abstract void loadAcademic();
  
  /**
   * Process submit of name.
   * @param field 
   */
  protected void submitName(JTextField field){
    try{
      if(!field.getText().isEmpty() && !field.getText().equals(this.person.getName())){
        this.person.setName(field.getText());
        
        this.message("Name was updated.");
      }
    }
    catch(Exception e){
      this.message("Error updating name.");
    }
  }
  
  /**
   * Process submit of age.
   * @param field 
   */
  protected void submitAge(JTextField field){
    try{
      if(!field.getText().isEmpty() && !Integer.valueOf(field.getText()).equals(this.person.getAge())){
        this.person.setAge(Integer.valueOf(field.getText()));
        
        this.message("Age was updated.");
      }
    }
    catch(Exception e){
      this.message("Error updating age.");
    }
  }
  
  /**
   * Process submit of email.
   * Also, updates on peopleByEmail list.
   * @param field 
   */
  protected void submitEmail(JTextField field){
    try{
      if(!field.getText().isEmpty() && !field.getText().equals(this.person.getEmail())){
        this.getStore().updateUserEmail(this.person, field.getText());

        this.message("Email was updated.");
      }
    }
    catch(Exception e){
      this.message("Error updating email.");
    }
  }
  
  /**
   * Process submit of visualizations.
   * Also, updates edges on network.
   * For requirement: "Editar as ligações e visualizações no grafo após ser carregado do ficheiro".
   * @param field 
   */
  protected void submitVisualizations(JTextField field){
    try{
      if(!field.getText().isEmpty() && !Integer.valueOf(field.getText()).equals(this.person.getVisualizations())){
        this.getStore().updateUserVisualizations(this.person, Integer.valueOf(field.getText()));
  
        this.message("Visualizations were updated.");
      }
    }
    catch(Exception e){
      this.message("Error updating visualizations.");
    }
  }
  
  /**
   * Process submit of skill create.
   */
  protected void submitSkillCreate(){
    try {
      SkillCreateEdit form = new SkillCreateEdit();
      form.setTitle("Create Skill");
      form.setData(this);
      form.pack();
      form.setVisible(true);
    }
    catch(Exception e){
      this.message("Error creating skill.");
    }
  }
  
  /**
   * Process submit of skill edit.
   * @param index
   */
  protected void submitSkillEdit(int index){
    try {
      if(index != -1){
        SkillCreateEdit form = new SkillCreateEdit();
        form.setTitle("Edit Skill");
        form.setData(this, index);
        form.pack();
        form.setVisible(true);
      }
      else{
        this.message("Please select a skill first.");
      }
    }
    catch(Exception e){
      this.message("Error editing skill.");
    }
  }
  
  /**
   * Process submit of skill delete.
   * @param index
   */
  protected void submitSkillDelete(int index){
    try {
      if(index != -1){
        this.person.getSkillList().remove(index);
        this.loadSkill();
        
        this.message("Skill was deleted.");
      }
      else{
        this.message("Please select a skill first.");
      }
    }
    catch(Exception e){
      this.message("Error deleting skill.");
    }
  }

  /**
   * Process submit of professional create.
   */
  protected void submitProfessionalCreate(){
    try {
      ProfessionalCreateEdit form = new ProfessionalCreateEdit();
      form.setTitle("Create Professional Formation");
      form.setData(this);
      form.pack();
      form.setVisible(true);
    }
    catch(Exception e){
      this.message("Error creating professional formation.");
    }
  }
  
  /**
   * Process submit of professional edit.
   * @param index
   */
  protected void submitProfessionalEdit(int index){
    try {
      if(index != -1){
        ProfessionalCreateEdit form = new ProfessionalCreateEdit();
        form.setTitle("Edit Professional Formation");
        form.setData(this, index);
        form.pack();
        form.setVisible(true);
      }
      else{
        this.message("Please select a professional formation first.");
      }
    }
    catch(Exception e){
      this.message("Error editing professional formation.");
    }
  }
  
  /**
   * Process submit of professional delete.
   * @param index
   */
  protected void submitProfessionalDelete(int index){
    try {
      if(index != -1){
        this.person.getProfessionalList().remove(index);
        this.loadProfessional();
        
        this.message("Professional formation was deleted.");
      }
      else{
        this.message("Please select a professional formation first.");
      }
    }
    catch(Exception e){
      this.message("Error deleting professional formation.");
    }
  }
  
  /**
   * Process submit of academic create.
   */
  protected void submitAcademicCreate(){
    try {
      AcademicCreateEdit form = new AcademicCreateEdit();
      form.setTitle("Create Academic Formation");
      form.setData(this);
      form.pack();
      form.setVisible(true);
    }
    catch(Exception e){
      this.message("Error creating academic formation.");
    }
  }
  
  /**
   * Process submit of academic edit.
   * @param index
   */
  protected void submitAcademicEdit(int index){
    try {
      if(index != -1){
        AcademicCreateEdit form = new AcademicCreateEdit();
        form.setTitle("Edit Academic Formation");
        form.setData(this, index);
        form.pack();
        form.setVisible(true);
      }
      else{
        this.message("Please select an academic formation first.");
      }
    }
    catch(Exception e){
      this.message("Error editing academic formation.");
    }
  }
  
  /**
   * Process submit of academic delete.
   * @param index
   */
  protected void submitAcademicDelete(int index){
    try {
      if(index != -1){
        this.person.getAcademicList().remove(index);
        this.loadAcademic();
        
        this.message("Academic formation was deleted.");
      }
      else{
        this.message("Please select an academic formation first.");
      }
    }
    catch(Exception e){
      this.message("Error deleting academic formation.");
    }
  }
  
  /**
   * Process submit of mention create.
   */
  protected void submitMentionCreate(){
    try {
      MentionCreate form = new MentionCreate();
      form.setTitle("Mention an User");
      form.setData(this);
      form.pack();
      form.setVisible(true);
    }
    catch(Exception e){
      this.message("Error creating a mention.");
    }
  }
    
  /**
   * Process submit of mention delete.
   * @param index
   */
  protected void submitMentionDelete(int index){
    try {
      if(index != -1){
        this.getStore().removeUserMention(this.person, index);
        this.loadMentions();
        
        this.message("User is no more mentioned by you.");
      }
      else{
        this.message("Please select a person first.");
      }
    }
    catch(Exception e){
      this.message("Error deleting a mention.");
    }
  }
  
  /**
   * Process submit of contact create.
   * For requirement: "Editar as ligações e visualizações no grafo após ser carregado do ficheiro".
   */
  protected void submitContactCreate(){
    try {
      ContactCreate form = new ContactCreate();
      form.setTitle("Add User as Contact");
      form.setData(this);
      form.pack();
      form.setVisible(true);
    }
    catch(Exception e){
      this.message("Error adding an user.");
    }
  }
    
  /**
   * Process submit of contact delete.
   * For requirement: "Editar as ligações e visualizações no grafo após ser carregado do ficheiro".
   * @param index
   */
  protected void submitContactDelete(int index){
    try {
      if(index != -1){
        this.getStore().removeUserContact(this.person, index);
        this.loadContacts();
        
        this.message("User was removed from your contact list.");
      }
      else{
        this.message("Please select a person first.");
      }
    }
    catch(Exception e){
      this.message("Error removing user from your contact list.");
    }
  }
}
