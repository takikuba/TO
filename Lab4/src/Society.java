import java.util.*;

public class Society {

    Map<String, PersonName> persons = new HashMap<>();
    static Map<Long, Person> people = new HashMap<>();
    static List<Long> id = new ArrayList<>();
    static NameFactory nameFactory = new NameFactory();
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
        } else {
            System.out.println("Nie ma takiej osoby!");
        }

    }

    public int getSize(){
        return people.size();
    }

    public void showPersons(){

        for ( String str: persons.keySet()){
            persons.get(str).showPerson();
        }
    }

    public SocietyIterator iterator(){
        return new SocietyIterator();
    }

    static class SocietyIterator implements Iterator {
        private int index = 0;

        @Override
        public Person next() {
            if(this.hasNext()){
                return people.get(id.get(index++));
            } else {
                return null;
            }
        }

        @Override
        public boolean hasNext() {
            if ( index < people.size() ) {
                return true;
            } else {
                return false;
            }
        }

        public String toString(){
            return people.keySet().toArray()[index].toString();
        }
    }

}
