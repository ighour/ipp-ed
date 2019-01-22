/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.resources;

import ed.trabalho.adt.PersonIdOrderedList;
import ed.trabalho.adt.SocialNetwork;
import ed.trabalho.model.Person;
import ed.trabalho.model.Professional;
import ed.trabalho.store.BaseStore;
import estg.ed.array.DynamicArray;
import estg.ed.exceptions.ElementNotFoundException;
import estg.ed.exceptions.EmptyCollectionException;
import estg.ed.exceptions.NotComparableException;
import estg.ed.exceptions.VertexIsNotAccessibleException;
import estg.ed.interfaces.DynamicArrayContract;
import estg.ed.interfaces.NetworkADT;
import estg.ed.interfaces.OrderedListADT;
import estg.ed.interfaces.PriorityQueueADT;
import estg.ed.list.OrderedArrayList;
import estg.ed.tree.binary.ArrayPriorityMinQueue;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 * Base for every frame.
 * @author igu
 */
public abstract class Base extends javax.swing.JFrame {
  protected BaseStore getStore(){
    return BaseStore.getInstance();
  }
  
  /**
   * Show a message.
   * @param message 
   */
  protected void message(String message){
    JOptionPane.showMessageDialog(null, message);
  }
  
  /**
   * Find an user by id.
   * @param id
   * @return
   * @throws ElementNotFoundException 
   */
  protected Person findUserById(int id) throws ElementNotFoundException{
    return this.getStore().searchUserById(id);
  }
  
  /**
   * Find an user by email.
   * For requirement: "A informação de um utilizador pode ser consultada usando o email".
   * @param email
   * @return
   * @throws ElementNotFoundException 
   */
  protected Person findUserByEmail(String email) throws ElementNotFoundException{
    return this.getStore().searchUserByEmail(email);
  }
  
  /**
   * Check if graph is complete.
   * For requirement: "Criar funções para testar se o grafo é completo (os utilizadores estão todos ligados entre si)".
   * @return
   */
  protected String checkGraphIsComplete() {
    if(this.getStore().getPeopleCount() == 0)
      return "Graph is empty (no vertices).";
    else if(this.getStore().graphIsComplete())
      return "Graph is complete (all vertices are connected with each other).";
    else
      return "Graph is not complete.";
  }
  
  /**
   * Get the minimal path between users as a graph.
   * For requirement: "Verificar se dois utilizadores se encontram ligados entre si e apresentar o caminho mais curto entre eles usando as métricas descritas".
   * @param from
   * @param to
   * @return
   * @throws ElementNotFoundException 
   * @throws estg.ed.exceptions.VertexIsNotAccessibleException 
   */
  protected SocialNetwork getMinimalPathBetweenUsers(Person from, Person to) throws ElementNotFoundException, VertexIsNotAccessibleException{
    //Get path
    Iterator it = this.getStore().getIteratorShortestPath(from, to);
    
    //There is no path
    if(it.hasNext() == false)
      throw new VertexIsNotAccessibleException("Vertex is not accessible.");
    
    //Construct a graph to show the path with the Jung
    SocialNetwork resultGraph = new SocialNetwork();
    Person last = null;

    //Populate the view graph with users in minimum path
    while(it.hasNext()){
      Person p = (Person) it.next();

      resultGraph.addVertex(p);

      //There is a user before -> add an edge
      if(last != null){
        resultGraph.addEdge(last, p, 1 / (double) p.getVisualizations());
      }

      last = p;
    }

    return resultGraph;
  }
  
  /**
   * Get the reachable users from an user on graph.
   * For requirement: "Verificar quais os utilizadores que são alcançáveis a partir de um determinado utilizador".
   * @param from
   * @return
   * @throws ElementNotFoundException 
   */
  protected SocialNetwork getReachablePeople(Person from) throws ElementNotFoundException{
    return this.getStore().getMstNetwork(from);
  }
  
  /**
   * Get not reachable users from user on graph.
   * For requirement: "Listar utilizadores que não são possíveis de contactar, a partir de um determinado utilizador".
   * @param from
   * @return
   * @throws ElementNotFoundException
   * @throws NotComparableException
   * @throws EmptyCollectionException 
   */
  protected OrderedListADT<Person> getNotReachablePeople(Person from) throws ElementNotFoundException, NotComparableException, EmptyCollectionException{
    //Get reachable users
    NetworkADT<Person> resultGraph = this.getReachablePeople(from);

    //Create result list
    OrderedListADT<Person> resultList = new OrderedArrayList();
    Iterator it = this.getStore().getPeopleByIdIterator();
    while(it.hasNext()){
      Person p = (Person) it.next();
      resultList.add(p);
    }

    //Remove reachable users from list
    Iterator reachable = resultGraph.iteratorBFS(from);
    while(reachable.hasNext()){
      Person p = (Person) reachable.next();
      resultList.remove(p);
    }
    
    return resultList;
  }
  
