package Lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

private Map<String, List<String>> phoneBook;

    public PhoneBook(){
        phoneBook = new TreeMap<>();
    }

    public void add(String name, String number){
        if(phoneBook.containsKey(name)){
            phoneBook.get(name).add(number);
        }
        else {
            List<String> numbers = new ArrayList<>();
            numbers.add(number);
            phoneBook.put(name,numbers);
        }
    }
    public List<String> getNumber(String name){
        return phoneBook.get(name);
    }

}
