package ed.trabalho.resources.form.model;

import ed.trabalho.model.Person;

/**
 * Extends PersonViewEdit frame to create a person before loading data.
 */
public class PersonCreate extends PersonViewEdit {

    /**
     * Create an "empty" person. Using the last person id found plus one. If
     * list is empty, put ID 1.
     */
    public final void setPerson() {
        //Need to load store before
        if (this.getStore() == null) {
            this.message("Error creating person. Store was not loaded yet.");
            return;
        }

        //Get id
        int id = this.getStore().getNextValidId();

        //Create person
        Person newPerson = new Person(id, "", 0, "", 0);

        //Add to store
        try {
            this.getStore().addUser(newPerson);
        } catch (Exception e) {
            this.message("Error adding new user.");
            return;
        }

        //Populate as PersonViewEdit class
        super.setPerson(newPerson);
    }
}
