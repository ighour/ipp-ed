/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.helpers;

import com.google.gson.Gson;
import ed.trabalho.json.CargosProfissionais;
import ed.trabalho.json.Contact;
import ed.trabalho.json.FormacaoAcademica;
import ed.trabalho.json.GrafoSocial;
import ed.trabalho.json.Mencao;
import ed.trabalho.json.Pessoa;
import ed.trabalho.model.Academic;
import ed.trabalho.model.Person;
import ed.trabalho.model.Professional;
import ed.trabalho.model.Skill;
import estg.ed.exceptions.ElementNotFoundException;
import estg.ed.exceptions.NotComparableException;
import estg.ed.interfaces.DynamicArrayContract;
import estg.ed.interfaces.NetworkADT;
import estg.ed.interfaces.OrderedListADT;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Helper class to handle JSON input data and insert in network.
 * @author igu
 */
public abstract class Data {
  
  /**
   * Reads a JSON file and map it to java classes.
   * @param path
   * @return
   * @throws FileNotFoundException 
   */
  public static Pessoa[] readJson(String path) throws FileNotFoundException{
    Gson gson = new Gson();
    
    GrafoSocial json = gson.fromJson(new FileReader(path), GrafoSocial.class);
    
    return json.getResult();
  }
    
  /**
   * Populates the network and binary search tree with provided data.
   * @param source
   * @param network
   * @param peopleById
   * @throws estg.ed.exceptions.ElementNotFoundException
   */
  public static void populate(Pessoa[] source, NetworkADT<Person> network, OrderedListADT<Person> peopleById) throws ElementNotFoundException, NotComparableException{
    //Create list of People
    Person[] peopleList = new Person[source.length];

    //Loop through source
    for(int i = 0; i < source.length; i++){
      //Create person if needed
      if(peopleList[i] == null)
        peopleList[i] = addPerson(source[i], network, peopleById);
      
      //Add relations
      addRelations(i, source, peopleList, network, peopleById);
    }
  }
  
  /**
   * Add a person to the network.
   * Only the attributes which does not referrer to another person.
   * @param p
   * @param network
   * @return 
   */
  private static Person addPerson(Pessoa p, NetworkADT<Person> network, OrderedListADT<Person> peopleById) throws NotComparableException{
    //Parse "Pessoa" (converted JSON data) to "Person" (model)
    Person newPerson = new Person(p.getId(), p.getNome(), p.getIdade(), p.getEmail(), p.getVisualizacoes());

    //Add AcademicList
    DynamicArrayContract<Academic> academicList = newPerson.getAcademicList();
    for(FormacaoAcademica x : p.getFormacaoAcademica())
      academicList.add(new Academic(x.getAno(), x.getFormacao()), academicList.size());

    //Add ProfessionalList
    DynamicArrayContract<Professional> professionalList = newPerson.getProfessionalList();
    for(CargosProfissionais x : p.getCargosProfissionais())
      professionalList.add(new Professional(x.getAno(), x.getEmpresa(), x.getCargo()), professionalList.size());

    //Add SkillList
    DynamicArrayContract<Skill> skillList = newPerson.getSkillList();
    for(String x : p.getSkills())
      skillList.add(new Skill(x), skillList.size());

    //Add newPerson to Network
    network.addVertex(newPerson);
    
    //Add newPerson to peopleById list
    peopleById.add(newPerson);

    //Return newPerson
    return newPerson;
  }
  
  /**
   * Add person relation of mentions and contacts.
   * Relations which referrer to another person.
   * @param id
   * @param source
   * @param peopleList
   * @param network
   * @throws ElementNotFoundException 
   */
  private static void addRelations(int id, Pessoa[] source, Person[] peopleList, NetworkADT<Person> network, OrderedListADT<Person> peopleById) throws ElementNotFoundException, NotComparableException{
    /* Add Mentions */
    
    //Get mentions from source data
    Mencao[] sourceMentions = source[id].getMencoes();

    //Add mentions relation
    for (Mencao sourceMention : sourceMentions) {
      int mentionUid = sourceMention.getUserid();
      int uidIndex = getIndex(mentionUid, source);
      
      addRelation(peopleList[id].getMentionList(), uidIndex, source, peopleList, network, peopleById);
    }
    
    /* Add Contacts */
    
    //Get contacts from source data
    Contact[] sourceContacts = source[id].getContacts();

    //Add contacts relation
    for (Contact sourceContact : sourceContacts) {
      int contactUid = sourceContact.getUserid();
      int uidIndex = getIndex(contactUid, source);
      
      addRelation(peopleList[id].getContactList(), uidIndex, source, peopleList, network, peopleById);
      
      //Add edge in network
      //Using visualizations for weight
      //p (neighbor) -> owner
      network.addEdge(peopleList[id], peopleList[uidIndex], peopleList[uidIndex].getVisualizations());
    }
  }

  /**
   * Add a person to another person relation.
   * If the added person is not created yet, creates it.
   * @param relationList
   * @param relationIndex
   * @param source
   * @param peopleList
   * @param network 
   */
  private static void addRelation(DynamicArrayContract<Person> relationList, int relationIndex, Pessoa[] source, Person[] peopleList, NetworkADT<Person> network, OrderedListADT<Person> peopleById) throws NotComparableException{
    Person relationUser;

    //User was not created
    if(peopleList[relationIndex] == null){
      //Create the user
      relationUser = addPerson(source[relationIndex], network, peopleById);

      //Add to list
      peopleList[relationIndex] = relationUser;
    }

    //User exists
    else
      relationUser = peopleList[relationIndex];

    //Add to mention relation
    relationList.add(relationUser, relationList.size());
  }
  
  /**
   * Get the index of a Person inside the array of Pessoa.
   * @param uid
   * @param source
   * @return
   * @throws ElementNotFoundException 
   */
  private static int getIndex(int uid, Pessoa[] source) throws ElementNotFoundException{
    for(int i = 0; i < source.length; i++){
      Pessoa p = source[i];
      
      if(p.getId() == uid)
        return i;
    }
    
    throw new ElementNotFoundException();
  }
}