  /**
   * Get the list of users who are contact of contacts of desired user and with desired skills and who work(ed) in desired company.
   * For requirement: "Verificar a partir de um dado utilizador qual a lista de utilizadores que fazem parte dos contactos da lista de contactos que têm determinados skills / trabalharam em determinada empresa. Em resumo todas as pessoas que o utilizador pode contactar via 1 único intermediário.".
   * @param user
   * @param companyName
   * @param skills
   * @return 
   */
  protected PersonIdOrderedList getIndirectContactsWithSkillsAndCompany(Person user, String companyName, DynamicArrayContract<String> skills){
    //Get filters
    DynamicArrayContract<Person> contacts = user.getContactList();
    
    //Creates result ordered list
    PersonIdOrderedList resultList = new PersonIdOrderedList();
    
    //Iterate in users list to search users with filter
    Iterator it = this.getStore().getPeopleByIdIterator();
    while(it.hasNext()){
      Person p = (Person) it.next();
      
      //Is already in result or is himself
      if(resultList.contains(p) || p.getId() == user.getId())
        continue;
      
      boolean isContact = false;
      
      //Check is a contact of contact
      for(int i = 0; i < contacts.size(); i++){
        Person contact = contacts.get(i);
        
        //Succeed
        if(contact.isContact(p)){
          isContact = true;
          break;
        }
      }
      
      //Pass to next
      if(isContact == false)
        continue;
      
      boolean inCompany = false;
      
      //Check work(ed) in company
      DynamicArrayContract<Professional> professionalList = p.getProfessionalList();
      for(int i = 0; i < professionalList.size(); i++){
        Professional professional = professionalList.get(i);
        
        //Succeed
        if(professional.getCompany().equals(companyName)){
          inCompany = true;
          break;
        }
      }
      
      //Pass to next
      if(inCompany == false)
        continue;
      
      boolean hasSkills = true;
      
      //Check if has all skills
      for(int i = 0; i < skills.size(); i++){
        String skill = skills.get(i);
        
        //Does not have
        if(!p.hasSkill(skill)){
          hasSkills = false;
          break;
        }
      }
      
      //Pass to next
      if(hasSkills == false)
        continue;
      
      try {
        //Add to result
        resultList.add(p);
      } catch (NotComparableException ex) {}
    }
    
    return resultList;
  }
  
  /**
   * Get list of users from desired company who can achieve desired user in graph.
   * For requirement: "Apresentar uma lista de utilizadores de uma empresa passada como parâmetro que estão relacionados com um utilizador também passado como parâmetro".
   * @param user
   * @param companyName
   * @return 
   */
  protected DynamicArrayContract<Person> getListOfUsersFromCompanyWithRelationToUser(Person user, String companyName){
    //Creates result list
    DynamicArrayContract<Person> resultList = new DynamicArray<>();

    //Iterate in users list to search users who worked on desired company
    Iterator it = this.getStore().getPeopleByIdIterator();
    while(it.hasNext()){
      Person p = (Person) it.next();
      
      boolean inCompany = false;
      
      //Iterate in professional list
      DynamicArrayContract<Professional> professionalList = p.getProfessionalList();
      for(int i = 0; i < professionalList.size(); i++){
        Professional prof = professionalList.get(i);
        
        //User has worked in desired company
        if(prof.getCompany().equals(companyName)){
          inCompany = true;
          break;
        }
      }
      
      //Work(ed) in company
      if(inCompany == true){
        //Check if can achieve desired user
        try {
          //Try to get path weight between then
          this.getStore().getShortestPathWeight(p, user);

          //Add to result
          resultList.add(p, resultList.size());
        }
        //Target user is not acessible from current user
        catch (ElementNotFoundException | VertexIsNotAccessibleException ex) {}
      }
    }
    
    return resultList;
  }
  
  /**
   * Get the relation of (ex) employees of company A with desired role and company B.
   * For requirement: "Verificar que os utilizadores que ocupam um cargo numa empresa (ex: empresa A) não estão relacionados com a utilizadores com cargos noutra empresa passada como parâmetro (empresa B)". 
   * @param role
   * @param companyFrom
   * @param companyTo
   * @return 
   */
  protected DynamicArrayContract getRelationsOfEmployeesWithRoleInCompanies(String role, String companyFrom, String companyTo){
    DynamicArrayContract<Person> peopleFrom = new DynamicArray<>();
    DynamicArrayContract<Person> peopleTo = new DynamicArray<>();
    
    Iterator it = this.getStore().getPeopleByIdIterator();
    while(it.hasNext()){
      Person p = (Person) it.next();
      
      //Check if has worked in From company
      if(p.hasWorked(companyFrom, role))
        peopleFrom.add(p, peopleFrom.size());
      
      //Check if has worked in To company
      if(p.hasWorked(companyTo, role))
        peopleTo.add(p, peopleTo.size());
    }
    
    //Create result list
    DynamicArrayContract<UserAndRelatedBlock> resultList = new DynamicArray<>();
    
    for(int i = 0; i < peopleFrom.size(); i++){
      Person from = peopleFrom.get(i);
      UserAndRelatedBlock newUser = new UserAndRelatedBlock(from);
      
      for(int j = 0; j < peopleTo.size(); j++){
        Person to = peopleTo.get(j);
        
        try {
          //Add relation to node
          if(this.getStore().hasRelation(from, to)){
            newUser.relatedPeople.add(to, newUser.relatedPeople.size());
          }
        } catch (ElementNotFoundException ex) {}
      }
      
      //Add to result list
      resultList.add(newUser, resultList.size());
    }
    
    return resultList;
  }
  
