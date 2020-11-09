import java.util.HashMap;
import java.util.Map;

public class PersonName {

    private String name;
    private PersonNameType type;
    Map<String, PersonLastName> personsLast = new HashMap<>();

    public PersonName(PersonNameType type, String lastName, long id){
        this.name = lastName;
        this.type = type;
        addPerson(lastName, id);

    }

    public void addPerson(String lastName, long id){

        PersonNameType typeLastName = Society.lastNameFactory.getPerson(lastName);
        if(personsLast.containsKey(lastName)){
            personsLast.get(lastName).addId(id);
        } else {
            PersonLastName personLastName = new PersonLastName(type, typeLastName, id);
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

//    public PersonIterator iterator(){
//        return new PersonIterator();
//    }
//
//    public class PersonIterator implements Iterator {
//        private int index = 0;
//        private PersonLast.PersonLastIterator personLastIterator;
//
//        public PersonLast.PersonLastIterator getDeptIterator(){
//            return personsLast.get(personsLast.keySet().toArray()[index]).iterator();
//        }
//
//        @Override
//        public <E> E next() {
//            if (this.hasNext()) {
//                return (E) personsLast.get((String) personsLast.keySet().toArray()[index++]);
//            } else {
//                return null;
//            }
//        }
//
//        @Override
//        public boolean hasNext() {
//            if ( index < personsLast.size() ) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//    }

}
