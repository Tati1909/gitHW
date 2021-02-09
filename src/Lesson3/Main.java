package Lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"интерфейс", "Comparable", "служит", "для", "описания", "способа", "сравнения", "объектов", "для",
                "их", "дальнейшего", "упорядочивания", "Данный", "интерфейс", "Comparable", "указывает", "что", "объекты",
                "могут", "быть", "упорядочены", "Comparable"};
        Set<String> hashSet = new HashSet<>(Arrays.asList(arr));
        System.out.println("Список уникальных слов: " + hashSet);
        System.out.println(numberOfTimes(arr));
    } 
    public static Map<String,Integer> numberOfTimes(String[] args){
        Map<String,Integer> numberOfTimesMap = new HashMap<>();
        for(String s: args){
            if(!numberOfTimesMap.containsKey(s)){
                numberOfTimesMap.put(s,1);
            }
            else{
                numberOfTimesMap.put(s, numberOfTimesMap.get(s)+1);
            }
        }
        return numberOfTimesMap;
    }

}
