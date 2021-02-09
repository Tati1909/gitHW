package Lesson4.HW4;

import java.util.List;
import java.util.stream.Collectors;

public class Chat {
    private List<String> history;

    public Chat() {
    }
    public String getChatHistory(){
        return history.stream().collect(Collectors.joining("\n"));
    }
}
