/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.model;

import estg.ed.array.DynamicArray;
import estg.ed.interfaces.DynamicArrayContract;

/**
 *
 * @author igu
 */
public class Person implements Comparable<Person> {
  private final int id;
  private final String name;
  private final int age;
  private final String email;
  private final int visualizations;
  private DynamicArrayContract<Academic> academicList;
  private DynamicArrayContract<Professional> professionalList;
  private DynamicArrayContract<Skill> skillList;
  private DynamicArrayContract<Person> contactList;
  private DynamicArrayContract<Person> mentionList;
  private final int[] contactIdList;
  private final int[] mentionIdList;
  
  public Person(int id, String name, int age, String email, int visualizations, int[] contactIdList, int[] mentionIdList) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.email = email;
    this.visualizations = visualizations;
    this.academicList = new DynamicArray<>();
    this.professionalList = new DynamicArray<>();
    this.skillList = new DynamicArray<>();
    this.contactList = new DynamicArray<>();
    this.mentionList = new DynamicArray<>();
    this.contactIdList = contactIdList;
    this.mentionIdList = mentionIdList;
  }

  public int getId() {
    return id;
  }
  
  public DynamicArrayContract<Academic> getAcademicList() {
    return academicList;
  }

  public void setAcademicList(DynamicArrayContract<Academic> academicList) {
    this.academicList = academicList;
  }

  public DynamicArrayContract<Professional> getProfessionalList() {
    return professionalList;
  }

  public void setProfessionalList(DynamicArrayContract<Professional> professionalList) {
    this.professionalList = professionalList;
  }

  public DynamicArrayContract<Skill> getSkillList() {
    return skillList;
  }

  public void setSkillList(DynamicArrayContract<Skill> skillList) {
    this.skillList = skillList;
  }

  public DynamicArrayContract<Person> getContactList() {
    return contactList;
  }

  public void setContactList(DynamicArrayContract<Person> contactList) {
    this.contactList = contactList;
  }

  public DynamicArrayContract<Person> getMentionList() {
    return mentionList;
  }

  public void setMentionList(DynamicArrayContract<Person> mentionList) {
    this.mentionList = mentionList;
  }
  
  public int[] getContactIdList() {
    return contactIdList;
  }
  
  public int[] getMentionIdList() {
    return mentionIdList;
  }
  
  public int getMentions(){
    return this.mentionList.size();
  }
  
  public int getVisualizations() {
    return visualizations;
  }

  @Override
  public int compareTo(Person o) {
    if(this.id > o.id)
      return 1;
    else if(this.id < o.id)
      return -1;
    else
      return 0;
  }
  
  @Override
  public String toString(){
    return String.valueOf(this.id);
  }

}
