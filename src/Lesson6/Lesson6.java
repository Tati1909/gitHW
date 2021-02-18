package Lesson6;

import java.io.Serializable;

public class Lesson6  implements Serializable {
        private int age;
        private String name;

        public Lesson6 (int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return name+" "+age;
        }


}
