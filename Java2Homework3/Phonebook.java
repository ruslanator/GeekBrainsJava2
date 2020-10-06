package Java2Homework3;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {

    HashMap<String, Person> phonebook = new HashMap<>();
    
    public void addPerson(String name, String phone, String email) {
        Person person = new Person(phone, email);
        phonebook.put(name, person);
    }
    public void searchPhone(String name){
        ArrayList<String> phones = new ArrayList<>();
        if (phonebook.containsKey(name)){
            phones.add(phonebook.get(name).getPhone());
        } else {
            System.out.println("Такой фамилии нет в телефонной книге!");
        }
        System.out.println(phones);
    }
    public void searchEmail(String name){
        ArrayList<String> emails = new ArrayList<>();
        if (phonebook.containsKey(name)){
            emails.add(phonebook.get(name).getEmail());
        } else {
            System.out.println("Такой фамилии нет в телефонной книге!");
        }
        System.out.println(emails);
    }
}
