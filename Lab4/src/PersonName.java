import java.util.HashMap;
import java.util.Map;

public class PersonName {

    PersonNameType type;
    Map<String, PersonLastName> personsLast = new HashMap<>();

    public PersonName(PersonNameType type, String lastName, long id){
        this.type = type;
        addPerson(lastName, id);
    }

    public void addPerson(String lastName, long id){
        PersonNameType typeLast = Society.lastNameFactory.getPerson(lastName);
        if(personsLast.containsKey(lastName)){
            personsLast.get(lastName).addPerson(id);
        } else {
            PersonLastName personLastName = new PersonLastName(typeLast, id);
            personsLast.put(lastName, personLastName);
        }

    }

    public void rmPerson(String lastName, long id){
        if(personsLast.containsKey(lastName)){
            if(personsLast.get(lastName).hasChild()) {
                personsLast.get(lastName).rmPerson(id);
                if(!personsLast.get(lastName).hasChild()) personsLast.remove(lastName);
            } else {
                personsLast.remove(lastName);
            }
        }
    }

    public boolean hasChild(){
        return personsLast.size() > 0;
    }

    public int getSize(){
        return personsLast.size();
    }

    public void showPerson(){
        type.show();
        for(String str: personsLast.keySet()){
            personsLast.get(str).show();
        }
    }

    public boolean findPerson(String lastName, long id) {
        if(personsLast.containsKey(lastName)){
            return personsLast.get(lastName).findPerson(id);
        }
        return false;
    }

    public PersonNameIterator iterator(){
        return new PersonNameIterator();
    }


    public class PersonNameIterator implements Iterator<PersonLastName> {
        private int index = 0;

        @Override
        public PersonLastName next() {
            if(this.hasNext()) {
                return personsLast.get(personsLast.keySet().toArray()[index++]);
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return index < personsLast.size();
        }

    }

}
