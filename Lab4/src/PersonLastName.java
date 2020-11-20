import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonLastName {

    private PersonNameType typeName;
    private PersonNameType type;
    private List<Long> id = new ArrayList<>();

    public PersonLastName(PersonNameType personNameType, PersonNameType type, long id){
        this.typeName = personNameType;
        this.type = type;
        addId(id);
    }

    public void addId(long id){
        this.id.add(id);
    }

    public int getSize(){
        return id.size();
    }

    public void rmPerson(long id){
        if(this.id.contains(id)){
            this.id.remove(id);
        }
    }

    public PersonLastNameIterator iterator(){
        return new PersonLastNameIterator();
    }


    public boolean hasChild(){
        return id.size() > 0;
    }

    public void show(){
        System.out.print("  -");
        type.show();
        for(long i: id){
            System.out.print("      -");
            System.out.println(i);
        }
    }

    class PersonLastNameIterator implements Iterator<Long>{
        private int index = 0;


        @Override
        public Long next() {
            if( this.hasNext() ){
                return id.get(index++);
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return index < id.size();
        }
    }

}

