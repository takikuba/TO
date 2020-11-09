public class Person {
    private PersonNameType name;
    private PersonNameType lastName;
    private Long id;

    public Person(PersonNameType name, PersonNameType lastName, long id){
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    public String toString(){
        return name + " " + lastName + " " + id;
    }

    public String getName(){
        return name.toString();
    }
    public String getLastName(){
        return lastName.toString();
    }
    public long getId(){
        return id;
    }
}
