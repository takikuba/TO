import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonLastName {

    private final PersonNameType type;
    private final List<Long> id = new ArrayList<>();

    public PersonLastName(PersonNameType type, long id){
        this.type = type;
        addPerson(id);
    }

    public void addPerson(long id){
        this.id.add(id);
    }

    public int getSize(){
        return id.size();
    }

    public void rmPerson(long id){
        this.id.remove(id);
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

    public boolean findPerson(long id) {
        return this.id.contains(id);
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

