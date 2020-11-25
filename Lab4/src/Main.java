public class Main{

    public static void main(String[] args) {

        Society society = new Society();
        society.addPerson("Jan", "Kowalski", 11111111111L);
        society.addPerson("Jan", "Kowalski", 22222222222L);
        society.addPerson("Jan", "Nowak", 33333333333L);
        society.addPerson("Pan", "Nowak", 4444444444L);
        society.addPerson("Pan", "Nowak", 55555555555L);
        society.addPerson("Pan", "Carter", 66666666666L);
        society.addPerson("Pan", "Carter", 77777777777L);

        System.out.println("--------TreeBeforeUseRM--------");
        society.showPersons();

        society.rmPerson("Pan", "Nowak", 55555555555L);

        System.out.println("--------TreeAfterUseRM---------");
        society.showPersons();

        System.out.println("---FindFunctionDemonstration---");
        System.out.println(society.findPerson("Jan", "Kowalski", 11111111111L));
        society.rmPerson("Jan", "Kowalski", 11111111111L);
        System.out.println(society.findPerson("Jan", "Kowalski", 11111111111L));


        System.out.println("------------Iterator------------");
        Society.SocietyIterator iteratorSociety = society.iterator();
        while(iteratorSociety.hasNext()){
            PersonName p = iteratorSociety.next();
            System.out.println(p);
            PersonName.PersonNameIterator iteratorPerson = p.iterator();
            while(iteratorPerson.hasNext()){
                PersonLastName p2 = iteratorPerson.next();
                System.out.print("  \\_ ");
                System.out.println(p2);
                PersonLastName.PersonLastNameIterator iterator = p2.iterator();
                while(iterator.hasNext()){
                    System.out.print("     \\_ ");
                    System.out.println(iterator.next());
                }
            }
        }

    }
}
