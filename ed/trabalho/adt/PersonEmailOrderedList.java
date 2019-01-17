/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.adt;

import ed.trabalho.model.Person;
import estg.ed.exceptions.ElementNotFoundException;
import estg.ed.exceptions.NotComparableException;
import estg.ed.interfaces.OrderedListADT;
import estg.ed.list.OrderedArrayList;

/**
 * List of Person ordered by email.
 * @author igu
 */
public class PersonEmailOrderedList extends OrderedArrayList<Person> implements OrderedListADT<Person> {
  /**
   * Adds the specified element to this list at the proper location.
   * Element needs to implement Comparable interface.
   * Add to internal circular dynamic array on proper location.
   * Order by email.
   * @param element the element to be added to this list
   * @throws estg.ed.exceptions.NotComparableException
   */
  @Override
  public void add(Person element) throws NotComparableException {
    //Element email attribute is not comparable
    if(!(element.getEmail() instanceof Comparable))
      throw new NotComparableException("Person email is not comparable.");
    
    //Find position for element
    int index = 0;
    
    for(int i = 0; i < array.size(); i++){
      Person compared = array.get(i);
      
      //Is greater
      if(element.getEmail().compareTo(compared.getEmail()) > 0)
        index = i + 1;
      
      //Is equal or smaller
      else
        break;
    }
    
    //Insert in list
    array.add(element, index);
    
    this.modcount++;
  }

  /**
   * Returns a string representation of this list.
   * Returns a friendly string with users.
   * @return a string representation of this list
   */
  @Override
  public String toString() {
    StringBuilder stb = new StringBuilder();
    
    int size = this.array.size();
    
    for(int i = 0; i < size; i++){
      Person p = this.array.get(i);
      
      stb.append("\"").append(p.getId()).append(": ").append(p.getEmail()).append("\"");
      
      if(i != size - 1)
        stb.append(" , ");
    }
    
    return stb.toString();
  }
  
  /**
   * Search a person by email.
   * Uses recursion to binary search in ordered list.
   * Throws ElementNotFoundException if there is no person with desired email.
   * @param targetEmail
   * @return
   * @throws ElementNotFoundException 
   */
  public Person searchByEmail(String targetEmail) throws ElementNotFoundException{
    if(this.array.size() == 0)
      throw new ElementNotFoundException("There is no person with Email " + targetEmail);
    
    return this.searchByEmailRec(targetEmail, 0, this.array.size() - 1);
  }
  
  private Person searchByEmailRec(String targetEmail, int left, int right) throws ElementNotFoundException{
    //Not found
    if(left > right)
      throw new ElementNotFoundException("There is no person with Email " + targetEmail);
    
    //Compare to middle
    int middle = (left + right) / 2;
    
    Person search = this.array.get(middle);

    //Found
    if(targetEmail.equals(search.getEmail()))
      return search;
    
    //Email is smaller
    else if(targetEmail.compareTo(search.getEmail()) < 0)
      return searchByEmailRec(targetEmail, left, middle - 1);
    
    //Is greater
    else
      return searchByEmailRec(targetEmail, middle + 1, right);
  }
}
