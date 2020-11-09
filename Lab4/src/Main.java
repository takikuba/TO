public class Main extends Society{

    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main(){

        addPerson("Jan", "Nowak", 1L);
        addPerson("Andrzej", "Duda", 2L);
        addPerson("Andrzej", "Komorowski", 43L);
        addPerson("Kuba", "Sasin", 3L);
        addPerson("Kuba", "Po", 6L);
        addPerson("Jan", "Po", 4L);
        addPerson("Jan", "Po", 5L);
        addPerson("Jan", "Po", 7L);

        SocietyIterator iterator = iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        showPersons();
        System.out.println("Count of Name Factory: " + nameFactory.getSize());
        System.out.println("Count of Last Name Factory: " + lastNameFactory.getSize());
        System.out.println("Count of Humans in Society: " + getSize());

        System.out.println("------------------------------------------------------");

        rmPerson("Jan", "Po", 7);
        showPersons();
        System.out.println(getSize());

        iterator = iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }

}
