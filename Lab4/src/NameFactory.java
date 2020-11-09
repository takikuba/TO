import java.util.HashMap;
import java.util.Map;

public class NameFactory {
    private Map<String, PersonNameType> personTypes = new HashMap<>();

    public PersonNameType getPerson(String name){

        PersonNameType type = personTypes.get(name);
        if ( type == null ){
            type = new PersonNameType(name);
            personTypes.put(name, type);
        }
        return type;

    }

    public void show(){
        for(PersonNameType type: personTypes.values()) {
            type.show();
        }
    }

    public int getSize(){
        return personTypes.size();
    }
}
