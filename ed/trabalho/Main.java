/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho;

import com.google.gson.Gson;
import ed.trabalho.adt.ReverseNetwork;
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
import estg.ed.list.OrderedArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

/**
 *
 * @author igu
 */
public class Main {

  /**
   * @param args the command line arguments
   * @throws java.io.FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException, NotComparableException, ElementNotFoundException, VertexIsNotAccessibleException {
    //Parse json to array with info
    Pessoa[] result = readJson();
    
    //Generates Empty Directional Network
    //It is reverse, so more weight is the best cost
    NetworkADT<Person> network = new ReverseNetwork<>();
    
    //Add pool of people to an ordered list (to get relations after)
    OrderedListADT<Person> peopleList = new OrderedArrayList<>();
    
    //Process json result
    for(Pessoa p : result){
      //Parse "Pessoa" (Json) to "Person" (Model)
      Person newPerson = new Person(p.getId(), p.getNome(), p.getIdade(), p.getEmail(), p.getVisualizacoes(), jsonContactsToId(p.getContacts()), jsonMentionsToId(p.getMencoes()));
    
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
      
      //Add newPerson to people list
      peopleList.add(newPerson);
    }

    //Parse mentions and contacts
    Iterator peopleListIterator = peopleList.iterator();
    while(peopleListIterator.hasNext()){
      Person p = (Person) peopleListIterator.next();
      
      //Set mentions reference
      addPeopleReferenceToMentions(p, peopleList);
      
      //Set contacts reference
      addPeopleReferenceToContacts(p, peopleList, network);
    }

    //Test Network
    testNetwork(network, peopleList);
  }
  
  private static Pessoa[] readJson() throws FileNotFoundException{
    //Temporarly reads JSON from /test.json
    Gson gson = new Gson();
    
    GrafoSocial json = gson.fromJson(new FileReader("./src/test.json"), GrafoSocial.class);
    
    return json.getResult();
  }
  
  private static int[] jsonContactsToId(Contact[] list){
    int[] ids = new int[list.length];
    
    for(int i = 0; i < list.length; i++){
      ids[i] = list[i].getUserid();
    }
    
    return ids;
  }
  
  private static int[] jsonMentionsToId(Mencao[] list){
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
  
  private static void testNetwork(NetworkADT<Person> x, OrderedListADT<Person> peopleList) throws ElementNotFoundException, VertexIsNotAccessibleException {
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
    
    System.out.println("\n# TEST NETWORK");
    
    System.out.println("\nAdjacency Matrix:");
    System.out.println(x.toString());
    
    System.out.println("\nIs Connected:");
    System.out.println(x.isConnected());
    
    Iterator i1 = x.iteratorBFS(p0);
    System.out.println("\nITERATOR BFS FROM 0");
    while(i1.hasNext())
      System.out.print(i1.next() + "\t");
    System.out.println("");
      
    Iterator i2 = x.iteratorDFS(p0);
    System.out.println("\nITERATOR DFS FROM 0");
    while(i2.hasNext())
      System.out.print(i2.next() + "\t");
    System.out.println("");
    
    Iterator i3 = x.iteratorShortestPath(p0, p3);
    System.out.println("\nITERATOR SP FROM 0 TO 3");
    while(i3.hasNext())
      System.out.print(i3.next() + "\t");
    System.out.println("");
    
    System.out.println("\nShortest Path Weight from 0 to 3:");
    System.out.println(x.shortestPathWeight(p0, p3));
    
    NetworkADT<Person> mst = x.mstNetwork(p0);
    System.out.println("\nMST FROM A");
    System.out.println(mst.toString());
    Iterator i4 = mst.iteratorBFS(p0);
    while(i4.hasNext())
      System.out.print(i4.next() + "\t");
    System.out.println("");
  }
  
}
