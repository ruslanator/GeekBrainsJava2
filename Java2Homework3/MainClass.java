package Java2Homework3;

import java.util.HashMap;

public class MainClass {
    public static void main (String[] args){
        String[] cars = {"Mercedes", "Audi", "Nissan", "Kia", "Toyota", "Suzuki", "Ford", "Ferrari",
        "BMW", "Toyota", "Mazda", "Renault", "Honda", "Nissan", "Audi", "Skoda", "Volkswagen", "Hyundai",
        "Volvo", "Honda", "Chevrolet", "Subaru", "Lexus", "Honda"};
        HashMap<String, Integer> hashmap = new HashMap<>();
        for (String s : cars){
            hashmap.put(s, hashmap.getOrDefault(s, 0) + 1);
        }
        System.out.println(hashmap);

        Phonebook phonebook = new Phonebook();
        phonebook.addPerson("Ivanov", "+7 888 999 28 88", "ivanov@mail.ru");
        phonebook.addPerson("Petrov", "+7 999 998 99 99", "petrov@gmail.ru");
        phonebook.addPerson("Sidorov", "+7 777 777 77 77", "sidorov@mail.ru");
        phonebook.addPerson("Ivanov", "+7 666 666 66 66", "ivanov2@mail.ru");
        phonebook.addPerson("Kuznecov", "+7 111 111 11 11", "kuzn@yandex.ru");
        phonebook.addPerson("Kulikov", "+7 555 555 55 55", "ivanov2@mail.ru");

        phonebook.searchPhone("Kulikov");
        phonebook.searchEmail("Kuznecov");
    }
}
