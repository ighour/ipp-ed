package ed.trabalho.helpers;

import com.google.gson.Gson;
import ed.trabalho.exceptions.*;
import ed.trabalho.json.*;
import ed.trabalho.model.*;
import ed.trabalho.store.BaseStore;
import estg.ed.exceptions.ElementNotFoundException;
import estg.ed.exceptions.NotComparableException;
import estg.ed.interfaces.DynamicArrayContract;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Helper class to handle JSON input data and insert in store.
 */
public abstract class Data {

    /**
     * Reads a JSON file and map it to java classes.
     *
     * @param path path to JSON file
     * @return array of Pessoa containing brute value of JSON file as java
     * classes
     * @throws FileNotFoundException file was not found
     */
    public static Pessoa[] readJson(String path) throws FileNotFoundException {
        Gson gson = new Gson();

        GrafoSocial json = gson.fromJson(new FileReader(path), GrafoSocial.class);

        return json.getResult();
    }

    /**
     * Populates the network and binary search tree with provided data.
     *
     * @param source array of Pessoa containing brute value of JSON file as java
     * classes
     * @param store instance of Store to save elements
     * @throws estg.ed.exceptions.ElementNotFoundException element was not found
     * @throws estg.ed.exceptions.NotComparableException element is not
     * comparable
     * @throws ed.trabalho.exceptions.UserIsAlreadyMentionedException user is
     * already mentioned
     * @throws ed.trabalho.exceptions.UserIsAlreadyAContactException user is
     * already a contact
     * @throws ed.trabalho.exceptions.UserIsAlreadyAddedException user is
     * already added
     */
    public static void populate(Pessoa[] source, BaseStore store) throws ElementNotFoundException, NotComparableException, UserIsAlreadyMentionedException, UserIsAlreadyAContactException, UserIsAlreadyAddedException {
        //Clear store before (needed if loaded another JSON)
        store.clearStore();

        //Create list of People
        Person[] peopleList = new Person[source.length];

        //Loop through source
        for (int i = 0; i < source.length; i++) {
            //Create person if needed
            if (peopleList[i] == null) {
                peopleList[i] = addPerson(source[i], store);
            }

            //Add relations
            addRelations(i, source, peopleList, store);
        }
    }

    /**
     * Add a person to the network. Only the attributes which does not referrer
     * to another person.
     *
     * @param p person reference to add
     * @param store store to receive person
     * @return added person
     * @throws estg.ed.exceptions.NotComparableException user is not comparable
     * @throws ed.trabalho.exceptions.UserIsAlreadyAddedException user was
     * already added
     */
    private static Person addPerson(Pessoa p, BaseStore store) throws NotComparableException, UserIsAlreadyAddedException {
        //Parse "Pessoa" (converted JSON data) to "Person" (model)
        Person newPerson = new Person(p.getId(), p.getNome(), p.getIdade(), p.getEmail(), p.getVisualizacoes());

        //Add AcademicList
        DynamicArrayContract<Academic> academicList = newPerson.getAcademicList();
        for (FormacaoAcademica x : p.getFormacaoAcademica()) {
            academicList.add(new Academic(x.getAno(), x.getFormacao()), academicList.size());
        }

        //Add ProfessionalList
        DynamicArrayContract<Professional> professionalList = newPerson.getProfessionalList();
        for (CargosProfissionais x : p.getCargosProfissionais()) {
            professionalList.add(new Professional(x.getAno(), x.getEmpresa(), x.getCargo()), professionalList.size());
        }

        //Add SkillList
        DynamicArrayContract<Skill> skillList = newPerson.getSkillList();
        for (String x : p.getSkills()) {
            skillList.add(new Skill(x), skillList.size());
        }

        //Add newPerson to Network
        store.addUser(newPerson);

        //Return newPerson
        return newPerson;
    }

    /**
     * Add person relation of mentions and contacts. Relations which referrer to
     * another person.
     *
     * @param id position on arrays used to create elements
     * @param source array of Pessoa containing brute info
     * @param peopleList array of Person containing result info
     * @param store store to receive Person
     * @throws ElementNotFoundException user was not found
     * @throws estg.ed.exceptions.NotComparableException user is not comparable
     * @throws ed.trabalho.exceptions.UserIsAlreadyMentionedException user was
     * already mentioned
     * @throws ed.trabalho.exceptions.UserIsAlreadyAContactException user is
     * already a contact
     * @throws ed.trabalho.exceptions.UserIsAlreadyAddedException user was
     * already added
     */
    private static void addRelations(int id, Pessoa[] source, Person[] peopleList, BaseStore store) throws ElementNotFoundException, NotComparableException, UserIsAlreadyMentionedException, UserIsAlreadyAContactException, UserIsAlreadyAddedException {
        /* Add Mentions */

        //Get mentions from source data
        Mencao[] sourceMentions = source[id].getMencoes();

        //Add mentions relation
        for (Mencao sourceMention : sourceMentions) {
            int mentionUid = sourceMention.getUserid();
            int uidIndex = getIndex(mentionUid, source);

            //Relation user was not created yet
            if (peopleList[uidIndex] == null) {
                peopleList[uidIndex] = addPerson(source[uidIndex], store);
            }

            store.addUserMention(peopleList[id], peopleList[uidIndex]);
        }

        /* Add Contacts */
        //Get contacts from source data
        Contact[] sourceContacts = source[id].getContacts();

        //Add contacts relation
        for (Contact sourceContact : sourceContacts) {
            int contactUid = sourceContact.getUserid();
            int uidIndex = getIndex(contactUid, source);

            //Relation user was not created yet
            if (peopleList[uidIndex] == null) {
                peopleList[uidIndex] = addPerson(source[uidIndex], store);
            }

            store.addUserContact(peopleList[id], peopleList[uidIndex]);
        }
    }

    /**
     * Get the index of a Person inside the array of Pessoa.
     *
     * @param uid id of Person
     * @param source array of Pessoa with brute info
     * @return index on arrays to enable converting Pessoa into Person
     * @throws ElementNotFoundException user was not found
     */
    private static int getIndex(int uid, Pessoa[] source) throws ElementNotFoundException {
        for (int i = 0; i < source.length; i++) {
            Pessoa p = source[i];

            if (p.getId() == uid) {
                return i;
            }
        }

        throw new ElementNotFoundException();
    }
}