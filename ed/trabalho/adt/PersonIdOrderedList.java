package ed.trabalho.adt;

import ed.trabalho.model.Person;
import estg.ed.exceptions.ElementNotFoundException;
import estg.ed.interfaces.OrderedListADT;
import estg.ed.list.OrderedArrayList;

/**
 * List of Person ordered by id.
 */
public class PersonIdOrderedList extends OrderedArrayList<Person> implements OrderedListADT<Person> {

    /**
     * Returns a string representation of this list. Returns a friendly string
     * with users.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();

        int size = this.array.size();

        for (int i = 0; i < size; i++) {
            Person p = this.array.get(i);

            stb.append("\"").append(p.getId()).append("\"");

            if (i != size - 1) {
                stb.append(" , ");
            }
        }

        return stb.toString();
    }

    /**
     * Search a person by id. Uses recursion to binary search in ordered list.
     * Throws ElementNotFoundException if there is no person with desired id.
     *
     * @param targetId id to find
     * @return user reference
     * @throws ElementNotFoundException user was not found
     */
    public Person searchById(int targetId) throws ElementNotFoundException {
        if (this.array.size() == 0) {
            throw new ElementNotFoundException("There is no person with ID " + targetId);
        }

        return this.searchByIdRec(targetId, 0, this.array.size() - 1);
    }

    private Person searchByIdRec(int targetId, int left, int right) throws ElementNotFoundException {
        //Not found
        if (left > right) {
            throw new ElementNotFoundException("There is no person with ID " + targetId);
        }

        //Compare to middle
        int middle = (left + right) / 2;

        Person search = this.array.get(middle);
        int searchId = search.getId();

        //Found
        if (targetId == searchId) {
            return search;
        } 

        //Is smaller
        else if (targetId < searchId) {
            return searchByIdRec(targetId, left, middle - 1);
        } 
        
        //Is greater
        else {
            return searchByIdRec(targetId, middle + 1, right);
        }
    }
}