  /**
   * Class to store Person info and related people IDs.
   */
  private class UserAndRelatedBlock {
    public Person person;
    public DynamicArrayContract<Person> relatedPeople;
    
    public UserAndRelatedBlock(Person person){
      this.person = person;
      this.relatedPeople = new DynamicArray<>();
    }
    
    @Override
    public String toString(){
      StringBuilder stb = new StringBuilder();
      
      stb.append(this.person.toString()).append(" - ");
      
      if(this.relatedPeople.size() == 0)
        stb.append("No relations");
      
      else{
        for(int i = 0; i < this.relatedPeople.size(); i++){
          stb.append(this.relatedPeople.get(i).getId()).append(", ");
        }
      }
      
      return stb.toString();
    }
  }
  
  /**
   * Get the list of users with desired skills from desired user and ordered by link cost ascending.
   * For requirement: "Apresentar uma lista de utilizadores que contém um determinado skill no seu perfil ordenado pelo menor custo de ligação. O método deverá ter como parâmetro o utilizador inicial".
   * @param user
   * @param skill
   * @return
   * @throws ElementNotFoundException
   * @throws VertexIsNotAccessibleException 
   */
  protected PriorityQueueADT getListOfUsersWithSkillOrderedByLinkCost(Person user, String skill) throws ElementNotFoundException, VertexIsNotAccessibleException{
    //Get spawning tree of user
    SocialNetwork resultGraph = this.getStore().getMstNetwork(user);

    //Create result in PriorityMaxQueue (preference is to less weight = 1/n)
    PriorityQueueADT<UserWeightBlock> resultQueue = new ArrayPriorityMinQueue<>();

    //Iterate in user list
    Iterator it = resultGraph.iteratorBFS(user);

    //Check user has skill
    Person first = (Person) it.next();
    if(first.hasSkill(skill))
      resultQueue.enqueue(new UserWeightBlock(first, 0), 0);

    while(it.hasNext()){
      Person p = (Person) it.next();

      if(p.hasSkill(skill)){
        double cost = resultGraph.shortestPathWeight(user, p);
        resultQueue.enqueue(new UserWeightBlock(p, cost), cost);
      }
    }
    
    return resultQueue;
  }
  
  /**
   * Class to store Person info and Path Weight.
   */
  private class UserWeightBlock {
    public Person person;
    public double pathWeight;
    
    public UserWeightBlock(Person person, double pathWeight){
      this.person = person;
      this.pathWeight = pathWeight;
    }
    
    @Override
    public String toString(){
      return this.person.toString() + " / " + this.pathWeight;
    }
  }
  
  /**
   * Get the media of contacts and mentions of user compared to the total.
   * For extra requirement: "Apresentar a média de menções e ligações dos utilizadores alcançáveis por um utilizador versus a média de ligações e menções do grafo social".
   * @param from
   * @return 
   * @throws estg.ed.exceptions.ElementNotFoundException 
   */
  protected String getMediaComparative(Person from) throws ElementNotFoundException{
    //Get user mention media
    double userMentionMedia = this.getStore().getMentionMedia(from);

    //Get total mention media
    double totalMentionMedia = this.getStore().getMentionMedia();

    //Get user contacyt media
    double userContactMedia = this.getStore().getContactMedia(from);

    //Get total contacyt media
    double totalContactMedia = this.getStore().getContactMedia();

    return "User Mention Media: " + userMentionMedia + ".\nTotal Mention Media: " + totalMentionMedia + ".\n\nUser Contact Media: " + userContactMedia + ".\nTotal Contact Media: " + totalContactMedia + ".";
  }
  
  /**
   * Counts the number of links from the user spawning tree.
   * For extra requirement: "Teste dos graus de separação entre utilizadores da plataforma (O número de mínimo de ligações para um utilizador se conectar a todos os outros utilizadores no grafo social)".
   * @param from
   * @return
   * @throws ElementNotFoundException 
   */
  protected int getCountOfLinksUserTree(Person from) throws ElementNotFoundException{
    SocialNetwork resultGraph = this.getStore().getMstNetwork(from);

    //Calculate the number of edges of graph
    return resultGraph.size() - 1;
  }
}
