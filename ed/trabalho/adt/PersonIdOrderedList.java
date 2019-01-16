/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.adt;

import ed.trabalho.model.Person;
import estg.ed.interfaces.OrderedListADT;
import estg.ed.list.OrderedArrayList;

/**
 * List of Person ordered by id.
 * Using default compareTo of Person.
 * @author igu
 */
public class PersonIdOrderedList extends OrderedArrayList<Person> implements OrderedListADT<Person> {
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
      
      stb.append("\"").append(p.toString()).append("\"");
      
      if(i != size - 1)
        stb.append(" , ");
    }
    
    return stb.toString();
  }
}
