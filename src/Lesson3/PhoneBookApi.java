package Lesson3;

public class PhoneBookApi {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов","11111223");
        phoneBook.add("Сидоров","86558995");
        phoneBook.add("Мороз","5456435");
        phoneBook.add("Иванов","543543");

        System.out.println(phoneBook.getNumber("Иванов"));
        System.out.println(phoneBook.getNumber("Сидоров"));
        System.out.println(phoneBook.getNumber("Мороз"));


    }

}
