package Lesson4.HW4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Account implements Serializable {
    private List<String> history;

    public Account() {
        history = new ArrayList<>();
    }

    public String getChatHistory(){
        return history.stream().collect(Collectors.joining("\n"));
    }
}