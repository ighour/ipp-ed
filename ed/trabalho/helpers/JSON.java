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
import estg.ed.exceptions.VertexIsNotAccessibleException;
import estg.ed.interfaces.DynamicArrayContract;
import estg.ed.interfaces.NetworkADT;
import estg.ed.interfaces.OrderedListADT;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igu
 */
public abstract class JSON {
  public static Pessoa[] readJson(String path) throws FileNotFoundException{
    Gson gson = new Gson();
    
    GrafoSocial json = gson.fromJson(new FileReader(path), GrafoSocial.class);
    
    return json.getResult();
  }
    
  public static void populateData(Pessoa[] json, NetworkADT<Person> network, OrderedListADT<Person> peopleList){
    //Process json result
    for(Pessoa p : json){
      //Parse "Pessoa" (Json) to "Person" (Model)
      Person newPerson = new Person(p.getId(), p.getNome(), p.getIdade(), p.getEmail(), p.getVisualizacoes(), contactsToId(p.getContacts()), mentionsToId(p.getMencoes()));
    
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
      
      try {
        //Add newPerson to people list
        peopleList.add(newPerson);
      } catch (NotComparableException ex) {
        Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    //Parse mentions and contacts
    Iterator peopleListIterator = peopleList.iterator();
    while(peopleListIterator.hasNext()){
      Person p = (Person) peopleListIterator.next();
      
      //Set mentions reference
      addPeopleReferenceToMentions(p, peopleList);
      
      try {
        //Set contacts reference
        addPeopleReferenceToContacts(p, peopleList, network);
      } catch (ElementNotFoundException ex) {
        Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  private static int[] contactsToId(Contact[] list){
    int[] ids = new int[list.length];
    
    for(int i = 0; i < list.length; i++){
      ids[i] = list[i].getUserid();
    }
    
    return ids;
  }
  
  private static int[] mentionsToId(Mencao[] list){
    int[] ids = new int[list.length];
    
    for(int i = 0; i < list.length; i++){
      ids[i] = list[i].getUserid();
    }
    
    return ids;
  }
  
  private static void addPeopleReferenceToMentions(Person owner, OrderedListADT<Person> people){
    int[] ids = owner.getMentionIdList();
    DynamicArrayContract<Person> list = owner.getMentionList();
    int count = ids.length;
    
    //Iterate in people list
    Iterator peopleIterator = people.iterator();
    while(peopleIterator.hasNext()){
      Person p = (Person) peopleIterator.next();
      
      //Iterate in ids (list of mentions or contacts id)
      for(int id : ids){
        //Is the same id
        if(p.getId() == id){
          //Add person to list
          list.add(p, list.size());
          count--;
        }
        //Stop if added all ids
        if(count == 0)
          return;
      }
    }
  }
  
  private static void addPeopleReferenceToContacts(Person owner, OrderedListADT<Person> people, NetworkADT<Person> network) throws ElementNotFoundException{
    int[] ids = owner.getContactIdList();
    DynamicArrayContract<Person> list = owner.getContactList();
    int count = ids.length;
    
    //Iterate in people list
    Iterator peopleIterator = people.iterator();
    while(peopleIterator.hasNext()){
      Person p = (Person) peopleIterator.next();
      
      //Iterate in ids (list of mentions or contacts id)
      for(int id : ids){
        //Is the same id
        if(p.getId() == id){
          //Add person to list
          list.add(p, list.size());
          
          //Add edge in network
          //Using visualizations for weight
          //p (neighbor) -> owner
          network.addEdge(p, owner, owner.getVisualizations());
          
          count--;
        }
        //Stop if added all ids
        if(count == 0)
          return;
      }
    }
  }
 
  public static String testNetwork(NetworkADT<Person> x, OrderedListADT<Person> peopleList) throws ElementNotFoundException, VertexIsNotAccessibleException {
    try{
      StringBuilder stb = new StringBuilder();

      Person p0 = null;
      Person p3 = null;

      Iterator peopleIterator = peopleList.iterator();
      while(peopleIterator.hasNext()){
        Person p = (Person) peopleIterator.next();

        if(p.getId() == 0)
          p0 = p;

        if(p.getId() == 3)
          p3 = p;
      }

      stb.append("# Adjacency Matrix:").append("\n");
      stb.append(x.toString()).append("\n").append("\n");

      stb.append("# Is Connected:").append("\n");
      stb.append(x.isConnected()).append("\n").append("\n");

      Iterator i1 = x.iteratorBFS(p0);
      stb.append("# ITERATOR BFS FROM 0").append("\n");
      while(i1.hasNext())
        stb.append(i1.next()).append("\t");
      stb.append("\n").append("\n");

      Iterator i2 = x.iteratorDFS(p0);
      stb.append("# ITERATOR DFS FROM 0").append("\n");
      while(i2.hasNext())
        stb.append(i2.next()).append("\t");
      stb.append("\n").append("\n");

      Iterator i3 = x.iteratorShortestPath(p0, p3);
      stb.append("# ITERATOR SP FROM 0 TO 3").append("\n");
      while(i3.hasNext())
        stb.append(i3.next()).append("\t");
      stb.append("\n").append("\n");

      stb.append("# Shortest Path Weight from 0 to 3:").append("\n");
      stb.append(x.shortestPathWeight(p0, p3)).append("\n").append("\n");

      NetworkADT<Person> mst = x.mstNetwork(p0);
      stb.append("# MST FROM A").append("\n");
      stb.append(mst.toString()).append("\n");
      Iterator i4 = mst.iteratorBFS(p0);
      while(i4.hasNext())
        stb.append(i4.next()).append("\t");
      
      stb.append("\n\nSuccessfully tested Network!");

      return stb.toString();
    }
    catch(Exception ex){
      return "Error testing JSON.";
    }
  }
}
