import java.util.*;

public class Society {

    static Map<String, PersonName> persons = new HashMap<>();
    List<Long> id = new ArrayList<>();
    NameFactory nameFactory = new NameFactory();
    static NameFactory lastNameFactory = new NameFactory();

    public void addPerson(String name, String lastName, long id){

        if(this.id.contains(id)){
            throw new IllegalArgumentException("Pesel juz jest w bazie!");
        } else {
            this.id.add(id);
        }

        PersonNameType type = nameFactory.getPerson(name);
        if(persons.containsKey(name)){
            persons.get(name).addPerson(lastName, id);
        } else {
            PersonName personName = new PersonName(type, lastName, id);
            persons.put(name, personName);
        }

    }

    public void rmPerson(String name, String lastName, long id){
        if(persons.containsKey(name)){
            if (persons.get(name).hasChild()) {
                persons.get(name).rmPerson(lastName, id);
                if(!persons.get(name).hasChild()) persons.remove(name);
            } else {
                persons.remove(name);
            }
            this.id.remove(id);
        } else {
            System.out.println("Nie ma takiej osoby!");
        }

    }

    public boolean findPerson(String name, String lastName, long id){
        if(persons.containsKey(name)){
            return persons.get(name).findPerson(lastName, id);
        }
        return false;
    }

    public int getSize(){
        return persons.size();
    }

    public void showPersons(){

        for ( String str: persons.keySet()){
            persons.get(str).showPerson();
        }
    }

    public SocietyIterator iterator(){
        return new SocietyIterator();
    }

    static class SocietyIterator implements Iterator<PersonName> {
        private int index = 0;

        @Override
        public PersonName next() {
            if(this.hasNext()){
                return persons.get(persons.keySet().toArray()[index++]);
            } else {
                return null;
            }
        }

        @Override
        public boolean hasNext() {
            return index < persons.size();
        }

    }

}
